package org.assimbly.auth.endpoint;

import com.mongodb.client.MongoClient;
import org.assimbly.auth.domain.Role;
import org.assimbly.auth.domain.Tenant;
import org.assimbly.auth.domain.User;
import org.assimbly.auth.endpoint.annotation.Secured;
import org.assimbly.auth.jwt.JwtValidator;
import org.assimbly.auth.mongo.MongoClientProvider;
import org.assimbly.auth.mongo.MongoDao;
import org.assimbly.auth.util.helper.ConfigHelper;

import jakarta.annotation.Priority;
import jakarta.ws.rs.ForbiddenException;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ResourceInfo;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class acting as a filter for authorization roles. This class is called after the
 * AuthenticationFilter so it assumes that the user it is given is already validated.
 */
@Secured
@Provider
@Priority(Priorities.AUTHORIZATION)
public class AuthorizationFilter implements ContainerRequestFilter {

    private static final String TENANT_NAME_PATH_PARAM = "tenantName";

    private MongoDao mongoDao;

    @Context
    private ResourceInfo resourceInfo;

    public AuthorizationFilter() {
        String baseDatabaseName = ConfigHelper.get("baseDatabaseName");
        MongoClient mongoClient = MongoClientProvider.getClient();
        this.mongoDao = new MongoDao(mongoClient, baseDatabaseName);
        //this.mongoDao = new MongoDao(ConfigHelper.get("baseDatabaseName"));
    }

    public AuthorizationFilter(String baseDatabaseName){
        MongoClient mongoClient = MongoClientProvider.getClient();
        this.mongoDao = new MongoDao(mongoClient, baseDatabaseName);
    }

    /**
     * Check the called method to see if the user who called it has correct authorization.
     * Return a 403: Forbidden response when the user is not authorized to access.
     *
     * @param requestContext to get all the request data from.
     * @throws IOException when something goes wrong while reading the request.
     */
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        try {
            String token = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
            String userEmail = JwtValidator.decode(token).get("name", String.class);
            User user = mongoDao.findUserByEmail(userEmail);

            MultivaluedMap<String, String> pathParams = requestContext.getUriInfo().getPathParameters();

            authOnRoles(user);
            authOnTenant(user, pathParams);
        } catch (Exception e) {
            Logger.getLogger(AuthorizationFilter.class.getName()).log(Level.SEVERE, null, e);

            requestContext.abortWith(
                    Response.status(Response.Status.FORBIDDEN)
                            .entity(Errors.FORBIDDEN)
                            .build());
        }
    }

    /**
     * Check if the given user is authorized by checking if the user
     * has the required role to access the resource.
     *
     * @param user to check for.
     * @throws ForbiddenException if the user does not have the required role.
     */
    private void authOnRoles(User user) throws ForbiddenException {
        Class<?> resourceClass = resourceInfo.getResourceClass();
        List<Role> classRoles = extractRoles(resourceClass);

        Method resourceMethod = resourceInfo.getResourceMethod();
        List<Role> methodRoles = extractRoles(resourceMethod);

        if (methodRoles.isEmpty()) {
            if (!classRoles.isEmpty()) {
                checkRoles(user, classRoles);
            }
        } else {
            checkRoles(user, methodRoles);
        }
    }

    /**
     * Extract the roles annotated on the given element.
     *
     * @param element to get the roles from.
     * @return a list with all the found roles.
     */
    private List<Role> extractRoles(AnnotatedElement element) {
        if (element == null) {
            return new ArrayList<>();
        } else {
            Secured secured = element.getAnnotation(Secured.class);
            if (secured == null) {
                return new ArrayList<>();
            } else {
                Role[] allowedRoles = secured.roles();
                return Arrays.asList(allowedRoles);
            }
        }
    }

    /**
     * Check if the given user has one of the allowed roles.
     * Throw an Exception when the user has none of these roles and therefore is not authorized.
     *
     * @param user         to check the role for.
     * @param allowedRoles the roles which are authorized.
     * @throws ForbiddenException when the user is not authorized.
     */
    private void checkRoles(User user, List<Role> allowedRoles) throws ForbiddenException {
        for (Role role : allowedRoles) {
            if (role.equals(user.getRole())) {
                return;
            }
        }

        throw new ForbiddenException();
    }

    /**
     * Check if the given user is authorized by checking if the user
     * has belongs to the required tenant if specified.
     * Skip this checking process if the user has the super admin role.
     *
     * @param user to check for.
     * @throws ForbiddenException if the user does not belong to the specified tenant.
     */
    private void authOnTenant(User user, MultivaluedMap<String, String> pathParams) throws ForbiddenException {
        if (!Role.SUPER_ADMIN.equals(user.getRole())) {

            boolean hasToCheck = extractTenant(resourceInfo.getResourceClass())
                    || extractTenant(resourceInfo.getResourceMethod());

            if (hasToCheck) {
                checkTenant(user, pathParams.get(TENANT_NAME_PATH_PARAM).get(0));
            }
        }
    }

    /**
     * Extract if the tenant has to be checked from the given element.
     *
     * @param element to get the tenantCheck from.
     * @return true if the tenant needs to be checked.
     */
    private boolean extractTenant(AnnotatedElement element) {
        if (element == null) {
            return false;
        } else {
            Secured secured = element.getAnnotation(Secured.class);
            return secured != null && secured.checkTenant();
        }
    }

    /**
     * Check if the give user belongs to a tenant with the given tenant name.
     *
     * @param user       to check the tenant for.
     * @param tenantName of the tenant which is authorized.
     * @throws ForbiddenException when the names do not match.
     */
    private void checkTenant(User user, String tenantName) throws ForbiddenException {
        Tenant tenant = mongoDao.findTenant(user);

        if (tenantName.equals(tenant.getDbName())) {
            return;
        }

        throw new ForbiddenException();
    }
}
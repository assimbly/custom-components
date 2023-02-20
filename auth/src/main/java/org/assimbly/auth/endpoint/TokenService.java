package org.assimbly.auth.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.assimbly.auth.InvalidTenantException;
import org.assimbly.auth.InvalidUserException;
import org.assimbly.auth.jwt.JwtBuilder;
import org.assimbly.auth.domain.Status;
import org.assimbly.auth.domain.Tenant;
import org.assimbly.auth.domain.User;
import org.assimbly.auth.mongo.MongoDao;
import org.assimbly.util.helper.Base64Helper;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.UnsupportedEncodingException;

import static java.nio.charset.StandardCharsets.UTF_8;

@Path("/token")
public class TokenService {

    private static final Logger LOG = LoggerFactory.getLogger(TokenService.class);

    private MongoDao mongoDao;

    public TokenService(String database){
        mongoDao = new MongoDao(database);
    }

    /**
     * Issue a JSON Web Token (JWT) to a possible client when the client
     * can be authenticated by his given credentials retrieved from the Authorization header.
     * The client can use this token to authenticate himself with while using the endpoints of this system.
     *
     * @param authHeader HTTP header containing the necessary data to authenticate the client.
     * @return a valid signed JWT.
     */
    @GET
    public Response issueToken(@HeaderParam("Authorization") String authHeader) {
        try {
            String[] values = decodeHeader(authHeader);

            User user = authenticate(values[0], values[1]);

            String token = buildToken(user);

            return Response.status(Response.Status.OK)
                    .entity(token)
                    .build();
        } catch (BadRequestException e) {
            LOG.warn(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(Errors.INCORRECT_AUTH_HEADER)
                    .build();
        } catch (InvalidUserException e) {
            LOG.warn(e.getMessage());

            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity(Errors.UNAUTHORIZED)
                    .build();
        } catch (InvalidTenantException e) {
            LOG.warn(e.getMessage());

            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity(Errors.INVALID_TENANT)
                    .build();
        } catch (UnsupportedEncodingException e) {
            LOG.warn(e.getMessage());

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Errors.MAX_REQUESTS)
                    .build();
        }
    }

    /**
     * Decode the base64 header containing the clients credentials and
     * return this as an array containing the email, password and tenant name.
     *
     * @param base64 string to decode.
     * @return string array with credentials.
     * @throws BadRequestException when something is wrong with the base64 encoding
     *                             or necessary data is missing.
     */
    private String[] decodeHeader(String base64) throws BadRequestException {
        String[] values;

        try {
            String header = Base64Helper.unmarshal(base64, UTF_8);
            values = header.split(":");
        } catch (Exception e) {
            throw new BadRequestException(e);
        }

        if (values.length != 2
                || nullOrEmpty(values[0])
                || nullOrEmpty(values[1])) {

            throw new BadRequestException();
        }

        return values;
    }

    /**
     * Authenticate a possible client by the given email and password.
     * Return the user if one is found with the given credentials, else throw an exception.
     *
     * @param email    to find the client by.
     * @param password to validate the client by.
     * @return a User object with the authenticated client.
     * @throws NotAuthorizedException when the user with the credentials is not found.
     */

    private User authenticate(String email, String password) throws InvalidUserException, InvalidTenantException {
        User user = mongoDao.findUser(email, password);
        if (user == null || !Status.ACTIVE.equals(user.getStatus())) {
            throw new InvalidUserException();
        }

        Tenant tenant = mongoDao.findTenant(user);
        if (tenant != null && tenant.getDisabled()) {
            throw new InvalidTenantException();
        }

        return user;
    }

    /**
     * Create a JWT belonging to the given User.
     *
     * @param user to create the token for.
     * @return a valid Signed JWT.
     * @throws UnsupportedEncodingException when the encoding used to sign the token is not supported.
     */
    private String buildToken(User user) throws UnsupportedEncodingException {
        return JwtBuilder.build(user.getEmail(), "role");
    }

    /**
     * Check if a String is null or empty.
     *
     * @param value the String to check
     * @return true if the given String is null or empty.
     */
    private static boolean nullOrEmpty(String value) {
        return value == null || value.isEmpty();
    }

}

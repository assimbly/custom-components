package org.assimbly.auth.endpoint;

import com.google.common.base.CaseFormat;
import com.mongodb.client.MongoClient;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import com.warrenstrange.googleauth.GoogleAuthenticatorQRGenerator;
import io.jsonwebtoken.JwtException;
import org.assimbly.auth.domain.TwoFactorRequest;
import org.assimbly.auth.domain.User;
import org.assimbly.auth.endpoint.annotation.Secured;
import org.assimbly.auth.jwt.JwtValidator;
import org.assimbly.auth.mongo.GoogleCredentialsRepository;
import org.assimbly.auth.mongo.MongoDao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

@Path("/")
public class AuthenticatorService {

    private static final GoogleAuthenticator authenticator = new GoogleAuthenticator();

    private MongoDao mongoDao;

    public AuthenticatorService(MongoClient mongoClient, String databaseName){
        authenticator.setCredentialRepository(new GoogleCredentialsRepository(mongoClient, databaseName));
        mongoDao = new MongoDao(mongoClient.getDatabase(databaseName));
    }

    @GET
    @Secured
    @Path("/register")
    public Response register(@HeaderParam("Authorization") String jwt, @Context UriInfo ui) throws URISyntaxException {
        try {
            String userEmail = JwtValidator.decode(jwt).get("name", String.class);
            User user = mongoDao.findUserByEmail(userEmail);

            GoogleAuthenticatorKey key = authenticator.createCredentials(user.getEmail());

            String domainName = ui.getQueryParameters().getFirst("domain_name");

            String issuer = String.format("Assimbly - %s",
                    CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, domainName));

            String qrLocation = GoogleAuthenticatorQRGenerator.getOtpAuthURL(issuer, user.getEmail(), key);

            return Response.seeOther(new URI(qrLocation)).build();
        } catch (UnsupportedEncodingException | JwtException e) {
            return Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity("The session token is invalid.")
                    .build();
        }
    }

    @DELETE
    @Path("/remove")
    public Response remove(@HeaderParam("Authorization") String jwt) {
        try {
            String userEmail = JwtValidator.decode(jwt).get("name", String.class);
            User user = mongoDao.findUserByEmail(userEmail);

            mongoDao.removeAuthenticatorSettings(user);

            return Response.ok().build();
        } catch (UnsupportedEncodingException | JwtException e) {
            return Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity("The session token is invalid.")
                    .build();
        }
    }

    @POST
    @Path("/validate")
    @Consumes("application/json")
    public Boolean validate(TwoFactorRequest request){
        return authenticator.authorizeUser(request.getEmail(), request.getToken());
    }
}

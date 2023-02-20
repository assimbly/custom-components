package world.dovetail.soap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;
import org.apache.camel.spi.UriPath;

import org.assimbly.util.helper.Base64Helper;
import world.dovetail.soap.domain.SoapHeader;
import world.dovetail.soap.domain.SoapHttpHeader;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@UriParams
public class SoapConfiguration {

    @UriPath
    @Metadata(required = true)
    private String wsdl;

    @UriParam
    @Metadata(required = true)
    private String action;

    @UriParam
    @Metadata(required = true)
    private boolean extract;

    @UriParam
    @Metadata(required = true)
    private boolean smart;

    @UriParam
    private String auth;

    @UriParam
    private String headers;

    @UriParam
    private String httpHeaders;

    @UriParam(name = "parameters")
    private String params;

    public SoapConfiguration() {}

    public void dynamicApply(String prop, Object value) throws URISyntaxException {
        if("wsdl".equals(prop)) {
            URI wsdl = new URI((String) value);

            setParams(wsdl.getQuery());

            String queryless = new URI(wsdl.getScheme(),
                    wsdl.getAuthority(),
                    wsdl.getPath(),
                    null, // Ignore the query part of the input url
                    wsdl.getFragment()).toString();

            setWsdl(queryless);
        }else if("action".equals(prop)) {
            setAction((String) value);
        }else if("extract".equals(prop)) {
            setExtract((Boolean) value);
        }else if("smart".equals(prop)) {
            setSmart((Boolean) value);
        }else if("auth".equals(prop)) {
            setAuth((String) value);
        }
    }

    /**
     * Location URL of the WSDL that should be parsed.
     */
    public void setWsdl(String wsdl) {
        this.wsdl = wsdl;
    }

    /**
     * Soap Action that should be called on the WSDL.
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * Whether or not the SoapEnvelop / SoapBody should be extracted from the Response.
     */
    public void setExtract(boolean extract) {
        this.extract = extract;
    }

    /**
     * Whether the component should auto lookup namespaces in the WSDL and apply them to the input XML.
     */
    public void setSmart(boolean smart) {
        this.smart = smart;
    }

    /**
     * Optional: Basic Authentication Credentials.
     */
    public void setAuth(String auth) {
        this.auth = auth;
    }

    /**
     * Optional: SoapHeaders that should be sent with the Soap call.
     */
    public void setHeaders(String headers) {
        this.headers = headers;
    }

    /**
     * Optional: HttpHeaders that should be set for the Soap call.
     */
    public void setHttpHeaders(String httpheaders) {
        this.httpHeaders = httpheaders;
    }

    /**
     * Optional: Url Parameters that should be used retrieving the WSDL.
     */
    public void setParams(String parameters) {
        this.params = parameters;
    }

    public String getWsdl() {
        return wsdl;
    }

    public String getAction() {
        return action;
    }

    public boolean isExtract() {
        return extract;
    }

    public boolean isSmart() {
        return smart;
    }

    public String getAuth() {
        return auth;
    }

    public List<SoapHeader> getHeaders() throws IOException {
        List<SoapHeader> list = new ArrayList<>();

        if(headers != null) {
            String json = Base64Helper.unmarshal(headers, StandardCharsets.UTF_8);
            list = new ObjectMapper().readValue(json, new TypeReference<List<SoapHeader>>() {});
        }

        return list;
    }

    public List<SoapHttpHeader> getHttpHeaders() throws IOException {
        List<SoapHttpHeader> list = new ArrayList<>();

        if(httpHeaders != null) {
            String json = Base64Helper.unmarshal(httpHeaders, StandardCharsets.UTF_8);
            list = new ObjectMapper().readValue(json, new TypeReference<List<SoapHttpHeader>>() {});
        }

        return list;
    }

    public String getParameters() {
        return params;
    }
}

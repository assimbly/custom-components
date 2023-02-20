package world.dovetail.amazon.domain;

public class Marketplace {

    private String id;
    private String name;
    private String countryCode;
    private String endpoint;

    public Marketplace(String id, String name, String countryCode, String endpoint) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.endpoint = endpoint;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getEndpoint() {
        return endpoint;
    }
}

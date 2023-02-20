package world.dovetail.amazon.api;

import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import world.dovetail.amazon.domain.Marketplace;
import org.assimbly.util.Pair;

import java.util.List;

public class FeedsApi extends AmazonMarketplaceApi implements AmazonApi {

    public FeedsApi(List<NameValuePair> form, Marketplace marketplace, String secretKey) {
        super(form, marketplace, secretKey);
    }

    public Pair<StatusLine, String> getFeedSubmissionResult() throws Exception {
        sign();

        return post(getForm(), null);
    }

    public Pair<StatusLine, String> submitFeed(String body) throws Exception {
        sign();

        return post(getForm(), body);
    }

    @Override
    public String getMethodUrl(){
        return "/";
    }
}

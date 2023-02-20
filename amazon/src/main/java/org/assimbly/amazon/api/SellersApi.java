package org.assimbly.amazon.api;

import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.assimbly.amazon.domain.Marketplace;
import org.assimbly.util.Pair;

import java.util.List;

public class SellersApi extends AmazonMarketplaceApi implements AmazonApi {

    public SellersApi(List<NameValuePair> form, Marketplace marketplace, String secretKey) {
        super(form, marketplace, secretKey);
    }

    public Pair<StatusLine, String> listMarketplaceParticipations() throws Exception {
        sign();

        return post(getForm(), null);
    }

    @Override
    public String getMethodUrl(){
        return "/Sellers/2011-07-01";
    }
}

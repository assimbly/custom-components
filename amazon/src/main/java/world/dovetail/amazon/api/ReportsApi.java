package world.dovetail.amazon.api;

import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import world.dovetail.amazon.domain.Marketplace;
import org.assimbly.util.Pair;

import java.util.List;

public class ReportsApi extends AmazonMarketplaceApi implements AmazonApi {

    public ReportsApi(List<NameValuePair> form, Marketplace marketplace, String secretKey) {
        super(form, marketplace, secretKey);
    }

    public Pair<StatusLine, String> getReport() throws Exception {
        sign();

        return post(getForm(), null);
    }

    public Pair<StatusLine, String> getReportList() throws Exception {
        sign();

        return post(getForm(), null);
    }

    public Pair<StatusLine, String> updateReportAcknowledgements() throws Exception {
        sign();

        return post(getForm(), null);
    }
}

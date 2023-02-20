package world.dovetail.amazon.api;

import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import world.dovetail.amazon.domain.Marketplace;
import org.assimbly.util.Pair;

import java.util.List;

public class OrdersApi extends AmazonMarketplaceApi implements AmazonApi  {

    public OrdersApi(List<NameValuePair> form, Marketplace marketplace, String secretKey) {
        super(form, marketplace, secretKey);
    }

    public Pair<StatusLine, String> listOrders() throws Exception {
        sign();

        return post(getForm(), null);
    }

    public Pair<StatusLine, String> listOrderItems() throws Exception {
        sign();

        return post(getForm(), null);
    }

    @Override
    public String getMethodUrl(){
        return "/Orders/2013-09-01";
    }
}

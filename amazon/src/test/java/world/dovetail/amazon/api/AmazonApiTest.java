package world.dovetail.amazon.api;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import world.dovetail.amazon.domain.Amazon;
import world.dovetail.amazon.domain.Region;
import world.dovetail.amazon.exception.MarketplaceNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class AmazonApiTest {

    private static final String SECRET_KEY = "HKSf7TLdG+SXi+S9cBq+SYwIdGTZ3ickkNC+/FXR";

    private static AmazonMarketplaceApi api;
    private static List<NameValuePair> form;

    @Before
    public void init() throws MarketplaceNotFoundException {
        form = new ArrayList<>();
        form.add(new BasicNameValuePair("FeedType", "_POST_PRODUCT_DATA_"));
        form.add(new BasicNameValuePair("PurgeAndReplace", "false"));

        api = new AmazonMarketplaceApi(form, Amazon.INSTANCE.findMarketPlace(Region.NA), SECRET_KEY);
    }

    @Test
    public void encodeFormTest() throws MarketplaceNotFoundException {
        form.add(new BasicNameValuePair("Encoded", "= !"));

        api = new AmazonMarketplaceApi(form, Amazon.INSTANCE.findMarketPlace(Region.NA), SECRET_KEY);

        String actual = api.getUrlEncodedForm();
        String expected = "FeedType=_POST_PRODUCT_DATA_&PurgeAndReplace=false&Encoded=%3D+%21";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void signingTest() throws Exception {
        api.sign();

        NameValuePair expected =
                new BasicNameValuePair("Signature", "N+RmfABaBxf20r0TJlDwd5ZtnAQJhJ5jALr5tFwKV6E=");

        Assert.assertEquals(3, form.size());
        Assert.assertEquals(expected, form.get(2));
    }
}

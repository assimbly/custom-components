package org.assimbly.aggregate.json;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonAggregateStrategy implements AggregationStrategy {

    final static Logger logger = Logger.getLogger(JsonAggregateStrategy.class);

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {

        JSONArray array;

        if (oldExchange == null) {
            return newExchange;
        }

        if(oldExchange.getProperty("hasBeenAggregated") != null
                && oldExchange.getProperty("hasBeenAggregated", Boolean.class)) {
            array = new JSONArray(oldExchange.getIn().getBody(String.class));
        }else{
            array = wrapInArray(new JSONArray(), oldExchange.getIn().getBody(String.class));
        }

        array = wrapInArray(array, newExchange.getIn().getBody(String.class));

        oldExchange.setProperty("hasBeenAggregated", true);

        oldExchange.getIn().setBody(array.toString(2));

        return oldExchange;
    }

    private JSONArray wrapInArray(JSONArray array, String json){
        if(json.substring(0, 1).equals("[")) {
            return array.put(new JSONArray(json));
        } else {
            return array.put(new JSONObject(json));
        }
    }
}

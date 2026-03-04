package org.assimbly.aggregate;

import org.apache.camel.AggregationStrategy;
import org.assimbly.aggregate.json.JsonAggregateStrategy;
import org.assimbly.aggregate.xml.XmlAggregateStrategy;
import org.apache.camel.Exchange;

public class AggregateStrategy implements AggregationStrategy {

    private AggregationStrategy aggregationStrategy;

    @Override
    public Exchange aggregate(Exchange firstExchange, Exchange newExchange) {

        String aggregateType = newExchange.getProperty("Aggregate-Type", String.class);

        if (firstExchange != null)
            aggregateType = firstExchange.getProperty("Aggregate-Type", String.class);

        if(aggregateType.equalsIgnoreCase("text/xml")){
            aggregationStrategy = new XmlAggregateStrategy();
        }else if(aggregateType.equalsIgnoreCase("application/json")){
            aggregationStrategy = new JsonAggregateStrategy();
        }

        return aggregationStrategy.aggregate(firstExchange, newExchange);
    }

}

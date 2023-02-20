package world.dovetail.aggregate;

import org.apache.camel.AggregationStrategy;
import org.apache.log4j.Logger;
import world.dovetail.aggregate.json.JsonAggregateStrategy;
import world.dovetail.aggregate.xml.XmlAggregateStrategy;
import org.apache.camel.Exchange;

public class AggregateStrategy implements AggregationStrategy {

    final static Logger logger = Logger.getLogger(AggregateStrategy.class);

    private AggregationStrategy AggregateStrategy;

    @Override
    public Exchange aggregate(Exchange firstExchange, Exchange newExchange) {

        String aggregateType = newExchange.getProperty("Aggregate-Type", String.class);

        if (firstExchange != null)
            aggregateType = firstExchange.getProperty("Aggregate-Type", String.class);

        switch(aggregateType) {
            case "text/xml":
                AggregateStrategy = new XmlAggregateStrategy();
                break;
            case "application/json":
                AggregateStrategy = new JsonAggregateStrategy();
        }

        return AggregateStrategy.aggregate(firstExchange, newExchange);
    }

}

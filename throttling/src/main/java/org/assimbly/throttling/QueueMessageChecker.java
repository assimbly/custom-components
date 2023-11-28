package org.assimbly.throttling;

import org.apache.activemq.broker.jmx.BrokerViewMBean;
import org.apache.activemq.broker.jmx.QueueViewMBean;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import org.apache.log4j.Logger;

import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class QueueMessageChecker implements Processor {
    private static Logger logger = Logger.getLogger(QueueMessageChecker.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        String environment = System.getenv("ASSIMBLY_ENV");
        String amqJmxPort = System.getenv("ASSIMBLY_BROKER_JMX_PORT");
        String queueName = exchange.getProperty("AssimblyQueueName", "", String.class).replace("=", "");

        String jmxUrl = "service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi";

        if(amqJmxPort==null) {
            amqJmxPort = "1616";
        }

        if(environment!=null) {
            jmxUrl = "service:jmx:rmi:///jndi/rmi://assimbly-broker-"
                    + environment
                    + ":"
                    + amqJmxPort + "/jmxrmi";
        }

        JMXServiceURL jmx = new JMXServiceURL(jmxUrl);

        try (JMXConnector jmxConnector = JMXConnectorFactory.connect(jmx)) {

            MBeanServerConnection mBeanServerConnection = jmxConnector.getMBeanServerConnection();

            ObjectName broker = new ObjectName("org.apache.activemq:type=Broker,brokerName=localhost");
            BrokerViewMBean brokerBean = JMX.newMBeanProxy(mBeanServerConnection, broker, BrokerViewMBean.class);

            Optional<ObjectName> foundQueue = Arrays.stream(brokerBean.getQueues())
                    .filter(Objects::nonNull)
                    .filter(objectName -> objectName.getKeyProperty("destinationName").contains(queueName))
                    .findFirst();

            boolean hasPendingMessages = false;
            long pendingMessagesCount = 0;

            if (foundQueue.isPresent()) {
                QueueViewMBean queueBean = JMX.newMBeanProxy(mBeanServerConnection, foundQueue.get(), QueueViewMBean.class);
                pendingMessagesCount = queueBean.getQueueSize();
                hasPendingMessages = pendingMessagesCount > 0;
            }

            exchange.setProperty("AssimblyQueueHasMessages", hasPendingMessages);

            if (hasPendingMessages)
                exchange.setProperty("AssimblyPendingMessagesCount", pendingMessagesCount);

        } catch (Exception e) {
            logger.error("Something went wrong while try to check a queue (" + queueName + ") for messages, see error below:\n" + e.getMessage());
        } finally {
            exchange.removeProperty("AssimblyQueueName");
        }
    }
}

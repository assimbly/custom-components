package org.assimbly.sql;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.text.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.assimbly.util.helper.ExchangeHelper;
import org.assimbly.util.helper.XmlHelper;
import org.assimbly.sql.adapter.DatabaseAdapter;
import org.assimbly.sql.domain.JDBCConnection;
import org.assimbly.sql.exception.SQLException;

import javax.xml.parsers.ParserConfigurationException;
import java.sql.*;

public class SqlProcessor implements Processor {

    private static final Logger LOG = LoggerFactory.getLogger(SqlProcessor.class);

    private SqlEndpoint endpoint;

    public SqlProcessor(SqlEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        SqlConfiguration config = endpoint.getConfiguration();

        JDBCConnection jdbcConnection = JDBCConnection.builder()
                    .setUsername(config.getUsername(exchange))
                    .setPassword(config.getPassword(exchange))
                    .setDatabase(config.getDatabase(exchange))
                    .setHost(config.getHost(exchange))
                    .setInstance(config.getInstance(exchange))
                    .setPort(Integer.parseInt(config.getPort(exchange)))
                    .setSecure(config.getUseSSL())
                    .setEnabledTLSProtocols(config.getTlsVersion())
                    .setEscapeChars(config.getEscapeChars())
                .build();

        DatabaseAdapter adapter = config.getConnectionType().getAdapter();

        Connection connection = jdbcConnection.connect(adapter);

        if(connection == null)
            throw new SQLException("Could not connect to the database, check your settings.");

        Document result = executeQuery(exchange, connection, config.getQuery(exchange).trim());

        exchange.getIn().setBody(XmlHelper.prettyPrint(result));
    }

    private Document executeQuery(Exchange exchange, Connection connection, String sqlQuery) throws java.sql.SQLException, ParserConfigurationException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ResultSetMetaData resultSetMetaData = null;
        Node results = null, result = null, primaryKey = null, resultSize = null, hasErrors = null;
        int rowCount = 0;

        Document doc = XmlHelper.newDocument();

        if(doc == null)
            throw new ParserConfigurationException();

        // root element
        Element rootElement = doc.createElement("ResultSet");
        doc.appendChild(rootElement);

        try {
            statement = createPreparedStatement(exchange, connection, sqlQuery);

            boolean resultSetFlag = statement.execute();

            if(resultSetFlag) {

                resultSet = statement.getResultSet();
                resultSetMetaData = resultSet.getMetaData();
                resultSize = doc.createElement("ResultSize");
                results = doc.createElement("Results");

                while (resultSet.next()) {

                    result = doc.createElement("Result");

                    for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {

                        Node attribute = doc.createElement(getValidColumnLabel(resultSetMetaData.getColumnLabel(i), i));

                        attribute.setTextContent(resultSet.getString(i));

                        result.appendChild(attribute);
                    }

                    rowCount++;
                    results.appendChild(result);
                }

                resultSize.setTextContent(String.valueOf(rowCount));
                rootElement.appendChild(resultSize);
                rootElement.appendChild(results);

                resultSet.close();
            } else {

                if(statement.getUpdateCount() > 0)
                    resultSet = statement.getGeneratedKeys();

                if(resultSet != null) {

                    hasErrors = doc.createElement("HasErrors");
                    hasErrors.setTextContent("false");

                    while (resultSet.next()) {

                        if(rowCount == 0) {
                            results = doc.createElement("Results");
                            resultSize = doc.createElement("ResultSize");
                        }

                        result = doc.createElement("Result");
                        primaryKey = doc.createElement("generatedKey");
                        primaryKey.setTextContent(String.valueOf(resultSet.getInt(1)));

                        result.appendChild(primaryKey);

                        rowCount++;
                        results.appendChild(result);
                    }

                    rootElement.appendChild(hasErrors);

                    if(results != null && resultSize != null) {
                        rootElement.appendChild(results);
                        resultSize.setTextContent(String.valueOf(rowCount));
                        rootElement.appendChild(resultSize);
                    }

                    resultSet.close();
                }
            }

            statement.close();
            connection.close();
        }catch(Exception e) {
            createErrorXml(doc, rootElement, e);
        } finally {
            //finally block used to close resources
            if(statement != null)
                statement.close();

            connection.close();
        }

        return doc;
    }

    private void createErrorXml(Document doc, Element rootElement, Exception e){
        Node hasErrors = doc.createElement("HasErrors");
        hasErrors.setTextContent(String.valueOf(true));

        Node errorMessage = doc.createElement("ErrorMessage");
        errorMessage.setTextContent(e.getMessage());

        rootElement.appendChild(hasErrors);
        rootElement.appendChild(errorMessage);
    }

    private String getValidColumnLabel(String columnLabel, int i) {
        if(columnLabel == null || columnLabel.trim().isEmpty())
            return "COLUMN" + i;

        columnLabel = columnLabel.trim();
        return columnLabel.replaceAll("[^a-zA-Z0-9_ ]", "");
    }

    private PreparedStatement createPreparedStatement(Exchange exchange, Connection connection, String sqlQuery) throws java.sql.SQLException {
        if(ExchangeHelper.hasVariables(sqlQuery))
            sqlQuery = ExchangeHelper.interpolate(sqlQuery, exchange);

        if(endpoint.getConfiguration().getEscapeChars()) {
            for(int escapesMade = 0; escapesMade < endpoint.getConfiguration().escapesNeeded(); escapesMade++) {
                sqlQuery = StringEscapeUtils.escapeJson(sqlQuery);
            }
        }

        return connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
    }

}

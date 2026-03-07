package org.assimbly.sql;

import java.sql.*;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.text.StringEscapeUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.assimbly.util.helper.ExchangeHelper;
import org.assimbly.util.helper.XmlHelper;
import org.assimbly.sql.adapter.DatabaseAdapter;
import org.assimbly.sql.domain.JDBCConnection;
import org.assimbly.sql.exception.SQLException;

import javax.xml.parsers.ParserConfigurationException;

public class SqlProcessor implements Processor {

    private final SqlEndpoint endpoint;

    public SqlProcessor(SqlEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        SqlConfiguration config = endpoint.getConfiguration();
        Connection connection = openConnection(config, exchange);

        if (connection == null)
            throw new SQLException("Could not connect to the database, check your settings.");

        Document result = executeQuery(exchange, connection, config.getQuery().trim());
        exchange.getIn().setBody(XmlHelper.prettyPrint(result));
    }

    private Connection openConnection(SqlConfiguration config, Exchange exchange) throws Exception {
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
        return jdbcConnection.connect(adapter);
    }

    private Document executeQuery(Exchange exchange, Connection connection, String sqlQuery) throws java.sql.SQLException, ParserConfigurationException {
        Document doc = XmlHelper.newDocument();

        if (doc == null)
            throw new ParserConfigurationException();

        Element rootElement = doc.createElement("ResultSet");
        doc.appendChild(rootElement);

        PreparedStatement statement = createPreparedStatement(exchange, connection, sqlQuery);

        try {
            boolean hasResultSet = statement.execute();
            if (hasResultSet)
                appendSelectResults(doc, rootElement, statement.getResultSet());
            else
                appendUpdateResults(doc, rootElement, statement);
        } catch (Exception e) {
            appendErrorNodes(doc, rootElement, e);
        } finally {
            closeResources(statement, connection);
        }

        return doc;
    }

    private void appendSelectResults(Document doc, Element rootElement, ResultSet resultSet) throws java.sql.SQLException {
        ResultSetMetaData meta = resultSet.getMetaData();
        Element results = doc.createElement("Results");
        int rowCount = 0;

        while (resultSet.next()) {
            results.appendChild(buildResultRow(doc, resultSet, meta));
            rowCount++;
        }

        appendResultSize(doc, rootElement, rowCount);
        rootElement.appendChild(results);
        resultSet.close();
    }

    private Node buildResultRow(Document doc, ResultSet resultSet, ResultSetMetaData meta) throws java.sql.SQLException {
        Node result = doc.createElement("Result");

        for (int i = 1; i <= meta.getColumnCount(); i++) {
            Node attribute = doc.createElement(getValidColumnLabel(meta.getColumnLabel(i), i));
            attribute.setTextContent(resultSet.getString(i));
            result.appendChild(attribute);
        }

        return result;
    }

    private void appendUpdateResults(Document doc, Element rootElement, PreparedStatement statement) throws java.sql.SQLException {
        appendHasErrors(doc, rootElement, false);

        if (statement.getUpdateCount() <= 0) return;

        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys == null) return;

        appendGeneratedKeys(doc, rootElement, generatedKeys);
        generatedKeys.close();
    }

    private void appendGeneratedKeys(Document doc, Element rootElement, ResultSet generatedKeys) throws java.sql.SQLException {
        Element results = doc.createElement("Results");
        int rowCount = 0;

        while (generatedKeys.next()) {
            Node result = doc.createElement("Result");
            Node primaryKey = doc.createElement("generatedKey");
            primaryKey.setTextContent(String.valueOf(generatedKeys.getInt(1)));
            result.appendChild(primaryKey);
            results.appendChild(result);
            rowCount++;
        }

        rootElement.appendChild(results);
        appendResultSize(doc, rootElement, rowCount);
    }

    private void appendResultSize(Document doc, Element rootElement, int rowCount) {
        Node resultSize = doc.createElement("ResultSize");
        resultSize.setTextContent(String.valueOf(rowCount));
        rootElement.appendChild(resultSize);
    }

    private void appendHasErrors(Document doc, Element rootElement, boolean hasErrors) {
        Node hasErrorsNode = doc.createElement("HasErrors");
        hasErrorsNode.setTextContent(String.valueOf(hasErrors));
        rootElement.appendChild(hasErrorsNode);
    }

    private void appendErrorNodes(Document doc, Element rootElement, Exception e) {
        appendHasErrors(doc, rootElement, true);
        Node errorMessage = doc.createElement("ErrorMessage");
        errorMessage.setTextContent(e.getMessage());
        rootElement.appendChild(errorMessage);
    }

    private void closeResources(PreparedStatement statement, Connection connection) throws java.sql.SQLException {
        if (statement != null) statement.close();
        connection.close();
    }

    private String getValidColumnLabel(String columnLabel, int i) {
        if (columnLabel == null || columnLabel.trim().isEmpty())
            return "COLUMN" + i;

        return columnLabel.trim().replaceAll("[^a-zA-Z0-9_ ]", "");
    }

    private PreparedStatement createPreparedStatement(Exchange exchange, Connection connection, String sqlQuery) throws java.sql.SQLException {
        if (ExchangeHelper.hasVariables(sqlQuery))
            sqlQuery = ExchangeHelper.interpolate(sqlQuery, exchange);

        if (endpoint.getConfiguration().getEscapeChars())
            for (int i = 0; i < endpoint.getConfiguration().escapesNeeded(); i++)
                sqlQuery = StringEscapeUtils.escapeJson(sqlQuery);

        return connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
    }

}
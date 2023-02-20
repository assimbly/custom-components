package org.assimbly.fmuta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FmutaFeedEnricher {
    private static final String BYTE_ORDER_MARK = "\uFEFF";
    private static final String LINE_NUMBER_LABEL = "Regelnr";
    private static final String VOUCHER_NUMBER_HEADER = "BoekstukNr";
    private static final String DESCRIPTION_HEADER_FOR_HEADERS = "HeaderOmschrijving";
    private static final String DESCRIPTION_HEADER_FOR_LINES = "RegelOmschrijving";
    private static final String DESCRIPTION_HEADER = "Omschrijving";
    private static final String COUNTER_ACCOUNT_HEADER = "Tegenrekening";
    private static final String INVOICE_NUMBER_HEADER = "Factuurnr";
    private static final String AMOUNT_HEADER = "Bedrag";
    private static final String INCL_EXCL_HEADER = "Incl_Excl";
    private static final String EXCHANGE_RATE_HEADER = "Koers";
    private static final String INVOICE_EXPIRATION_DATE_HEADER = "Vervaldatum_Factuur";
    private static final String CREDIT_DISCOUNT_EXPIRATION_DATE_HEADER = "Vervaldatum_Bedrag_Krediet_bep";
    private static final String VAT_CODE_HEADER = "BTWCode";
    private static final String VAT_AMOUNT_HEADER = "BTWBedrag";
    private static final String REFERENCE_HEADER = "Referentie";
    private static final String PAYMENT_METHOD_HEADER = "Betalingswijze";

    private static final Logger logger = LoggerFactory.getLogger(FmutaFeedEnricher.class);

    private BigDecimalConverter converterForInput = new BigDecimalConverter(',');
    private BigDecimalConverter converterForOutput;

    private String LINE_NUMBER_HEADER;

    public FmutaFeedEnricher(char decimalSeparator) {
        this.converterForOutput = new BigDecimalConverter(decimalSeparator);
    }

    public List<Map<String, Object>> enrich(List<Map<String, Object>> body) {
        validate(body);

        logger.info("Enriching FMUTA feed containing {} lines", body.size());

        convertAmounts(body);
        List<Map<String, Object>> enrichedWithHeaders = enrichWithHeaders(body);
        splitDescriptions(enrichedWithHeaders);
        enrichWithRunningTotal(enrichedWithHeaders);
        revertAmounts(enrichedWithHeaders);
        clearFields(enrichedWithHeaders);
        dropAuxiliaryColumns(enrichedWithHeaders);

        logger.info("Enriched FMUTA feed contains {} lines", enrichedWithHeaders.size());

        return enrichedWithHeaders;
    }

    private void validate(List<Map<String, Object>> body) {
        if (body == null) {
            throw new IllegalArgumentException("Null body provided");
        }

        if (body.size() > 0) {
            Map<String, Object> firstLine = body.get(0);

            LINE_NUMBER_HEADER = findLineNumberHeader(firstLine);

            if (firstLine.get(LINE_NUMBER_HEADER) == null) {
                throw new IllegalArgumentException("No name for the column containing line numbers found");
            }
            if (firstLine.get(AMOUNT_HEADER) == null) {
                throw new IllegalArgumentException("No name for the column containing amounts found");
            }
            if (firstLine.get(INCL_EXCL_HEADER) == null) {
                throw new IllegalArgumentException("No name for the column indicating whether amounts contain VAT found");
            }
            if (firstLine.get(VAT_AMOUNT_HEADER) == null) {
                throw new IllegalArgumentException("No name for the column containing VAT amounts found");
            }

            logger.info("Input contains all required columns");
        } else {
            logger.info("Body contains no lines");
        }
    }

    private void convertAmounts(List<Map<String, Object>> lines) {
        for (Map<String, Object> line : lines) {
            line.put(AMOUNT_HEADER, converterForInput.convert((String) line.get(AMOUNT_HEADER)));
            line.put(VAT_AMOUNT_HEADER, converterForInput.convert((String) line.get(VAT_AMOUNT_HEADER)));
        }
    }

    private void revertAmounts(List<Map<String, Object>> lines) {
        for (Map<String, Object> line : lines) {
            line.put(AMOUNT_HEADER, converterForOutput.revert((BigDecimal) line.get(AMOUNT_HEADER)));
            line.put(VAT_AMOUNT_HEADER, converterForOutput.revert((BigDecimal) line.get(VAT_AMOUNT_HEADER)));
        }
    }

    private List<Map<String, Object>> enrichWithHeaders(List<Map<String, Object>> lines) {
        List<Map<String, Object>> result = new ArrayList<>(lines.size() * 2);
        for (Map<String, Object> line : lines) {
            String lineNumber = (String) line.get(LINE_NUMBER_HEADER);
            if ("1".equals(lineNumber)) {
                logger.debug("Adding header to output");

                Map<String, Object> header = new LinkedHashMap<>(line);
                header.put(LINE_NUMBER_HEADER, "0");
                result.add(header);
            }
            result.add(line);
        }
        return result;
    }


    private void splitDescriptions(List<Map<String, Object>> lines) {
        for (Map<String, Object> line : lines) {
            String lineNumber = (String) line.get(LINE_NUMBER_HEADER);
            if ("0".equals(lineNumber)) {
                line.put(DESCRIPTION_HEADER, line.get(DESCRIPTION_HEADER_FOR_HEADERS));
            } else {
                line.put(DESCRIPTION_HEADER, line.get(DESCRIPTION_HEADER_FOR_LINES));
            }
        }
    }

    private void enrichWithRunningTotal(List<Map<String, Object>> lines) {
        Map<String, Object> header = null;
        for (Map<String, Object> line : lines) {
            String lineNumber = (String) line.get(LINE_NUMBER_HEADER);
            if ("0".equals(lineNumber)) {
                header = line;
                header.put(AMOUNT_HEADER, BigDecimal.ZERO);
                header.put(VAT_AMOUNT_HEADER, BigDecimal.ZERO);
            }

            if (header != null) {
                BigDecimal runningTotal = (BigDecimal) header.get(AMOUNT_HEADER);
                BigDecimal amount = (BigDecimal) line.get(AMOUNT_HEADER);
                String inclExclValue = (String) line.get(INCL_EXCL_HEADER);
                if ("Excl".equals(inclExclValue)) {
                    BigDecimal vatAmount = (BigDecimal) line.get(VAT_AMOUNT_HEADER);
                    amount = amount.add(vatAmount);
                }
                header.put(AMOUNT_HEADER, runningTotal.add(amount));
            }
        }
    }

    private void clearFields(List<Map<String, Object>> lines) {
        for (Map<String, Object> line : lines) {
            String lineNumber = (String) line.get(LINE_NUMBER_HEADER);
            if ("0".equals(lineNumber)) {
                clearHeaderFields(line);
            } else {
                clearLineFields(line);
            }
        }
    }

    private void clearHeaderFields(Map<String, Object> header) {
        header.put(COUNTER_ACCOUNT_HEADER, "");
        header.put(INVOICE_NUMBER_HEADER, "");
        header.put(EXCHANGE_RATE_HEADER, "");
        header.put(VAT_CODE_HEADER, "");
        header.put(VAT_AMOUNT_HEADER, "");
    }

    private void clearLineFields(Map<String, Object> line) {
        line.put(VOUCHER_NUMBER_HEADER, "");
        line.put(INVOICE_EXPIRATION_DATE_HEADER, "");
        line.put(CREDIT_DISCOUNT_EXPIRATION_DATE_HEADER, "");
        line.put(REFERENCE_HEADER, "");
        line.put(PAYMENT_METHOD_HEADER, "");
    }

    private void dropAuxiliaryColumns(List<Map<String, Object>> lines) {
        for (Map<String, Object> line : lines) {
            line.remove(INCL_EXCL_HEADER);
            line.remove(DESCRIPTION_HEADER_FOR_HEADERS);
            line.remove(DESCRIPTION_HEADER_FOR_LINES);
        }
    }

    private String findLineNumberHeader(Map<String, Object> firstLine) {

        if (firstLine.keySet().contains(LINE_NUMBER_LABEL))
            return LINE_NUMBER_LABEL;

        return BYTE_ORDER_MARK + LINE_NUMBER_LABEL;
    }
}

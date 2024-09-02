package org.assimbly.oriflame.details;

import com.google.common.collect.Lists;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.AttributesImpl;

import jakarta.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EdiDetails {

    public static final String XMLNS = "_XMLNS";

    public static final EdiDetails PII_DETAILS;
    public static final EdiDetails PIOR_DETAILS;
    public static final EdiDetails PIOR_CROSS_DETAILS;
    public static final EdiDetails PIT_DETAILS;
    public static final EdiDetails POOI_DETAILS;
    public static final EdiDetails PPOO_DETAILS;

    static {
        PII_DETAILS = new EdiDetails(true);
        PIOR_DETAILS = new EdiDetails();
        PIOR_CROSS_DETAILS = new EdiDetails();
        PIT_DETAILS = new EdiDetails();
        POOI_DETAILS = new EdiDetails();
        PPOO_DETAILS = new EdiDetails();

        /*
         * PII
         */
        PII_DETAILS.lineReaders.put("$group$MAIN", "GROUP_NAME[4]");
        PII_DETAILS.lineReaders.put("$group$HDR", "GROUP_NAME[3]BPP[10]BOX_SIZE[10]BOX_WEIGHT[10]CATALOG_NO[16]" +
                "COUNTRY_OF_ORIGIN_1[3]COUNTRY_OF_ORIGIN_2[3]COUNTRY_OF_ORIGIN_3[3]COUNTRY_OF_ORIGIN_4[3]" +
                "COUNTRY_OF_ORIGIN_5[3]DESCRIPTION[30]DESCRIPTION_2[30]DIMENSIONS[14]EXPIRING[1]" +
                "INVENTORY_VALUE[13]STATE[8]UOM[3]GTIN[30]");
        PII_DETAILS.lineReaders.put("$group$DET", "GROUP_NAME[3]PART_NO[16]PART_QTY[10]");

        PII_DETAILS.groupings.put("MAIN", Lists.newArrayList("ITEM_INFORMATION"));
        PII_DETAILS.groupings.put("HDR", Lists.newArrayList("ITEM_INFORMATION_DETAILS", "ITEM_INFORMATION_DETAIL"));
        PII_DETAILS.groupings.put("DET", Lists.newArrayList("COMPONENT_PARTS", "COMPONENT_PART"));

        PII_DETAILS.fields.put("MAIN", Lists.newArrayList("SITE", "SOURCE"));
        PII_DETAILS.fields.put("HDR", Lists.newArrayList("BPP","BOX_SIZE","BOX_WEIGHT","CATALOG_NO","COUNTRY_OF_ORIGIN_1",
                "COUNTRY_OF_ORIGIN_2","COUNTRY_OF_ORIGIN_3","COUNTRY_OF_ORIGIN_4","COUNTRY_OF_ORIGIN_5",
                "DESCRIPTION","DESCRIPTION2","DIMENSIONS","EXPIRING","GTIN","INVENTORY_VALUE","STATE","UOM"));
        PII_DETAILS.fields.put("DET", Lists.newArrayList("PART_NO","PART_QTY"));

        PII_DETAILS.nodeAttributes.put("ITEM_INFORMATION" + XMLNS, "urn:ifsworld-com:schemas:post_item_information");

        PII_DETAILS.fieldTypes.put("BPP", FieldType.FLOAT);
        PII_DETAILS.fieldTypes.put("BOX_SIZE", FieldType.FLOAT);
        PII_DETAILS.fieldTypes.put("BOX_WEIGHT", FieldType.FLOAT);
        PII_DETAILS.fieldTypes.put("PART_QTY", FieldType.FLOAT);

        /*
         * PIOR
         */
        PIOR_DETAILS.lineReaders.put("$group$HDR", "GROUP_NAME[3]DATE_CREATED[8]DELIVERY_DATE[8]ORDER_NO[16]ORDER_TYPE[30]REMARKS[70]IGNORE[10]VENDOR_NO[20]INBOUND_COMPLETE[1]GLN_RECEIVER[30]GLN_SENDER[30]");
        PIOR_DETAILS.lineReaders.put("$group$PAL", "GROUP_NAME[3]PALLET_ID[20]BPP[30]UPP[30]");
        PIOR_DETAILS.lineReaders.put("$group$ART", "GROUP_NAME[3]BATCH_NO[70]BOX_SIZE[20]BOX_WEIGHT[20]COUNTRY_OF_ORIGIN[3]CUSTOMS_STAT_NO[70]DELNOTE_NO[30]DIMENSIONS[26]EXPIRY_DATE[8]LOCATION_NO[1]PALLET_ID[70]PART_NO[16]QUANTITY[10]REASON_CODE[50]REMARKS[70]SEQUENCE_NO[10]BOX_ID[30]COUNTRY_OF_FILLING[30]GTIN[30]PRODUCTION_DATE[30]");

        PIOR_DETAILS.groupings.put("HDR", Lists.newArrayList("INBOUND_ORDER_RECEIPT"));
        PIOR_DETAILS.groupings.put("PAL", Lists.newArrayList("INBOUND_ORDER_RECEIPT_PALLETS", "INBOUND_ORDER_RECEIPT_PALLET"));
        PIOR_DETAILS.groupings.put("ART", Lists.newArrayList("INBOUND_ORDER_RECEIPT_LINES", "INBOUND_ORDER_RECEIPT_LINE"));

        PIOR_DETAILS.fields.put("HDR", Lists.newArrayList("DATE_CREATED","DELIVERY_DATE","GLN_RECEIVER","GLN_SENDER","INBOUND_COMPLETE","ORDER_NO", "ORDER_TYPE","REMARKS","SITE","VENDOR_NO"));
        PIOR_DETAILS.fields.put("PAL", Lists.newArrayList("BPP","PALLET_ID","UPP"));
        PIOR_DETAILS.fields.put("ART", Lists.newArrayList("BATCH_NO","BOX_ID","BOX_SIZE","BOX_WEIGHT","COUNTRY_OF_FILLING","COUNTRY_OF_ORIGIN","CUSTOMS_STAT_NO","DELNOTE_NO","DIMENSIONS","EXPIRY_DATE","GTIN","LOCATION_NO","PART_NO","PRODUCTION_DATE","QUANTITY","REASON_CODE","REMARKS","SEQUENCE_NO"));

        PIOR_DETAILS.nodeAttributes.put("INBOUND_ORDER_RECEIPT" + XMLNS, "urn:ifsworld-com:schemas:post_inbound_order_receipt");

        PIOR_DETAILS.fieldTypes.put("DATE_CREATED", FieldType.DATE);
        PIOR_DETAILS.fieldTypes.put("DELIVERY_DATE", FieldType.DATE);
        PIOR_DETAILS.fieldTypes.put("BPP", FieldType.FLOAT);
        PIOR_DETAILS.fieldTypes.put("UPP", FieldType.FLOAT);
        PIOR_DETAILS.fieldTypes.put("BOX_SIZE", FieldType.FLOAT);
        PIOR_DETAILS.fieldTypes.put("BOX_WEIGHT", FieldType.FLOAT);
        PIOR_DETAILS.fieldTypes.put("EXPIRY_DATE", FieldType.DATE);
        PIOR_DETAILS.fieldTypes.put("PRODUCTION_DATE", FieldType.DATE);
        PIOR_DETAILS.fieldTypes.put("QUANTITY", FieldType.FLOAT);
        PIOR_DETAILS.fieldTypes.put("SEQUENCE_NO", FieldType.FLOAT);

        /*
         * PIOR_CROSS
         */
        PIOR_CROSS_DETAILS.lineReaders.put("$group$HDR", "GROUP_NAME[3]DATE_CREATED[8]DELIVERY_DATE[8]ORDER_NO[16]ORDER_TYPE[30]REMARKS[70]SITE[10]VENDOR_NO[20]INBOUND_COMPLETE[1]GLN_RECEIVER[30]GLN_SENDER[30]");
        PIOR_CROSS_DETAILS.lineReaders.put("$group$PAL", "GROUP_NAME[3]PALLET_ID[20]BPP[30]UPP[30]");
        PIOR_CROSS_DETAILS.lineReaders.put("$group$ART", "GROUP_NAME[3]BATCH_NO[70]BOX_SIZE[20]BOX_WEIGHT[20]COUNTRY_OF_ORIGIN[3]CUSTOMS_STAT_NO[70]DELNOTE_NO[30]DIMENSIONS[26]EXPIRY_DATE[8]LOCATION_NO[1]PALLET_ID[70]PART_NO[16]QUANTITY[10]REASON_CODE[50]REMARKS[70]SEQUENCE_NO[10]BOX_ID[30]COUNTRY_OF_FILLING[30]GTIN[30]PRODUCTION_DATE[30]");

        PIOR_CROSS_DETAILS.groupings.put("HDR", Lists.newArrayList("INBOUND_ORDER_RECEIPT"));
        PIOR_CROSS_DETAILS.groupings.put("PAL", Lists.newArrayList("INBOUND_ORDER_RECEIPT_PALLETS", "INBOUND_ORDER_RECEIPT_PALLET"));
        PIOR_CROSS_DETAILS.groupings.put("ART", Lists.newArrayList("INBOUND_ORDER_RECEIPT_LINES", "INBOUND_ORDER_RECEIPT_LINE"));

        PIOR_CROSS_DETAILS.fields.put("HDR", Lists.newArrayList("DATE_CREATED","DELIVERY_DATE","GLN_RECEIVER","GLN_SENDER","INBOUND_COMPLETE","ORDER_NO", "ORDER_TYPE","REMARKS","SITE","VENDOR_NO"));
        PIOR_CROSS_DETAILS.fields.put("PAL", Lists.newArrayList("BPP","PALLET_ID","UPP"));
        PIOR_CROSS_DETAILS.fields.put("ART", Lists.newArrayList("BATCH_NO","BOX_ID","BOX_SIZE","BOX_WEIGHT","COUNTRY_OF_FILLING","COUNTRY_OF_ORIGIN","CUSTOMS_STAT_NO","DELNOTE_NO","DIMENSIONS","EXPIRY_DATE","GTIN","LOCATION_NO","PART_NO","PRODUCTION_DATE","QUANTITY","REASON_CODE","REMARKS","SEQUENCE_NO"));

        PIOR_CROSS_DETAILS.nodeAttributes.put("INBOUND_ORDER_RECEIPT" + XMLNS, "urn:ifsworld-com:schemas:post_inbound_order_receipt");

        PIOR_CROSS_DETAILS.fieldTypes.put("DATE_CREATED", FieldType.DATE);
        PIOR_CROSS_DETAILS.fieldTypes.put("DELIVERY_DATE", FieldType.DATE);
        PIOR_CROSS_DETAILS.fieldTypes.put("BPP", FieldType.FLOAT);
        PIOR_CROSS_DETAILS.fieldTypes.put("UPP", FieldType.FLOAT);
        PIOR_CROSS_DETAILS.fieldTypes.put("BOX_SIZE", FieldType.FLOAT);
        PIOR_CROSS_DETAILS.fieldTypes.put("BOX_WEIGHT", FieldType.FLOAT);
        PIOR_CROSS_DETAILS.fieldTypes.put("EXPIRY_DATE", FieldType.DATE);
        PIOR_CROSS_DETAILS.fieldTypes.put("PRODUCTION_DATE", FieldType.DATE);
        PIOR_CROSS_DETAILS.fieldTypes.put("QUANTITY", FieldType.FLOAT);
        PIOR_CROSS_DETAILS.fieldTypes.put("SEQUENCE_NO", FieldType.FLOAT);

        /*
         * PIT
         */
        PIT_DETAILS.lineReaders.put("$group$HDR", "GROUP_NAME[3]TRANSACTION_TYPE[26]GLN[21]");
        PIT_DETAILS.lineReaders.put("$group$ART", "GROUP_NAME[3]ERROR_TEXT[50]EXPIRY_DATE[8]EXPIRY_DATE_TO[8]LOCATION_NO[1]LOCATION_NO_TO[10]PART_NO[16]QUANTITY[10]REASON_CODE[50]COUNTRY_OF_ORIGIN[3]STATUS[10]STOCK_ADJ_DATE[8]BATCH_NO[20]BOX_ID[30]ERROR_TEXT[30]GTIN[30]");

        PIT_DETAILS.groupings.put("HDR", Lists.newArrayList("INVENTORY_TRANSACTIONS"));
        PIT_DETAILS.groupings.put("ART", Lists.newArrayList("ITEMS", "INVENTORY_TRANSACTION"));

        PIT_DETAILS.fields.put("HDR", Lists.newArrayList("GLN","SITE","SOURCE","TRANSACTION_TYPE"));
        PIT_DETAILS.fields.put("ART", Lists.newArrayList("BATCH_NO","BOX_ID","COUNTRY_OF_ORIGIN","ERROR_TEXT","EXPIRY_DATE","GTIN","LOCATION_NO","LOCATION_NO_TO","PART_NO","QUANTITY","REASON_CODE","STATUS","STOCK_ADJ_DATE"));

        PIT_DETAILS.nodeAttributes.put("INVENTORY_TRANSACTIONS" + XMLNS, "urn:ifsworld-com:schemas:post_inventory_transactions");

        PIT_DETAILS.fieldTypes.put("EXPIRY_DATE", FieldType.DATE);
        PIT_DETAILS.fieldTypes.put("STOCK_ADJ_DATE", FieldType.DATE);

        /*
         * POOI
         */
        POOI_DETAILS.lineReaders.put("$group$HDR", "GROUP_NAME[3]AIRWAY_BILL_NO[10]CUST_REF[10]CUSTOMER_NO[10]DELIVERY_DATE[8]NOTE_ID[15]REMARKS[70]SCRAP_REASON[50]SHIPMENT_ID[30]SHIPPED_DATE[8]IGNORE[10]TERMS_DELIVERY[20]TERMS_PAYMENT[20]GLN_SENDER[13]");
        POOI_DETAILS.lineReaders.put("$group$ADR", "GROUP_NAME[3]ADDRESS_LINE_1[30]ADDRESS_LINE_2[30]ADDRESS_LINE_3[30]ADDRESS_LINE_4[30]CITY[25]CO_ORDER_TYPE[20]COUNTRY[2]CRT_QTY[10]CURRENCY[5]CUSTOMS_DUTY_COST[10]DELIVERY_COST[10]DESTINATION_ID[10]GROSS_WEIGHT[20]INSURANCE_COST[20]INVOICE_ADDRESS_NO[20]INVOICE_NO[20]NOTE_TEXT[70]OUTBOUND_COMPLETE[5]PALLET_COST[20]PALLET_QTY[20]PALLET_WEIGHT[20]SENDER_REF[20]SHIP_VIA_CODE[20]ZIP_CODE[8]GLN_RECEIVER[13]SOURCE_WAREHOUSE_ID[30]");
        POOI_DETAILS.lineReaders.put("$group$PLT", "GROUP_NAME[3]PALLET_ID[20]BPP[30]UPP[30]");
        POOI_DETAILS.lineReaders.put("$group$ISL", "GROUP_NAME[3]BATCH_NO[30]BOX_SIZE[20]BOX_WEIGHT[20]COUNTRY_OF_ORIGIN[2]CUSTOMS_STAT_NO[30]DELNOTE_NO[30]DIMENSIONS[26]EXPIRY_DATE[8]LINE_NO[6]LOCATION_NO[5]NET_WEIGHT[20]ORIGINAL_PART_NO[16]PART_NO[16]PICK_LIST_NO[30]PLANNED_DELIVERY_DATE[8]PROMISED_DELIVERY_DATE[8]QUANTITY[10]REL_NO[15]REMARKS[70]SEQUENCE_NO[10]UNIT_PRICE[10]WANTED_DELIVERY_DATE[8]BOX_ID[30]COUNTRY_OF_FILLING[2]EARLIEST_START_DATE[8]GTIN[30]INBOUND_REFERENCE[30]PRODUCTION_DATE[8]");

        POOI_DETAILS.groupings.put("HDR", Lists.newArrayList("OUTBOUND_ORDER_ISSUE"));
        POOI_DETAILS.groupings.put("ADR", Lists.newArrayList("HEADERS", "OUTBOUND_ORDER_ISSUE_HEADER"));
        POOI_DETAILS.groupings.put("PLT", Lists.newArrayList("PALLETS", "OUTBOUND_ORDER_ISSUE_PALLET"));
        POOI_DETAILS.groupings.put("ISL", Lists.newArrayList("LINES", "OUTBOUND_ORDER_ISSUE_LINE"));

        POOI_DETAILS.fields.put("HDR", Lists.newArrayList("AIRWAY_BILL_NO","CUST_REF","CUSTOMER_NO","DELIVERY_DATE","GLN_SENDER",
                "NOTE_ID","REMARKS","SCRAP_REASON","SHIPMENT_ID","SHIPPED_DATE","SITE","TERMS_DELIVERY","TERMS_PAYMENT"));
        POOI_DETAILS.fields.put("ADR", Lists.newArrayList("ADDRESS_LINE_1","ADDRESS_LINE_2","ADDRESS_LINE_3","ADDRESS_LINE_4","CITY",
                "CO_ORDER_TYPE","COUNTRY","CRT_QTY","CURRENCY","CUSTOMS_DUTY_COST","DELIVERY_COST","DESTINATION_ID",
                "GLN_RECEIVER","GROSS_WEIGHT","INSURANCE_COST","INVOICE_ADDRESS_NO","INVOICE_NO","NOTE_TEXT",
                "OUTBOUND_COMPLETE","PALLET_COST","PALLET_QTY","PALLET_WEIGHT","SENDER_REF","SHIP_VIA_CODE",
                "SOURCE_WAREHOUSE_ID","ZIP_CODE","CHARGES"));
        POOI_DETAILS.fields.put("PLT", Lists.newArrayList("BPP","PALLET_ID","UPP"));
        POOI_DETAILS.fields.put("ISL", Lists.newArrayList("BATCH_NO","BOX_ID","BOX_SIZE","BOX_WEIGHT","COUNTRY_OF_FILLING",
                "COUNTRY_OF_ORIGIN","CUSTOMS_STAT_NO","DELNOTE_NO","DIMENSIONS","EARLIEST_START_DATE","EXPIRY_DATE",
                "GTIN","INBOUND_REFERENCE","LINE_NO","LOCATION_NO","NET_WEIGHT","ORIGINAL_PART_NO","PART_NO",
                "PICK_LIST_NO","PLANNED_DELIVERY_DATE","PRODUCTION_DATE","PROMISED_DELIVERY_DATE","QUANTITY",
                "REL_NO","REMARKS","SEQUENCE_NO","UNIT_PRICE","WANTED_DELIVERY_DATE"));

        POOI_DETAILS.nodeAttributes.put("OUTBOUND_ORDER_ISSUE" + XMLNS, "urn:ifsworld-com:schemas:post_outbound_order_issue");

        POOI_DETAILS.fieldTypes.put("DATE_CREATED", FieldType.DATE);
        POOI_DETAILS.fieldTypes.put("SHIPPED_DATE", FieldType.DATE);
        POOI_DETAILS.fieldTypes.put("DELIVERY_DATE", FieldType.DATE);
        POOI_DETAILS.fieldTypes.put("BPP", FieldType.FLOAT);
        POOI_DETAILS.fieldTypes.put("UPP", FieldType.FLOAT);
        POOI_DETAILS.fieldTypes.put("BOX_SIZE", FieldType.FLOAT);
        POOI_DETAILS.fieldTypes.put("BOX_WEIGHT", FieldType.FLOAT);
        POOI_DETAILS.fieldTypes.put("EXPIRY_DATE", FieldType.DATE);
        POOI_DETAILS.fieldTypes.put("PRODUCTION_DATE", FieldType.DATE);
        POOI_DETAILS.fieldTypes.put("QUANTITY", FieldType.FLOAT);
        POOI_DETAILS.fieldTypes.put("SEQUENCE_NO", FieldType.FLOAT);
        POOI_DETAILS.fieldTypes.put("CRT_QTY", FieldType.FLOAT);
        POOI_DETAILS.fieldTypes.put("GROSS_WEIGHT", FieldType.FLOAT);
        POOI_DETAILS.fieldTypes.put("PALLET_QTY", FieldType.FLOAT);
        POOI_DETAILS.fieldTypes.put("PALLET_WEIGHT", FieldType.FLOAT);
        POOI_DETAILS.fieldTypes.put("EARLIEST_START_DATE", FieldType.DATE);
        POOI_DETAILS.fieldTypes.put("PLANNED_DELIVERY_DATE", FieldType.DATE);
        POOI_DETAILS.fieldTypes.put("WANTED_DELIVERY_DATE", FieldType.DATE);
        POOI_DETAILS.fieldTypes.put("NET_WEIGHT", FieldType.FLOAT);
        POOI_DETAILS.fieldTypes.put("REMARKS", FieldType.ENCODED);

        /*
         * PPOO
         */
        PPOO_DETAILS.lineReaders.put("$group$HDR", "GROUP_NAME[3]CUSTOMER_REF[20]CUSTOMER_NO[10]PALLET_QTY[10]SHIPMENT_ID[10]IGNORE[3]GLN_SENDER[30]");
        PPOO_DETAILS.lineReaders.put("$group$POH", "GROUP_NAME[3]COMPLETE_INSPECTION[30]COURIER_ID[10]COURIER_NAME[10]DESTINATION_ID[10]GROSS_WEIGHT[10]PALLET_ID[10]PALLET_WEIGHT[10]SHIP_VIA_CODE[10]STATUS[10]FULLPACKER_PICKING[10]SINGLEUNIT_PICKING[10]GLN_RECEIVER[13]");
        PPOO_DETAILS.lineReaders.put("$group$POC", "GROUP_NAME[3]BATCH_ID[10]CONSIGNMENT_ID[10]CRT_QTY[10]PAYMENT_AMOUNT[10]PAYMENT_CURRENCY[10]PICKUP_ADDRESS_LINE_1[70]PICKUP_ADDRESS_LINE_2[70]PICKUP_ADDRESS_LINE_3[70]PICKUP_CITY[70]PICKUP_COUNTRY[50]PICKUP_EMAIL[70]PICKUP_ID[10]PICKUP_MANAGER[70]PICKUP_NAME[70]PICKUP_PHONE[20]PICKUP_ZIPCODE[20]ROUTE_DESCRIPTION[70]ROUTE_ID[20]SERVICE_TYPE[20]");
        PPOO_DETAILS.lineReaders.put("$group$POB", "GROUP_NAME[3]BOX_ID[20]CONSULTANT_ADDRESS_LINE_1[70]CONSULTANT_ADDRESS_LINE_2[70]CONSULTANT_ADDRESS_LINE_3[70]CONSULTANT_CITY[70]CONSULTANT_COUNTRY[50]CONSULTANT_EMAIL[70]CONSULTANT_ID[10]CONSULTANT_NAME[70]CONSULTANT_ORDER_NO[70]CONSULTANT_PHONE[20]CONSULTANT_ZIPCODE[70]TRACKING_ID[70]VOLUME[20]WEIGHT[20]");

        PPOO_DETAILS.groupings.put("HDR", Lists.newArrayList("PALLET_OUTBOUND_ORDER"));
        PPOO_DETAILS.groupings.put("POH", Lists.newArrayList("PALLET_OUTBOUND_HEADERS", "PALLET_OUTBOUND_HEADER"));
        PPOO_DETAILS.groupings.put("POC", Lists.newArrayList("PALLET_OUTBOUND_CONSIGNMENTS", "PALLET_OUTBOUND_CONSIGNMENT"));
        PPOO_DETAILS.groupings.put("POB", Lists.newArrayList("PALLET_OUTBOUND_BOXES", "PALLET_OUTBOUND_BOX"));

        PPOO_DETAILS.fields.put("HDR", Lists.newArrayList("CUSTOMER_NO","CUSTOMER_REF","GLN_SENDER","PALLET_QTY",
                "SHIPMENT_ID","SITE","PALLET_OUTBOUND_HEADERS"));
        PPOO_DETAILS.fields.put("POH", Lists.newArrayList("COMPLETE_INSPECTION","COURIER_ID","COURIER_NAME",
                "DESTINATION_ID","FULLPACKER_PICKING","GLN_RECEIVER","GROSS_WEIGHT","PALLET_ID","PALLET_WEIGHT",
                "SHIP_VIA_CODE","SINGLEUNIT_PICKING","STATUS","PALLET_OUTBOUND_CONSIGNMENTS"));
        PPOO_DETAILS.fields.put("POC", Lists.newArrayList("BATCH_ID","CONSIGNMENT_ID","CRT_QTY","PAYMENT_AMOUNT",
                "PAYMENT_CURRENCY","PICKUP_ADDRESS_LINE_1","PICKUP_ADDRESS_LINE_2","PICKUP_ADDRESS_LINE_3",
                "PICKUP_CITY","PICKUP_COUNTRY","PICKUP_EMAIL","PICKUP_ID","PICKUP_MANAGER","PICKUP_NAME","PICKUP_PHONE",
                "PICKUP_ZIP_CODE","ROUTE_DESCRIPTION","ROUTE_ID","SERVICE_TYPE","PALLET_OUTBOUND_BOXES"));
        PPOO_DETAILS.fields.put("POB", Lists.newArrayList("BOX_ID","CONSULTANT_ADDRESS_LINE_1",
                "CONSULTANT_ADDRESS_LINE_2","CONSULTANT_ADDRESS_LINE_3","CONSULTANT_CITY","CONSULTANT_COUNTRY",
                "CONSULTANT_EMAIL","CONSULTANT_ID","CONSULTANT_NAME","CONSULTANT_ORDER_NO","CONSULTANT_PHONE",
                "CONSULTANT_ZIP_CODE","TRACKING_ID","VOLUME","WEIGHT"));

        PPOO_DETAILS.nodeAttributes.put("PALLET_OUTBOUND_ORDER" + XMLNS, "urn:ifsworld-com:schemas:post_pallet_outbound_order");

        PPOO_DETAILS.fieldTypes.put("PALLET_QTY", FieldType.FLOAT);
        PPOO_DETAILS.fieldTypes.put("COMPLETE_INSPECTION", FieldType.FLOAT);
        PPOO_DETAILS.fieldTypes.put("FULLPACKER_PICKING", FieldType.FLOAT);
        PPOO_DETAILS.fieldTypes.put("GROSS_WEIGHT", FieldType.FLOAT);
        PPOO_DETAILS.fieldTypes.put("PALLET_WEIGHT", FieldType.FLOAT);
        PPOO_DETAILS.fieldTypes.put("SINGLEUNIT_PICKING", FieldType.FLOAT);
        PPOO_DETAILS.fieldTypes.put("CRT_QTY", FieldType.FLOAT);
    }

    public final Map<String, String> lineReaders = new HashMap<String, String>();
    public final Map<String, List<String>> groupings = new HashMap<String, List<String>>();
    public final  Map<String, List<String>> fields = new HashMap<String, List<String>>();
    public final  Map<String, FieldType> fieldTypes = new HashMap<>();
    public final  Map<String, String> additionalEntries = new HashMap<String, String>();
    public final  Map<String, String> nodeAttributes = new HashMap<String, String>();

    public Boolean hasMainGroup;

    public EdiDetails(boolean hasMainGroup) {
        this.hasMainGroup = hasMainGroup;

        additionalEntries.put("SITE", "DCBUD");
        additionalEntries.put("SOURCE", "WMS");
    }

    public EdiDetails() {
        this(false);
    }

    public Attributes getNodeAttribute(String key) {
        AttributesImpl attributes = new AttributesImpl();
        if(nodeAttributes.containsKey(key + XMLNS)){
            attributes.addAttribute("", "xmlns", "xmlns", "CDATA", nodeAttributes.get(key + XMLNS));
        }
        return attributes;
    }

    public String convert(String key, String value){
        String ret = value;

        FieldType type = fieldTypes.get(key);

        if(type != null){
            switch (type){
                case FLOAT:
                    ret = String.valueOf(Float.parseFloat(value));
                    break;
                case DATE:
                    SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
                    SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
                    try {
                        Date date = format1.parse(value);
                        ret = format2.format(date);
                        ret = ret.substring(0, ret.length()-2) + ":00";
                    } catch (ParseException e) {
                        //TODO
                    }
                    break;
                case ENCODED:
                    try {
                        ret = new String (DatatypeConverter.printBase64Binary(value.getBytes("ISO-8859-1")));
                    } catch (UnsupportedEncodingException e) {
                        ret = "";
                    }
                    break;
            }
        }
        return ret;
    }

    protected enum FieldType {
        STRING, FLOAT, DATE, ENCODED
    }
}

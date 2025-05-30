package org.assimbly.tenantvariables.domain;

import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TenantVariable {

    public static final String ID_FIELD = "_id";
    public static final String TYPE_FIELD = "_type";
    public static final String NAME_FIELD = "name";
    public static final String STATIC_TENANT_VARIABLE_GROUP_ID_FIELD = "static_tenant_variable_group_id";
    public static final String CREATED_AT_FIELD = "createdAt";
    public static final String CREATED_BY_FIELD = "createdBy";
    public static final String VALUES_FIELD = "values";
    public static final String TAG_IDS_FIELD = "tag_ids";

    public enum TenantVarType {
        TenantVariable,
        StaticTenantVariable;
    }

    private ObjectId _id;
    private String _type;
    private String name;
    private ObjectId staticTenantVariableGroupId;
    private long createdAt;
    private String createdBy;

    private List<EnvironmentValue> values;

    private List<ObjectId> tagIds;

    public TenantVariable(){
        this._id = new ObjectId();
        this._type = TenantVarType.TenantVariable.name();
        this.staticTenantVariableGroupId = new ObjectId();
        this.values = new ArrayList<>();
        this.tagIds = new ArrayList<>();
    }

    public TenantVariable(String name){
        this._id = new ObjectId();
        this._type = TenantVarType.TenantVariable.name();
        this.name = name;
        this.staticTenantVariableGroupId = new ObjectId();
        this.values = new ArrayList<>();
        this.tagIds = new ArrayList<>();
    }

    public TenantVariable(String name, TenantVarType tenantVarType){
        this._id = new ObjectId();
        this._type = tenantVarType.name();
        this.name = name;
        this.staticTenantVariableGroupId = new ObjectId();
        this.values = new ArrayList<>();
    }

    public List<EnvironmentValue> getValues() {
        return values;
    }

    public Optional<EnvironmentValue> find(String environment) {
        return values.stream()
                .filter(v -> v.getEnvironment().equals(environment))
                .findFirst();
    }

    public void put(EnvironmentValue environmentValue) {
        values.add(environmentValue);
    }

    public static TenantVariable fromDocument(Document document) {
        TenantVariable tenantVariable = new TenantVariable();
        tenantVariable.set_id(document.getObjectId(ID_FIELD));
        if(document.getString(TYPE_FIELD) != null) {
            tenantVariable.set_type(document.getString(TYPE_FIELD));
        }
        tenantVariable.setName(document.getString(NAME_FIELD));
        tenantVariable.setStaticTenantVariableGroupId(document.getObjectId(STATIC_TENANT_VARIABLE_GROUP_ID_FIELD));

        Object createdAtField = document.get(CREATED_AT_FIELD);
        if (createdAtField != null) {
            if (createdAtField instanceof Long) {
                tenantVariable.setCreatedAt((Long) createdAtField);
            } else if (createdAtField instanceof Integer) {
                // Convert Integer to Long
                tenantVariable.setCreatedAt(((Integer) createdAtField).longValue());
            }
        }

        tenantVariable.setCreatedBy(document.getString(CREATED_BY_FIELD));

        List<Document> valuesList = (List<Document>) document.get(VALUES_FIELD);
        for (Document valueDoc : valuesList) {
            EnvironmentValue environmentValue = new EnvironmentValue();
            environmentValue.set_id(valueDoc.getObjectId(EnvironmentValue.ID_FIELD));
            environmentValue.setEnvironment(valueDoc.getString(EnvironmentValue.ENVIRONMENT_FIELD));
            environmentValue.setValue(valueDoc.getString(EnvironmentValue.VALUE_FIELD));
            environmentValue.setEncrypted(valueDoc.getBoolean(EnvironmentValue.ENCRYPTED_FIELD));
            environmentValue.setNonce(valueDoc.getString(EnvironmentValue.NONCE_FIELD));
            Object lastUpdateObj = valueDoc.get(EnvironmentValue.LAST_UPDATE_FIELD);
            if (lastUpdateObj != null) {
                environmentValue.setLastUpdate(((Number) lastUpdateObj).longValue());
            }
            environmentValue.setUpdatedBy(valueDoc.getString(EnvironmentValue.UPDATED_BY_FIELD));
            tenantVariable.put(environmentValue);
        }

        tenantVariable.setTagIds(document.getList(TAG_IDS_FIELD, ObjectId.class));

        return tenantVariable;
    }

    public Document toDocument() {
        Document document = new Document();
        document.append(ID_FIELD, this.get_id());
        document.append(TYPE_FIELD, this.get_type());
        document.append(NAME_FIELD, this.getName());
        document.append(STATIC_TENANT_VARIABLE_GROUP_ID_FIELD, this.getStaticTenantVariableGroupId());
        document.append(CREATED_AT_FIELD, this.getCreatedAt());
        document.append(CREATED_BY_FIELD, this.getCreatedBy());

        List<Document> valuesList = new ArrayList<>();
        for (EnvironmentValue environmentValue : this.getValues()) {
            Document valueDoc = new Document();
            valueDoc.append(EnvironmentValue.ID_FIELD, environmentValue.get_id());
            valueDoc.append(EnvironmentValue.ENVIRONMENT_FIELD, environmentValue.getEnvironment());
            valueDoc.append(EnvironmentValue.VALUE_FIELD, environmentValue.getValue());
            valueDoc.append(EnvironmentValue.ENCRYPTED_FIELD, environmentValue.isEncrypted());
            valueDoc.append(EnvironmentValue.NONCE_FIELD, environmentValue.getNonce());
            valueDoc.append(EnvironmentValue.LAST_UPDATE_FIELD, environmentValue.getLastUpdate());
            valueDoc.append(EnvironmentValue.UPDATED_BY_FIELD, environmentValue.getUpdatedBy());
            valuesList.add(valueDoc);
        }
        document.append(VALUES_FIELD, valuesList);

        document.append(TAG_IDS_FIELD, this.getTagIds());

        return document;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObjectId getStaticTenantVariableGroupId() {
        return staticTenantVariableGroupId;
    }

    public void setStaticTenantVariableGroupId(ObjectId staticTenantVariableGroupId) {
        this.staticTenantVariableGroupId = staticTenantVariableGroupId;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) { this.createdAt = createdAt; }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public List<ObjectId> getTagIds() {
        return tagIds;
    }

    public void setTagIds(List<ObjectId> tagIds) {
        this.tagIds = tagIds;
    }
}
package org.assimbly.tenantvariables.domain;

import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TenantVariable {

    public static final String ID_FIELD = "id";
    public static final String TYPE_FIELD = "type";
    public static final String NAME_FIELD = "name";
    public static final String STATIC_TENANT_VARIABLE_GROUPID_FIELD = "static_tenant_variable_groupid";
    public static final String CREATED_AT_FIELD = "createdAt";
    public static final String CREATED_BY_FIELD = "createdBy";
    public static final String VALUES_FIELD = "values";
    public static final String TAGIDS_FIELD = "tagids";

    public enum TenantVarType {
        TENANT_VARIABLE,
        STATIC_TENANT_VARIABLE
    }

    private ObjectId id;
    private String type;
    private String name;
    private ObjectId statictenantVariableGroupId;
    private long createdAt;
    private String createdBy;

    private final List<EnvironmentValue> values;

    private List<ObjectId> tagIds;

    public TenantVariable(){
        this.id = new ObjectId();
        this.type = TenantVarType.TENANT_VARIABLE.name();
        this.statictenantVariableGroupId = new ObjectId();
        this.values = new ArrayList<>();
        this.tagIds = new ArrayList<>();
    }

    public TenantVariable(String name){
        this.id = new ObjectId();
        this.type = TenantVarType.TENANT_VARIABLE.name();
        this.name = name;
        this.statictenantVariableGroupId = new ObjectId();
        this.values = new ArrayList<>();
        this.tagIds = new ArrayList<>();
    }

    public TenantVariable(String name, TenantVarType tenantVarType){
        this.id = new ObjectId();
        this.type = tenantVarType.name();
        this.name = name;
        this.statictenantVariableGroupId = new ObjectId();
        this.values = new ArrayList<>();
    }

    public List<EnvironmentValue> getValues() {
        return values;
    }

    public Optional<EnvironmentValue> find(String environment) {
        return values.stream()
                .filter(v -> Optional.ofNullable(v.getEnvironment())
                        .map(env -> env.equals(environment))
                        .orElse(false))
                .findFirst();
    }

    public void put(EnvironmentValue environmentValue) {
        values.add(environmentValue);
    }

    public static TenantVariable fromDocument(Document document) {
        TenantVariable tenantVariable = new TenantVariable();
        tenantVariable.setId(document.getObjectId(ID_FIELD));
        if(document.getString(TYPE_FIELD) != null) {
            tenantVariable.setType(document.getString(TYPE_FIELD));
        }
        tenantVariable.setName(document.getString(NAME_FIELD));
        tenantVariable.setstatictenantVariableGroupId(document.getObjectId(STATIC_TENANT_VARIABLE_GROUPID_FIELD));

        Object createdAtField = document.get(CREATED_AT_FIELD);
        if (createdAtField != null) {
            if (createdAtField instanceof Long long1) {
                tenantVariable.setCreatedAt(long1);
            } else if (createdAtField instanceof Integer integer) {
                // Convert Integer to Long
                tenantVariable.setCreatedAt(integer.longValue());
            }
        }

        tenantVariable.setCreatedBy(document.getString(CREATED_BY_FIELD));

        List<Document> valuesList = (List<Document>) document.get(VALUES_FIELD);
        for (Document valueDoc : valuesList) {
            EnvironmentValue environmentValue = new EnvironmentValue();
            environmentValue.setId(valueDoc.getObjectId(EnvironmentValue.ID_FIELD));
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

        tenantVariable.setTagIds(document.getList(TAGIDS_FIELD, ObjectId.class));

        return tenantVariable;
    }

    public Document toDocument() {
        Document document = new Document();
        document.append(ID_FIELD, this.getId());
        document.append(TYPE_FIELD, this.getType());
        document.append(NAME_FIELD, this.getName());
        document.append(STATIC_TENANT_VARIABLE_GROUPID_FIELD, this.getstatictenantVariableGroupId());
        document.append(CREATED_AT_FIELD, this.getCreatedAt());
        document.append(CREATED_BY_FIELD, this.getCreatedBy());

        List<Document> valuesList = new ArrayList<>();
        for (EnvironmentValue environmentValue : this.getValues()) {
            Document valueDoc = new Document();
            valueDoc.append(EnvironmentValue.ID_FIELD, environmentValue.getId());
            valueDoc.append(EnvironmentValue.ENVIRONMENT_FIELD, environmentValue.getEnvironment());
            valueDoc.append(EnvironmentValue.VALUE_FIELD, environmentValue.getValue());
            valueDoc.append(EnvironmentValue.ENCRYPTED_FIELD, environmentValue.isEncrypted());
            valueDoc.append(EnvironmentValue.NONCE_FIELD, environmentValue.getNonce());
            valueDoc.append(EnvironmentValue.LAST_UPDATE_FIELD, environmentValue.getLastUpdate());
            valueDoc.append(EnvironmentValue.UPDATED_BY_FIELD, environmentValue.getUpdatedBy());
            valuesList.add(valueDoc);
        }
        document.append(VALUES_FIELD, valuesList);

        document.append(TAGIDS_FIELD, this.getTagIds());

        return document;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObjectId getstatictenantVariableGroupId() {
        return statictenantVariableGroupId;
    }

    public void setstatictenantVariableGroupId(ObjectId statictenantVariableGroupId) {
        this.statictenantVariableGroupId = statictenantVariableGroupId;
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

package com.creatubbles.api.model.ability;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;

@Type("abilities")
public class Ability {

    @Id
    private String id;

    @JsonProperty("resource_type")
    private String resourceType;

    @JsonProperty("resource_id")
    private String resourceId;

    private Boolean permission;

    private String operation;

    public String getId() {
        return id;
    }

    public String getResourceType() {
        return resourceType;
    }

    public String getResourceId() {
        return resourceId;
    }

    public Boolean getPermission() {
        return permission;
    }

    public String getOperation() {
        return operation;
    }

    @Override
    public String toString() {
        return "Ability{" +
                "id='" + id + '\'' +
                ", resourceType='" + resourceType + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", permission=" + permission +
                ", operation='" + operation + '\'' +
                '}';
    }
}
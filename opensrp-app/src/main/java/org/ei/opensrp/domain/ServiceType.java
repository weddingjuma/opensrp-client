package org.ei.opensrp.domain;

import java.util.Date;

/**
 * Created by keyman on 3/1/17.
 */
public class ServiceType {
    Long id;
    String name;
    String serviceNameEntity;
    String serviceNameEntityId;
    String dateEntity;
    String dateEntityId;
    String units;
    String serviceLogic;
    Long updatedAt;


    public ServiceType() {
    }

    public ServiceType(Long id, String name, String serviceNameEntity,
                       String serviceNameEntityId,
                       String dateEntity,
                       String dateEntityId, String units, String serviceLogic, Long updatedAt) {
        this.id = id;
        this.name = name;
        this.serviceNameEntity = serviceNameEntity;
        this.serviceNameEntityId = serviceNameEntityId;
        this.dateEntity = dateEntity;
        this.dateEntityId = dateEntityId;
        this.units = units;
        this.serviceLogic = serviceLogic;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServiceNameEntity() {
        return serviceNameEntity;
    }

    public void setServiceNameEntity(String serviceNameEntity) {
        this.serviceNameEntity = serviceNameEntity;
    }

    public String getServiceNameEntityId() {
        return serviceNameEntityId;
    }

    public void setServiceNameEntityId(String serviceNameEntityId) {
        this.serviceNameEntityId = serviceNameEntityId;
    }

    public String getDateEntity() {
        return dateEntity;
    }

    public void setDateEntity(String dateEntity) {
        this.dateEntity = dateEntity;
    }

    public String getDateEntityId() {
        return dateEntityId;
    }

    public void setDateEntityId(String dateEntityId) {
        this.dateEntityId = dateEntityId;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getServiceLogic() {
        return serviceLogic;
    }

    public void setServiceLogic(String serviceLogic) {
        this.serviceLogic = serviceLogic;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }
}

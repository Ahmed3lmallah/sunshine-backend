package com.cognizant.cde.tjfems.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "manager_office")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ManagerToOffice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "manager_id")
    private Long managerId;

    @Column(name = "office_id")
    private Long officeId;

    public void setId(long id) {
        this.id = id;
    }

    public void setManagerId(long managerId) {
        this.managerId = managerId;
    }

    public void setOfficeId(long officeId) {
        this.officeId = officeId;
    }

    public long getId() {
        return id;
    }

    public long getManagerId() {
        return managerId;
    }

    public long getOfficeId() {
        return officeId;
    }

}

package com.cognizant.cde.tjfems.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "equipment_office")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EquipmentToOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "equipment_id")
    private Long equipmentId;

    @Column(name = "office_id")
    private Long officeId;
}

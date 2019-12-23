package com.cognizant.equipmentcrud.repository;

import com.cognizant.equipmentcrud.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

    List<Equipment> getEquipmentByOfficeId(Long officeId);

}

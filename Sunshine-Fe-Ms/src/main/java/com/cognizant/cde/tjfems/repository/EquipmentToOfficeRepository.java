//package com.cognizant.cde.tjfems.repository;
//
//import com.cognizant.cde.tjfems.model.EquipmentToOffice;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.util.List;
//
//public interface EquipmentToOfficeRepository {
//    @Query(value = "SELECT * FROM equipment_office m WHERE m.equipment_id = :id",
//            nativeQuery = true)
//    List<EquipmentToOffice> findAllByOfficeId(@Param("id") Long id);
//}

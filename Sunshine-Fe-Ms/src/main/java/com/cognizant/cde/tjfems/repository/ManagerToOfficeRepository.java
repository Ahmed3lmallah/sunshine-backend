package com.cognizant.cde.tjfems.repository;

import com.cognizant.cde.tjfems.model.ManagerToOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerToOfficeRepository extends JpaRepository<ManagerToOffice, Long> {

    @Query(value = "SELECT * FROM manager_office m WHERE m.manager_id = :id",
    nativeQuery = true)
    List<ManagerToOffice> findAllByManagerId(@Param("id") Long id);
}

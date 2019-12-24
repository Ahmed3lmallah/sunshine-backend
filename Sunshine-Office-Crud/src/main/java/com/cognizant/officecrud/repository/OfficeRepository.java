package com.cognizant.officecrud.repository;

import com.cognizant.officecrud.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {
    List<Office> findOfficeByManagerId(Long managerId);
}

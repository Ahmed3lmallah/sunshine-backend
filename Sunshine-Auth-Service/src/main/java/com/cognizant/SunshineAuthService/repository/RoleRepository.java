package com.cognizant.SunshineAuthService.repository;

import com.cognizant.SunshineAuthService.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByName(String name);
}

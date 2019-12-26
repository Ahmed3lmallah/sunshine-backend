package com.cognizant.cde.tjfems.repository;

import com.cognizant.cde.tjfems.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface HistoryRepository extends JpaRepository<History, Long> {
    List<History> findHistoryByService(String service);
    List<History> findHistoryByUsername(String username);
}

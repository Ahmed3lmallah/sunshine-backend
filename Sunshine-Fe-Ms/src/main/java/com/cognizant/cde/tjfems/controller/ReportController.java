package com.cognizant.cde.tjfems.controller;

import com.cognizant.cde.tjfems.model.History;
import com.cognizant.cde.tjfems.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    @Autowired
    private HistoryRepository historyRepository;

    @GetMapping("/user/{username}")
    public List<History> getHistoryPerUser(@PathVariable String username){
        return historyRepository.findHistoryByUsername(username);
    }

    @GetMapping("/service/{service}")
    public List<History> getHistoryPerService(@PathVariable String service){
        return historyRepository.findHistoryByService(service);
    }
}

package com.hanrry.studytracker.controller;

import com.hanrry.studytracker.dto.DashboardResponseDTO;
import com.hanrry.studytracker.service.DashboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/dashboard")
public class DashboardController {


    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService){
        this.dashboardService = dashboardService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DashboardResponseDTO> findDashboard(@PathVariable Long id){
        DashboardResponseDTO dashboard = dashboardService.getDashboard(id);
        return ResponseEntity.ok().body(dashboard);
    }
}

package com.miApp.AppS.controller;


import com.miApp.AppS.dto.SavinPlanDTO;
import com.miApp.AppS.service.SavinPlanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/savinPlans")

public class SavinPlanController {

    private final SavinPlanService savinPlanService;


    public SavinPlanController(SavinPlanService savinPlanService) {
        this.savinPlanService = savinPlanService;
    }

    @GetMapping ("/all")
    public ResponseEntity <List<SavinPlanDTO>> getAllSavinPlans() {
        List<SavinPlanDTO> savinPlans = savinPlanService.getAllSavinPlans();
        return ResponseEntity.ok(savinPlans);
    }

    @GetMapping ("/{savinPlanId}")
    public ResponseEntity <SavinPlanDTO> getSavinPlanById(Long savinPlanId) {
        SavinPlanDTO savinPlan = savinPlanService.getSavinPlanById(savinPlanId);
        return ResponseEntity.ok(savinPlan);
    }

    @PostMapping ("/create")
    public ResponseEntity <SavinPlanDTO> createSavinPlan(SavinPlanDTO savinPlanDTO) {
        savinPlanService.createSavinPlan(savinPlanDTO);
        return ResponseEntity.ok(savinPlanDTO);
    }


}

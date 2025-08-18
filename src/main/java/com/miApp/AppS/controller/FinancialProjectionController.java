package com.miApp.AppS.controller;


import com.miApp.AppS.dto.FinancialProjectionDTO;
import com.miApp.AppS.service.FinancialProjectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api/financial-projections")
public class FinancialProjectionController {

    private final FinancialProjectionService financialProjectionService;

    public FinancialProjectionController(FinancialProjectionService financialProjectionService) {
        this.financialProjectionService = financialProjectionService;
    }

    @GetMapping ("/all")
    public ResponseEntity<List<FinancialProjectionDTO>> getAllFinancialProjections() {
        List<FinancialProjectionDTO> financialProjections = financialProjectionService.getAllFinancialProjections();
        return ResponseEntity.ok(financialProjections);
    }

    @GetMapping ("/{financialProjectionId}")
    public ResponseEntity<FinancialProjectionDTO> getFinancialProjectionById(Long financialProjectionId) {
        FinancialProjectionDTO financialProjection = financialProjectionService.getFinancialProjectionById(financialProjectionId);
        return ResponseEntity.ok(financialProjection);
    }

    @PostMapping("/create")
    public ResponseEntity<FinancialProjectionDTO> createFinancialProjection(FinancialProjectionDTO financialProjectionDTO) {
        financialProjectionService.createFinancialProjection(financialProjectionDTO);
        return ResponseEntity.ok(financialProjectionDTO);
    }

}

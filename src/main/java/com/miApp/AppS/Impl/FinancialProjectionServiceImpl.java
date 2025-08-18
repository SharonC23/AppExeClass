package com.miApp.AppS.Impl;


import com.miApp.AppS.dto.FinancialProjectionDTO;
import com.miApp.AppS.entity.FinancialProjection;
import com.miApp.AppS.exceptions.CustomException;
import com.miApp.AppS.repository.FinancialProjectionRepository;
import com.miApp.AppS.service.FinancialProjectionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FinancialProjectionServiceImpl implements FinancialProjectionService {

    private final FinancialProjectionRepository financialProjectionRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public FinancialProjectionServiceImpl(FinancialProjectionRepository financialProjectionRepository, ModelMapper modelMapper) {
        this.financialProjectionRepository = financialProjectionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<FinancialProjectionDTO> getAllFinancialProjections() {
        List<FinancialProjection> financialProjections = financialProjectionRepository.findAll();
        return financialProjections.stream()
                .map(financialProjection -> modelMapper.map(financialProjection, FinancialProjectionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public FinancialProjectionDTO findAllFinancialProjections() {
        return null;
    }

    @Override
    public FinancialProjectionDTO getFinancialProjectionById(Long financialProjectionId) {
        FinancialProjection financialProjection = financialProjectionRepository.findById(financialProjectionId)
                .orElseThrow(() -> new CustomException("Financial projection not found with id: " + financialProjectionId));
        return modelMapper.map(financialProjection, FinancialProjectionDTO.class);
    }

    @Override
    public FinancialProjectionDTO createFinancialProjection(FinancialProjectionDTO financialProjectionDTO) {
        if (financialProjectionRepository.findById(financialProjectionDTO.getIdProjection()).isPresent()) {
            throw new CustomException("Financial projection with this ID already exists");
        }
        FinancialProjection financialProjection = modelMapper.map(financialProjectionDTO, FinancialProjection.class);
        financialProjection = financialProjectionRepository.save(financialProjection);
        return modelMapper.map(financialProjection, FinancialProjectionDTO.class);
    }

    @Override
    public FinancialProjectionDTO updateFinancialProjection(Long financialProjectionId, FinancialProjectionDTO financialProjectionDTO) {
        FinancialProjection financialProjection = financialProjectionRepository.findById(financialProjectionId)
                .orElseThrow(() -> new CustomException("Financial projection not found with id: " + financialProjectionId));
        financialProjection.setAmount(financialProjectionDTO.getAmount());
        financialProjection.setDescriptionProjection(financialProjectionDTO.getDescriptionProjection());
        FinancialProjection updatedFinancialProjection = financialProjectionRepository.save(financialProjection);
        return modelMapper.map(updatedFinancialProjection, FinancialProjectionDTO.class);
    }

    @Override
    public boolean deleteFinancialProjection(Long financialProjectionId) {
        if(!financialProjectionRepository.existsById(financialProjectionId)) {
            throw new CustomException("Financial projection not found with id: " + financialProjectionId);
        }
        financialProjectionRepository.deleteById(financialProjectionId);
        return true;
    }
}

package com.miApp.AppS.Impl;

import com.miApp.AppS.dto.SavingMovementDTO;
import com.miApp.AppS.entity.SavingMovement;
import com.miApp.AppS.exceptions.CustomException;
import com.miApp.AppS.repository.SavingMovementRepository;
import com.miApp.AppS.service.SavingMovementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SavingMovementServiceImpl implements SavingMovementService {

    private final SavingMovementRepository savingMovementRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public SavingMovementServiceImpl(SavingMovementRepository savingMovementRepository, ModelMapper modelMapper) {
        this.savingMovementRepository = savingMovementRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<SavingMovementDTO> getAllSavingMovements() {
        List<SavingMovement> SavingMovements = savingMovementRepository.findAll();
                return SavingMovements.stream()
                .map(savingMovement -> modelMapper.map(savingMovement, SavingMovementDTO.class))
                        .collect(Collectors.toList());
    }

    @Override
    public SavingMovementDTO findAllSavingMovements() {
        return null;
    }

    @Override
    public SavingMovementDTO getSavingMovementById(Long savingMovementId) {
        SavingMovement savingMovement = savingMovementRepository.findById(savingMovementId)
                .orElseThrow(() -> new CustomException("Saving movement not found with id: " + savingMovementId));
        return modelMapper.map(savingMovement, SavingMovementDTO.class);
    }

    @Override
    public SavingMovementDTO createSavingMovement(SavingMovementDTO savingMovementDTO) {
        if (savingMovementRepository.findById(savingMovementDTO.getIdSaving()).isPresent()) {
            throw new CustomException("Saving movement with this ID already exists");
        }
        SavingMovement savingMovement = modelMapper.map(savingMovementDTO, SavingMovement.class);
        savingMovement = savingMovementRepository.save(savingMovement);
        return modelMapper.map(savingMovement, SavingMovementDTO.class);
    }


    @Override
    public SavingMovementDTO updateSavingMovement(Long savingMovementId, SavingMovementDTO savingMovementDTO) {
         SavingMovement savingMovement = savingMovementRepository.findById(savingMovementId)
                .orElseThrow(() -> new CustomException("Saving movement not found with id: " + savingMovementId));
        savingMovement.setAmount(savingMovementDTO.getAmount());
        savingMovement.setSavingDate(savingMovementDTO.getSavingDate());
        SavingMovement updatedSavingMovement = savingMovementRepository.save(savingMovement);
        return modelMapper.map(updatedSavingMovement, SavingMovementDTO.class);

    }

    @Override
    public boolean deleteSavingMovement(Long savingMovementId) {
        if (!savingMovementRepository.existsById(savingMovementId)) {
            throw new CustomException("Saving movement not found with id: " + savingMovementId);
        }
        savingMovementRepository.deleteById(savingMovementId);
        return true;

    }
}

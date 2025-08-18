package com.miApp.AppS.Impl;

import com.miApp.AppS.dto.CapitalizationSettingsDTO;
import com.miApp.AppS.entity.CapitalizationSettings;
import com.miApp.AppS.exceptions.CustomException;
import com.miApp.AppS.repository.CapitalizationSettingsRepository;
import com.miApp.AppS.service.CapitalizationSettingsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapitalizationServiceImpl implements CapitalizationSettingsService {

    private final CapitalizationSettingsRepository capitalizationSettingsRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public CapitalizationServiceImpl(CapitalizationSettingsRepository capitalizationSettingsRepository, ModelMapper modelMapper) {
        this.capitalizationSettingsRepository = capitalizationSettingsRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CapitalizationSettingsDTO> getAllCapitalizationSettings() {
        List<CapitalizationSettings> settings = capitalizationSettingsRepository.findAll();
        return settings.stream()
                .map(setting -> modelMapper.map(setting, CapitalizationSettingsDTO.class))
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public CapitalizationSettingsDTO findAllCapitalizationSettings() {
        return null;
    }

    @Override
    public CapitalizationSettingsDTO getCapitalizationSettingsById(Long idCapitalizationSettings) {
        CapitalizationSettings settings = capitalizationSettingsRepository.findById(idCapitalizationSettings)
                .orElseThrow(() -> new CustomException("Capitalization settings not found with id: " + idCapitalizationSettings));
        return modelMapper.map(settings, CapitalizationSettingsDTO.class);
    }

    @Override
    public CapitalizationSettingsDTO createCapitalizationSettings(CapitalizationSettingsDTO capitalizationSettingsDTO) {
        return null;
    }


    @Override
    public CapitalizationSettingsDTO updateCapitalizationSettings(Long idCapitalizationSettings, CapitalizationSettingsDTO capitalizationSttingsDTO) {
        return null;
    }

    @Override
    public void deleteCapitalizationSettings(Long idCapitalizationSettings) {

    }
}

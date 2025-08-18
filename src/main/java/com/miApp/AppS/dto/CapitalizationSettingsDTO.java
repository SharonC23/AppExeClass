package com.miApp.AppS.dto;

import jakarta.persistence.Column;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CapitalizationSettingsDTO {

    private Long IdCapitalizationSettings;

    private String name;

    private String type; // Tipo de capitalización (diaria, semanal, mensual, etc.)

    private String description; // Descripción de la capitalización

    private Double amount; // Monto de la capitalización

    private LocalDateTime date; // Fecha de la capitalización

    private LocalDate createdAt; // Fecha de creación de la capitalización

    private LocalDate updatedAt; // Fecha de actualización de la capitalización

    private String status; // Estado de la capitalización (activa, inactiva, completada)

}

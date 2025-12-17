package com.perez.dam.taskmanager.exception;


import lombok.AllArgsConstructor; // Constructor con todos los campos [cite: 113]
import lombok.Data; // Getters y Setters [cite: 112]

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
}

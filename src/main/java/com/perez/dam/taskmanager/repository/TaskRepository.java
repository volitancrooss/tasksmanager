package com.perez.dam.taskmanager.repository;


import com.perez.dam.taskmanager.model.Priority;
import com.perez.dam.taskmanager.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> { // Extiende para CRUD básico [cite: 72]

    // Métodos de consulta personalizados de Spring Data MongoDB [cite: 74]
    List<Task> findByCompleted(boolean completed); // Buscar por estado de completado [cite: 75]
    List<Task> findByCategory(String category); // Buscar por categoría [cite: 76]
    List<Task> findByTagsContaining(String tag); // Buscar tareas que contengan una etiqueta [cite: 77]
    List<Task> findByPriority(Priority priority); // Buscar por prioridad [cite: 78]
    List<Task> findByTitleContainingIgnoreCase(String title); // Buscar por título ignorando mayúsculas/minúsculas [cite: 79]
    List<Task> findByDueDateBefore(LocalDateTime date); // Buscar tareas con fecha de vencimiento anterior a una fecha [cite: 80]
}
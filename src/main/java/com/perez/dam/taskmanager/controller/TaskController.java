package com.perez.dam.taskmanager.controller;


import com.perez.dam.taskmanager.model.Task;
import com.perez.dam.taskmanager.model.Priority;
import com.perez.dam.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    // Inyección de TaskService
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // POST /api/tasks - Crear nueva tarea [cite: 135, 136, 137]
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Devuelve 201 CREATED
    public Task createTask(@Valid @RequestBody Task task) {
        return taskService.createTask(task);
    }

    // GET /api/tasks - Obtener todas las tareas [cite: 138, 139, 140]
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // GET /api/tasks/{id} - Obtener tarea por ID [cite: 141, 142, 143]
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable String id) {
        return taskService.getTaskById(id);
    }

    // PUT /api/tasks/{id} - Actualizar tarea completa [cite: 144, 145, 146]
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable String id, @Valid @RequestBody Task taskDetails) {
        return taskService.updateTask(id, taskDetails);
    }

    // DELETE /api/tasks/{id} - Eliminar tarea [cite: 153, 154, 155]
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Devuelve 204 NO CONTENT
    public void deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
    }

    // --- Endpoints de cambio de estado y búsqueda ---

    // PATCH /api/tasks/{id}/complete - Marcar como completada [cite: 147, 148, 149]
    @PatchMapping("/{id}/complete")
    public Task markTaskComplete(@PathVariable String id) {
        return taskService.markTaskComplete(id, true);
    }

    // PATCH /api/tasks/{id}/incomplete - Marcar como no completada [cite: 150, 151, 152]
    @PatchMapping("/{id}/incomplete")
    public Task markTaskIncomplete(@PathVariable String id) {
        return taskService.markTaskComplete(id, false);
    }

    // GET /api/tasks/completed - Obtener tareas completadas [cite: 156, 157, 158]
    @GetMapping("/completed")
    public List<Task> getCompletedTasks() {
        return taskService.findTasksByCompleted(true);
    }

    // GET /api/tasks/pending - Obtener tareas pendientes [cite: 159, 160, 161]
    @GetMapping("/pending")
    public List<Task> getPendingTasks() {
        return taskService.findTasksByCompleted(false);
    }

    // GET /api/tasks/category/{category} - Buscar por categoría [cite: 162, 163]
    @GetMapping("/category/{category}")
    public List<Task> getTasksByCategory(@PathVariable String category) {
        return taskService.findTasksByCategory(category);
    }

    // GET /api/tasks/tag/{tag} - Buscar por etiqueta [cite: 165, 166]
    @GetMapping("/tag/{tag}")
    public List<Task> getTasksByTag(@PathVariable String tag) {
        return taskService.findTasksByTag(tag);
    }

    // GET /api/tasks/priority/{priority} - Buscar por prioridad [cite: 168, 169]
    @GetMapping("/priority/{priority}")
    public List<Task> getTasksByPriority(@PathVariable Priority priority) {
        return taskService.findTasksByPriority(priority);
    }

    // GET /api/tasks/search?title={title} - Buscar por título [cite: 175, 177]
    @GetMapping("/search")
    public List<Task> searchTasksByTitle(@RequestParam String title) {
        return taskService.findTasksByTitle(title);
    }
}

package com.perez.dam.taskmanager.service;


import com.perez.dam.taskmanager.exception.TaskNotFoundException;
import com.perez.dam.taskmanager.model.Priority;
import com.perez.dam.taskmanager.model.Task;
import com.perez.dam.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;


    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) {
        // Establecer las fechas de creación y actualización iniciales
        LocalDateTime now = LocalDateTime.now();
        task.setCreatedAt(now);
        task.setUpdatedAt(now);
        task.setCompleted(false); // Por defecto, una tarea nueva está pendiente
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(String id) {
        // Usa .orElseThrow() para lanzar la excepción personalizada si no se encuentra [cite: 97]
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    @Override
    public Task updateTask(String id, Task taskDetails) {
        Task existingTask = getTaskById(id); // Reutiliza el método para verificar existencia

        // Actualiza campos
        existingTask.setTitle(taskDetails.getTitle());
        existingTask.setDescription(taskDetails.getDescription());
        existingTask.setCompleted(taskDetails.isCompleted());
        existingTask.setPriority(taskDetails.getPriority());
        existingTask.setTags(taskDetails.getTags());
        existingTask.setCategory(taskDetails.getCategory());
        existingTask.setDueDate(taskDetails.getDueDate());

        // Gestiona el 'updatedAt' automáticamente [cite: 96]
        existingTask.setUpdatedAt(LocalDateTime.now());

        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(String id) {
        Task taskToDelete = getTaskById(id); // Verifica existencia antes de eliminar
        taskRepository.delete(taskToDelete);
    }

    @Override
    public Task markTaskComplete(String id, boolean completed) {
        Task task = getTaskById(id); // Obtener y verificar
        task.setCompleted(completed);
        task.setUpdatedAt(LocalDateTime.now()); // Actualizar timestamp
        return taskRepository.save(task);
    }

    // Implementaciones de métodos de búsqueda (delegan al repositorio) [cite: 90]
    @Override
    public List<Task> findTasksByCompleted(boolean completed) {
        return taskRepository.findByCompleted(completed);
    }

    @Override
    public List<Task> findTasksByCategory(String category) {
        return taskRepository.findByCategory(category);
    }

    @Override
    public List<Task> findTasksByTag(String tag) {
        return taskRepository.findByTagsContaining(tag);
    }

    @Override
    public List<Task> findTasksByPriority(Priority priority) {
        return taskRepository.findByPriority(priority);
    }

    @Override
    public List<Task> findTasksByTitle(String title) {
        return taskRepository.findByTitleContainingIgnoreCase(title);
    }
}

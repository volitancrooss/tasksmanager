package com.perez.dam.taskmanager.service;

import com.perez.dam.taskmanager.model.Priority;
import com.perez.dam.taskmanager.model.Task;
import java.util.List;

public interface TaskService {

    Task createTask(Task task); // Crear una tarea [cite: 85]

    List<Task> getAllTasks(); // Obtener todas las tareas [cite: 86]

    Task getTaskById(String id); // Obtener una tarea por ID [cite: 87]

    Task updateTask(String id, Task taskDetails); // Actualizar una tarea completa [cite: 88]

    void deleteTask(String id); // Eliminar una tarea [cite: 89]

    // Métodos de búsqueda [cite: 90]
    List<Task> findTasksByCompleted(boolean completed);
    List<Task> findTasksByCategory(String category);
    List<Task> findTasksByTag(String tag);
    List<Task> findTasksByPriority(Priority priority);
    List<Task> findTasksByTitle(String title);

    Task markTaskComplete(String id, boolean completed); // Marcar como completada/no completada [cite: 90]
}

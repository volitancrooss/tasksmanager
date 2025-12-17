# 📝 Gestor de Tareas API - Spring Boot & MongoDB

Este proyecto es una API RESTful desarrollada con **Java 25** y **Spring Boot 4.0**, diseñada para gestionar tareas de forma eficiente utilizando **MongoDB** como base de datos no relacional.

## 🚀 Características

* **CRUD Completo**: Creación, lectura, actualización y eliminación de tareas.
* **Persistencia**: Almacenamiento de datos en una instancia local de MongoDB (Puerto 27017).
* **Validación**: Gestión de datos de entrada para asegurar la integridad de la información.

## 🛠️ Tecnologías Utilizadas

* **Java 25**: Lenguaje de programación principal.
* **Spring Boot 4.0**: Framework para el desarrollo de la aplicación web.
* **Spring Data MongoDB**: Para la interacción con la base de datos.
* **Maven**: Gestor de dependencias y construcción del proyecto.
* **Lombok**: Para reducir el código repetitivo (Boilerplate).

## 📋 Requisitos Previos

1.  **MongoDB**: El servicio debe estar iniciado en `localhost:27017`.
2.  **JDK 25**: Instalado y configurado en el sistema.
3.  **Postman**: Para realizar las pruebas de los endpoints.

## ⚙️ Instalación y Configuración

1.  Clona el repositorio.
2.  Asegúrate de que MongoDB esté corriendo localmente.
3.  Configura el archivo `src/main/resources/application.properties` con tu URI de conexión:
    ```properties
    spring.data.mongodb.uri=mongodb://localhost:27017/taskmanager
    server.port=8081
    ```
4.  Ejecuta la aplicación desde tu IDE o mediante el comando:
    ```bash
    mvn spring-boot:run
    ```

## 🧪 Pruebas con Postman

Para crear una tarea (Endpoint: `POST /api/tasks`), utiliza el siguiente formato JSON en el **Body** (seleccionando `raw` y tipo `JSON`):

```json
{
    "title": "Tarea 3",
    "description": "otra tarea...",
    "completed": false,
    "priority": "ALTA",
    "tags": ["WEB"],
    "category": "Programación",
    "dueDate": "2025-12-17T10:42:00"
}

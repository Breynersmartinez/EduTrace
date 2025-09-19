
---

# **API de Gestión de Proyectos y Estudiantes**

Esta API desarrollada en **Spring Boot** permite gestionar estudiantes, proyectos, equipos y tareas.
Su objetivo es dar **trazabilidad al trabajo en equipo**, asegurando que cada integrante tenga evidencia de sus avances y responsabilidades.

Ideal para proyectos académicos (ej. **SDN**) o de desarrollo colaborativo, donde es importante demostrar quién trabaja y cuánto aporta.

---

## **Tabla de Contenidos**

1. [Características](#características)
2. [Tecnologías Utilizadas](#tecnologías-utilizadas)
3. [Requisitos](#requisitos)
4. [Instalación y Configuración](#instalación-y-configuración)
5. [Endpoints](#endpoints)
6. [Ejemplos de Uso](#ejemplos-de-uso)
7. [Manejo de Excepciones](#manejo-de-excepciones)
8. [Contribución](#contribución)
9. [Licencia](#licencia)

---

## **Características**

* **Gestión de Estudiantes**: CRUD completo para manejar información de cada integrante.
* **Gestión de Proyectos**: Permite crear y asignar proyectos a estudiantes/profesores.
* **Gestión de Tareas**: Cada miembro puede registrar y actualizar su progreso en tareas.
* **Roles de Usuario**: Soporte para estudiantes, líderes y profesores.
* **Validación de Datos**: Emails únicos, IDs de estudiante obligatorios.
* **Manejo de Excepciones**: Respuestas claras y estructuradas.
* **Base de Datos PostgresSQL**: Persistencia de datos en un motor relacional.
* **Documentación con Swagger**: Acceso rápido a la especificación de la API.

Características clave para proyectos académicos:

* **Trazabilidad completa**: Cada acción se guarda con timestamp y usuario.
* **Reportes automáticos**: Registro del avance de cada miembro.
* **Evaluación objetiva**: Métricas cuantificables por persona (tareas cumplidas).
* **Control de esfuerzo**: Evidencia de quién trabaja más o menos.

---

## **Tecnologías Utilizadas**

* **Spring Boot** (Backend en Java).
* **Spring Data JPA** (Persistencia de datos).
* **MySQL** (Base de datos).
* **Swagger** (Documentación).
* **Lombok** (Menos código repetitivo).

---

## **Requisitos**

* **Java 17 o superior**.
* **MySQL** instalado y configurado.
* **Maven** para dependencias.

---

## **Instalación y Configuración**

(igual a lo que ya tienes, solo cambia el nombre de la BD por algo como `gestion_proyectos` en lugar de `estudiantes`).

---

## **Endpoints**

Algunos ejemplos de endpoints REST:

### 👤 Estudiantes

* `GET /api/v1/users` → Listar estudiantes.
* `POST /api/v1/users` → Crear estudiante.
* `GET /api/v1/users/{id}` → Obtener estudiante por ID.
* `DELETE /api/v1/users/{id}` → Eliminar estudiante.

### 📁 Proyectos

* `GET /api/v1/projects` → Listar proyectos.
* `POST /api/v1/projects` → Crear proyecto.
* `GET /api/v1/projects/{id}` → Consultar proyecto.

### ✅ Tareas

* `GET /api/v1/tasks` → Listar todas las tareas.
* `POST /api/v1/tasks` → Crear tarea.
* `GET /api/v1/tasks/user/{id}` → Ver tareas de un usuario.
* `GET /api/v1/tasks/project/{id}` → Ver tareas de un proyecto.

---

## **Manejo de Excepciones**

* Estudiante no encontrado.
* Proyecto no asignado.
* Correo electrónico duplicado.
* Tarea inexistente.

---

## **Licencia**

MIT.


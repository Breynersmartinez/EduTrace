

# **API de Gestión de Estudiantes**

Esta es una API básica desarrollada en **Spring Boot** que permite realizar operaciones CRUD (Create, Read, Update, Delete) para gestionar estudiantes. La API está diseñada para ser simple, fácil de usar y extensible.

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
- **CRUD Completo**: Permite crear, leer, actualizar y eliminar estudiantes.
- **Validación de Datos**: Valida que los datos ingresados sean correctos (por ejemplo, correo electrónico único).
- **Manejo de Excepciones**: Captura excepciones y devuelve respuestas claras y útiles.
- **Base de Datos MySQL**: Almacena los datos en una base de datos MySQL.
- **Documentación con Swagger**: Incluye documentación automática de la API.

Características clave del diseño:

Trazabilidad completa - Cada acción queda registrada con timestamp y usuario
Integración con Git - Sincronización automática de contribuciones de código
Reportes automatizados - Genera evidencias sin trabajo manual
Evaluación objetiva - Métricas cuantificables de desempeño

Lo más importante para tu caso:

GitContribution - Rastrea automáticamente quién contribuye código real
WeeklyReport - Fuerza a todos a documentar su trabajo semanalmente
PeerEvaluation - Los compañeros se evalúan entre sí anónimamente
Task tracking - Registra horas estimadas vs. reales por persona
---

## **Tecnologías Utilizadas**
- **Spring Boot**: Framework para desarrollar aplicaciones Java.
- **Spring Data JPA**: Para la persistencia de datos.
- **MySQL**: Base de datos relacional.
- **Swagger**: Para documentar la API.
- **Lombok**: Para reducir el código repetitivo (getters, setters, constructores).

---

## **Requisitos**
- **Java 17 o superior**.
- **MySQL** instalado y configurado.
- **Maven** para la gestión de dependencias.

---

## **Instalación y Configuración**

### **1. Clonar el Repositorio**
```bash
git clone https://github.com/tu-usuario/crud-rapido.git
cd crud-rapido
```

### **2. Configurar la Base de Datos**
1. Crea una base de datos en MySQL llamada `estudiantes`.
2. Configura las credenciales de la base de datos en el archivo `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/estudiantes
   spring.datasource.username=root
   spring.datasource.password=tu-contraseña
   spring.jpa.hibernate.ddl-auto=update
   ```

### **3. Compilar y Ejecutar la Aplicación**
```bash
mvn clean install
mvn spring-boot:run
```

La aplicación estará disponible en: `http://localhost:8081`.

---

## **Endpoints**

### **1. Obtener Todos los Estudiantes**
- **Método**: `GET`
- **URL**: `/api/v1/students`
- **Respuesta**:
  ```json
  [
    {
      "studentId": 1,
      "firstName": "Juan",
      "lastName": "Pérez",
      "email": "juan.perez@example.com"
    }
  ]
  ```

### **2. Obtener un Estudiante por ID**
- **Método**: `GET`
- **URL**: `/api/v1/students/{studentId}`
- **Respuesta**:
  ```json
  {
    "studentId": 1,
    "firstName": "Juan",
    "lastName": "Pérez",
    "email": "juan.perez@example.com"
  }
  ```

### **3. Crear un Nuevo Estudiante**
- **Método**: `POST`
- **URL**: `/api/v1/students`
- **Cuerpo de la Solicitud**:
  ```json
  {
    "firstName": "Ana",
    "lastName": "Gómez",
    "email": "ana.gomez@example.com"
  }
  ```
- **Respuesta**:
  ```json
  "Estudiante guardado correctamente."
  ```

### **4. Eliminar un Estudiante**
- **Método**: `DELETE`
- **URL**: `/api/v1/students/{studentId}`
- **Respuesta**:
  ```json
  "Estudiante eliminado correctamente."
  ```

---

## **Ejemplos de Uso**

### **1. Crear un Estudiante**
```bash
curl -X POST http://localhost:8081/api/v1/students \
-H "Content-Type: application/json" \
-d '{
  "firstName": "Ana",
  "lastName": "Gómez",
  "email": "ana.gomez@example.com"
}'
```

### **2. Obtener Todos los Estudiantes**
```bash
curl -X GET http://localhost:8081/api/v1/students
```

### **3. Eliminar un Estudiante**
```bash
curl -X DELETE http://localhost:8081/api/v1/students/1
```

---

## **Manejo de Excepciones**
La API maneja excepciones comunes y devuelve respuestas claras. Algunos ejemplos:

- **Correo Electrónico Duplicado**:
  ```json
  {
    "timestamp": "2025-03-18T17:33:23.449+00:00",
    "status": 409,
    "error": "Conflict",
    "message": "Error: El correo electrónico ya está en uso.",
    "path": "/api/v1/students"
  }
  ```

- **Estudiante No Encontrado**:
  ```json
  {
    "timestamp": "2025-03-18T17:33:23.449+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Estudiante no encontrado.",
    "path": "/api/v1/students/123"
  }
  ```

---

## **Contribución**
Si deseas contribuir a este proyecto, sigue estos pasos:
1. Haz un fork del repositorio.
2. Crea una rama para tu contribución (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz commit (`git commit -m 'Añadir nueva funcionalidad'`).
4. Haz push a la rama (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.

---

## **Licencia**
Este proyecto está bajo la licencia **MIT**. Para más detalles, consulta el archivo [LICENSE](LICENSE).

---

¡Gracias por usar esta API! Si tienes alguna pregunta o sugerencia, no dudes en abrir un issue o contactarme. 😊

---


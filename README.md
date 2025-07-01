# IronSchool - School Management System

IronSchool es una aplicación de consola construida con Spring Boot que permite gestionar estudiantes, profesores y cursos. Está diseñada para simular un sistema básico de gestión escolar con persistencia en base de datos y una interfaz de comandos.

## 🛠️ Tecnologías usadas

- Java 17+
- Spring Boot 3.5+
- Spring Data JPA
- MySQL
- Lombok
- JUnit 5
- IntelliJ IDEA

---

## 🚀 ¿Cómo ejecutar?

1. Asegúrate de tener MySQL corriendo (puerto 3314, base de datos `demo`).
2. Clona el proyecto.
3. Abre en IntelliJ.
4. Ejecuta `DemoApplication.java` para lanzar la consola.
5. Interactúa con comandos desde la terminal integrada.

---

## 📦 Comandos disponibles

### 🎓 Estudiantes

- `SHOW STUDENTS` — Lista todos los estudiantes.
- `LOOKUP STUDENT [STUDENT_ID]` — Muestra los detalles de un estudiante.
- `ENROLL [STUDENT_ID] [COURSE_ID]` — Inscribe a un estudiante en un curso.

### 🧑‍🏫 Profesores

- `SHOW TEACHERS` — Lista todos los profesores.
- `LOOKUP TEACHER [TEACHER_ID]` — Muestra los detalles de un profesor.
- `ASSIGN [TEACHER_ID] [COURSE_ID]` — Asigna un profesor a un curso.

### 📘 Cursos

- `SHOW COURSES` — Lista todos los cursos.
- `LOOKUP COURSE [COURSE_ID]` — Muestra los detalles de un curso.

### 📈 Finanzas

- `SHOW PROFIT` — Calcula el beneficio neto: ingresos por cursos - salarios.

### ❌ Salida

- `EXIT` — Cierra la aplicación.

---

## 🧪 Testing

- `SchoolServiceTest.java` cubre la lógica de negocio clave.
- Se utilizan mocks para pruebas unitarias.

---

## 🧑 Autor

Proyecto desarrollado por [Tu Nombre] como parte del Homework 2 del bootcamp Ironhack.

---

## 📎 Notas

- Los IDs (`S-uuid`, `T-uuid`, `C-uuid`) se generan automáticamente.
- El sistema maneja errores y evita inscripciones repetidas.

# 📚 School Management System (Console App with Java & Spring Boot)

Este proyecto es una aplicación de consola en Java con Spring Boot que simula un sistema de gestión escolar. Permite administrar profesores, estudiantes y cursos mediante comandos escritos en la terminal.

---

## 🚀 Funcionalidades

- Crear y gestionar **profesores**, **estudiantes** y **cursos**
- Asignar profesores a cursos
- Inscribir estudiantes en cursos
- Calcular el **beneficio neto** de la escuela
- Ejecutar comandos tipo terminal (`ENROLL S1 C1`, `SHOW COURSES`, etc.)
- Validaciones de entrada y manejo de errores
- Bonus: mostrar estudiantes por curso, dinero ganado, dinero gastado
- Pruebas unitarias con **JUnit 5**

---

## 🧾 Estructura del Proyecto

```
src
├── main
│   ├── java.com.example.demo
│   │   ├── model         # Clases: Student, Teacher, Course
│   │   ├── service       # Lógica central: SchoolService
│   │   └── CommandApp    # Main app con menú por comandos
├── test
│   └── java.com.example.demo
│       ├── SchoolServiceTest     # Pruebas de lógica
│       └── ValidationTest        # Pruebas de validaciones
```

---

## ⚙️ Cómo ejecutar

### 🔧 Requisitos

- Java 17+
- Maven
- IntelliJ (opcional, recomendado)

### ▶ Ejecutar desde consola

```bash
./mvnw clean install
./mvnw spring-boot:run
```

> O bien, ejecuta directamente la clase `CommandApp` desde tu IDE.

---

## 🖥️ Comandos disponibles

| Comando                        | Acción                                                                 |
|-------------------------------|------------------------------------------------------------------------|
| `ENROLL [STUDENT_ID] [COURSE_ID]`     | Inscribe un estudiante en un curso y suma el precio al dinero ganado |
| `ASSIGN [TEACHER_ID] [COURSE_ID]`     | Asigna un profesor a un curso                                         |
| `SHOW COURSES`                | Muestra todos los cursos                                               |
| `SHOW STUDENTS`               | Muestra todos los estudiantes                                          |
| `SHOW STUDENTS [COURSE_ID]`   | Muestra estudiantes de un curso específico (bonus)                     |
| `SHOW TEACHERS`               | Muestra todos los profesores                                           |
| `LOOKUP STUDENT [ID]`         | Muestra los datos de un estudiante específico                          |
| `LOOKUP COURSE [ID]`          | Muestra los datos de un curso específico                               |
| `LOOKUP TEACHER [ID]`         | Muestra los datos de un profesor específico                            |
| `SHOW PROFIT`                 | Muestra (dinero ganado - sueldos)                                      |
| `SHOW MONEY EARNED`           | Muestra el total ganado en todos los cursos (bonus)                    |
| `SHOW MONEY SPENT`            | Muestra la suma de sueldos de todos los profesores (bonus)             |
| `EXIT`                        | Finaliza la ejecución                                                  |

---

## ✅ Pruebas

Este proyecto incluye pruebas unitarias con JUnit 5.

Para ejecutarlas:

```bash
./mvnw test
```

Pruebas incluidas:
- Asignación de profesores
- Inscripción de estudiantes
- Cálculo de beneficio
- Validaciones de datos (nombre vacío, email inválido, etc.)

---

## 🤝 Contribución

- Todos los miembros del equipo deben contribuir en tiempo y código.
- Todo código debe ser revisado antes de hacer merge a `main`.
- Crea una rama por funcionalidad (`feature/nombre`), y un Pull Request.
- Este repositorio debe tener siempre este `README.md` actualizado.

---

## 📌 Notas Finales

Este proyecto tiene como fin mejorar tus habilidades en Java, Spring Boot, programación orientada a objetos, testing y colaboración en equipo.  
Es normal que sea desafiante. Investiga, pregunta y ¡sigue practicando!

---

## 👥 Autores

- Franziska 👷
- Lluc 👷 
- Arni 👷 

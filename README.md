# 🚀 DevBlog - Spring Boot Web App

Un sistema de gestión de contenido (Blog) full-stack desarrollado para implementar una arquitectura MVC con Spring Boot, renderizado del lado del servidor con Thymeleaf y diseño responsivo con Bootstrap 5.

## 🛠️ Tecnologías Utilizadas

* **Backend:** Java 21, Spring Boot 3 (Web, Data JPA, Validation)
* **Base de Datos:** PostgreSQL
* **Frontend:** Thymeleaf (con plantillas y fragmentos), HTML5
* **Estilos:** Bootstrap 5 (Flexbox, CSS Grid)
* **Herramientas:** Maven, Lombok

## ✨ Características Implementadas

* **CRUD Completo:** Creación, lectura, actualización y eliminación de publicaciones en la base de datos.
* **Reutilización de Vistas:** Un único formulario (`formulario.html`) maneja inteligentemente tanto la creación como la edición de posts mediante el estado del ID.
* **Validación de Datos (Backend):** Uso de anotaciones como `@NotBlank` y `@Size` para evitar registros en blanco o inválidos, devolviendo retroalimentación visual interactiva al usuario.
* **Diseño Responsivo (Mobile-First):** Interfaz fluida que se adapta desde pantallas ultra anchas hasta dispositivos móviles gracias al sistema de columnas de Bootstrap y etiquetas `viewport`.
* **Código DRY (Don't Repeat Yourself):** Implementación avanzada de fragmentos en Thymeleaf (`fragments.html`) para modularizar la cabecera, barra de navegación y carga de scripts.

## 📂 Estructura del Proyecto

```text
src/main/
├── java/com/devent/blog/
│   ├── controller/BlogController.java
│   ├── model/Post.java
│   └── repository/PostRepository.java
└── resources/
    ├── application.properties
    └── templates/
        ├── fragments.html
        ├── index.html
        ├── formulario.html
        └── detalle.html
```

## 🚀 Guía de Instalación y Uso

Prerrequisitos

* Java 21 o superior
* Maven
* PostgreSQL corriendo localmente en el puerto 5432

Pasos para ejecutar localmente
1. **Clonar el repositorio:**
```bash
git clone [https://github.com/fsstf/devblog-spring-thymeleaf.git](https://github.com/fsstf/devblog-spring-thymeleaf.git)
cd devblog-spring-thymeleaf
```
2. **Preparar la Base de Datos:**<br>
   Abre tu consola de PostgreSQL (psql) o cliente preferido y ejecuta:
```bash
CREATE DATABASE blog_db;
```
3. **Configurar Credenciales:**<br>
   Abre el archivo src/main/resources/application.properties y ajusta el usuario y la contraseña según tu entorno local:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/blog_db
spring.datasource.username=postgres
spring.datasource.password=root
```
4. **Compilar y Ejecutar:**<br>
Desde la raíz del proyecto, ejecuta el siguiente comando:
```bash
mvn clean spring-boot:run
```
5. **Acceder a la aplicación:**<br>
Abre tu navegador web y visita http://localhost:8080

**Desarrollado por:** @fsstf

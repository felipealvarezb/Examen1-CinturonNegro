# Libreria API - Cinturón negro

Este es un proyecto desarrollado en **Spring Boot** con una arquitectura por capas. Utiliza **MySQL** como base de datos. Es un proyecto 
para el bootcamp de JAVA que fue calificado como una de las mejores entrega según lo visto hasta el momento en clase.



## 📌 Arquitectura

El proyecto sigue una arquitectura por capas:

- **Controller**: Maneja las peticiones HTTP.
- **Service**: Contiene la lógica de negocio.
- **Repository**: Se encarga de la comunicación con la base de datos.
- **Model**: Define las entidades del dominio.
- **DTO**: Define los modelos para creación y actualización, como también para respuesta
- **Mappers**: Define los mapeos de DTO's a entidades y de entidades a ResponseDTO's
- **Exception**: Define las clases para el manejo de excepciones cunado se lanza un EntityNotFound o MethodArgumentNotValid


### 📊 Modelo Entidad-Relación

A continuación, se muestra el modelo de entidad-relación del proyecto:
![Captura de pantalla 2025-02-27 a la(s) 5 04 21 p m](https://github.com/user-attachments/assets/42a04630-47e4-4f9e-994a-f3363a219ddd)



## 🚀 Configuración del Proyecto

## Requisitos previos

Antes de desplegar la aplicación, asegúrate de tener instalado lo siguiente en tu sistema:

1. **Java Development Kit (JDK) 21 o superior**  
   [Descargar JDK](https://adoptium.net/)

2. **Maven** (para compilar y ejecutar el proyecto)  
   [Descargar Maven](https://maven.apache.org/download.cgi)

3. **Postman o cURL** (opcional, para probar los endpoints)

---

## Configuración inicial

### 1. Clonar el repositorio
Clona este repositorio en tu máquina local:

```bash
git clone https://github.com/felipealvarezb/Examen1-CinturonNegro
```

### 2. Compilar el proyecto

Para compilar el proyecto, ejecuta:

```bash
./mvnw clean install
./mvnw spring-boot:run
```


## 📜 API Endpoints

Puedes probar los endpoints con Postman de forma local (`http://localhost:8080/api/v1/**`).


Algunos endpoints principales:
- **Author**:
  - `GET /api/v1/author` → Obtener todas las autores.
  - `POST /api/v1/author` → Crear una autor.
  - `PUT /api/v1/author/{id}` → Actualizar una autor.
  - `DELETE /api/v1/author/{id}` → Eliminar una autor.

- **Book**:
  - `GET /api/v1/book` → Obtener todas los libros.
  - `POST /api/v1/book` → Crear un libro.
  - `POST /api/v1/book/{bookId}/gender/{genderId}` → Asignar un genero a un libro.
  - `DELETE /api/v1/book/{bookId}/gender/{genderId}` → Eliminar un genero de un libro.
  - `PUT /api/v1/book/{id}` → Actualizar un libro.
  - `DELETE /api/v1/book/{id}` → Eliminar un libro.

- **Editorial**:
  - `GET /api/v1/editorial` → Obtener todos los editoriales.
  - `POST /api/v1/editorial` → Crear una editorial.
  - `PUT /api/v1/editorial/{id}` → Actualizar una editorial.
  - `DELETE /api/v1/editorial/{id}` → Eliminar una editorial.
 
- **Genero**:
  - `GET /api/v1/gender` → Obtener todos los generos.
  - `POST /api/v1/gender` → Crear un genero.
  - `PUT /api/v1/gender/{id}` → Actualizar un genero.
  - `DELETE /api/v1/gender/{id}` → Eliminar un genero.

---

## 🛠 Tecnologías Utilizadas

- **Spring Boot 3**
- **Spring Data JPA**
- **MySQL**
- **Lombok**

---

## 📌 Autor

Desarrollado por **Felipe Álvarez** 🚀.

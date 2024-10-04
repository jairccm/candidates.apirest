# candidates.apirest

# Proyecto de Microservicios - API para gestion de candidatidos - Arquitectura hexagonal

Este proyecto es una API basada en Spring Boot que gestiona candidatos utilizando una base de datos MySQL.

## Requisitos Previos

Antes de comenzar, asegúrate de tener instalados los siguientes componentes en tu máquina:

- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [MySQL](https://dev.mysql.com/downloads/mysql/)

## Configuración del Proyecto

### 1. Clonar el Repositorio

Clona este repositorio en tu máquina local utilizando el siguiente comando:

```bash
git https://github.com/jairccm/candidates.apirest
cd candidates.apirest
```

### 2. Configurar la Base de Datos

1. **Crear la Base de Datos**:
   Abre tu cliente MySQL y crea la base de datos `candidates`:

   ```sql
   CREATE DATABASE candidates;
   ```

2. **Configurar las Credenciales**:
   Asegúrate de que el archivo `src/main/resources/application.properties` tenga la siguiente configuración para conectarse a tu base de datos:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/candidates
   spring.datasource.username=root
   spring.datasource.password=Admin2024
   ```

### 3. Dependencias de Maven

Este proyecto utiliza Maven para gestionar las dependencias. Asegúrate de que las dependencias en el archivo `pom.xml` sean las correctas. Algunas de las dependencias clave son:

- `spring-boot-starter-web`
- `spring-boot-starter-data-jpa`
- `mysql-connector-j`
- `flyway-mysql`

### 4. Compilar el Proyecto

Ejecuta el siguiente comando en la raíz del proyecto para compilar el proyecto:

```bash
mvn clean install
```

### 5. Ejecutar la Aplicación

Una vez que el proyecto se haya compilado con éxito, puedes ejecutar la aplicación con el siguiente comando:

```bash
mvn spring-boot:run
```

La aplicación estará disponible en [http://localhost:8080](http://localhost:8080).

## Migraciones de Base de Datos

Este proyecto utiliza [Flyway](https://flywaydb.org/) para gestionar las migraciones de la base de datos. Asegúrate de que las migraciones estén configuradas correctamente y disponibles en el directorio `src/main/resources/db/migration`.


## Uso de la API

La API expone varios endpoints. Consulta la documentación de OpenAPI que se generará automáticamente al iniciar la aplicación en:

- [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## Pruebas

Para ejecutar las pruebas unitarias del proyecto, utiliza el siguiente comando:

```bash
mvn test
```

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.

## Contacto

Si tienes alguna pregunta o sugerencia, no dudes en contactar conmigo.

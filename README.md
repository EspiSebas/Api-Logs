# API-Logs — Registro de solicitudes HTTP

API-Logs es un proyecto desarrollado con Java y Spring Boot cuyo objetivo es registrar información sobre las peticiones realizadas a una API externa.

El proyecto busca facilitar el seguimiento de las comunicaciones entre servicios, permitiendo almacenar información relevante para el análisis, la trazabilidad y la depuración de solicitudes HTTP.

## Objetivo del proyecto

Desarrollar una API que permita centralizar el registro de las solicitudes realizadas a un servicio externo, facilitando la consulta y el análisis de la información registrada.

## Tecnologías utilizadas

| Tecnología | Propósito |
|---|---|
| Java 17 | Lenguaje de programación |
| Spring Boot 4 | Desarrollo de la aplicación backend |
| Spring WebMVC | Construcción de endpoints REST |
| Spring WebFlux | Soporte para programación reactiva y comunicación HTTP |
| Spring Data JPA | Persistencia y acceso a datos |
| MySQL | Base de datos relacional |
| Spring Cloud Config | Gestión de configuración externa |
| Spring Cloud OpenFeign | Integración y comunicación con servicios externos |
| Gradle | Gestión de dependencias y construcción del proyecto |
| Lombok | Reducción de código repetitivo |

## Arquitectura general

El flujo general previsto para el proyecto es:

1. Una aplicación realiza una petición a una API externa.
2. La aplicación registra información relevante de la solicitud y su respuesta.
3. Los registros se almacenan para facilitar su consulta posterior.
4. La información puede utilizarse para analizar errores y realizar seguimiento de las comunicaciones entre servicios.

```text
┌───────────────────────┐
│ Aplicación cliente    │
└───────────┬───────────┘
            │
            ▼
┌───────────────────────┐
│ API-Logs               │
│                       │
│ Registro de solicitudes│
│ Integración HTTP       │
│ Persistencia de datos  │
└───────────┬───────────┘
            │
       ┌────┴─────┐
       ▼          ▼
┌────────────┐ ┌────────────┐
│ API externa│ │   MySQL    │
└────────────┘ └────────────┘
```

*El diagrama representa el flujo conceptual del proyecto; la implementación concreta depende de los componentes y endpoints disponibles en el código.*

## Requisitos previos

Antes de ejecutar el proyecto, asegúrate de contar con:

- JDK 17.
- MySQL.
- Git.
- Una conexión a internet para descargar las dependencias de Gradle.
- Las credenciales y la URL de la API externa, si son necesarias para la configuración.

## Instalación y ejecución

### 1. Clonar el repositorio

```bash
git clone https://github.com/EspiSebas/Api-Logs.git
cd Api-Logs
```

### 2. Configurar la base de datos

Crea una base de datos en MySQL para el proyecto. Por ejemplo:

```sql
CREATE DATABASE api_logs;
```

Configura las credenciales, la URL de conexión y las demás propiedades requeridas por la aplicación en su archivo de configuración.

La configuración debe coincidir con las propiedades que utiliza el código fuente.

### 3. Ejecutar la aplicación

En Linux o macOS:

```bash
./gradlew bootRun
```

En Windows:

```bash
gradlew.bat bootRun
```

Gradle descargará las dependencias necesarias y ejecutará la aplicación.

### 4. Ejecutar las pruebas

Para ejecutar las pruebas automatizadas:

```bash
./gradlew test
```

## Posibles aplicaciones

Una solución de registro de solicitudes HTTP puede resultar útil para:

- Diagnosticar errores de comunicación entre servicios.
- Facilitar la depuración de integraciones con APIs externas.
- Mantener trazabilidad de las operaciones realizadas.
- Analizar tiempos de respuesta y códigos de estado HTTP, si estos datos se registran.
- Centralizar información técnica para apoyar el mantenimiento de aplicaciones.

## Mejoras futuras

Algunas mejoras que podrían ampliar las capacidades del proyecto son:

- Implementar filtros de búsqueda por fecha, endpoint y código de estado.
- Incorporar métricas de rendimiento y tiempos de respuesta.
- Agregar manejo centralizado de errores.
- Implementar pruebas unitarias y de integración.
- Incorporar Docker para simplificar el despliegue.
- Añadir documentación interactiva de los endpoints.
- Aplicar mecanismos de protección para evitar almacenar credenciales o información sensible en los logs.

## Autor

**Sebastian Espinosa**

Tecnólogo en Análisis y Desarrollo de Software | Desarrollador Backend

- GitHub: [@EspiSebas](https://github.com/EspiSebas)
- LinkedIn: [sebastian-espinosa-dev](https://www.linkedin.com/in/sebastian-espinosa-dev/)

---

*Proyecto personal orientado al aprendizaje de desarrollo backend con Java, Spring Boot, persistencia de datos e integración entre servicios mediante HTTP.*

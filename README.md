
# 2Apis_Feign_Process_Transaction_Angular

Proyecto compuesto por:

- Frontend Angular
- API Transacciones (Spring Boot)
- API Procesador (Spring Boot)
- Base de datos H2
- Comunicación entre APIs mediante OpenFeign


## Estructura del proyecto

```
2Apis_Feign_Process_Transaction_Angular
│
├── api-transacciones          # Backend API 1 - Puerto 8080
│
├── api-procesador             # Backend API 2 - Puerto 8081
│
├── transacciones-front        # Frontend Angular - Puerto 4200
│
├── docker-compose.yml
│
└── README.md
```


# Requisitos

Para ejecución manual:

- Java 17
- Maven 3.9+
- Node.js 22+
- Angular CLI
- Docker


# Ejecución con Docker Compose

Desde la raíz del proyecto ejecutar:

```bash
docker compose up --build
```

Este comando levantará todos los servicios:

## Frontend Angular

URL:

```
http://localhost:4200
```


## API Transacciones

Puerto:

```
8080
```

URL:

```
http://localhost:8080
```


## API Procesador

Puerto:

```
8081
```

URL:

```
http://localhost:8081
```


## Consola H2

URL:

```
http://localhost:8082
```

Configuración:

```
JDBC URL:
jdbc:h2:file:./data/transaccionesdb

Usuario:
sa

Password:
(vacío)
```


# Ejecución manual


## Backend 1 - API Transacciones

```bash
cd api-transacciones

mvn clean package

mvn spring-boot:run
```

Disponible en:

```
http://localhost:8080
```


## Backend 2 - API Procesador

```bash
cd api-procesador

mvn clean package

mvn spring-boot:run
```

Disponible en:

```
http://localhost:8081
```


## Frontend Angular

```bash
cd transacciones-front

npm install

ng serve
```

Disponible en:

```
http://localhost:4200
```


# Endpoints principales


## Login

Método:

```
POST
```

URL:

```
http://localhost:8081/auth/login
```

Ejemplo:

```json
{
  "usuario": "admin",
  "password": "alfred123456"
}
```

Respuesta:

```json
{
  "mensaje": "Login correcto"
}
```


## Registro de operación

Método:

```
POST
```

URL:

```
http://localhost:8080/operaciones
```

Ejemplo:

```json
{
  "operacion": "venta",
  "importe": 100,
  "cliente": "cliente prueba",
  "secreto": "texto_encriptado_AES"
}
```

Respuesta:

```json
{
  "id": 4,
  "estatus": "Aprobada",
  "referencia": 191210,
  "operacion": "venta"
}
```


# Base de datos

Motor:

```
H2 Database
```

Modo:

```
File Database
```

Ubicación:

```
./data/transaccionesdb
```


# Detener servicios Docker

```bash
docker compose down
```


# Eliminar contenedores y volúmenes

```bash
docker compose down -v
```


# Tecnologías utilizadas


## Backend

- Java 17
- Spring Boot 3.5.5
- Spring Data JPA
- Hibernate
- Spring Validation
- OpenFeign
- H2 Database
- Maven


## Frontend

- Angular
- TypeScript
- HTML
- CSS


## Infraestructura

- Docker
- Docker Compose
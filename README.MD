# MICRO-SERVICIO API-CAT

#### Aplicacion en `SpringBoot` con `Mongo`

Microservicio basado en la api publica `https://thecatapi.com`, con una capa de mongo.

> Los endpoint tipo **REST** estan documentados en el archivo `rest.http` en la raiz del repo.

### Requerimientos:
* Docker
* Editor de codigo

### Importante:

- No se requiere tener instalado el `java-jdk` por que tambien tiene dockerizado el `maven`.
- En `src\main\resources\application.properties` cambia el DNS de conexion a base de datos.

## DOCKER

```sh
docker build -t api-cat .
```

```sh
docker run -d -p 8080:8080 --name api-cat-app api-cat
```
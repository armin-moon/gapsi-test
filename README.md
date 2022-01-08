# gapsi-test

Proyecto backet para completar el test de desarollo Java para Gapsi

## Tecnología usada 🛠️

Para esta API se está utilizando java 11, spring boot con spring batch.

* [Spring Boot ](https://spring.io/projects/spring-boot): framework versión 2.4.2
* [Java](https://www.oracle.com/mx/java/technologies/javase/jdk11-archive-downloads.html): versión 11
* [Maven](https://maven.apache.org/) administrador de dependencias versión 3 o superior

## Configuracion ⚙️

Para editar el puerto del microservicio se debe de editar en el archico src/main/resources/application.properties por default se tiene el puerto 8080
```
server.port: 8080
```
La data inicial se encuentra en el archivo src/main/resources/db.json

```
{
    "provedores":[
        {   
            "nombre":"COCACOLA",
            "razonSocial":"Cocacola",
            "direccion":"Direccion Cocacola"
        },
        {
            "nombre":"GARRITOS",
            "razonSocial":"Garritos",
            "direccion":"Direcion Garritos"
        },
        {
            "nombre":"NESCAFE",
            "razonSocial":"NESCAFE",
            "direccion":"Direcion NESCAFE"
        },
        {
            "nombre":"STARTBUCKS",
            "razonSocial":"Startbucks",
            "direccion":"Direcion Startbucks"
        }
    ]
}
```

## Instalación 🚀

Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas.

```
$ git clone https://github.com/armin-moon/gapsi-test.git
$ cd gapsi-test
$ mvn clean package
$ mvn spring-boot:run
```

# LABORATORIO 5 AREP

### Autor: Daniela Garcia 


Este laboratorio cuenta con tres servidores y para distribuir la carga se usa Round Robin que lo que hace es dividirla en tres y asi lograr balancearla para que no se sature el servidor.

Para el despliegue se usa Docker el cual automatiza este proceso usando contenedores.

## Conceptos

### Docker

"*Docker es un proyecto de código abierto que automatiza el despliegue de aplicaciones dentro de contenedores de software, proporcionando una capa adicional de abstracción y automatización de virtualización de aplicaciones en múltiples sistemas operativos.*"


### Round Robin
"*Round-robin es un método para seleccionar todos los abstractos en un grupo de manera equitativa y en un orden racional, normalmente comenzando por el primer elemento de la lista hasta llegar al último y empezando de nuevo desde el primer elemento.*"


### EC2
*"EC2 permite a los usuarios alquilar computadores virtuales en los cuales pueden ejecutar sus propias aplicaciones."*


### MongoDB
"*MongoDB es un sistema de base de datos NoSQL, orientado a documentos y de código abierto. En lugar de guardar los datos en tablas, tal y como se hace en las bases de datos relacionales, MongoDB guarda estructuras de datos BSON (una especificación similar a JSON) con un esquema dinámico, haciendo que la integración de los datos en ciertas aplicaciones sea más fácil y rápida.*"




### Prerequisitos
* Maven: Herramienta para la gestión y construcción de proyectos.
* Java: Lenguaje de programación.
* Git: Sistema de control de versiones distribuido.
* Docker: plataforma de software para permite crear, probar e implementar aplicaciones rápidamente.

## Solución


### Uso de la aplicación

Para poder correr el programa se deben seguir los siguientes pasos:
* Clonar el respositorio con el 

```

mvn clean install

```


![](img/img.png)

![](img/img_2.png)

* Instalamos java en cada una de las instancias menos en la de mongo

![](img/img_4.png)

![](img/img_3.png)

* Instancia 3

![](img/img_5.png)

* Instancia 2

![](img/img_6.png)
* Instancia 1

![](img/img_7.png)

* RoundRobin

![](img/img_8.png)


![img.png](img.png)

![img_1.png](img_1.png)



### Autor

* **Daniela García Romero**:[danielagar320](https://github.com/danielagar320)
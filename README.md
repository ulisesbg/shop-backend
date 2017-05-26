# shop-backend
Servicios Rest para Consumir Datos, usando una arquitectura Spring+Hibernate+PostgreSQL


Requerimientos: Java 7; PostgreSQL 9.x,Apache-Maven 3.1.1, Apache Tomcat 7

1-Se requiere la configuracion de Maven para la descarga de los plugins del proyecto. Agregar a las variables de entorno %MAVEN_HOME%\bin
2-Una vez  configurado MAVEN, se debe agregar el plugin de MAVEN a Eclipse IDE, yo utilice Eclipse Neon el cual ya lo trae precargado.
3-Importar el proyecto al workspace de eclipse IDE
4-Ejecutar el comando mvn build o Run>Build desde eclipse IDE con GOAL: clean install
5- Una vez que maven descargue todas las depencias solo resta ejecutar el script en una Instancia de PostgreSQL 9.x
6- Run ShopApplication en Tomcat 7.


Adjunto una URL del Proyecto en Openshift con las mismas caracteristicas del ambiente: http://shop-ulisesbg.rhcloud.com/ShopApplication/

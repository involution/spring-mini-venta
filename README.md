spring-mini-venta
=================

Proyecto de mini sistema de ventas con el uso de spring framework, hibernate y JPA 2.


Tenemos lo siguiente:

- Carpeta "miniVenta" que es un proyecto hecho en Eclipse Indigo R2, uso de maven, spring framework, hibernate y JPA 2.0.
	
Para ejecutar lo primero: 
* Run as -> Maven install
* y finalmente: Run as -> Java application (com.mini.venta.launch.SpringLauncher)

- Tenemos un script para la BD en MySQL, el archivo MiniVenta20130311.sql



OBSERVACION
===========

Quizas tengan problemas con el jar forms-1.3.0.jar(algo asi como que no lo encuentra), este jar debe estar contenido dentro del repositorio de maven en tu maquina, por ejemplo yo lo tengo en:
/home/scarlos/.m2/repository/forms/forms/1.3.0/forms-1.3.0.jar

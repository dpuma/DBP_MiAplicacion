Aplicación Registro de Usuarios y Reserva de Peliculas

Resumen de la presente aplicacion:
FUNCIONALIDAD E INTERFACES
Tiene por funcionalidad controlar el logueo y el registro de distintos usuarios para una simulación de reservas para entradas al cine.
Cuenta con funcionalidades como:
- Registrar nuevo usuario (donde solicita sus datos como: Nombre, DNI, Celular y un Password para su cuenta)
- Loguearse (mediante el DNI y su Password)
- Reservar Pelicula y Horario: dentro de dicho activity se puede reservar más de una entrada para Película y borrar las reservaciones hechas.

Manejo de Base de Datos, el proyecto cuenta con el manejo de una base de datos con dos tablas:
- En una se guarda los usuarios que se registran, con lo cual se puede corroborar su DNI y su Password al momento de loguearse, se utiliza su DNI como primary key.
- En la otra tabla, se guardan las reservas de entradas que realicen los usuarios, esta tabla permite consultar las reservaciones de cada uno de los usuarios mediante su DNI como llave foránea y tambien borrar las reservaciones de usuarios específicos.

Manual de Usuario:
Primero hay que registrarse en la aplicacion, ingresando los datos personales como Nombre Completo, DNI, Numero de Celular y un Password.
Segundo, regresando a la pantalla de logueo, se ingresa el DNI y el Password para acceder a la Reserva de peliculas.
Tercero, podras elegir que la pelicula y el horario de preferencia, seleccionando entre las opciones y presionando el boton Nueva Reserva para efectuar tu elección
Cuarto, puedes acceder nuevamente a la Reserva de peliculas para ver en su totalidad las películas que hayas reservado anteriormente o en todo caso, borrar toda la lista de reservas.

Link al repositorio: https://github.com/dpuma/DBP_MiAplicacion

Integrantes del trabajo:
- Angela Sucso Choque
- Dennis Pumaraime Espinoza
# ScholarWeb

## Descripcion
Vamos a realizar la creación de un página web de un colegio de primaria, en el cual se podrán hacer cosas como: 
 - Envio de correo a los padres de las notas de los hijos, sus faltas e incluso el menu del mes. 
 - Tanto profesores, padres y monitores recibiran las ultimas noticias del colegio. 
 - Las personas que no sean del centro, podrán visualizar las diferentes zonas del centro y sus distintas actividades. 
 - El centro contara con menú especializado para los niños intolerantes. 

### 1. _Sección pública_.

Funcionalidades:
- Visualización de los diferentes lugares del colegio.
- Noticias vinculadas al colegio.
- Visualización del menú del comedor (intolerancia a alimentos).

### 2. _Sección privada_.

Funcionalidades:
- Subida de notas por parte del profesor.
- Datos privados de alumnos (notas, excursiones, faltas, trabajos).
- Login de padres para ver datos de su hijo/a.
- Envío de correo a padres con las actividades, notas y faltas de su hijo/a.
- Administración de alumnos y profesores.
- Gestión de notas, trabajos y faltas del los alumnos.

### **Entidades que componen la aplicación web.**
Tendremos en un principio 6 entidades en toda la aplicación web que se identificarán como: 
- Administradores de la página.
- Alumnos.
- Profesores.
- Clase.
- Padres.
- Asignaturas 
- Comedor (menus con o sin intolerancia). 

### **Funcionalidades del servicio interno.**
- Menu comedor. 
- Notificaciones a padres (notas, faltas, horario).
- Dias festivos.
- Menú comedor.

### **DIAGRAMA DE CLASES.**
![Untitled Diagram](https://user-images.githubusercontent.com/45795451/55950272-c8f4b780-5c54-11e9-95b2-0437191ca006.png)

### **DIAGRAMA ENTIDAD-RELACIÓN.**
![diagrama_2 (2)](https://user-images.githubusercontent.com/45795451/55953317-0dd01c80-5c5c-11e9-97c0-d4a63beb3e22.png)

### **MODELO DE NAVEGACIÓN.**
![NAVEGACION](https://user-images.githubusercontent.com/45795451/54568204-a74a3c80-49d6-11e9-81ed-9fa954976e72.png)

### **CAPTURAS DE PANTALLA.**
     1- PANTALLA DE INICIO.
 ![principal](https://user-images.githubusercontent.com/45795451/53005017-a2738680-3432-11e9-8abc-17be771fe635.png)
     
Mediante esta pantalla de inicio se puede acceder a todas las facilidades y funcionalidades que ofrece la página web. Gran parte de sus secciones son de carácter público, a excepción del acceso privado o login. Estas secciones públicas cuentan con información relacionada con el colegio en sí: profesores, noticias, actividades, horarios y el menú del comedor. Ofrece también una ventana de contacto con la que poder enviar mensajes al colegio. Por último, cuenta en la zona inferior con más datos del colegio, como es el teléfono de contacto, la dirección y un mapa en el que, al cliquear, te redirecciona a google maps, ubicando el colegio en el mapa.

     
     2-PANTALLA DE "PROFESORES".
 ![profesores](https://user-images.githubusercontent.com/45795451/53005172-fb431f00-3432-11e9-964b-9998fd7ec2d4.png)
 
En esta ventana se ofrece un listado de los profesores que componene el colegio, junto con una serie de datos de los mismos: nombre, correo y asignaturas que imparte. Se ofrece también una fotografía del profesor (de manera opcional).

    
     3-PANTALLA DE "NOTICIAS".
 ![noticias](https://user-images.githubusercontent.com/45795451/53005176-fd0ce280-3432-11e9-945d-bb3e5c57a8b7.png)
 
 Gracias a la opción de "Noticias", se quiere tener informado a todo el mundo de los acontecimientos que suceden entorno al colegio (tanto para gente relacionada con el centro como gente externa que visita la página web). Las noticias serán variadas y engoblan todo tipo de temáticas.
 
 
     4-PANTALLA DE "CONTACTOS".
 ![contacto](https://user-images.githubusercontent.com/45795451/53006749-1f542f80-3436-11e9-8dad-3f977cc4dc29.png)
 
 Si una persona desea contactar con el centro por cualquier motivo y no desea contactar vía teléfono, puede ponerse en contacto con el colegio mediante un mensaje en esta ventana, en la que se informará de lo que se desee dejando un nombre, un teléfono y un correo de contacto.
     
     5-PANTALLA DE LOGIN.
 ![login](https://user-images.githubusercontent.com/45795451/53005185-01390000-3433-11e9-8ed3-4dc0f9d1ec1e.png)
 
 Mediante el login, aquellos usuarios que formen parte del centro (alumnos, profesores y padres) podrán acceder a su sección privada, dentro de la cual contarán con una serie de secciones propias de cada tipo de usuario. 
 
 
     6- PDF (CON Y SIN DESCARGA).
 
 
 Al seleccionar los distintos pdf que aparecen al final de la página, podrán suceder dos cosas: 
 1. Que el pdf se abra como se muestra en la siguiente imagen:
 
 ![pdf_comedor](https://user-images.githubusercontent.com/45795451/54568786-dbbef800-49d8-11e9-9926-dcc1c182e2e6.png)
 
 2. Que el pdf se descargue de manera automática:
 
 ![pdf_descarga](https://user-images.githubusercontent.com/45795451/54568798-e5e0f680-49d8-11e9-81e7-0b74af52068b.png)
 

### **Fase 3 - Ejecución de la app en un entorno Linux virtualizado**

Para la ejecución de la aplicación en un entorno virtualizado deberemos tener instalado Vagrant y VirtualBox. A continuación explicaremos los pasos a seguir:

- Lo primero es crear la máquina virtual, para ello desde una PowerShell de Windows iremos a la carpeta vagran donde se almacenarán las   máquinas virtuales y creamos una:

	   * mkdir -p ~/vagrant/scholarweb
	   * cd ~/vagrant/scholarweb
    
- Ahora pasamos a crear la maquina virtual de Linux de 64 bits

	   * vagrant init ubuntu/trusty64
    
- Una vez creada deberemos arrancarla. La primera vez que la arranquemos descargará toda la configuración del S.O, así que tardará un poco.

	   * vagrant up
    
- Ahora que la máquina está arrancada deberemos entrar en ella pero antes vamos a compiar tres ficheros en la carpeta ~/vagrant/scholarweb.

	   * Los ficheros que tenemos que copiar serán los .jar de nuestra app (generados anteriormente en STS con Run As > Maven build) y del  servicio interno, junto con el fichero .sql que hemos generado de nuestra base de datos en Windows:
    
		    * formularioUsuarios.sql
		    * ScholarWebPublic-0.0.1-SNAPSHOT.jar
      
- En esta misma carpeta modificamos el archivo Vagrantfile descomentando la siguiente línea:

	   * config.vm.network "private_network", ip: "192.168.33.10"
    
- Esto hará que nuestra máquina tenga esa ip y asi podamos conectarnos a ella por la web.

- Una vez que hemos copiado estos ficheros entramos en la máquina virtual

	   * vagrant ssh
    
- Ahora debemos descargar la versión de java 1.8 para poder ejecutar nuestra app. A nosotros no nos salia para isntalar la versión 8 de java, asi que hemso seguido el siguiente tutorial:

	   * https://ricondelzorro.wordpress.com/instalacion-de-java-y-netbeans/como-instalar-openjdk-8-en-ubuntu-14-04-14-10-y-15-04-lts-atravez-de-ppa/
    
- El siguiente paso es moverse a la carpeta /vagrant que es donde estan nuestro ficheros compartidos.

- Ahora debemos instalar mysql-server en nuestra máquina. Para ello ejecutaremos el siguiente comando:

	   *sudo apt-get install mysql-server
    
- Una vez se ha instalado el servidor de mysql (el cual nos ha pedido una contraseña para el usuario root [password:12345678]) vamos a crear nuestra base de datos:

	   * mysql -h localhost -u root -p (nos pedirá la contraseña: es la que hemos comentado al inicio de este paso)
	   * CREATE DATABASE scholarweb
    
- Ahora que tenemos la BBDD creada importaremos nuestra BBDD de Windows:

	   * mysql –u root -p scholarweb < formularioUsuarios.sql
    
- Ya tenemos nuestra BBDD con las tablas

- Por último ejecutamos los dos ficheros .jar que hemos nombrado anteriormente a la vez.

	   * java -jar scholarweb-0.0.1-SNAPSHOT.jar & java -jar ScholarWebPublic-0.0.1-SNAPSHOT.jar
    
- Ahora que tenemos tanto la web como el servicio interno corriendo vamos a probarlo desde nuestro navegador local.

	   * Escribimos https://192.168.33.10:8443 y nos debería aparecer nuestra página de ScholarWeb
	   
	  
###  DESARROLLO Y USO DEL SERVICIO INTERNO

El servicio interno va a consistir en el envio de un correo al gmail que se indique mediante dos acciones y propósitos distintos:
- Si el cliente se introduce en la ventana de "Contacto", deberá introducir los datos: Nombre, Correo, Teléfono y Cuerpo del mensaje. Al enviar el mensaje, lo recibirá, tanto el cliente que ha enviado el mensaje como el administrador de ScholarWeb en el correo "scholar.web.dad@gmail.com"
- Otra manera de recibir este correo es, una vez el administrador registra un nuevo usuario, este usuario recibirá como destinatario un correo dandole la bienvenido y mostrandole sus datos.

### SERVICIO MAIL / API REST
En la clase principal hemos creado dos clases donde, tienen la clase Mail con sus atributos(from, to, subject y body) y el de la otra clase, que es llamado en el controlador de contacto, donde te pide los atributos de la clase, se rellenan. Mediante la llamada "postForLocation" llamamos al metodo. 

	* private static final String RestService = "http://127.0.0.1:8070/send"; 
	
	  RestTemplate servInterno = new RestTemplate(); 
		   
	  String from = "scholar.web.dad@gmail.com"; // dirección de correo remitente -> usuario Administrador
	  String to = mail; // dirección del correo de destino -> nuevo usuario
	  String bodys = "Hola " + name + ", has sido contactado por la pag ScholarWeb facilitandonos el Telefono " + telefono + ", el Email: " +mail +"y el mensaje: " +body +" en breves le responderemos. \n Un saludo ScholarWeb.";
			
	* servInterno.postForLocation(RestService, new Mail(from,to,"conctato en pag ScholarWeb",bodys));

Luego en la aplicación del servicio interno tenemos la clase Mail con los mismo atributos de la clase principal. 

Al final para poder hacer las llamadas entre el servicio interno y la aplicacion principal, tenemos que añadir en el properties: 

	*APP INTERNA 
	server.port=8070
	spring.mail.host=smtp.gmail.com
	spring.mail.properties.mail.smtp.port=587
	
	*APP PRINCIPAL
	spring.mail.host=smtp.gmail.com
	spring.mail.port=587
	spring.mail.username= your mail
	spring.mail.password= your password
	spring.mail.properties.smtp.auth=true
	spring.mail.properties.smtp.starttls.enable=true
	

### SERVICIO PDF
Como servicio adicional, el cliente podrá descargar en la página principal una serie de PDF con información de la escuela. Esta acción la apodrá realizar cualquier cliente que acceda sin necesidad de encontrarse registrado.
En ciertos pdf se abrirá el mismo en otra ventana, mientras que en otros casos se descargará de manera automática.

Mantenemos este servicio en la clase principal donde lo tenemos distribuido en tres imagenes, donde cada imagen tiene su pdf. 

Hemos realizado un metodo para cada imagen/pdf donde hemos incluido un parametro nuevo en la cabecera 
	
	* @RequestParam(defaultValue="deportes.pdf")

donde dentro del método con tener la llamada a la creación de ese fichero.

	*File file = new File(EXTERNAL_FILE_PATH +"/"+ fileName);
		
### INFRAESTRUCTURA DOCKER.
![Untitled Diagram](https://user-images.githubusercontent.com/45795451/56870258-2e92c300-6a0d-11e9-9aaf-594e1a75dfb7.jpg)

### Video Explicativo de la funcionalidad de la web
https://www.youtube.com/watch?v=nWzAhFHLJws&feature=youtu.be


### **Equipo de desarrollo.**
  1. Jorge Alonso Vivar
  2. Laura Fernández García
  3. Belén Palazón Pacheco.
  
### **Gestión de Proyecto en Trello.**
- https://trello.com/b/EJT4Gd68/scholarweb


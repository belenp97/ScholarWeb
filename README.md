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
![uml](https://user-images.githubusercontent.com/45795451/52914858-a3d76e80-32cd-11e9-955a-c76f15ee7a04.png)

- Rectángulo azul: entidades.
- Rectángulo rojo: Repository de cada entidad.
- Rectángulo verder: Controller de cada entidad.

### **DIAGRAMA ENTIDAD-RELACIÓN.**
![entidad-relacion](https://user-images.githubusercontent.com/45795451/52915678-46e0b600-32d7-11e9-991f-d7332c5f59b0.png)

### **MODELO DE NAVEGACIÓN.**
![diagrama_navegacion](https://user-images.githubusercontent.com/45795451/53003749-faf55480-342f-11e9-8472-b8a12ec56b38.png)

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


### **Equipo de desarrollo.**
  1. Jorge Alonso Vivar
  2. Laura Fernández García
  3. Belén Palazón Pacheco.
  
### **Gestión de Proyecto en Trello.**
- https://trello.com/b/EJT4Gd68/scholarweb


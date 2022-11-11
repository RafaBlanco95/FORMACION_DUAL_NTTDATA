[NTT Data] [FP-Dual 2021-2023][2º Curso]

Proyecto del Taller Práctico GUIADO de Apache Tomcat

**Enunciado del Taller

-Crear, en Eclipse, un nuevo proyecto web del tipo ‘Dynamic Web Project’ con el nombre ‘nttdata-apacheTomcat’

-Pulsar ‘Next’ dos veces hasta alcanzar la pantalla en la que pueda ser marcada la opción ‘Generate web.xml deployment descriptor’

-Pulsar ‘Finish’

-En el directorio del proyecto ‘WebContent’ o ‘WebApp’ crear un nuevo fichero con el nombre ‘index.html’

-Visualizar el fichero ‘WebContent/web.xml’

-En la vista ‘Servers’ sobre el servidor local creado se hará click derecho y se pulsará la opción ‘Add and remove…’

-Se añadirá el proyecto creado al servidor. Pulsar sobre ‘Finish’

-En la vista ‘Servers’ sobre el servidor local creado se hará click derecho y se pulsará la opción ‘Start’

-Si todo va correctamente el servidor quedará arrancado y el proyecto desplegado

-Acceder, mediante el navegador, a la URL

-En el directorio ‘/src/’ crear un nuevo paquete Java llamado ‘com.nttdata.tomcat’ dentro del cual se creará un nuevo servlet llamado ‘NTTDataServlet’.

-Del nuevo servlet solo se configurará la primera pantalla y se pulsará ‘Finish’ dejando el resto de opciones por defecto.

-Editar la clase ‘NTTDataServlet’ para modificar el mensaje de respuesta ante una petición del tipo GET.

-Editar la clase ‘NTTDataServlet’ para modificar el mensaje de respuesta ante una petición del tipo POST.

-Con el servidor arrancado, acceder, mediante el navegador, a la URL

-Crear en el directorio ‘WebContent’ o ‘WebApp’ un nuevo fichero JSP con nombre ‘nttdataJSP’.

-Modificar el fichero creado para añadir un saludo en el cuerpo del HTML.

-Añadido el saludo al fichero ‘nttdataJSP’ se arrancará nuevamente el servidor para acceder a la URL:

-En el paquete ‘com.nttdata.tomcat’ crear la clase ‘NTTDataJSP’.

-Crear el método estático ‘helloNTTData’ que retorne una cadena de texto (String) y reciba como parámetro un nombre. 

-Modificar el fichero ‘nttdataJSP.jsp’ para añadir la importación de la clase Java creada y la invocación al método ‘helloNTTData’ de la misma


**Resolución del Taller

Se ha creado un proyecto java en el que se han cumplido los requisitos del enunciado, aplicando las tecnologías:


-APACHE TOMCAT
-JSP

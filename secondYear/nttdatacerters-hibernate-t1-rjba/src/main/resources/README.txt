[NTT Data] [FP-Dual 2021-2023][2º Curso]

Proyecto del Taller Práctico 1 de HIBERNATE

**Enunciado del Taller

-Elaborar un nuevo proyecto web en base a las siguientes indicaciones:

-El modelo de datos estará representado por una sola tabla (Cliente) cuyos atributos serán identificador numérico, nombre, primer apellido, segundo apellido, y número de documento de identidad (único, no nulo y hasta 9 caracteres). 

-Se requiere la implementación del patrón DAO. El patrón DAO definirá los métodos CRUD (insertar, consultar todos, consultar por ID, eliminar, actualizar) para la entidad. Además, la entidad Cliente contará con un método de búsqueda por nombres y apellidos.

-Se creará un servicio de gestión de Clientes que consuma el DAO correspondiente. Desde la clase principal se consumirá el servicio haciendo uso de todos los métodos creados.

-El mapeo de Hibernate se ha de realizar mediante anotaciones JPA. La configuración se realizará en el fichero hibernate.cfg.xml en caso de no utilizar Spring Boot (que pasaría a ser application.properties).
 
**Resolución del Taller

Se ha creado un proyecto java en el que se han cumplido los requisitos del enunciado, aplicando las tecnologías:

-APACHE MAVEN
-LOGBACK
-HIBERNATE 
-JPA

Para la resolución del taller se ha utilizado el patrón DAO, usando clases genéricas [CommonDaoI, CommonDaoImpl, AbstractEntity] para aportar escalabilidad al proyecto, ya que en este taller únicamente se trabaja con una entidad, pero será utilizado como base para los próximos talleres de esta tecnología, en los que serán necesarias estas clases genéricas 
Para más información consultar los comentarios del código de cada una de las clases 
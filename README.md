# Slick-MySql
=============

MySQL Schema export for Scala and Slick.

### Motivations

TypeSafe Slick is a fantastic Object-Relational Mapping (ORM) tool, and the upcoming version (3.0) contains its 
own JDBC/MySQL export tool for export existing MySQL schemas (and generating Scala code!). However, the current 
stable version, 2.1.x does not. So, until 3.0 is released in stable form, this project will fill that void.

<a name="build-requirements"></a>
### Build Requirements

* [Java SDK 1.7] (http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)
* [Scala 2.11.6] (http://scala-lang.org/download/)
* [SBT 0.13+] (http://www.scala-sbt.org/download.html)
* [Commons-Helpers 0.1.0] (https://github.com/ldaniels528/commons-helpers)

<a name="building-the-code"></a>
### Building the code

    $ sbt clean assembly
    
<a name="configuring-the-app"></a>
### Configuring the utility

Slick-MySQL uses a properties file to provide the JDBC connection information required for connecting to a MySQL server:

```
    catalog = databaseName
    url = jdbc:mysql://server/databaseName
    driver = com.mysql.jdbc.Driver
    user = root
    password = <root-password>  
```
 
### Running the utility

The utility requires two parameters, the configuration path (e.g. `configPath`) and the output path (e.g. `outputPath`)

    $ java -jar slick-mysql_0.1.bin.jar <configPath> <outputPath>
    
Here's an example:
    
    $ java -jar slick-mysql_0.1.bin.jar connection.properties ./src/main/scala




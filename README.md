# JPA + Hibernate - Sistema de Facturación

<p align="center">
  <img src="./images/logo-utn.png" alt="UTN" width="180">
</p>

![Java](https://img.shields.io/badge/Java-26-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![JPA](https://img.shields.io/badge/JPA-2.2-59666C?style=for-the-badge)
![Hibernate](https://img.shields.io/badge/Hibernate-5.6-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-9.4.0-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![PHP](https://img.shields.io/badge/PHP-8%2B-777BB4?style=for-the-badge&logo=php&logoColor=white)
![Nginx](https://img.shields.io/badge/Nginx-009639?style=for-the-badge&logo=nginx&logoColor=white)

Proyecto académico desarrollado para la materia **Desarrollo de Software** de la carrera **Ingeniería en Sistemas**.

El proyecto implementa un modelo de facturación utilizando **Java, JPA y Hibernate**, con persistencia de datos en **MySQL**. La base de datos puede ser administrada mediante **phpMyAdmin**, herramienta desarrollada sobre PHP, y el entorno de trabajo incluye **Nginx**.

---

## Tecnologías utilizadas

- **Java 26** — Lenguaje principal del proyecto.
- **JPA 2.2** — API utilizada para el mapeo objeto-relacional.
- **Hibernate 5.6** — Framework ORM utilizado como implementación de JPA.
- **MySQL** — Sistema gestor de base de datos.
- **Maven** — Gestión de dependencias y construcción del proyecto.
- **PHP** — Tecnología utilizada por herramientas de administración como phpMyAdmin.
- **phpMyAdmin** — Administración y visualización de la base de datos.
- **Nginx** — Servidor web utilizado dentro del entorno de trabajo.
- **IntelliJ IDEA** — Entorno de desarrollo.
- **Git / GitHub** — Control de versiones y almacenamiento del proyecto.

---

## Arquitectura

El proyecto utiliza una arquitectura basada en **JPA/Hibernate**, donde las clases Java del dominio se encuentran relacionadas con tablas de la base de datos.

El flujo principal de persistencia es:

```text
Java
  │
  ▼
JPA
  │
  ▼
Hibernate
  │
  ▼
MySQL
  │
  ▼
Base de datos Facturación
```

La configuración de la persistencia se encuentra en:

```text
src/main/resources/META-INF/persistence.xml
```

En este archivo se configura la unidad de persistencia, el driver de MySQL, la conexión a la base de datos y las propiedades de Hibernate.

---

## Modelo de datos

El proyecto trabaja con distintas entidades relacionadas con el proceso de facturación.

Entre las principales se encuentran:

- **Usuario**
- **Cliente**
- **Contacto**
- **Domicilio**
- **Articulo**
- **ListaPrecio**
- **ListaPrecioArticulo**
- **CondicionIva**
- **TipoMoneda**
- **PuntoVenta**
- **FacturaVenta**
- **FacturaVentaDetalle**

Las entidades se encuentran mapeadas mediante anotaciones de **JPA** y representan los distintos componentes del sistema de facturación.

---

## Persistencia con JPA

La aplicación utiliza `EntityManager` para realizar las operaciones de persistencia sobre la base de datos.

El flujo principal consiste en:

1. Crear el `EntityManagerFactory`.
2. Crear un `EntityManager`.
3. Iniciar una transacción.
4. Crear las entidades.
5. Establecer las relaciones entre las entidades.
6. Persistir los datos.
7. Confirmar la transacción.
8. Cerrar los recursos.

Ejemplo:

```java
EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("FacturacionPU");

EntityManager em = emf.createEntityManager();

em.getTransaction().begin();

// Creación y persistencia de entidades

em.getTransaction().commit();

em.close();
emf.close();
```

---

## Relaciones entre entidades

Las principales relaciones del modelo pueden representarse de la siguiente manera:

```text
Cliente
 ├── Contacto
 └── Domicilio

ListaPrecio
 └── ListaPrecioArticulo
       └── Articulo

FacturaVenta
 ├── Cliente
 ├── CondicionIva
 ├── TipoMoneda
 ├── PuntoVenta
 └── FacturaVentaDetalle
        └── ListaPrecioArticulo
```

La relación entre `FacturaVenta` y `FacturaVentaDetalle` se implementa de forma bidireccional.

---

## Estructura del proyecto

```text
jpa_grupal/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── org/
│       │       └── example/
│       │           └── jpa_grupal/
│       │               ├── Main.java
│       │               │
│       │               └── model/
│       │                   ├── Articulo.java
│       │                   ├── Cliente.java
│       │                   ├── CondicionIva.java
│       │                   ├── Contacto.java
│       │                   ├── Domicilio.java
│       │                   ├── FacturaVenta.java
│       │                   ├── FacturaVentaDetalle.java
│       │                   ├── ListaPrecio.java
│       │                   ├── ListaPrecioArticulo.java
│       │                   ├── PuntoVenta.java
│       │                   ├── TipoMoneda.java
│       │                   └── Usuario.java
│       │
│       └── resources/
│           └── META-INF/
│               └── persistence.xml
│
├── .gitignore
├── pom.xml
└── README.md
```

---

## Instalación y configuración

### Requisitos

Para ejecutar el proyecto se necesita contar con:

- **Java 26**
- **Maven**
- **MySQL**
- **phpMyAdmin**
- **PHP**
- **Nginx**
- **IntelliJ IDEA** u otro IDE compatible con Maven

---

### 1. Clonar el repositorio

```bash
git clone git@github.com:AlejoPavon/jpa-grupal.git
cd jpa_grupal
```

---

### 2. Crear la base de datos

Crear una base de datos llamada:

```text
facturacion
```

Desde MySQL:

```sql
CREATE DATABASE facturacion;
```

También puede crearse y administrarse utilizando **phpMyAdmin**.

---

### 3. Configurar la conexión

Abrir:

```text
src/main/resources/META-INF/persistence.xml
```

Verificar los datos de conexión:

```xml
<property name="javax.persistence.jdbc.url"
          value="jdbc:mysql://localhost:3306/facturacion?useSSL=false&amp;serverTimezone=UTC"/>

<property name="javax.persistence.jdbc.user"
          value="root"/>

<property name="javax.persistence.jdbc.password"
          value="TU_PASSWORD_MYSQL"/>
```

Reemplazar `TU_PASSWORD_MYSQL` por la contraseña correspondiente al usuario local de MySQL.

### 4. Descargar las dependencias

Desde la carpeta raíz del proyecto ejecutar:

```bash
mvn clean install
```

Maven descargará automáticamente las dependencias definidas en `pom.xml`.

---

### 5. Ejecutar el proyecto

Ejecutar la clase:

```text
src/main/java/org/example/jpa_grupal/Main.java
```

La aplicación iniciará la unidad de persistencia y realizará las operaciones definidas en `Main`.

Hibernate se encargará de generar y actualizar las tablas correspondientes según las entidades y la configuración:

```xml
<property name="hibernate.hbm2ddl.auto"
          value="update"/>
```

---

## Dependencias principales

Las principales dependencias utilizadas se encuentran en `pom.xml`:

```xml
<dependency>
    <groupId>javax.persistence</groupId>
    <artifactId>javax.persistence-api</artifactId>
    <version>2.2</version>
</dependency>

<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>5.6.15.Final</version>
</dependency>

<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>9.4.0</version>
</dependency>
```

---

## Funcionamiento

Al ejecutar `Main`, el sistema:

1. Inicializa la unidad de persistencia `FacturacionPU`.
2. Establece la conexión con MySQL.
3. Inicia una transacción.
4. Crea las entidades necesarias.
5. Establece las relaciones entre ellas.
6. Persiste los datos mediante `EntityManager`.
7. Confirma la transacción.
8. Cierra los recursos.

Hibernate genera las sentencias SQL correspondientes y permite verificar las operaciones realizadas sobre la base de datos.

---

## Materia

**Desarrollo de Software**  
**Ingeniería en Sistemas**

Proyecto práctico grupal sobre **ORM, JPA y Hibernate**.

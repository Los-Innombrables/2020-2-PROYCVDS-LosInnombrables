# Historial de Equipos 🚀
## 2020-2-PROYCVDS-LosInnombrables
## Roles ✒️
>*Oscar David Ospina Rodriguez* : Dueño del Producto
>
>*Daniel Felipe Rincon Muñoz* : Team Developer
>
>*Guillermo Alfonso Castro Camelo* : Team Developer
>
>*Andrés Mateo Calderón Ortega* : Team Developer
## Descripción del producto 📄
_La plataforma Historial de Equipos, es una herramienta donde los profesores y monitores encargados de la adminsitración de los equipos de la Facultad de Ingenieria De Sistemas de la Escuela Colombiana de Ingenieria Julio Garavito podrán Administrar, Consultar y Generar reportes de los equipos presentes en el laboratorio, además de las partes de cada uno de ellos y de las salas informáticas en las cuales estos son utilizados y guardados, esta plataforma cuenta con un sistema de autentificación avanazado que permitirá mantener la integridad tanto de los usuarios que ingresen como de la información que allí se maneje._
## Manual De usuario 📖
> 
## Funcionalidades Principales
>
# Arquitectura y Diseño 🔧
## Modelo E-R
![](/resources/DiagramaEntidadRelacion.png)
## Diagrama de clases
![](/resources/DiagramaClases.png)
## Capas 🛠️
_La aplicación está construida en 3 capas: Aplicación, Presentación y Persistencia._
### Capa Aplicación
_Realizamos la intermediacion entre las capas de Presentación y Persistencia, mediante el uso principal de Java, y frameworks como Google Guice que fue utilizado para realizar la inyeccion de dependencias para mantener un patron Fabrica estable y un acoplamiento de codigo bajo._
### Capa Presentación
_Contiene principalmente tecnologia de jsf(PrimeFaces) para facilitar la conexion con los beans manejados en la capa de Aplicación, adicionalmente esta capa está principalmente escrita en xhtml, css y JavaScript para brindar paginas web dinámicas e intuitivas para el usuario._
### Capa Persistencia
_Se manejo en la base de datos de heroku que utiliza un motor PostgreSQL, adicionalmente se utilizo el framework myBatis el cual fue el encargado de realizar el mapeo y las sentencias SQL a partir de ficheros .xml_

---
| Tecnologías Utilizadas 💻 |
| :--: |
|Primefaces|
|Mojarra|
|Google Guice|
|Java|
|PostgreSQL|
|XHTML|
|CSS|
|JavaScript|
## HerokuApp ☁️
[![Deployed to Heroku](https://www.herokucdn.com/deploy/button.png)](https://historial-de-equipos.herokuapp.com/)
## CircleCI ✔️
[![CircleCI](https://circleci.com/gh/Los-Innombrables/2020-2-PROYCVDS-LosInnombrables.svg?style=svg)](https://app.circleci.com/pipelines/github/Los-Innombrables/2020-2-PROYCVDS-LosInnombrables)
# Descripción del proceso ⚙️
## Integrantes 💪🏻:
 - Daniel Felipe Rincon Muñoz
 - Guillermo Alfonso Castro Camelo
 - Andrés Mateo Calderón Ortega
## Metodología 🙌🏼:
_Se trabajó mediante la metodología ágil de: **Scrum**, que es un proceso en el que se aplican de manera regular un conjunto de buenas prácticas para trabajar colaborativamente, en equipo, y obtener el mejor resultado posible de un proyecto. Se hicieron 3 sprints, de los cuales cada uno tuvo una duración de 2 semanas._
## Taiga 🎤:
[![Taiga Backlog](https://images.assets-landingi.com/jvS0A3Tm24feIBqs/logo_horizontal.png)](https://tree.taiga.io/project/candres1019-historial-de-equipos-labinfo/backlog)
## Release-Burndown Chart:
### Sprint1:
![](/resources/Sprint1.PNG)
### Sprint2:
![](/resources/Sprint2.PNG)
### Sprint3:
![](/resources/Sprint3.PNG)
## Reporte De Pruebas:
![](/resources/Test.PNG)
## Codacy
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/6ae092aed25d47a897b7ee6d26ff857f)](https://www.codacy.com/gh/Los-Innombrables/2020-2-PROYCVDS-LosInnombrables/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Los-Innombrables/2020-2-PROYCVDS-LosInnombrables&amp;utm_campaign=Badge_Grade)

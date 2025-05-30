EventMasterPro 

EventMasterPro es una aplicación de consola desarrollada en Java para para la administración completa de acontecimientos culturales o musicales. Facilita la gestión de eventos, recintos, artistas, boletos, participación y finanzas.

Funcionalidades principales

-  Crear y listar eventos
-  Gestionar recintos con fechas y características técnicas
-  Registrar y visualizar artistas con requerimientos técnicos
-  Crear y vender entradas
-  Control de acceso de asistentes
-  Registro financiero por evento
-  Estadísticas de asistencia

Estructura del Proyecto

El sistema sigue un enfoque orientado a objetos (POO), organizado en clases como:

- `EventeMasterProMedellin` – clase principal con el menú de opciones
- `Event` – define eventos con fecha, hora y categoría
- `Artist` – modela artistas con historial y requerimientos
- `Venue` – gestiona recintos y fechas disponibles
- `Ticket` – entradas con estado de venta y validación
- `AccessControl` – registro y validación de asistentes
- `FinancialRecord` – control de ingresos, gastos y balance


Tecnologías utilizadas

- Java 8 o superior
- Apache NetBeans IDE
- Librerías estándar (`java.util`, `java.time`)


Requisitos

- JDK 8+
- NetBeans
- Consola para entrada/salida estándar






# Converso-de-Moneda-ExchangeRate-API-en-Java

**Descripción:**

Esta aplicación de consola en Java está diseñada para convertir diferentes tipos de divisas. Utiliza una API externa para obtener las tasas de cambio actualizadas y permite al usuario seleccionar la divisa de origen y destino, así como el monto a convertir.

**Tecnologías Utilizadas:**

* **Java:** Lenguaje de programación principal.
* **API de Tasa de Cambio:** Se utiliza una API externa (especifica la API que estás usando) para obtener las tasas de cambio en tiempo real.
* **Maven/Gradle:** Gestor de dependencias (elige el que estés usando).
* **Docker:** Para crear un entorno de ejecución consistente y portable.

**Cómo Usar:**
1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/DaveSV/Converso-de-Moneda-ExchangeRate-API-en-Java.git
   ```
2. **Compilar la aplicación:**
```bash
cd conversor-de-divisas
# Comando de compilación según gestor de dependencias (mvn compile)
```
3. **Ejecutar la aplicación:**
```bash
# Comando de ejecución según gestor de dependencias (mvn exec:java)
```
Seguir las instrucciones en pantalla: La aplicación te guiará a través del proceso de conversión, solicitando la divisa de origen, la divisa de destino y el monto.
Estructura del Proyecto:

src: Contiene el código fuente de la aplicación.
pom.xml/build.gradle: Archivo de configuración del gestor de dependencias.
Dockerfile: (Si estás usando Docker) Define cómo construir la imagen Docker.
README.md: Este archivo.
Contribuciones:

Las contribuciones son bienvenidas. Si encuentras algún error o deseas agregar nuevas funcionalidades, por favor, crea un issue o un pull request.

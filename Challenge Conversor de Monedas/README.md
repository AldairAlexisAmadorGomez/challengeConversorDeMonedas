# Challenge Conversor de Monedas

## Descripción

El proyecto **Challenge Conversor de Monedas** es una aplicación que permite a los usuarios convertir entre diferentes monedas utilizando tasas de cambio actualizadas desde una API. La aplicación toma las tasas de cambio desde [ExchangeRate-API](https://v6.exchangerate-api.com), filtra las monedas disponibles y presenta los resultados en un formato legible, además de guardar los resultados en un archivo JSON.

## Características

- Obtiene tasas de cambio actualizadas desde la API de [ExchangeRate-API](https://v6.exchangerate-api.com).
- Filtra y muestra las monedas disponibles para la conversión.
- Permite al usuario ingresar múltiples monedas a convertir en un formato sencillo y accesible.
- Guarda los resultados de la conversión en un archivo JSON con una estructura clara y ordenada.
- Maneja errores para asegurar que todas las monedas ingresadas sean válidas y compatibles con las tasas de cambio.
- Proporciona una interfaz sencilla para ingresar las monedas de origen y destino.
- Soporta la conversión de diferentes cantidades y monedas simultáneamente.

## Menú de Conversión

El programa presenta un menú interactivo que permite al usuario seleccionar la conversión que desea realizar. Las opciones disponibles son:

1. **Peso argentino (ARS) a Dólar (USD)**
2. **Dólar (USD) a Peso argentino (ARS)**
3. **Real brasileño (BRL) a Dólar (USD)**
4. **Dólar (USD) a Real brasileño (BRL)**
5. **Peso colombiano (COP) a Dólar (USD)**
6. **Dólar (USD) a Peso colombiano (COP)**
7. **Salir**

### Flujo del Menú:

- **Opción 1**: Convierte de **Peso argentino (ARS)** a **Dólar (USD)**.
- **Opción 2**: Convierte de **Dólar (USD)** a **Peso argentino (ARS)**.
- **Opción 3**: Convierte de **Real brasileño (BRL)** a **Dólar (USD)**.
- **Opción 4**: Convierte de **Dólar (USD)** a **Real brasileño (BRL)**.
- **Opción 5**: Convierte de **Peso colombiano (COP)** a **Dólar (USD)**.
- **Opción 6**: Convierte de **Dólar (USD)** a **Peso colombiano (COP)**.
- **Opción 7**: Salir del programa.

### Cómo funciona:

1. **Selección de Opción**: El programa muestra el menú y espera que el usuario ingrese un número entre 1 y 7.
2. **Conversión**: Dependiendo de la opción seleccionada, el programa realiza la conversión de la moneda indicada, pidiendo al usuario que ingrese la cantidad de la moneda de origen.
3. **Cálculo y Resultados**: La aplicación calcula el monto equivalente usando las tasas de cambio obtenidas de la API y muestra el resultado al usuario.
4. **Repetir o Salir**: Después de cada conversión, el menú se vuelve a mostrar para permitir que el usuario realice más conversiones o salga del programa.

## Tecnologías Utilizadas

- **Java**: Lenguaje principal de desarrollo.
- **Maven**: Herramienta de construcción y gestión de dependencias.
- **Gson**: Biblioteca para el manejo y serialización de datos en formato JSON.
- **HttpClient** y **HttpResponse**: Para realizar solicitudes HTTP y obtener datos de la API.
- **API de ExchangeRate**: Fuente de las tasas de cambio actualizadas para realizar las conversiones.

## Instalación

1. Clona el repositorio en tu máquina local:
    ```bash
    git clone <url_del_repositorio>
    ```

2. Navega al directorio del proyecto:
    ```bash
    cd ChallengeConversorDeMonedas
    ```

3. Compila y ejecuta el proyecto con Maven:
    ```bash
    mvn clean install
    mvn exec:java
    ```

4. Se generará un archivo `conversion_result.json` con los resultados de la conversión de monedas.

## Contribución

1. Haz un fork del proyecto.
2. Crea una rama para tus cambios (`git checkout -b feature/nueva-caracteristica`).
3. Realiza tus cambios y haz commit (`git commit -am 'Agrega nueva característica'`).
4. Empuja a la rama (`git push origin feature/nueva-caracteristica`).
5. Abre un Pull Request.

## Licencia

Este proyecto está licenciado bajo la MIT License.

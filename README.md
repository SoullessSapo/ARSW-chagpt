
# 🤖 ChatGPT Spring Boot API

Este proyecto es una API REST construida con **Spring Boot** que permite enviar mensajes a la API de **OpenAI ChatGPT** y recibir respuestas en formato JSON. Su estructura está diseñada para ser modular, extensible y fácil de mantener gracias a la implementación de **patrones de diseño de software clásicos**.

---

## 🧠 ¿Cómo funciona el código?

### 🏁 Flujo general

1. El usuario hace un `POST` a `/chat` con un `prompt`.
2. El controlador (`ChatController`) recibe el JSON.
3. Se delega a un servicio (`ChatService`) que usa un `ChatStrategy` para obtener la respuesta.
4. `ChatGPTStrategy` construye la solicitud y la envía usando `ChatClientFacade`.
5. Se obtiene la respuesta desde la API de OpenAI y se devuelve al cliente.

---

## 🗂️ Paquetes y responsabilidades

| Paquete            | Propósito                                      |
|--------------------|------------------------------------------------|
| `controller`        | Maneja las solicitudes HTTP                   |
| `dto`              | Define objetos para entrada/salida JSON        |
| `service`          | Contiene lógica de negocio, estrategias y cliente |
| `config` (opcional)| Carga de variables o configuración (por `.env`) |

---

## 🧩 Clases principales

### `ChatController.java`
Controlador REST que expone el endpoint `/chat` y delega la lógica al servicio.

### `ChatService.java`
Clase principal de negocio que utiliza una estrategia (`ChatStrategy`) para obtener la respuesta al prompt.

### `ChatStrategy.java`
Interfaz que define cómo debe comportarse cualquier proveedor de IA (OpenAI, etc.).

### `ChatGPTStrategy.java`
Implementación concreta de `ChatStrategy` que usa la API oficial de OpenAI para responder.

### `ChatClientFacade.java`
Clase auxiliar que encapsula toda la lógica HTTP para comunicarse con OpenAI.

---

## 📥 Ejemplo de uso

### Solicitud

```json
POST /chat
{
  "prompt": "¿Cuál es la capital de Japón?"
}
```

### Respuesta

```json
{
  "response": "La capital de Japón es Tokio."
}
```

---

## 🧠 Patrones de diseño aplicados

Este proyecto mejora la arquitectura de una API básica utilizando **patrones de diseño orientados a objetos**, cumpliendo la consigna de modularizar y extender un servicio de ChatGPT.

### 1. Strategy Pattern

**Propósito:** Permitir intercambiar fácilmente el proveedor de respuestas (ChatGPT, Claude, etc.)

- `ChatStrategy` es una interfaz genérica.
- `ChatGPTStrategy` es una implementación concreta que usa OpenAI.
- `ChatService` no sabe quién responde, solo que puede pedir una respuesta.

➡ Esto permite reemplazar el modelo fácilmente, sin modificar otras capas.

---

### 2. Facade Pattern

**Propósito:** Ocultar la complejidad de las llamadas HTTP y la manipulación de JSON.

- `ChatClientFacade` encapsula:
  - La construcción del JSON.
  - La conexión HTTP a OpenAI.
  - El parseo de la respuesta.
  - La lectura de la API Key desde variables de entorno.

➡ Esto simplifica el uso desde otras clases y centraliza la lógica de red.

---

### 3. DTO Pattern

**Propósito:** Estandarizar el formato de entrada y salida de la API REST.

- `ChatRequest`: contiene el `prompt` enviado por el cliente.
- `ChatResponse`: contiene la `response` que se devuelve al cliente.

➡ Facilita el mantenimiento de la API y separa los datos de transporte de la lógica.

---

### 4. (Extensión posible) Decorator Pattern

Podrías envolver cualquier `ChatStrategy` con un `LoggingDecorator` para agregar logging sin alterar la clase base.

➡ Ideal para agregar métricas o control de errores sin modificar `ChatGPTStrategy`.

---

## 🎯 Conclusión

Este proyecto demuestra cómo aplicar patrones de diseño para convertir un simple cliente de la API de ChatGPT en una arquitectura robusta, limpia y lista para ser extendida o modificada sin impacto en otras partes del sistema.

---

## 🛠️ Requisitos para ejecutar

- Java 17+
- Maven
- Variable de entorno `OPENAI_API_KEY` definida

---

## 👨‍💻 Autor

Desarrollado por **Esteban Valencia Caicedo**

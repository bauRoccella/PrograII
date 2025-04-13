# Sistema de Gestión para un Cine

El contenido del repositorio simula un sistema de gestión de cine. Esta hecho en IntelliJ así que podria tener problemas con Eclipse.  
El sistema permite gestionar salas, funciones, tickets y otros aspectos relacionados con la operación diaria de un cine. La clase cine dirije el flujo de la aplicación.

TODO:
- Esta en espanglish, habria que dejarlo en un idioma o el otro. Inglés es la convención pero tampoco se les va a evaluar en ingles.

---

## Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes principales:

- **`org.example.model`**  
  Contiene las clases del modelo principal:
  - `Room`: representa una sala del cine.
  - `Function`: representa una proyección de película.
  - `Ticket`: representa una entrada.
  - `Theatre`: representa el cine completo ([singleton](https://refactoring.guru/es/design-patterns/singleton)).

- **`org.example.tda.colas`**  
  La implementación original traba estrictamente con números enteros (`ColaFunctions`). La implementación la modifique para que tome otros tipos de dato.

- **`org.example.tda.conjuntos`**  
  Lo mismo ocurre con (`ConjuntoTicket`)
---

## Funcionalidades Principales

### 1. Gestión de Salas (`Room`)
Cada sala tiene:
- Un número identificador único.
- Una capacidad fija.
- Una cola de funciones (películas programadas).

**Operaciones disponibles:**
- Agregar nuevas funciones a la sala.
- Remover funciones (cuando finalizan).
- Mostrar la película que se está proyectando actualmente.

---

### 2. Gestión de Funciones (`Function`)
Cada función representa una película y contiene:
- Título de la película.
- Tipo de idioma (doblada o subtitulada). **ATENCIÓN:** El tipo de dato que yo use es un 'enum' si no lo conocen o no les gusta pueden usar strings en casos parecidos.
- Si es en 3D o no.
- Hora de inicio.
- Un conjunto de tickets asociados.

---

### 3. Gestión de Tickets (`Ticket`)
Cada ticket contiene:
- Un identificador único.
- Número de asiento.
- Sala y hora de función.
- Estado de uso (usado o no).

**Gestión:**
- Los tickets usados se almacenan en un `ConjuntoTicket` dentro de la función correspondiente.

---

### 4. Teatro (`Theatre`)
El cine completo se representa mediante un singleton que:
- Contiene un conjunto fijo de salas.
- Permite agregar funciones a una sala específica.
- Actúa como punto de entrada para la gestión del cine.
- Tiene lugar para hacer uso de más funciones que podrian agregarse a futuro ya que las otras implementaciones lo soportan.

---

- **Lenguaje:** Java  
- **Gestión de dependencias y build:** Maven  
- **IDE recomendada:** IntelliJ IDEA  
- **Paradigmas aplicados:** Programación Orientada a Objetos, Estructuras de Datos Personalizadas. No respeta arquitecturas estrcitamente para no salir del temario o confundir.

---

## Cómo Ejecutar el Proyecto

1. Cloná este repositorio:
   ```bash
   git clone https://github.com/bauRoccella/PrograII.git

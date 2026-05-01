# SimuladorBancario
Simulador de Cola de Atención al Cliente para una sucursal bancaria, aplicando los conceptos de Pilas y Colas implementados desde cero con nodos y punteros en Java
-----------------------------------------------
## Estructura del simulador
```text
SimuladorBancario/
│
├── src/                          # Carpeta de código fuente
│   └── com/
│       └── banco/
│           ├── modelos/          # Clases de datos 
│           │   ├── Cliente.java
│           │   └── Nodo.java
│           │
│           ├── estructuras/      # Implementaciones de cola y pila
│           │   ├── Cola.java
│           │   └── Pila.java
│           │
│           └── principal/        # Main y menu
│               └── SimuladorBancario.java
│
├── data/                         # Carpeta para archivos externos
│   └── clientes.txt              # El archivo de texto con clientes existentes
|   └── manuales.txt              # El archivo de texto con clientes cargados manualmente
│
└── README.md                     # Documentación del proyecto
```

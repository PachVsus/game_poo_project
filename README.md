# 8 Bit Legend's

**8 Bit Legend's** es un videojuego en 2D desarrollado en Java, diseñado como proyecto académico para demostrar la aplicación de principios fundamentales de programación orientada a objetos, manejo de hilos y gráficos mediante la biblioteca `Swing`.

## 🎮 Descripción

El juego presenta una estructura basada en tiles de 16x16 píxeles escalados, con una resolución de pantalla fija. La lógica del juego se maneja mediante un ciclo principal implementado con hilos, lo cual permite gestionar la actualización y el renderizado de forma eficiente.

## 🛠️ Tecnologías Utilizadas

- Java SE 8+
- Swing (para la interfaz gráfica)
- Hilos (implementación con `Runnable`)
- VS Code (como entorno de desarrollo)
- Sistema de tiles para diseño gráfico 2D


## 🚀 Cómo Ejecutar

1. Clona el repositorio o descarga el proyecto.
2. Abre el proyecto en VS Code o tu IDE de preferencia.
3. Asegúrate de tener Java instalado y configurado correctamente.
4. Ejecuta el archivo `MainClass.java`.

```bash
javac src/App.java src/main/*.java -d bin
java -cp bin main.MainClass

Esta tarea fue programada en la version 17.0.4 de java para ubuntu (wsl)

Datos extra de la version de Java:
    openjdk 17.0.4 2022-07-19
    OpenJDK Runtime Environment (build 17.0.4+8-Ubuntu-120.04)
    OpenJDK 64-Bit Server VM (build 17.0.4+8-Ubuntu-120.04, mixed mode, sharing)

Datos extra de la version de javac:
    javac 17.0.4

Para ejecutar el programa hay que introducir el comando "make" en la consola bash ubicada en el directorio con todos los archivos.

El metodo de nextInt() de la libreria Java.util.Random necesita la version de CLDC 1.1 o mayor. Si el programa no compila por el error "method random.nextint() is not applicable" es por eso.

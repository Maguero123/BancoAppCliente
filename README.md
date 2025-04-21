# BancoAppCliente

Aplicación bancaria de escritorio diseñada para el cliente final. Permite registrarse, iniciar sesión y operar con una cuenta bancaria de manera simple y visual.

## Funcionalidades

- Registro de nuevos clientes (nombre, DNI, dirección, fecha de nacimiento, etc.)
- Inicio de sesión con correo electrónico y contraseña
- Visualización de saldo y CBU
- Depósitos, extracciones y transferencias
- Registro automático de todos los movimientos
- Interfaz moderna y amigable

## Tecnologías usadas

- Java 17
- JavaFX 21
- Maven
- IntelliJ IDEA

## Estructura del proyecto

com.banco.app 
├── Main.java 
├── model 
│ ├── Usuario.java 
│ ├── Cliente.java 
│ ├── Cuenta.java 
│ └── Movimiento.java 
├── ui │ 
├── VentanaInicio.java 
│ ├── VentanaRegistro.java 
│ ├── VentanaLogin.java 
│ ├── VentanaPrincipal.java 
│ ├── VentanaCuenta.java 
│ ├── VentanaMovimientos.java 
│ ├── VentanaDepositar.java 
│ ├── VentanaExtraer.java 
│ └── VentanaTransferir.java 
├── util 
│ ├── GeneradorCBU.java 
│ └── FechaUtils.java

## Cómo ejecutar

1. Clonar el repositorio
2. Asegurarse de tener JavaFX instalado y configurado
3. Ejecutar la clase `Main.java`
4. Crear una cuenta o iniciar sesión

## Autor

Mateo Agüero  
Argentina  
Correo: mateogabrielaguero15@gmail.com  
GitHub: https://github.com/Maguero123



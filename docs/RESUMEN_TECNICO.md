# Resumen técnico — Woof

## Objetivo y alcance

Mostrar nueve perros con fotografía, nombre, edad y actividad favorita mediante tarjetas Material Design 3. La aplicación es local, está en español y conserva la identidad de Woof. No se añadieron formularios, cuentas, servidores ni funcionalidades ajenas al ejercicio.

## Arquitectura

- MainActivity: actividad ComponentActivity y entrada a Compose; habilita edge-to-edge.
- WoofApp: Scaffold con encabezado y LazyColumn con claves basadas en el recurso de nombre.
- DogItem: Card, IconButton y AnimatedVisibility; rememberSaveable conserva la expansión al salir de la composición y al recrear la actividad.
- DogIcon: fotografía circular con ContentScale.Crop, sin deformación.
- DogInformation: nombre y edad mediante recursos de texto.
- data/Dog.kt: modelo inmutable y catálogo estático de nueve elementos.
- ui/theme: colores, formas y tipografía Material 3; adapta iconos de las barras al tema.
- res/values/strings.xml: textos de la interfaz y descripciones de accesibilidad por perro.
- res/drawable-nodpi: nueve fotografías originales, sin escalado adicional por densidad; res/drawable conserva los vectores.

## Datos

Koda (2), Lola (16), Frankie (2), Nox (8), Faye (8), Bella (14), Moana (2), Tzeitel (7) y Leroy (4). Las edades están en años. Cada entrada referencia su fotografía y una actividad favorita en español.

## Compatibilidad

minSdk 24; compileSdk/targetSdk 35. AGP 8.8.0, Gradle 8.12, Kotlin 2.1.0 y Compose BOM 2024.12.01. No se exige Android Studio para compilar desde el Wrapper. Se respetan los insets de las barras del sistema.

El encabezado utiliza el logotipo vectorial original de Woof; las flechas usan material-icons-core. Se retiró material-icons-extended, innecesario para estos controles. Gradle usa dos trabajadores y un máximo de 1 GiB de heap; el daemon Kotlin usa 512 MiB para reducir la presión de memoria en este equipo.

La configuración declara Android 7.0 o superior; las versiones ejecutadas y las que quedan sin comprobar se detallan en el registro de evidencias. El estado guardado no equivale a una base de datos: no existe contenido editable ni sincronización.

## Validación

Tres pruebas unitarias del catálogo y pruebas instrumentadas de interfaz/recursos. Los resultados reales, fallos encontrados y alcance de las capturas se registran en [VERIFICACION.md](evidencias/VERIFICACION.md). No confundir una revisión de código con una ejecución en un dispositivo.

Resultado de esta sesión: 3 unitarias y 5 instrumentadas aprobadas en Android 7.0/API 24. Compilación y ensamblado correctos; lint con 0 errores y 18 advertencias. Se inspeccionaron capturas reales en claro, oscuro, horizontal y fuente al 150 %. Android 16 no quedó aprobado: el primer proceso instrumentado se cerró antes de ejecutar pruebas.

## Referencias y atribución

- Material educativo Android Basics with Compose: Woof (origen del ejercicio).
- [Compatibilidad de Android Gradle Plugin 8.8](https://developer.android.com/build/releases/agp-8-8-0-release-notes): Build Tools 35.0.0 y API máxima 35.
- LICENSE y ASSETS_LICENSE.txt del proyecto original.

Estudiante: Isabela Haydee González Gonsale. Carnet: 0908-25-22418. Cuenta GitHub indicada: hgfdiuy. Enlaces reales en documentacion.txt, pendientes hasta su verificación. Este documento no asigna a la estudiante la autoría del material original de Android.

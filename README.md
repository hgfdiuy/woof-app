# Woof — aplicación Android

Aplicación académica de Kotlin y Jetpack Compose basada en Woof de Android Basics with Compose. Conserva los nueve perros, fotografías y nombres originales.

Entrega académica de **Isabela Haydee González Gonsale**, carnet **0908-25-22418**. Cuenta GitHub indicada: **hgfdiuy**. Se conservan las atribuciones originales; estos datos identifican a la estudiante responsable de la entrega.

## Funcionalidades

- Lista desplazable con fotografía, nombre y edad de nueve perros.
- Actividad favorita expandible y contraíble por tarjeta; varias tarjetas pueden estar abiertas.
- Estado de expansión guardado con rememberSaveable y claves estables en LazyColumn.
- Material Design 3, temas claro/oscuro e interfaz en español.
- Fotografías recortadas proporcionalmente y botones accesibles identificados por perro.
- Márgenes para las barras del sistema, incluido el comportamiento de Android 15 y posteriores.
- Catálogo local: no requiere internet, permisos de red, cuentas ni base de datos.

## Entorno y compilación

Configuración conservada: Android Gradle Plugin 8.8.0, Gradle Wrapper 8.12, Kotlin/Compose Compiler 2.1.0, Compose BOM 2024.12.01. Android mínimo 7.0 (API 24), compileSdk y targetSdk 35.

Se requiere Java compatible con Gradle 8.12 (esta sesión usa JDK 22), SDK Platform 35 y Build Tools 35.0.0. Android Studio es opcional para compilar por terminal. Configure JAVA_HOME y ANDROID_HOME o la ruta sdk.dir en local.properties (archivo local excluido de Git).

Desde PowerShell en la raíz:

```powershell
.\gradlew.bat --console=plain --max-workers=2 :app:testDebugUnitTest :app:assembleDebug
# Con un dispositivo autorizado o emulador arrancado:
.\gradlew.bat --console=plain --max-workers=2 :app:connectedDebugAndroidTest
.\gradlew.bat --console=plain --max-workers=2 :app:lintDebug
```

APK de depuración: `app/build/outputs/apk/debug/app-debug.apk`. Es un APK de prueba firmado con la clave de depuración local; no es una publicación en Google Play.

## Verificación y evidencias

Verificado el 27 de octubre de 2026: **3 pruebas unitarias y 5 de interfaz aprobadas**, APK compilado e instalado en Android 7.0/API 24, y lint con 0 errores (18 advertencias). Se revisaron seis capturas reales, incluidos tema oscuro, rotación y fuente al 150 %. El intento de interfaz en Android 16 falló antes de ejecutar pruebas y queda registrado.

Consultar [registro de verificación](docs/evidencias/VERIFICACION.md) para los resultados efectivamente obtenidos, entorno, limitaciones, tamaño y SHA-256 del APK. Las pruebas unitarias validan el catálogo; las instrumentadas comprueban fotos, datos, interacción, desplazamiento y recreación de la actividad.

Las capturas existentes en docs/evidencias deben corresponder a ejecuciones reales. No se afirma compatibilidad probada con todas las versiones de Android únicamente por compilar para API 24.

## Entrega

[Guía](docs/GUIA_ENTREGA.md), [resumen técnico](docs/RESUMEN_TECNICO.md) y [pruebas manuales](docs/PRUEBAS_MANUALES.md).

documentacion.txt contiene los datos oficiales de Isabela; los enlaces de GitHub y Drive se completarán tras publicar y comprobar los destinos autorizados. La carpeta local entrega/ contiene el paquete y la carpeta lista para subir a Drive; está excluida de Git. Consulte el estado de publicación actualizado en docs/evidencias/VERIFICACION.md.

Paquete preparado localmente: entrega/Woof-debug.apk, entrega/Woof-fuentes.zip, documentación/evidencias y entrega/SHA256SUMS.txt. Git local en main, sin commits ni remoto; archivos preparados para el primer commit con identidad autorizada.

## Licencias

Se conservan LICENSE, ASSETS_LICENSE.txt y las atribuciones del código y de las fotografías. La autoría del material de Android se distingue del trabajo académico del estudiante.

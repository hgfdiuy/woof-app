# Contexto persistente — Woof

## Alcance y autorización

- Trabajar solo dentro de este proyecto; no modificar los proyectos Java/Maven vecinos.
- Fuente recibida: Woof-proyecto-para-Codex.zip, carpeta Woof-entrega-base.
- El usuario autorizó implementación, dependencias necesarias, compilación, pruebas y preparación local de la entrega.
- documentacion.txt debe conservar exactamente cuatro campos. Datos oficiales recibidos: Isabela Haydee González Gonsale, carnet 0908-25-22418. Mantener PENDIENTE solo los enlaces aún sin verificar.
- La solicitud vigente autoriza preparar la publicación pública como hgfdiuy, condicionada a identidad Git confirmada y sesión correcta. Drive requiere cuenta y permisos autorizados. No inventar datos, enlaces, capturas ni resultados; no usar cuentas ajenas.
- Conservar las licencias y atribuciones originales de Android y de las fotografías.

## Avances verificados — 27 de octubre de 2026

- Proyecto Kotlin/Compose, namespace com.example.woof; nueve perros originales con nombres, edades, fotografías y actividades en español.
- Ajustes de insets para barras del sistema, recorte proporcional de fotos y etiquetas accesibles por perro.
- Encabezado con el logotipo original; material-icons-core sustituye a material-icons-extended.
- Fotografías originales movidas a drawable-nodpi para evitar ampliación por densidad; hashes conservados.
- Entorno preparado: JDK 22.0.2, Gradle Wrapper 8.12, AGP 8.8.0, Kotlin 2.1.0, SDK Platform 35 y Build Tools 35.0.0.
- Gradle limitado a 1 GiB y dos trabajadores; daemon Kotlin a 512 MiB por memoria reducida del equipo.
- testDebugUnitTest: 3 pruebas aprobadas; assembleDebug y assembleDebugAndroidTest correctos.
- lintDebug correcto: 0 errores y 18 advertencias, detalladas en docs/evidencias/lint-resumen.txt.
- Pruebas instrumentadas directas por ADB en Woof_Verificacion_API24 (Android 7.0, x86_64): OK (5 tests), 25.013 segundos.
- Se verificaron datos y actividades de los nueve perros, fotos, expansión/contracción, independencia de tarjetas, desplazamiento y estado tras recreación.
- Verificación visual real de temas claro/oscuro, rotación y fuente al 150 %; seis capturas inspeccionadas en docs/evidencias/.
- APK app/build/outputs/apk/debug/app-debug.apk: 15,702,160 bytes; firma v2 válida.
- SHA-256: 057915BE4E93FA5A4A0C07B28691478EC817588878DE3F9A7DD02217B774803A.
- Git local en main, archivos preparados para el primer commit; sin commits ni remoto. Revisión de formato sin errores y sin coincidencias en el escaneo de patrones de credenciales.
- Entrega local en entrega/: APK, ZIP de fuentes, documentación/evidencias y SHA256SUMS.txt. No se publicó ni compartió nada.

## Incidencias y límites

- Primer build interrumpido manualmente ante presión de memoria; se redujeron heap, paralelismo y dependencia de iconos.
- Importación filterToOne faltante en las pruebas: corregida; posterior compilación y ejecución aprobadas.
- connectedDebugAndroidTest en Android 16 terminó con Process crashed y 0 pruebas ejecutadas; el emulador registró fallos/ANR de servicios del sistema. Sus reintentos no dieron una instancia utilizable para pruebas.
- La suite se ejecutó correctamente por ADB en una instancia aislada API 24 con 1 GiB de RAM. Conservar ambos resultados; no presentar el intento Android 16 como aprobado.
- No se verificaron todas las API/arquitecturas ni un teléfono físico.
- Pendientes: nombre, carnet, enlaces reales y autorización del propietario para GitHub/Drive; primer commit con identidad autorizada, publicación, permisos y descarga desde Drive.

## Cierre de entrega — 27 de octubre de 2026

- Se revalidaron firma v2, SHA-256 y tamaño del APK de entrega; coincide con la salida compilada. Hash y tamaño permanecen sin cambios.
- Se comprobaron los 75 archivos del ZIP contra el proyecto, rutas, duplicados y exclusiones; se revisaron los 48 archivos de texto buscando patrones de secretos, sin coincidencias. Los binarios son imágenes y el JAR necesario del Gradle Wrapper.
- Se revisaron las 18 advertencias de lint individualmente por categoría y ubicación; ninguna afecta el catálogo actual. La justificación está en docs/evidencias/lint-resumen.txt. No se suprimieron avisos ni se cambiaron código, recursos o dependencias.
- Se conservaron las 3 pruebas unitarias y 5 de interfaz aprobadas y las seis capturas reales. No se repitieron compilaciones ni suites en este cierre documental.
- documentacion.txt conserva exactamente cuatro líneas con PENDIENTE; no se tomaron datos personales de otros proyectos.
- La guía detalla el primer commit con identidad confirmada, creación del repositorio autorizado, subida a Drive y verificación de permisos. No se ejecutaron commit, push, creación de repositorios ni subida de archivos.
- Git local en main, 75 archivos preparados; sin commits ni remoto. user.useConfigOnly=true local evita inferir una identidad; una identidad global existente no se considera autorizada para este proyecto. Mensaje de commit preparado en .git/WOOF_PRIMER_COMMIT.txt (no se incluye en el ZIP).
- Se sincronizaron las copias documentales de entrega/, el ZIP de 75 fuentes y SHA256SUMS.txt. El APK no se recompiló ni sustituyó por otro binario.
- entrega/INVENTARIO_FUENTES.txt enumera las 75 rutas y hashes de la versión empaquetada para facilitar su revisión. Es un archivo generado fuera de las fuentes Git.
- Pendientes del propietario: nombre y carnet del estudiante; nombre/correo Git autorizados; cuenta y repositorio GitHub de destino; cuenta/carpeta Drive y permisos exigidos por el docente. Los enlaces se completarán solo tras crearlos y verificarlos con autorización.

## Estado vigente con datos oficiales — 27 de octubre de 2026

- Estudiante: Isabela Haydee González Gonsale. Carnet: 0908-25-22418. Cuenta GitHub autorizada de destino: hgfdiuy, repositorio solicitado público woof-app.
- Nombre/carnet actualizados en documentacion.txt, README y resumen técnico; atribuciones originales intactas. Las menciones anteriores a cuatro campos pendientes son registro histórico, sustituido por estos datos oficiales.
- GitHub CLI autenticado como hgfdiuy; el conector GitHub usa otra cuenta y no debe utilizarse para publicar esta entrega. No se encontró hgfdiuy/woof-app en la consulta autenticada.
- Primer commit y publicación pendientes del correo Git expresamente autorizado, solicitado al usuario. No usar correo global ni inferir noreply. Mensaje: feat: entrega final de Woof-App con pruebas y documentación.
- El usuario indicó dejar Drive únicamente como carpeta local y no subir a la cuenta conectada. No subir ni compartir archivos. Cuenta de destino, enlace y permisos Drive pendientes; no almacenar datos de la cuenta conectada en las fuentes.
- Carpeta local lista para Drive: entrega/Woof-App - Isabela Haydee Gonzalez - Entrega/, con Documentacion.txt, paquete completo y manifiesto propio. Las fuentes mantienen documentacion.txt en minúsculas.
- APK con firma v2 válida, mismo SHA-256 y tamaño documentados; Android sin cambios. No se repitieron compilación ni suites. Mantener evidencias de API 24 y del intento fallido API 36.
- Enlaces de GitHub y Drive continúan PENDIENTE; no afirmar publicación ni accesibilidad hasta comprobarlas. Sin cambios en los proyectos Java vecinos.

## Publicación GitHub — 27 de octubre de 2026

- Correo Git autorizado por el usuario para esta entrega: rporrasd@miumg.edu.gt, con nombre Isabela Haydee González Gonsale. Aplicarlo por comando (git -c user.name=... -c user.email=...), sin tocar la configuración global.
- Repositorio público creado: https://github.com/hgfdiuy/woof-app. Primer commit cf485540dfe7460861f666b87593ebbeaebaef9d publicado en main; HEAD local = remoto y HTTP 200 sin sesión comprobados.
- Commit posterior solo documental con el estado de publicación; código Android y APK sin cambios, suites no repetidas.
- Drive sigue solo local por indicación del usuario; "Documentación adicional" PENDIENTE. No subir a la cuenta conectada.
- Regenerar ZIP, inventario, hashes y carpeta Drive con .verification/cierre-final/empaquetar.ps1 tras cambios documentales confirmados en un commit.

## Continuidad después del cierre

Leer README.md y docs/evidencias/VERIFICACION.md antes de continuar. Después de cambios de código ejecutar las verificaciones afectadas, actualizar evidencias y regenerar entrega/. .gradle/, .kotlin/, build/, local.properties, .verification/ (incluye AVD locales), entrega/, registros y claves están excluidos de Git. No incluir estos archivos locales en el ZIP de fuentes. Actualizar este archivo con fecha, resultados y bloqueos al terminar cada sesión.

# Registro de verificación

Sesión: 27 de octubre de 2026, America/Mexico_City.

## Resultados verificados

| Verificación | Resultado |
|---|---|
| :app:testDebugUnitTest | 3 pruebas, 0 fallos, 0 errores, 0 omitidas |
| :app:assembleDebug | Correcto; APK generado |
| :app:assembleDebugAndroidTest | Correcto; APK de pruebas generado |
| :app:lintDebug | Correcto; 0 errores, 18 advertencias |
| Firma del APK | apksigner verify --verbose: salida 0, firma v2 válida |
| Instalación por Gradle en emulador | APK principal y APK de pruebas instalados |
| Primer :app:connectedDebugAndroidTest | Falló la instrumentación: Process crashed; 0 pruebas ejecutadas |
| Instalación directa en Android 7.0/API 24 | APK principal y APK de pruebas: Success; apertura Status: ok |
| Suite instrumentada directa por ADB, API 24 | OK (5 tests), 25.013 s; todos aprobados |
| Temas claro/oscuro, rotación y fuente al 150 % | Revisión visual aprobada; seis capturas reales inspeccionadas |

Último ensamblado completo: BUILD SUCCESSFUL en 1 min 16 s. Entorno: Windows, JDK 22.0.2, Gradle 8.12, AGP 8.8.0, Kotlin 2.1.0, SDK Platform 35 y Build Tools 35.0.0. Emulador aprobado: Woof_Verificacion_API24, Android 7.0/API 24, x86_64, 720 × 1280 y 1 GiB de RAM. Emulador del intento fallido: Pixel8a_API36, Android 16/API 36.

## APK

- Ruta desde la raíz: app/build/outputs/apk/debug/app-debug.apk.
- Tamaño: 15,702,160 bytes.
- SHA-256: 057915BE4E93FA5A4A0C07B28691478EC817588878DE3F9A7DD02217B774803A.
- Paquete com.example.woof, versión 1.0, minSdk 24, targetSdk 35.
- Arquitecturas incluidas: arm64-v8a, armeabi-v7a, x86 y x86_64.
- Contiene las nueve fotografías originales en drawable-nodpi, sin alterar sus archivos.

Ver apk-integridad.txt, apk-firma.txt, pruebas-unitarias.xml y lint-resumen.txt. La copia del XML unitario omite únicamente el nombre del equipo.

## Incidencias encontradas

1. El primer intento de compilación se interrumpió manualmente ante presión de memoria. Se limitó Gradle a 1 GiB y dos trabajadores, y el daemon Kotlin a 512 MiB.
2. Se corrigió una importación faltante de filterToOne en las pruebas instrumentadas; la compilación posterior de pruebas pasó.
3. Se retiró material-icons-extended: el encabezado usa el logotipo original y las flechas material-icons-core.
4. Se reubicaron las fotografías originales en drawable-nodpi para evitar ampliación por densidad; los hashes se comprobaron antes y después del movimiento. Moana mide 4080 × 3072 píxeles.
5. El primer intento instrumentado terminó antes de descubrir pruebas. Durante esa ejecución el emulador también registró fallos/ANR de servicios del sistema. El arranque en frío y otra instancia API 36 no dieron un entorno utilizable para las pruebas. No se atribuye una causa definitiva al cierre del proceso de instrumentación. Se creó una instancia aislada AOSP de API 24 y allí se aprobaron los cinco casos directamente por ADB.

Las 18 advertencias de lint corresponden a versiones de dependencias disponibles (7), recursos sin uso (8), etiqueta redundante (1), sugerencia de plural (1) y carpeta v24 redundante (1). No son errores de compilación. El ensamblado también avisó que libandroidx.graphics.path.so se empaqueta sin quitar símbolos.

## Alcance pendiente

Las pruebas de interfaz y capturas están aprobadas en API 24. La configuración admite API 24 o superior, pero no se ha probado cada versión ni cada arquitectura. Android 16 no está aprobado y no se probó un teléfono físico. La descarga e instalación desde Drive queda pendiente de publicación autorizada y verificación del enlace.

## Evidencias y reproducción

- pruebas-interfaz.txt: salida original de AndroidJUnitRunner, numtests=5, cinco estados de éxito y OK (5 tests).
- pruebas-unitarias.xml: tres casos de DogsTest, sin fallos ni errores.
- compilacion-resumen.txt: tareas solicitadas y cierre del ensamblado final.
- instrumentacion-primer-intento.xml: intento fallido de Android 16 con cero pruebas ejecutadas; no confundir sus contadores con una aprobación.
- 01-inicio.png: catálogo al abrir, con fotografías, nombres y edades en español.
- 02-koda-expandido.png: actividad favorita y control de contracción.
- 03-final-lista.png: recorrido hasta Leroy, incluidas Bella, Moana y Tzeitel.
- 04-tema-oscuro.png: interfaz oscura real con Koda expandido.
- 05-horizontal.png: giro físico del emulador y expansión conservada.
- 06-texto-grande.png: escala de fuente 1.5 con contenido y botones visibles.

Para reproducir la suite aprobada, con un emulador/dispositivo autorizado arrancado y ambos APK compilados:

```powershell
adb install -r --no-streaming app/build/outputs/apk/debug/app-debug.apk
adb install -r --no-streaming app/build/outputs/apk/androidTest/debug/app-debug-androidTest.apk
adb shell am instrument -w -r -e class com.example.woof.WoofUiTest com.example.woof.test/androidx.test.runner.AndroidJUnitRunner
```

## Git y preparación local — estado anterior a recibir los datos oficiales

Repositorio main sin commits ni remoto, con archivos preparados para un primer commit bajo identidad autorizada. Se revisaron exclusiones, formato y patrones de credenciales; no se encontraron coincidencias en el escaneo utilizado. entrega/ contiene el APK, ZIP de fuentes, documentación, seis capturas, resultados y SHA256SUMS.txt. .verification/ conserva los registros locales y AVD fuera de los archivos entregables.

No se ha publicado ni compartido ningún archivo. Faltan nombre, carnet, enlace autorizado de GitHub y enlace autorizado de Drive, además de publicar/subir y comprobar sus permisos cuando el propietario lo autorice.

Los cuatro datos de documentacion.txt quedan PENDIENTE por instrucción del usuario. No se autoriza publicar ni compartir.

## Auditoría de cierre — 27 de octubre de 2026

Se revisaron de nuevo el APK de entrega, la salida compilada y su firma v2: coinciden en 15,702,160 bytes y el SHA-256 indicado arriba. Se validó el manifiesto de 25 archivos del paquete. El ZIP de fuentes conserva 75 archivos; todos se contrastaron con el proyecto y se revisaron rutas, duplicados y exclusiones. Se escanearon sus 48 archivos de texto sin coincidencias con los patrones de credenciales utilizados. Esta revisión no constituye una garantía absoluta de ausencia de secretos.

Las 18 advertencias se evaluaron con sus ubicaciones del XML original. No se detectó una corrección necesaria para los nueve perros actuales; consultar la justificación por categoría en lint-resumen.txt. Se mantuvieron visibles los avisos y no se modificaron código, recursos o dependencias. Se conservan los resultados anteriores de las 3 pruebas unitarias y 5 de interfaz; no se repitieron en este cierre documental.

Se preparó el mensaje del primer commit localmente y la guía de publicación, sin adoptar identidad Git de otras cuentas. El commit espera un nombre/correo confirmados por el propietario. Las fuentes, documentación y hashes se regeneraron para incluir esta auditoría; el APK permanece idéntico. No se tocaron los proyectos Java vecinos ni se publicó ningún archivo.

## Cierre con datos oficiales — 27 de octubre de 2026

Entrega de Isabela Haydee González Gonsale, carnet 0908-25-22418. documentacion.txt conserva exactamente cuatro campos, con nombre/carnet completos y enlaces PENDIENTE hasta su publicación y comprobación.

Se volvió a verificar apksigner verify --verbose: salida 0, firma v2 válida, un firmante. El APK de entrega y la salida de compilación conservan el tamaño y SHA-256 de este registro. No se modificaron código Android, recursos ni dependencias, ni se repitieron las suites aprobadas. Las seis capturas y las salidas originales se conservan; el intento fallido API 36 continúa documentado.

GitHub CLI existe y gh api user --jq .login devolvió hgfdiuy. El conector de GitHub corresponde a otra cuenta y no se usó para publicar. La consulta autenticada de hgfdiuy/woof-app no encontró ese repositorio. El primer commit y la publicación esperan la confirmación del correo Git solicitado al usuario; no se adoptó identidad de otro proyecto. El usuario indicó mantener Drive únicamente como carpeta local y no subir a la cuenta conectada; no se subió ni compartió ningún archivo.

Se revisaron los campos de autoría de las fuentes y documentación: identifican a Isabela en la entrega; se conservan The Android Open Source Project, licencias y atribuciones legítimas. No se copiaron datos de proyectos vecinos. Los 75 archivos fuente se vuelven a empaquetar y contrastar por SHA-256; se excluyen compilados, local.properties, cachés, claves, metadatos Git y la carpeta entrega/. El escaneo por patrones de secretos no encontró coincidencias; no es una garantía absoluta.

La carpeta entrega/Woof-App - Isabela Haydee Gonzalez - Entrega/ queda lista para subida manual con APK, ZIP, Documentacion.txt, README, licencias, inventario, hashes, informe técnico, guía y evidencias. Tiene su propio SHA256SUMS.txt; el manifiesto de entrega/ cubre únicamente el paquete de su nivel y docs/, sin duplicar esta copia. Los enlaces siguen sin poder comprobarse hasta contar con los destinos reales.

## Publicación en GitHub — 27 de octubre de 2026

El usuario autorizó el correo Git rporrasd@miumg.edu.gt para los commits de esta entrega; la identidad se aplicó por comando, sin modificar la configuración global. Con gh api user --jq .login devolviendo hgfdiuy y sin remoto previo, se creó el repositorio público vacío hgfdiuy/woof-app y se publicó main con el primer commit cf485540dfe7460861f666b87593ebbeaebaef9d (autor Isabela Haydee González Gonsale, 75 archivos). Se comprobó que HEAD local coincidía con main remoto y que https://github.com/hgfdiuy/woof-app responde HTTP 200 sin iniciar sesión. documentacion.txt registra esa URL.

Un commit posterior, solo documental, actualiza README, resumen técnico, guía, AGENTS.md y este registro con el estado de publicación. No cambia código Android, recursos, dependencias ni el APK; por eso no se repitieron compilación ni suites. El ZIP de fuentes, el inventario y los hashes se regeneran con esos documentos y se contrastan con el commit publicado.

Drive: por indicación del usuario no se subió nada a la cuenta conectada. La carpeta local queda lista para subida manual y "Documentación adicional" sigue PENDIENTE hasta tener un enlace autorizado y comprobado.

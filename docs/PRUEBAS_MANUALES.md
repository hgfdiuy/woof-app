# Pruebas manuales — resultados

Sesión: 27 de octubre de 2026 (America/Mexico_City). Emulador aislado Woof_Verificacion_API24: Android 7.0/API 24, x86_64, pantalla 720 × 1280, 1 GiB RAM. Se instaló el APK cuyo SHA-256 figura en [VERIFICACION.md](evidencias/VERIFICACION.md).

| ID | Comprobación | Resultado y evidencia |
|---|---|---|
| P01 | Instalar y abrir el APK | Aprobado: instalación Success y am start -W Status: ok; 01-inicio.png |
| P02 | Recorrer los nueve perros con nombre, foto y edad | Aprobado: prueba instrumentada y 01-inicio.png / 03-final-lista.png |
| P03 | Expandir cada actividad favorita | Aprobado automáticamente para los nueve; inspección de Koda en 02-koda-expandido.png |
| P04 | Contraer cada actividad | Aprobado automáticamente para los nueve; se comprueba desaparición del texto |
| P05 | Varias tarjetas independientes | Aprobado: cardsExpandIndependently |
| P06 | Ir hasta Leroy y regresar conservando expansión | Aprobado: scrollingAwayAndBackPreservesExpansion y revisión visual |
| P07 | Recreación y rotación | Aprobado: expansionSurvivesActivityRecreation y 05-horizontal.png; Koda continúa expandido |
| P08 | Tema oscuro y regreso al claro | Aprobado visualmente: 04-tema-oscuro.png y 05-horizontal.png |
| P09 | Fuente al 150 % | Aprobado visualmente: 06-texto-grande.png; fotografías y botones visibles |
| P10 | Descargar desde Drive e instalar | PENDIENTE: cuenta/permisos Drive y enlace todavía sin confirmar |

Las capturas son reales y se inspeccionaron después de obtenerlas del emulador. No todos los casos fueron manuales: la tabla distingue verificaciones automáticas y revisión visual.

## Pruebas automáticas

- DogsTest.kt: 3 pruebas unitarias, 0 fallos, 0 errores y 0 omitidas.
- WoofUiTest.kt: 5 pruebas instrumentadas, OK (5 tests), 25.013 segundos.
- Los nueve recursos fotográficos se decodificaron con BitmapFactory.
- Salida original de la suite: [pruebas-interfaz.txt](evidencias/pruebas-interfaz.txt).
- Copia portable del informe unitario: [pruebas-unitarias.xml](evidencias/pruebas-unitarias.xml).

La ejecución instrumentada aprobada se hizo directamente por ADB con ambos APK instalados. El intento anterior mediante connectedDebugAndroidTest en Android 16 terminó antes de ejecutar pruebas; se conserva en instrumentacion-primer-intento.xml.

## Método y límites

En API 24 el comando shell cmd uimode no está implementado. Se activó y desactivó el modo nocturno con el servicio UiModeManager; se comprobó su valor y el cambio real de colores. La orientación se cambió con user_rotation y la escala de fuente con font_scale; al terminar se restauraron orientación vertical, modo claro y escala 1.0.

La aprobación en API 24 no certifica todas las versiones ni todos los dispositivos. Android 16 y la instalación desde Drive siguen sin aprobarse. No se generaron capturas ficticias.

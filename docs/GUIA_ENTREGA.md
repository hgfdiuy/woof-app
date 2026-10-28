# Guía de entrega definitiva — Woof

## Estado actual

El APK y las pruebas ya están verificados: 3 unitarias y 5 de interfaz aprobadas en Android 7.0/API 24. El cierre actual modifica documentación y empaquetado; conserva el código y el APK probados. Android 16 no quedó aprobado; ver [registro completo](evidencias/VERIFICACION.md).

La carpeta entrega/ contiene Woof-debug.apk, Woof-fuentes.zip (75 archivos), README.md, documentacion.txt, licencias, README_ENTREGA.txt, INVENTARIO_FUENTES.txt, docs/ con seis capturas y resultados, y SHA256SUMS.txt. El inventario enumera rutas y hashes de las 75 fuentes. Los metadatos Git, SDK, cachés, AVD, credenciales y salidas de compilación se excluyen de las fuentes.

## Datos oficiales y destinos

documentacion.txt mantiene exactamente estas cuatro líneas:

```text
Nombre: Isabela Haydee González Gonsale
Carnet: 0908-25-22418
Repositorio: https://github.com/hgfdiuy/woof-app
Documentación adicional: PENDIENTE
```

El usuario proporcionó estos datos oficiales y la cuenta GitHub hgfdiuy, y confirmó el correo Git que debe usarse en los commits de esta entrega. Aplicar la identidad solo al proyecto/comando, sin cambiar la configuración global. No reutilizar información de otros proyectos. El mensaje inicial solicitado es: feat: entrega final de Woof-App con pruebas y documentación.

El destino es el repositorio público https://github.com/hgfdiuy/woof-app, creado con GitHub CLI autenticado como hgfdiuy porque no existía uno previo; el conector de GitHub pertenece a otra cuenta y no se utilizó para publicar. El usuario indicó dejar Drive únicamente como carpeta local y no subir a la cuenta conectada. Consultar el estado actualizado en evidencias/VERIFICACION.md antes de ejecutar acciones pendientes; completar enlaces solo después de verificarlos.

## Primer commit y continuidad

El repositorio está en main con 75 archivos de fuentes. El primer commit (cf48554) ya se creó con la identidad autorizada y se publicó en origin/main; los commits posteriores son solo documentales. El estado del commit y remoto se registra en evidencias/VERIFICACION.md. No ejecutar otro primer commit.

Procedimiento usado para el primer commit, conservado como referencia para reproducirlo en otra copia:

```powershell
git status --short
git diff --cached --check
$autorWoof = 'Isabela Haydee González Gonsale'
$correoWoof = Read-Host 'Correo Git confirmado y autorizado por el propietario'
if ([string]::IsNullOrWhiteSpace($autorWoof) -or
    [string]::IsNullOrWhiteSpace($correoWoof) -or
    $autorWoof -eq 'PENDIENTE' -or $correoWoof -eq 'PENDIENTE') {
    throw 'Falta identidad autorizada; no crear el commit.'
}
git add --all
git diff --cached --check
if ($LASTEXITCODE -ne 0) { throw 'Corregir la revision del indice antes del commit.' }
git -c user.name="$autorWoof" -c user.email="$correoWoof" commit -m "feat: entrega final de Woof-App con pruebas y documentación"
```

La identidad se aplica a ese comando, sin cambiar la configuración global. El nombre oficial y el correo Git fueron confirmados expresamente por el usuario. Para usar el ZIP de fuentes en otra computadora, descomprimirlo y ejecutar git init -b main dentro de Woof/ antes de preparar el primer commit: el ZIP no incluye .git/.

Excluir local.properties, .gradle/, .kotlin/, build/, .verification/, entrega/, APK, claves, .env y registros temporales. Conservar el JAR y scripts del Gradle Wrapper, necesarios para compilar, junto con las fuentes, pruebas, imágenes y licencias.

## GitHub — ejecutar únicamente con autorización

Ya ejecutado: origin apunta a https://github.com/hgfdiuy/woof-app y main está publicado. El procedimiento queda como referencia. En hgfdiuy, crear woof-app público y vacío solo después de verificar la cuenta activa con gh api user --jq .login y comprobar que no existe un destino apropiado. No inicializarlo con otro README, licencia o .gitignore. No insertar tokens en URLs ni archivos. Procedimiento basado en la [guía oficial de GitHub](https://docs.github.com/en/migrations/importing-source-code/using-the-command-line-to-import-source-code/adding-locally-hosted-code-to-github).

Después del primer commit y de comprobar el destino real:

```powershell
$repositorioWoof = Read-Host 'URL HTTPS real del repositorio GitHub autorizado'
if ($repositorioWoof -notmatch '^https://github\.com/[^/\s]+/[^/\s]+/?$') {
    throw 'Comprobar la URL autorizada antes de configurar el remoto.'
}
if (@(git remote) -contains 'origin') {
    throw 'origin ya existe; revisar su destino antes de continuar.'
}
git remote add origin $repositorioWoof
git remote -v
git push -u origin main
```

Comprobar desde GitHub que main contiene las fuentes, documentación y los datos definitivos, y que el docente tiene acceso. Comparar el SHA remoto con HEAD y los bytes de los 75 archivos con el ZIP. No utilizar force push. El registro de verificación indica las operaciones efectivamente ejecutadas.

## Sincronizar el paquete después de completar los datos

Los cambios solo documentales requieren actualizar ZIP, copias y hashes; no necesitan repetir las pruebas de aplicación ni recompilar el APK. Después de incluir los documentos definitivos en un commit:

```powershell
if (@(git status --porcelain).Count) { throw 'Confirmar los cambios antes de empaquetar HEAD.' }
git archive --format=zip --prefix=Woof/ --output=entrega/Woof-fuentes.zip HEAD
$raizWoof = (Get-Location).Path
$entregaWoof = Join-Path $raizWoof 'entrega'
Add-Type -AssemblyName System.IO.Compression
Add-Type -AssemblyName System.IO.Compression.FileSystem
$zipWoof = [IO.Compression.ZipFile]::OpenRead((Join-Path $entregaWoof 'Woof-fuentes.zip'))
try {
    $inventarioWoof = foreach ($entradaWoof in $zipWoof.Entries) {
        $flujoWoof = $entradaWoof.Open()
        $shaWoof = [Security.Cryptography.SHA256]::Create()
        try { $hashWoof = [BitConverter]::ToString($shaWoof.ComputeHash($flujoWoof)).Replace('-','').ToLowerInvariant() }
        finally { $flujoWoof.Dispose(); $shaWoof.Dispose() }
        $hashWoof + '  ' + $entradaWoof.FullName.Substring(5)
    }
} finally { $zipWoof.Dispose() }
[IO.File]::WriteAllLines((Join-Path $entregaWoof 'INVENTARIO_FUENTES.txt'), $inventarioWoof, [Text.UTF8Encoding]::new($false))
Copy-Item -LiteralPath 'README.md','documentacion.txt','LICENSE','ASSETS_LICENSE.txt' -Destination $entregaWoof -Force
Get-ChildItem -LiteralPath 'docs' -Recurse -File | ForEach-Object {
    $destinoWoof = Join-Path $entregaWoof $_.FullName.Substring($raizWoof.Length + 1)
    [IO.Directory]::CreateDirectory([IO.Path]::GetDirectoryName($destinoWoof)) | Out-Null
    Copy-Item -LiteralPath $_.FullName -Destination $destinoWoof -Force
}
$sumasWoof = Get-ChildItem -LiteralPath $entregaWoof -Recurse -File |
    Where-Object { $_.Name -ne 'SHA256SUMS.txt' } |
    Sort-Object FullName | ForEach-Object {
        (Get-FileHash -LiteralPath $_.FullName -Algorithm SHA256).Hash.ToLowerInvariant() +
        '  ' + $_.FullName.Substring($entregaWoof.Length + 1).Replace('\','/')
    }
[IO.File]::WriteAllLines((Join-Path $entregaWoof 'SHA256SUMS.txt'), $sumasWoof, [Text.UTF8Encoding]::new($false))
```

Si se cambia código o recursos, recompilar, repetir las verificaciones afectadas y actualizar también APK y evidencias. No mezclar un APK nuevo con los resultados del anterior.

## Google Drive — ejecutar únicamente con autorización

En la cuenta confirmada, usar Nuevo → Subir carpeta y seleccionar entrega/Woof-App - Isabela Haydee Gonzalez - Entrega/. Este directorio contiene una copia completa del paquete, con Documentacion.txt y su propio manifiesto de hashes. No contiene otra copia de sí mismo. Esperar a que termine la transferencia. Véase la [ayuda oficial para subir archivos](https://support.google.com/drive/answer/2424368?hl=es).

En Compartir, elegir el acceso exigido por el docente y el rol de lector. Si se exige acceso por enlace, comprobarlo desde una sesión sin iniciar; si es institucional o restringido, comprobarlo con una cuenta autorizada. Las políticas escolares pueden limitar el acceso externo. Véase la [ayuda oficial de permisos](https://support.google.com/drive/answer/7166529?hl=en).

Descargar el APK y comprobar que su SHA-256 coincide con apk-integridad.txt. Revisar también ZIP, documentos y capturas. Hasta realizar estas comprobaciones no declarar accesible el enlace ni aprobado el caso de instalación desde Drive.

## Cierre académico pendiente

El correo Git fue autorizado y el repositorio público se creó en https://github.com/hgfdiuy/woof-app. El primer commit se publicó en main; se comprobó acceso público sin iniciar sesión y coincidencia del SHA local y remoto (ver registro de verificación). Falta subir desde una cuenta Drive autorizada y completar su enlace después de comprobar lectura y descarga. Los marcadores PENDIENTE son deliberados y no constituyen una entrega académica cerrada. Tras cualquier cambio documental, sincronizar ZIP, copias, inventario, hashes y la carpeta lista para Drive; nunca copiarla recursivamente dentro de sí misma.

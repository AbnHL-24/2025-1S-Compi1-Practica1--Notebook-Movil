# Script para generar analizadores léxico y sintáctico con JFlex y Cup

# Configuración de rutas
$projectRoot = Get-Location
$jflexJar = Join-Path $projectRoot "app\libs\jflex-full-1.9.1.jar"
$cupJar = Join-Path $projectRoot "app\libs\java-cup-11b.jar"
$flexFile = Join-Path $projectRoot "app\src\main\java\com\abnhl\notebook_movil\model\analizadores\codigo\CodeLexer.flex"
$cupFile = Join-Path $projectRoot "app\src\main\java\com\abnhl\notebook_movil\model\analizadores\codigo\CodeParser.cup"
$outputDir = Split-Path $flexFile -Parent

# Verificar existencia de archivos
if (-not (Test-Path $jflexJar)) {
    Write-Host "Error: No se encuentra JFlex JAR ($jflexJar)" -ForegroundColor Red
    exit 1
}

if (-not (Test-Path $cupJar)) {
    Write-Host "Error: No se encuentra Cup JAR ($cupJar)" -ForegroundColor Red
    exit 1
}

# Crear directorio de salida si no existe
if (-not (Test-Path $outputDir)) {
    New-Item -ItemType Directory -Path $outputDir | Out-Null
}

# Función para ejecutar comandos Java
function Invoke-JavaTool {
    param(
        [string]$toolName,
        [string]$jarPath,
        [string]$arguments
    )

    Write-Host "`nEjecutando $toolName..." -ForegroundColor Cyan
    Write-Host "Comando: java -jar `"$jarPath`" $arguments" -ForegroundColor DarkGray

    $process = Start-Process java -ArgumentList "-jar", "`"$jarPath`"", $arguments -NoNewWindow -Wait -PassThru

    if ($process.ExitCode -ne 0) {
        Write-Host "Error en la ejecución de $toolName (Código $($process.ExitCode))" -ForegroundColor Red
        exit $process.ExitCode
    }
}

# Generar analizador léxico con JFlex
Invoke-JavaTool -toolName "JFlex" -jarPath $jflexJar -arguments "-d `"$outputDir`" `"$flexFile`""

# Generar analizador sintáctico con Cup
Invoke-JavaTool -toolName "Cup" -jarPath $cupJar -arguments "-parser CodeParser -destdir `"$outputDir`" `"$cupFile`""

Write-Host "`nGeneración completada exitosamente!" -ForegroundColor Green
Write-Host "Archivos generados en: $outputDir" -ForegroundColor Yellow
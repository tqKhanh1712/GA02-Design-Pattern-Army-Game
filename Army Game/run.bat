@echo off
chcp 65001 > nul
cd /d "%~dp0"

echo [*] Compiling...
if not exist out mkdir out

set SOURCES=
for /r src %%f in (*.java) do set SOURCES=!SOURCES! "%%f"

setlocal enabledelayedexpansion
set SOURCES=
for /r src %%f in (*.java) do set SOURCES=!SOURCES! "%%f"
javac -encoding UTF-8 -d out %SOURCES%

if %errorlevel% neq 0 (
    echo [!] Compile that bai!
    pause
    exit /b 1
)

echo [*] Running Army Game...
echo.
java -Dfile.encoding=UTF-8 -cp out Main
pause


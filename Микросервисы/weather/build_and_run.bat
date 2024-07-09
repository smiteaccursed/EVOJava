@echo off
setlocal

echo.
echo ------------------
echo  Building package 
echo ------------------
echo.
call .\mvnw package

if %errorlevel% neq 0 (
    echo Maven build failed!
    pause
    exit /b %errorlevel%
)

for %%f in (.\target\*.jar) do (
	echo.
	echo -----------------
	echo  Running package 
	echo -----------------
	echo.
	echo Target jar: %%f
	echo.
	java -jar "%%f"
	exit /b
)

rem Если JAR файл не найден
echo Не удалось найти JAR файл в папке target!
pause
exit /b 1
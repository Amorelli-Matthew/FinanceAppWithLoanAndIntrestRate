@echo off
echo ============================================
echo Compiling FinancialApplicationWithLoanAndIntrestRate_Gui...

cd /d "%~dp0"

if not exist "out" mkdir "out"

javac --module-path "%USERPROFILE%\Documents\javafx-sdk-24.0.1\lib" ^
      --add-modules javafx.controls,javafx.fxml ^
      -d "out" src\FinancialApplicationWithLoanAndIntrestRate_Gui\*.java
if errorlevel 1 (
    echo Compilation failed.
    pause
    exit /b 1
)

echo ✅ Compilation successful.
pause

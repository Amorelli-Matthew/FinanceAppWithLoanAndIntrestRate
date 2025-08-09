@echo off
echo ============================================
echo Running FinancialApplicationWithLoanAndIntrestRate_Gui...

cd /d "%~dp0"

if not exist "out" (
    echo 'out' folder not found. Run compile.bat first.
    pause
    exit /b 1
)

pushd "out"
java --module-path "%USERPROFILE%\Documents\javafx-sdk-24.0.1\lib" ^
     --add-modules javafx.controls,javafx.fxml ^
     -cp . FinancialApplicationWithLoanAndIntrestRate_Gui.FinancialApplicationWithLoanAndIntrestRate_Gui
set "_APP_RC=%ERRORLEVEL%"
popd

echo.
echo Done.
pause

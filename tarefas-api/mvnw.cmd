@ECHO OFF
SETLOCAL

REM %~dp0 sempre termina com "\". Se a gente colocar isso dentro de aspas em uma
REM propriedade -D, a barra final pode "escapar" a aspa e quebrar os argumentos.
REM Então removemos a "\" final.
SET "MAVEN_PROJECTBASEDIR=%~dp0"
IF "%MAVEN_PROJECTBASEDIR:~-1%"=="\" SET "MAVEN_PROJECTBASEDIR=%MAVEN_PROJECTBASEDIR:~0,-1%"

SET "WRAPPER_DIR=%MAVEN_PROJECTBASEDIR%\.mvn\wrapper"
SET "WRAPPER_JAR=%WRAPPER_DIR%\maven-wrapper.jar"

IF NOT EXIST "%WRAPPER_DIR%\maven-wrapper.properties" (
  ECHO Missing %WRAPPER_DIR%\maven-wrapper.properties
  EXIT /B 1
)

IF NOT EXIST "%WRAPPER_JAR%" (
  ECHO Missing %WRAPPER_JAR%
  EXIT /B 1
)

SET "JAVA_EXE=java"
IF NOT "%JAVA_HOME%"=="" (
  IF EXIST "%JAVA_HOME%\bin\java.exe" SET "JAVA_EXE=%JAVA_HOME%\bin\java.exe"
)

"%JAVA_EXE%" -classpath "%WRAPPER_JAR%" -Dmaven.multiModuleProjectDirectory="%MAVEN_PROJECTBASEDIR%" org.apache.maven.wrapper.MavenWrapperMain %*
ENDLOCAL


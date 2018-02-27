@echo off
TITLE Aion Lightning - Game Server Console
REM SET PATH="Type here your path to java jdk/jre (including bin folder)."
REM NOTE: Remove tag REM from previous line.
:START
CLS

echo.

echo Starting Aion Lightning Version 4.6 Game Server.

echo.

REM -------------------------------------
REM Default parameters for a basic server.
java -Xms512m -Xmx2048m -XX:MaxNewSize=24m -XX:NewSize=24m -XX:+UseParNewGC -XX:+CMSParallelRemarkEnabled -XX:+UseConcMarkSweepGC -XX:-UseSplitVerifier -ea -javaagent:./libs/al-commons.jar -cp ./libs/*;AL-Game.jar com.aionemu.gameserver.GameServer
REM -------------------------------------

SET CLASSPATH=%OLDCLASSPATH%

if ERRORLEVEL 2 goto restart
if ERRORLEVEL 1 goto error
if ERRORLEVEL 0 goto end

REM Restart...
:restart
echo.
echo Administrator Restart ...
echo.
goto start

REM Error...
:error
echo.
echo Server terminated abnormaly ...
echo.
goto end

REM End...
:end
echo.
echo Server terminated ...
echo.
pause

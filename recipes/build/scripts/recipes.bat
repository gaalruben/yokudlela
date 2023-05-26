@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%"=="" @echo off
@rem ##########################################################################
@rem
@rem  recipes startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and RECIPES_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if %ERRORLEVEL% equ 0 goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\recipes-1.0-SNAPSHOT-plain.jar;%APP_HOME%\lib\spring-boot-starter-data-jpa-2.7.4.jar;%APP_HOME%\lib\guava-31.1-jre.jar;%APP_HOME%\lib\keycloak-spring-boot-starter-21.1.1.jar;%APP_HOME%\lib\keycloak-spring-boot-2-adapter-21.1.1.jar;%APP_HOME%\lib\spring-boot-starter-web-2.7.4.jar;%APP_HOME%\lib\spring-boot-starter-json-2.7.4.jar;%APP_HOME%\lib\keycloak-spring-security-adapter-21.1.1.jar;%APP_HOME%\lib\springdoc-openapi-ui-1.5.10.jar;%APP_HOME%\lib\webjars-locator-core-0.45.jar;%APP_HOME%\lib\keycloak-policy-enforcer-21.1.1.jar;%APP_HOME%\lib\keycloak-authz-client-21.1.1.jar;%APP_HOME%\lib\keycloak-spring-boot-adapter-core-21.1.1.jar;%APP_HOME%\lib\spring-boot-container-bundle-21.1.1.jar;%APP_HOME%\lib\keycloak-adapter-core-21.1.1.jar;%APP_HOME%\lib\keycloak-crypto-default-21.1.1.jar;%APP_HOME%\lib\keycloak-core-21.1.1.jar;%APP_HOME%\lib\jackson-datatype-jdk8-2.13.4.jar;%APP_HOME%\lib\jackson-module-parameter-names-2.13.4.jar;%APP_HOME%\lib\springdoc-openapi-webmvc-core-1.5.10.jar;%APP_HOME%\lib\springdoc-openapi-common-1.5.10.jar;%APP_HOME%\lib\swagger-integration-2.1.10.jar;%APP_HOME%\lib\swagger-core-2.1.10.jar;%APP_HOME%\lib\jackson-dataformat-yaml-2.13.4.jar;%APP_HOME%\lib\jackson-core-2.13.4.jar;%APP_HOME%\lib\swagger-models-2.1.10.jar;%APP_HOME%\lib\jackson-annotations-2.13.4.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.12.6.jar;%APP_HOME%\lib\jackson-databind-2.12.6.jar;%APP_HOME%\lib\spring-boot-starter-validation-2.7.4.jar;%APP_HOME%\lib\spring-boot-starter-aop-2.7.4.jar;%APP_HOME%\lib\spring-boot-starter-jdbc-2.7.4.jar;%APP_HOME%\lib\spring-boot-starter-2.7.4.jar;%APP_HOME%\lib\modelmapper-3.1.1.jar;%APP_HOME%\lib\spring-data-jpa-2.7.3.jar;%APP_HOME%\lib\spring-orm-5.3.23.jar;%APP_HOME%\lib\spring-jdbc-5.3.12.jar;%APP_HOME%\lib\commons-beanutils-1.9.2.jar;%APP_HOME%\lib\swagger-annotations-2.2.10.jar;%APP_HOME%\lib\classgraph-4.8.69.jar;%APP_HOME%\lib\h2-2.1.214.jar;%APP_HOME%\lib\jakarta.transaction-api-1.3.3.jar;%APP_HOME%\lib\jakarta.persistence-api-2.2.3.jar;%APP_HOME%\lib\hibernate-core-5.6.11.Final.jar;%APP_HOME%\lib\spring-aspects-5.3.23.jar;%APP_HOME%\lib\failureaccess-1.0.1.jar;%APP_HOME%\lib\listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;%APP_HOME%\lib\jsr305-3.0.2.jar;%APP_HOME%\lib\checker-qual-3.12.0.jar;%APP_HOME%\lib\error_prone_annotations-2.11.0.jar;%APP_HOME%\lib\j2objc-annotations-1.3.jar;%APP_HOME%\lib\spring-boot-autoconfigure-2.7.4.jar;%APP_HOME%\lib\spring-boot-2.7.4.jar;%APP_HOME%\lib\spring-boot-starter-logging-2.7.4.jar;%APP_HOME%\lib\spring-boot-starter-tomcat-2.7.4.jar;%APP_HOME%\lib\jakarta.annotation-api-1.3.5.jar;%APP_HOME%\lib\spring-webmvc-5.3.23.jar;%APP_HOME%\lib\spring-web-5.3.23.jar;%APP_HOME%\lib\spring-tx-5.3.23.jar;%APP_HOME%\lib\spring-context-5.3.23.jar;%APP_HOME%\lib\spring-aop-5.3.23.jar;%APP_HOME%\lib\spring-data-commons-2.7.3.jar;%APP_HOME%\lib\spring-beans-5.3.23.jar;%APP_HOME%\lib\spring-expression-5.3.23.jar;%APP_HOME%\lib\spring-core-5.3.23.jar;%APP_HOME%\lib\snakeyaml-1.30.jar;%APP_HOME%\lib\tomcat-embed-el-9.0.65.jar;%APP_HOME%\lib\hibernate-validator-6.2.5.Final.jar;%APP_HOME%\lib\mysql-connector-j-8.0.33.jar;%APP_HOME%\lib\swagger-ui-3.51.1.jar;%APP_HOME%\lib\keycloak-server-spi-private-21.1.1.jar;%APP_HOME%\lib\httpclient-4.5.13.jar;%APP_HOME%\lib\commons-logging-1.2.jar;%APP_HOME%\lib\commons-collections-3.2.1.jar;%APP_HOME%\lib\HikariCP-4.0.3.jar;%APP_HOME%\lib\logback-classic-1.2.11.jar;%APP_HOME%\lib\log4j-to-slf4j-2.17.2.jar;%APP_HOME%\lib\jul-to-slf4j-1.7.36.jar;%APP_HOME%\lib\slf4j-api-1.7.36.jar;%APP_HOME%\lib\aspectjweaver-1.9.7.jar;%APP_HOME%\lib\hibernate-commons-annotations-5.1.2.Final.jar;%APP_HOME%\lib\jboss-logging-3.4.3.Final.jar;%APP_HOME%\lib\byte-buddy-1.12.17.jar;%APP_HOME%\lib\antlr-2.7.7.jar;%APP_HOME%\lib\jandex-2.4.2.Final.jar;%APP_HOME%\lib\classmate-1.5.1.jar;%APP_HOME%\lib\jaxb-runtime-2.3.6.jar;%APP_HOME%\lib\spring-jcl-5.3.23.jar;%APP_HOME%\lib\tomcat-embed-websocket-9.0.65.jar;%APP_HOME%\lib\tomcat-embed-core-9.0.65.jar;%APP_HOME%\lib\jakarta.validation-api-2.0.2.jar;%APP_HOME%\lib\keycloak-adapter-spi-21.1.1.jar;%APP_HOME%\lib\bcpkix-jdk15on-1.70.jar;%APP_HOME%\lib\bcutil-jdk15on-1.70.jar;%APP_HOME%\lib\bcprov-jdk15on-1.70.jar;%APP_HOME%\lib\jakarta.xml.bind-api-2.3.3.jar;%APP_HOME%\lib\txw2-2.3.6.jar;%APP_HOME%\lib\istack-commons-runtime-3.0.12.jar;%APP_HOME%\lib\keycloak-common-21.1.1.jar;%APP_HOME%\lib\jakarta.activation-1.2.2.jar;%APP_HOME%\lib\logback-core-1.2.11.jar;%APP_HOME%\lib\log4j-api-2.17.2.jar;%APP_HOME%\lib\commons-lang3-3.12.0.jar;%APP_HOME%\lib\httpcore-4.4.15.jar;%APP_HOME%\lib\commons-codec-1.15.jar;%APP_HOME%\lib\keycloak-server-spi-21.1.1.jar


@rem Execute recipes
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %RECIPES_OPTS%  -classpath "%CLASSPATH%" yokudlela.recipes.SpringApplication %*

:end
@rem End local scope for the variables with windows NT shell
if %ERRORLEVEL% equ 0 goto mainEnd

:fail
rem Set variable RECIPES_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
set EXIT_CODE=%ERRORLEVEL%
if %EXIT_CODE% equ 0 set EXIT_CODE=1
if not ""=="%RECIPES_EXIT_CONSOLE%" exit %EXIT_CODE%
exit /b %EXIT_CODE%

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega

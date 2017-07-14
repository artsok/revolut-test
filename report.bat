cd target\
rmdir allure-report /s /q
java -jar ..\lib\allure\lib\allure-cli.jar generate -v 1.4.5 allure-results
java -jar ..\lib\allure\lib\allure-cli.jar report open
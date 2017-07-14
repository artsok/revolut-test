# revolut-test
Revolut QA Mobile Test

# Для работы на локальной машине необходимо:
1) Установить Java 1.8;
2) Установить MAVEN;
3) Установить appium-desktop;
4) Установить android-sdk;
5) Установить haxm-windows (Для ускорения работы эмулятора);
6) Скачать image в SDK-Manager;
6) Создать Android Virtual Devide (AVD) - Android 6.0 API Level 23. Google APIs Intel Atom. Use HOST GPU.
7) Установить apk на устройсво (adb install Revolut_qa_4.3.0.237.apk);

# Конфигурация проекта
Для конфигурации выполнения используются файлы .properties, расположенные в src\test\resources\config.
Основной файл - application.properties, в нем указываем основные настройки для запуска тестов.


# Запуск тестов
runTest.bat - запуск автотестов;

# Генерация отчета
Для генерации отчета необходимо запустить файл report.bat


# Тестовое задание от компании Revolut
# QA Test
# Preparation
1.	Download the latest Revolut Android app from here:
https://drive.google.com/file/d/0B-YFwMlhFxhdRnBDcS1qV2N2YTA/view?usp=sharing
2.	Login using the test account +44662266 pass 1111
3.	You can also sign up for more test accounts using any random phone number starting with +44.
4.	You can “top up” using one of these test cards:

Card Type		Card Number		3D Secure Enabled
Visa	4530910000012345	n
	    4510150000000321	n
	    4107857757053670	y

Expiry Date: When using the test card numbers, you can use any date in the future for the expiry date (e.g., 11/18).


# Test:
1.	MAIN TEST: Design a full set of regression tests for the “Add new beneficiary” flow (accessed from the main bottom menu button (purple) -> “To bank account”).

2.	BONUS POINTS: Find as many bugs as you can. Put together a document detailing these bugs in whatever way you see fit.

3.	Put together a document detailing these tests in whatever way you see fit


Automate prepared test suite with a testing automation toolkit for iOS/Android of your choice (e.g. https://www.quora.com/What-is-the-best-Mobile-App-Testing-Tool-like-TestFairy-for-iPhone-and-Android)

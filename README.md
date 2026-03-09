# File Filter Utility (Java)

Утилита для фильтрации  содержимого файлов по типу данных

## Требования

- Java 17+
- Windows / Linux / Mac с установленным JDK

## Структура проекта


file-filter-utility/
    examples/
       in1.txt
       in2.txt
    src/
        filter/
            Main.java
            FileProcessor.java
            OutputManager.java
            Statistics.java
    manifest.txt
    README.md


- Входные файлы (`in1.txt`, `in2.txt`) в `examples/`.
- Выходные файлы идут  в папку, указанную  через `-o`.

## Компиляция

В корне проекта

```bash
javac -d out src/filter/*.java
```

-d out - папка для .class файлов с пакетами.

Создание JAR
jar cfm uXl.jar manifest.txt -C out .   (manifest.txt указывает, какой класс содержит main())



Запуск
java -jar uXl.jar -s -a -p sample- examples/in1.txt examples/in2.txt -o examples/output


-s - краткая статистика (количество элементов)

-f - полная статистика (количество, min/max, сумма, среднее, длина строк)

-a - добавление к существующим файлам

-p <prefix> - префикс для выходных файлов (sample- → sample-integers.txt)

-o <path> - путь для сохранения файлов (создаётся автоматически, если нет)

Пример

Запуск:

java -jar uXl.jar -s -a -p sample- examples/in1.txt examples/in2.txt -o examples/output

Выходные файлы:

examples/output/sample-integers.txt
examples/output/sample-floats.txt
examples/output/sample-strings.txt

Статистика будет выведена в консоль.
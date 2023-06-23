## Rpn-Calculator
- постфиксная (https://ru.wikipedia.org/wiki/Обратная_польская_запись)
- Аналог bc. Арифметика (+ - * / ^) и элементарные функции от одного вещественного аргумента (sin, cos, tan, log, log10, log2). Будет преимуществом: поддержка вещественных чисел с произвольной точностью (см. java.lang.BigDecimal)
- Калькулятор должен позволять легко (минимальным изменением кода) добавлять новые операторы [, бонус — и с более чем 2 аргументами тоже]

GET test

ex) http://localhost:8080/test

# How to use?
    > Build the jar.
    > 
    >   mvn clean compile package
    > cd target
    >
    > Execute the jar with arguments:
    > 
    > java -jar hse-0.0.1-SNAPSHOT.jar 
    > 
    > firstNumber secondNumber operation
    > 
    > 1 1 +
    >
    > 1 1 /
    >
    > 2 ^
    >
    > 1 cos
    > 
    > q (quit)
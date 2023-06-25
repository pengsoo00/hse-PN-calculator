## Rpn-Calculator
- постфиксная (https://ru.wikipedia.org/wiki/Обратная_польская_запись)
- Аналог bc. Арифметика (+ - * / ^) и элементарные функции от одного вещественного аргумента (sin, cos, tan, log, log10, log2). Будет преимуществом: поддержка вещественных чисел с произвольной точностью (см. java.lang.BigDecimal)
- Калькулятор должен позволять легко (минимальным изменением кода) добавлять новые операторы [, бонус — и с более чем 2 аргументами тоже]

# How to use?
    # Build the file.jar
    > mvn clean compile package
    > cd target

    # Execute the jar:
    > java -jar hse-0.0.1-SNAPSHOT.jar

    # firstNumber secondNumber operation 
    Example:
    > 1 1 +
      [1]
      [1, 1]
      [2]
    
    > 1 2 /
      [1, 2]
      [2, 1, 2]
      [0.5000000000, 2]

    > 2 ^
      [0.25000000000000000000, 2]

    > cos
      [0.9689124217106447, 2]

    > q (quit)

# Command line application in a Docker container
    > docker container run -it pengs00/docker-rpn-calculator:firsttry

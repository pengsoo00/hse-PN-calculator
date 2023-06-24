## Rpn-Calculator
- постфиксная (https://ru.wikipedia.org/wiki/Обратная_польская_запись)
- Аналог bc. Арифметика (+ - * / ^) и элементарные функции от одного вещественного аргумента (sin, cos, tan, log, log10, log2). Будет преимуществом: поддержка вещественных чисел с произвольной точностью (см. java.lang.BigDecimal)
- Калькулятор должен позволять легко (минимальным изменением кода) добавлять новые операторы [, бонус — и с более чем 2 аргументами тоже]

GET test

ex) http://localhost:8080/test

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
    # Build the jar.
    > mvn clean compile package
    
    # Build the image.
    > docker build -f src/main/docker/Dockerfile.jvm -t spring/calculator-jvm .
    
    # View your created image.
    > docker images | grep spring/calculator-jvm
    
    # Run the container using.
    > docker run -i --rm -p 8080:8080 -e FIRST=1 -e OPERATION=+ -e SECOND=2 spring/calculator-jvm
    
    # Remove your image.
    > docker rmi spring/calculator-jvm
    
    # Clean up any resources — images, containers, volumes, and networks — that are dangling (not tagged or associated with a container).
    > docker system prune
Simple Examples
========================================

Simple examples for [Doma](https://github.com/domaframework/doma).

Environment
------------

* `DOMA2_DIALECT`: `H2` or `PostgreSQL`
* `DOMA2_DATASOURCE_URL`: datasource url
    * e.g. `jdbc:postgresql://localhost:5432/doma_json`
* `DOMA2_DATASOURCE_USERNAME`: datasource username
* `DOMA2_DATASOURCE_PASSWORD`: datasource password

Java version
------------

You need Java 11 or later.

Build
-----

```bash
$ ./gradlew build
```

Import the project into your IDE
--------------------------------

### IDEA

Import the project as a Gradle project.


何のテスト？
-------

JSON 型を doma2 で扱う動作確認。
H2 と PostgreSQL で検証している。


License
-------

Apache License, Version 2.0

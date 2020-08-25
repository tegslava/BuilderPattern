# Задача Люди

## Описание
В этом задании попрактикуемся с шаблоном *Builder* (*Строитель*). Мы спроектируем класс `Person`, в котором будут храниться данные о человеке:
* **Имя** (`String`). Каждый человек обязан иметь имя, причём с момента создания объекта изменить его нельзя.
* **Фамилия** (`String`). Каждый человек обязан иметь фамилию, причём с момента создания объекта изменить её нельзя.
* **Возраст** (`int`). Если возраст человека известен, то с момента создания объекта он может быть изменён только увеличением на единицу через вызов метода `happyBirthday()`. Возраст человека может быть неизвестен, в этом случае метод `boolean hasAge()` должен вернуть `false`, иначе - `true`. Подумайте, как эффективнее хранить в объекте информацию о том, известен ли возраст человека.
* **Текущий город жительства** (`String`). Может быть известен (в этом случае метод `boolean hasAddress()` должен вернуть `true`, иначе - `false`) и выставлен в любой через `setAddress(String city)`.

Все данные о человеке должны быть доступны через соответствующие методы (например, `String getName()`), поля же класса не должны быть `public`. 

Также надо создать класс `PersonBuilder` для конструирования объектов класса `Person`. Объекту этого класса (далее - *билдер*) можно выставлять любые данные для будущего объекта класса `Person` через методы (например, `setName(String name)`). И в этом объекте будет метод `Person build()`, возвращающий объект класса `Person` с указанными билдеру данными. В случае, если мы билдеру не указали достаточное количество данных (например, не указали фамилию), то метод `build()` должен выкинуть `IllegalStateException` с осмысленным сообщением. Если же мы передали неподходящие данные билдеру (например, некорректный возрст `builder.setAge(-100)`), то именно этот метод должен выкинуть `IllegalArgumentException` с осмысленным сообщением. Каждый метод добавления данных в билдер должен возвращать самого себя чтобы можно было сделать, например, вот так:
```java
Person person = new PersonBuilder()
                  .setName("Антошка")
                  .setSurname("Лопатов")
                  .setAge(48)
                  .build();
```

Также в класс `Person` надо добавить метод `PersonBuilder newChildBuilder()`, который будет возвращать полузаполненный билдер для ребёнка, а именно: с уже заполненными фамилией (родительской), возрастом и текущим городом жительства (родительским).

Продемонстрируйте работу ваших классов в классе `Main` (необязательно реализовывать ввод данных от пользователя).

## Отчет о запуске программы

> 23:01:37: Executing task 'Main.main()'... <br/>
><br/>
> Starting Gradle Daemon...<br/>
> Gradle Daemon started in 2 s 787 ms<br/>
> Task :compileJava UP-TO-DATE<br/>
> Task :processResources NO-SOURCE<br/>
> Task :classes UP-TO-DATE<br/>
><br/>
> Task :Main.main()<br/>
> У Person{name='Анна', surname='Вольф', age=31, address=Сидней} есть сын, Person{name='Антошка', surname='Вольф', address=Сидней}<br/>
> java.lang.IllegalStateException: Не задано обязательное поле �?мя<br/>
> 	at creational.PersonBuilder.build(PersonBuilder.java:40)<br/>
> 	at Main.main(Main.java:20)<br/>
> java.lang.IllegalArgumentException: Недопустимое значение возраста -100<br/>
> 	at creational.PersonBuilder.setAge(PersonBuilder.java:25)<br/>
> 	at Main.main(Main.java:27)<br/>
> <br/>
> Deprecated Gradle features were used in this build, making it incompatible with Gradle 7.0.<br/>
> Use '--warning-mode all' to show the individual deprecation warnings.<br/>
> See https://docs.gradle.org/6.3/userguide/command_line_interface.html#sec:command_line_warnings<br/>
> <br/>
> BUILD SUCCESSFUL in 8s <br/>
> 2 actionable tasks: 1 executed, 1 up-to-date <br/>
> 
> 23:01:48: Task execution finished 'Main.main()'.<br/>
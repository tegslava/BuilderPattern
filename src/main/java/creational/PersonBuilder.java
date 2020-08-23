package creational;

public class PersonBuilder implements IPersonBuilder {
    private String name;
    private String surname;
    private String address;
    private int age = -1;

    public PersonBuilder setName(String name) {
        if ((name == null) || name.trim().length() == 0)
            throw new IllegalArgumentException(String.format("Недопустимое значение имени %s", name));
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if ((surname == null) || surname.trim().length() == 0)
            throw new IllegalArgumentException(String.format("Недопустимое значение фамилии %s", surname));
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if ((age < 0) || (age > 100))
            throw new IllegalArgumentException(String.format("Недопустимое значение возраста %d", age));

        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        if ((address == null) || address.trim().length() == 0)
            throw new IllegalArgumentException(String.format("Недопустимое значение адреса %s", address));
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null)
            throw new IllegalStateException("Не задано обязательное поле Имя");
        if (surname == null)
            throw new IllegalStateException("Не задано обязательное поле Фамилия");
        Person person;
        if (age == -1) {
            person = new Person(name, surname);
        } else
            person = new Person(name, surname, age);
        if (address != null) person.setAddress(address);
        return person;
    }
}

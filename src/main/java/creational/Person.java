package creational;

import java.util.Objects;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age = -1;
    protected String address = null;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        return (age >= 0);
    }

    public boolean hasAddress() {
        return (address != null);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void happyBirthday() {
        this.age += 1;
    }

    public void setAddress(String city) {
        this.address = city;
    }

    @Override
    public String toString() {
        String res = String.format("Person{name='%s', surname='%s'", this.name, this.surname);
        if (this.age != -1) res = String.format("%s, age=%d", res, age);
        if (this.address != null) res = String.format("%s, address=%s", res, address);
        return res += "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder personBuilder = new PersonBuilder();
        personBuilder.setSurname(this.surname);
        personBuilder.setAddress(this.address);
        return personBuilder;
    }
}

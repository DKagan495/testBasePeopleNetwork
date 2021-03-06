package By.Kagan.DAOtest.Models;

public class Person {
    private int id;
    private String Name, Surname, Patronymic;

    public Person(int id, String name, String surname, String patronymic) {
        this.id = id;
        Name = name;
        Surname = surname;
        Patronymic = patronymic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getPatronymic() {
        return Patronymic;
    }

    public void setPatronymic(String patronymic) {
        Patronymic = patronymic;
    }
}

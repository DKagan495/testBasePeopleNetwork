package By.Kagan.DAOtest.Models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    private int id;
    @Min(value = 0, message = "Age can't be with minus")
    private int age;
    @NotEmpty(message = "Name is empty, we`re can`t create account of inattentive user. Fix your error, please.")
    @Size(min = 2, max = 20, message = "Invalid name. This name is not real!")
    private String Name;
    @NotEmpty(message = "Surname is empty, we`re can`t create account of inattentive user. Fix your error, please.")
    @Size(min = 2, max = 20, message = "Invalid surname. This name is not real!")
    private String Surname;
    @NotEmpty(message = "Patronymic is empty, we`re can`t create account of inattentive user. Fix your error, please.")
    @Size(min = 2, max = 20, message = "Invalid patronymic. This name is not real!")
    private String Patronymic;
    @NotEmpty(message = "Email is empty, we`re can`t create account of inattentive user. Fix your error, please.")
    @Email(message = "Email should be email(not random stack of symbols)")
    private String email;
    @NotEmpty(message = "Enter the password, foolish user!")
    @Size(min = 10, message = "Idiot, enter the password of 10 symbols and bigger! Now you`re password is not safe")
    private String password;

    public Person()
    {

    }
    public Person(int id, String name, String surname, String patronymic, String email, String password, int age) {
        this.id = id;
        this.email = email;
        this.age = age;
        this.password = password;
        Name = name;
        Surname = surname;
        Patronymic = patronymic;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

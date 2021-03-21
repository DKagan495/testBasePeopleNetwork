package By.Kagan.DAOtest.DAO;

import By.Kagan.DAOtest.Models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    static int IDENTIFIER = 0;
    private static final String URL = "jdbc:postgresql://localhost:1605/first_db";
    private static final String USERNAME = "postgres";
    public static final String PASSWORD = "daka16052002";
    private static Connection connection;
    static {
        try{
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException classNotFoundException)
        {
            classNotFoundException.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public List<Person> index()
    {
        List <Person> peopleList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT*FROM Person";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next())
            {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setAge(resultSet.getInt("age"));
                person.setName(resultSet.getString("name"));
                person.setSurname(resultSet.getString("surname"));
                person.setPatronymic(resultSet.getString("patronymic"));
                person.setEmail(resultSet.getString("email"));
                person.setPassword(resultSet.getString("password"));
                peopleList.add(person);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return peopleList;
    }
    public Person show(int id)
    {
       // return peopleList.stream().filter(Person->Person.getId()==id).findAny().orElse(null);
        return null;
    }
    public void toList(Person person)
    {
      //  person.setId(++IDENTIFIER);
        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO Person VALUES(" + 1 + ",'" + person.getAge() + "','" + person.getName() + "', '" + person.getSurname() + "', '" + person.getPatronymic() + "', '" + person.getEmail() + "', '" + person.getPassword()+"')";
            statement.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
   /* public boolean log(Person person)
    {
        int iterator = 0;
        for(int i = 0; i < peopleList.size(); i++)
        {
           if(peopleList.get(i).getEmail().equals(person.getEmail()) && peopleList.get(i).getPassword().equals(person.getPassword()))
           {
               iterator++;
               break;
           }
        }
        if(iterator == 1)
            return true;
        else
            return false;
    }*/
    public void edit(int id, Person editedperson)
    {
     /*   Person personToEdit = show(id);
        personToEdit.setName(editedperson.getName());
        personToEdit.setSurname(editedperson.getSurname());
        personToEdit.setPatronymic(editedperson.getPatronymic());*/
    }
    public void deletePerson(int id)
    {
   //     peopleList.removeIf(person -> person.getId() == id);
    }
}

package By.Kagan.DAOtest.DAO;

import By.Kagan.DAOtest.Models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    static int IDENTIFIER = 0;
    public static boolean isPersonLogInSuccessful = false;
    private static final String URL = "jdbc:postgresql://localhost:1605/first_db";
    private static final String USERNAME = "postgres";
    public static final String PASSWORD = "daka16052002";
    public int logId = 0;
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
        List <Person> peopleList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select*from person");

            String SQL = "SELECT*FROM Person";
            ResultSet resultSet = preparedStatement.executeQuery();
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

        return peopleList.stream().filter(Person->Person.getId()==id).findAny().orElse(null);
        //return null;
    }
    public void toList(Person person)
    {
       int personId = 0;
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT*FROM Person";
            ResultSet resultSet = statement.executeQuery(SQL);
            while(resultSet.next())
            {
                Person person1 = new Person();
                person1.setId(resultSet.getInt("id"));
                personId = resultSet.getInt("id");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        person.setId(++personId);
        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO Person VALUES(" + person.getId() + ",'" + person.getAge() + "','" + person.getName() + "', '" + person.getSurname() + "', '" + person.getPatronymic() + "', '" + person.getEmail() + "', '" + person.getPassword()+"')";
            statement.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public boolean log(Person person)
    {
        int iterator = 0;
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT*FROM Person";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next())
            {
                Person logpers = new Person();
                logpers.setEmail(resultSet.getString("email"));
                logpers.setPassword(resultSet.getString("password"));
                if(logpers.getEmail().equals(person.getEmail()) && logpers.getPassword().equals(person.getPassword()))
                {
                    iterator++;
                    logId = logpers.getId();
                    break;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(iterator == 1) {
            isPersonLogInSuccessful = true;
            System.out.println(isPersonLogInSuccessful);
            person.setLogBool(true);
            return true;
        }
        else
        {
            person.setLogBool(false);
            return false;
        }
    }
    public void edit(int id, Person editedperson)
    {
       Person personToEdit = show(id);
        personToEdit.setName(editedperson.getName());
        personToEdit.setSurname(editedperson.getSurname());
        personToEdit.setPatronymic(editedperson.getPatronymic());
    }
    public void deletePerson(int id)
    {
        List <Person> peopleList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "DELETE*FROM Person WHERE Person.id = id";
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

       peopleList.removeIf(person -> person.getId() == id);

    }
}

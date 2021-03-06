package By.Kagan.DAOtest.DAO;

import By.Kagan.DAOtest.Models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private List<Person> peopleList;
    {
        peopleList = new ArrayList<>();
        peopleList.add(new Person(1, "Daniel", "Kagan", "Alexandrovi4"));
        peopleList.add(new Person(2, "Vladislav", "Zakrevski", "Vitaljevich"));
        peopleList.add(new Person(3, "Vladislav", "Korsak", "Unknown patronymic"));
        peopleList.add(new Person(4, "Alexander", "Kuzneatsov", "Aliexeyevich"));
        peopleList.add(new Person(5, "Roman", "Zhuravski", "Viktorovich"));
    }
    public List<Person> index()
    {
        return peopleList;
    }
    public Person show(int id)
    {
        return peopleList.stream().filter(Person->Person.getId()==id).findAny().orElse(null);
    }
}

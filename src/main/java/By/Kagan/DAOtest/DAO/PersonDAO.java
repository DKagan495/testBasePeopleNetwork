package By.Kagan.DAOtest.DAO;

import By.Kagan.DAOtest.Models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    static int IDENTIFIER = 0;
    private List<Person> peopleList;
    {
        peopleList = new ArrayList<>();
        peopleList.add(new Person(++IDENTIFIER, "Daniel", "Kagan", "Alexandrovi4"));
        peopleList.add(new Person(++IDENTIFIER, "Vladislav", "Zakrevski", "Vitaljevich"));
        peopleList.add(new Person(++IDENTIFIER, "Vladislav", "Korsak", "Unknown patronymic"));
        peopleList.add(new Person(++IDENTIFIER, "Alexander", "Kuzneatsov", "Aliexeyevich"));
        peopleList.add(new Person(++IDENTIFIER, "Roman", "Zhuravski", "Viktorovich"));
    }
    public List<Person> index()
    {
        return peopleList;
    }
    public Person show(int id)
    {
        return peopleList.stream().filter(Person->Person.getId()==id).findAny().orElse(null);
    }
    public void toList(Person person)
    {
        person.setId(++IDENTIFIER);
        peopleList.add(person);
    }
    public boolean log(Person person)
    {
        int iterator = 0;
        for(int i = 0; i < IDENTIFIER; i++)
        {
           if(peopleList.get(i).getName().equals(person.getName()) && peopleList.get(i).getSurname().equals(person.getSurname()))
           {
               iterator++;
               break;
           }
        }
        if(iterator == 1)
            return true;
        else
            return false;
    }
    public void edit(int id, Person editedperson)
    {
        Person personToEdit = show(id);
        personToEdit.setName(editedperson.getName());
        personToEdit.setSurname(editedperson.getSurname());
        personToEdit.setPatronymic(editedperson.getPatronymic());
    }
}

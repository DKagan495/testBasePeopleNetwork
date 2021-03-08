package By.Kagan.DAOtest.Controllers;

import By.Kagan.DAOtest.DAO.PersonDAO;
import By.Kagan.DAOtest.Models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonDAO personDAO;
    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model)
    {
        //get all people list with DAO
        model.addAttribute("people", personDAO.index());
        return "index";
    }
    @GetMapping("/{id}")
    public String concretePerson(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("person", personDAO.show(id));
        return "concperson";
    }
    @GetMapping("/registration")
    public String newPerson(Model model)
    {
        model.addAttribute("person", new Person());
        return "RegistrastionForm";
    }
   /* @PostMapping()
    public String create(@ModelAttribute("person") Person person)
    {
        personDAO.toList(person);
        return "redirect:/people";
    }*/
    @GetMapping("/login")
    public String login(Model model)
    {
        model.addAttribute("person", new Person());
        return "loginform";
    }
    @PostMapping()
    public String tologin(@ModelAttribute("person") Person person)
    {
        if(!personDAO.log(person))
        {
            return "redirect:/failedform";
        }
        else
        {
            return "redirect:/people";
        }
    }
}
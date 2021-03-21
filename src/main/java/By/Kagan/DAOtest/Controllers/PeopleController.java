package By.Kagan.DAOtest.Controllers;

import By.Kagan.DAOtest.DAO.PersonDAO;
import By.Kagan.DAOtest.Models.Person;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return "RegistrastionForm";
            personDAO.toList(person);
            return "redirect:/people";
    }
    @GetMapping("/login")
    public String login(Model model)
    {
        model.addAttribute("person", new Person());
        return "loginform";
    }
    @GetMapping("/logfail")
    public String failog()
    {
        return "failure";
    }
    @PostMapping("/dologin")
    public String tologin(@ModelAttribute("person") Person person)
    {
   /*     if(!personDAO.log(person))
        {
            return "redirect:/people/logfail";
        }
        else
        {
            return "redirect:/people";
        }*/
        return null;
    }
    @GetMapping("/{id}/edit")
    public String doEdit(Model model, @PathVariable("id") int id)
    {
        model.addAttribute("person", personDAO.show(id));
        return "editprofileform";
    }
    @PatchMapping("/{id}")
    public String edit(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult, @PathVariable("id") int id)
    {
        if (bindingResult.hasErrors())
            return "editprofileform";
        personDAO.edit(id, person);
        return "redirect:/people";
    }
    @DeleteMapping("/{id}")
    public String delete_account(@PathVariable("id") int id)
    {
        personDAO.deletePerson(id);
        return "redirect:/people";
    }
}

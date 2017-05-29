package control;

import models.Contacts;
import models.ContactsWithid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.ClientsService;
import service.ContactsService;


@Controller
public class ContactsController {

    private ContactsService contactsService;
    private ClientsService clientsService;

    @Autowired(required=true)
    @Qualifier(value="contactsService")
    public void setContactsService(ContactsService ps){
        this.contactsService = ps;
    }

    @Autowired(required=true)
    @Qualifier(value="clientsService")
    public void setClientsService(ClientsService ps){
        this.clientsService = ps;
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String listContacts(Model model) {
        model.addAttribute("contactsWithid", new ContactsWithid());
        model.addAttribute("listContacts", this.contactsService.listContacts());
        return "contacts";
    }

    //For add and update contacts both
    @RequestMapping(value= "/contacts/add", method = RequestMethod.POST)
    public String addContacts(@ModelAttribute("contactsWithid") ContactsWithid p) {
        Contacts a = new Contacts();
        a.setMail(p.getMail());
        a.setId(p.getId());
        a.setAddress(p.getAddress());
        a.setFirstName(p.getFirstName());
        a.setSecondName(p.getSecondName());
        a.setPhoneNumber(p.getPhoneNumber());
        a.setClient(clientsService.getClientsById(p.getClientId()));
        try {
            if (p.getId() == null) {
                //new contacts, add it
                this.contactsService.addContacts(a);
            } else {
                //existing contacts, call update
                this.contactsService.updateContacts(a);
            }
        } catch (Exception e) {
            return "error";
        }
        return "redirect:/contacts";

    }

    @RequestMapping("/contacts/remove/{id}")
    public String removeContacts(@PathVariable("id") Integer id){
        try {
            this.contactsService.removeContacts(id);
            return "redirect:/contacts";
        } catch (Exception e) {
            return "error";
        }
    }

    @RequestMapping("/contacts/edit/{id}")
    public String editContacts(@PathVariable("id") Integer id, Model model){
        Contacts a = this.contactsService.getContactsById(id);
        model.addAttribute("contacts", a);
        model.addAttribute("contactsWithid", new ContactsWithid(a));
        model.addAttribute("listContacts", this.contactsService.listContacts());
        return "contacts";
    }

}

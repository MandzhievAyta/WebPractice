package control;

import models.Clients;
import models.Individuals;
import models.IndividualsWithid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.AccountsService;
import service.ClientsService;
import service.ContactsService;
import service.IndividualsService;


@Controller
public class IndividualsController {

    private IndividualsService individualsService;
    private ClientsService clientsService;
    private AccountsService accountsService;
    private ContactsService contactsService;

    @Autowired(required=true)
    @Qualifier(value="individualsService")
    public void setIndividualsService(IndividualsService ps){
        this.individualsService = ps;
    }

    @Autowired(required=true)
    @Qualifier(value="clientsService")
    public void setClientsService(ClientsService ps){
        this.clientsService = ps;
    }

    @Autowired(required=true)
    @Qualifier(value="contactsService")
    public void setContactsService(ContactsService ps){
        this.contactsService = ps;
    }


    @Autowired(required=true)
    @Qualifier(value="accountsService")
    public void setAccountsService(AccountsService ps){
        this.accountsService = ps;
    }

    @RequestMapping(value = "/individuals", method = RequestMethod.GET)
    public String listIndividuals(Model model) {
        model.addAttribute("individualsWithid", new IndividualsWithid());
        model.addAttribute("listIndividuals", this.individualsService.listIndividuals());
        return "individuals";
    }

    //For add and update individuals both
    @RequestMapping(value= "/individuals/add", method = RequestMethod.POST)
    public String addIndividuals(@ModelAttribute("individualsWithid") IndividualsWithid p) {
        Individuals a = new Individuals();
        a.setId(p.getId());
        a.setFirstName(p.getFirstName());
        a.setSecondName(p.getSecondName());
        try {
            if (p.getId() == null) {
                //new individuals, add it
                Clients cl = new Clients();
                cl.setType(Clients.ClientType.individual);
                clientsService.addClients(cl);
                a.setClient(clientsService.getClientsById(cl.getId()));
                this.individualsService.addIndividuals(a);
            } else {
                a.setClient(clientsService.getClientsById(p.getClientId()));
                //existing individuals, call update
                this.individualsService.updateIndividuals(a);
                return "redirect:/individuals/edit/" + p.getId();
            }
        } catch (Exception e) {
            return "error";
        }
        return "redirect:/individuals";

    }

    @RequestMapping("/individuals/remove/{id}")
    public String removeIndividuals(@PathVariable("id") Integer id){
        try {
            this.individualsService.removeIndividuals(id);
            return "redirect:/individuals";
        } catch (Exception e) {
            return "error";
        }
    }

    @RequestMapping("/individuals/edit/{id}")
    public String editIndividuals(@PathVariable("id") Integer id, Model model){
        Individuals a = this.individualsService.getIndividualsById(id);
        model.addAttribute("individuals", a);
        model.addAttribute("individualsWithid", new IndividualsWithid(a));
        model.addAttribute("listIndividuals", this.individualsService.listIndividuals());
        model.addAttribute("listAccounts", this.accountsService.getAccountsByClientId(a.getClient().getId()));
        model.addAttribute("listContacts", this.contactsService.getContactsByClientId(a.getClient().getId()));
        return "individualsPersonal";
    }

}

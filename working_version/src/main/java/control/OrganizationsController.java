package control;

import models.Clients;
import models.Organizations;
import models.OrganizationsWithid;
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
import service.OrganizationsService;


@Controller
public class OrganizationsController {

    private OrganizationsService organizationsService;
    private ClientsService clientsService;
    private AccountsService accountsService;
    private ContactsService contactsService;

    @Autowired(required=true)
    @Qualifier(value="organizationsService")
    public void setOrganizationsService(OrganizationsService ps){
        this.organizationsService = ps;
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

    @RequestMapping(value = "/organizations", method = RequestMethod.GET)
    public String listOrganizations(Model model) {
        model.addAttribute("organizationsWithid", new OrganizationsWithid());
        model.addAttribute("listOrganizations", this.organizationsService.listOrganizations());
        return "organizations";
    }

    //For add and update organizations both
    @RequestMapping(value= "/organizations/add", method = RequestMethod.POST)
    public String addOrganizations(@ModelAttribute("organizationsWithid") OrganizationsWithid p) {
        Organizations a = new Organizations();
        a.setId(p.getId());
        a.setName(p.getName());
        try {
            if (p.getId() == null) {
                //new organizations, add it
                Clients cl = new Clients();
                cl.setType(Clients.ClientType.organization);
                clientsService.addClients(cl);
                a.setClient(clientsService.getClientsById(cl.getId()));
                this.organizationsService.addOrganizations(a);
            } else {
                a.setClient(clientsService.getClientsById(p.getClientId()));
                //existing organizations, call update
                this.organizationsService.updateOrganizations(a);
                return "redirect:/organizations/edit/" + p.getId();
            }
        } catch (Exception e) {
            return  "error";
        }
        return "redirect:/organizations";

    }

    @RequestMapping("/organizations/remove/{id}")
    public String removeOrganizations(@PathVariable("id") Integer id){
        try {
            this.organizationsService.removeOrganizations(id);
            return "redirect:/organizations";
        } catch (Exception e) {
            return "error";
        }
    }

    @RequestMapping("/organizations/edit/{id}")
    public String editOrganizations(@PathVariable("id") Integer id, Model model){
        Organizations a = this.organizationsService.getOrganizationsById(id);
        model.addAttribute("organizations", a);
        model.addAttribute("organizationsWithid", new OrganizationsWithid(a));
        model.addAttribute("listOrganizations", this.organizationsService.listOrganizations());
        model.addAttribute("listAccounts", this.accountsService.getAccountsByClientId(a.getClient().getId()));
        model.addAttribute("listContacts", this.contactsService.getContactsByClientId(a.getClient().getId()));
        return "organizationsPersonal";
    }

}

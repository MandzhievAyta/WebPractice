package control;

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
import service.ClientsService;
import service.IndividualsService;
import service.OrganizationsService;


@Controller
public class ClientsHomeController {

    private IndividualsService individualsService;
    private ClientsService clientsService;
    private OrganizationsService organizationsService;

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
    @Qualifier(value="organizationsService")
    public void setOrganizationsService(OrganizationsService ps){
        this.organizationsService = ps;
    }

    @RequestMapping(value = "/clientsHome", method = RequestMethod.GET)
    public String listClients(Model model) {
        model.addAttribute("listIndividuals", this.individualsService.listIndividuals());
        model.addAttribute("listOrganizations", this.organizationsService.listOrganizations());
        return "clientsHome";
    }
}

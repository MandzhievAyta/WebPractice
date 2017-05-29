package control;

import models.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.ClientsService;


@Controller
public class ClientsController {

    private ClientsService clientsService;

    @Autowired(required=true)
    @Qualifier(value="clientsService")
    public void setClientsService(ClientsService ps){
        this.clientsService = ps;
    }

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public String listClients(Model model) {
        model.addAttribute("clients", new Clients());
        model.addAttribute("listClients", this.clientsService.listClients());
        return "clients";
    }

    //For add and update clients both
    @RequestMapping(value= "/clients/add", method = RequestMethod.POST)
    public String addClients(@ModelAttribute("clients") Clients p) {

        if (p.getId() == null){
            //new clients, add it
            this.clientsService.addClients(p);
        }else{
            //existing clients, call update
            this.clientsService.updateClients(p);
        }

        return "redirect:/clients";

    }

    @RequestMapping("/clients/remove/{id}")
    public String removeClients(@PathVariable("id") Integer id){
        try {
            this.clientsService.removeClients(id);
            return "redirect:/clients";
        } catch (Exception e) {
            return "error";
        }
    }

    @RequestMapping("/clients/edit/{id}")
    public String editClients(@PathVariable("id") Integer id, Model model){
        model.addAttribute("clients", this.clientsService.getClientsById(id));
        model.addAttribute("listClients", this.clientsService.listClients());
        return "clients";
    }

}

package control;

import models.InternetTariffs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.InternetTariffsService;


@Controller
public class InternetTariffsController {

    private InternetTariffsService internetTariffsService;

    @Autowired(required=true)
    @Qualifier(value="internetTariffsService")
    public void setInternetTariffsService(InternetTariffsService ps){
        this.internetTariffsService = ps;
    }

    @RequestMapping(value = "/internetTariffs", method = RequestMethod.GET)
    public String listInternetTariffs(Model model) {
        model.addAttribute("internetTariffs", new InternetTariffs());
        model.addAttribute("listInternetTariffs", this.internetTariffsService.listInternetTariffs());
        return "internetTariffs";
    }

    //For add and update internetTariffs both
    @RequestMapping(value= "/internetTariffs/add", method = RequestMethod.POST)
    public String addInternetTariffs(@ModelAttribute("internetTariffs") InternetTariffs p) {

        if (p.getId() == null){
            //new internetTariffs, add it
            this.internetTariffsService.addInternetTariffs(p);
        }else{
            //existing internetTariffs, call update
            this.internetTariffsService.updateInternetTariffs(p);
        }

        return "redirect:/internetTariffs";

    }

    @RequestMapping("/internetTariffs/remove/{id}")
    public String removeInternetTariffs(@PathVariable("id") Integer id){
        try {
            this.internetTariffsService.removeInternetTariffs(id);
            return "redirect:/internetTariffs";
        } catch (Exception e) {
            return "error";
        }
    }

    @RequestMapping("/internetTariffs/edit/{id}")
    public String editInternetTariffs(@PathVariable("id") Integer id, Model model){
        model.addAttribute("internetTariffs", this.internetTariffsService.getInternetTariffsById(id));
        model.addAttribute("listInternetTariffs", this.internetTariffsService.listInternetTariffs());
        return "internetTariffs";
    }

}

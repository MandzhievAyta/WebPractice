package control;

import models.SmsTariffs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.SmsTariffsService;

@Controller
public class SmsTariffsController {

    private SmsTariffsService smsTariffsService;

    @Autowired(required=true)
    @Qualifier(value="smsTariffsService")
    public void setSmsTariffsService(SmsTariffsService ps){
        this.smsTariffsService = ps;
    }

    @RequestMapping(value = "/smsTariffs", method = RequestMethod.GET)
    public String listSmsTariffs(Model model) {
        model.addAttribute("smsTariffs", new SmsTariffs());
        model.addAttribute("listSmsTariffs", this.smsTariffsService.listSmsTariffs());
        return "smsTariffs";
    }

    //For add and update smsTariffs both
    @RequestMapping(value= "/smsTariffs/add", method = RequestMethod.POST)
    public String addSmsTariffs(@ModelAttribute("smsTariffs") SmsTariffs p) {

        if (p.getId() == null){
            //new smsTariffs, add it
            this.smsTariffsService.addSmsTariffs(p);
        }else{
            //existing smsTariffs, call update
            this.smsTariffsService.updateSmsTariffs(p);
        }

        return "redirect:/smsTariffs";

    }

    @RequestMapping("/smsTariffs/remove/{id}")
    public String removeSmsTariffs(@PathVariable("id") Integer id){
        try {
            this.smsTariffsService.removeSmsTariffs(id);
            return "redirect:/smsTariffs";
        } catch (Exception e) {
            return "error";
        }
    }

    @RequestMapping("/smsTariffs/edit/{id}")
    public String editSmsTariffs(@PathVariable("id") Integer id, Model model){
        model.addAttribute("smsTariffs", this.smsTariffsService.getSmsTariffsById(id));
        model.addAttribute("listSmsTariffs", this.smsTariffsService.listSmsTariffs());
        return "smsTariffs";
    }

}

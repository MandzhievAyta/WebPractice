package control;

import models.CallTariffs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CallTariffsService;


@Controller
public class CallTariffsController {

    private CallTariffsService callTariffsService;

    @Autowired(required=true)
    @Qualifier(value="callTariffsService")
    public void setCallTariffsService(CallTariffsService ps){
        this.callTariffsService = ps;
    }

    @RequestMapping(value = "/callTariffs", method = RequestMethod.GET)
    public String listCallTariffss(Model model) {
        model.addAttribute("callTariffs", new CallTariffs());
        model.addAttribute("listCallTariffs", this.callTariffsService.listCallTariffs());
        return "callTariffs";
    }

    //For add and update callTariffs both
    @RequestMapping(value= "/callTariffs/add", method = RequestMethod.POST)
    public String addCallTariffs(@ModelAttribute("callTariffs") CallTariffs p) {

        if (p.getId() == null){
            //new callTariffs, add it
            this.callTariffsService.addCallTariffs(p);
        }else{
            //existing callTariffs, call update
            this.callTariffsService.updateCallTariffs(p);
        }

        return "redirect:/callTariffs";

    }

    @RequestMapping("/callTariffs/remove/{id}")
    public String removeCallTariffs(@PathVariable("id") Integer id){
        try {
            this.callTariffsService.removeCallTariffs(id);
            return "redirect:/callTariffs";
        } catch (Exception e) {
            return "error";
        }
    }

    @RequestMapping("/callTariffs/edit/{id}")
    public String editCallTariffs(@PathVariable("id") Integer id, Model model){
        model.addAttribute("callTariffs", this.callTariffsService.getCallTariffsById(id));
        model.addAttribute("listCallTariffs", this.callTariffsService.listCallTariffs());
        return "callTariffs";
    }

}

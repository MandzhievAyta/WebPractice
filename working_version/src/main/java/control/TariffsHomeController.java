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
import service.*;


@Controller
public class TariffsHomeController {

    private SmsTariffsService smsTariffsService;
    private InternetTariffsService internetTariffsService;
    private CallTariffsService callTariffsService;

    @Autowired(required=true)
    @Qualifier(value="callTariffsService")
    public void setCallTariffsService(CallTariffsService ps){
        this.callTariffsService = ps;
    }

    @Autowired(required=true)
    @Qualifier(value="smsTariffsService")
    public void setSmsTariffsService(SmsTariffsService ps){
        this.smsTariffsService = ps;
    }


    @Autowired(required=true)
    @Qualifier(value="internetTariffsService")
    public void setInternetTariffsService(InternetTariffsService ps){
        this.internetTariffsService = ps;
    }

    @RequestMapping(value = "/tariffsHome", method = RequestMethod.GET)
    public String listTariffs(Model model) {
        model.addAttribute("listSmsTariffs", this.smsTariffsService.listSmsTariffs());
        model.addAttribute("listInternetTariffs", this.internetTariffsService.listInternetTariffs());
        model.addAttribute("listCallTariffs", this.callTariffsService.listCallTariffs());
        return "tariffsHome";
    }
}

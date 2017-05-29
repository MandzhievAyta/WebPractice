package control;

import models.ContractsHistory;
import models.ContractsHistoryWithid;
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
public class ContractsHistoryController {

    private ContractsHistoryService contractsHistoryService;
    private AccountsService accountsService;
    private CallTariffsService callTariffsService;
    private SmsTariffsService smsTariffsService;
    private InternetTariffsService internetTariffsService;

    @Autowired(required=true)
    @Qualifier(value="contractsHistoryService")
    public void setContractsHistoryService(ContractsHistoryService ps){
        this.contractsHistoryService = ps;
    }

    @Autowired(required=true)
    @Qualifier(value="accountsService")
    public void setAccountsService(AccountsService ps){
        this.accountsService = ps;
    }

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


    @RequestMapping(value = "/contractsHistory", method = RequestMethod.GET)
    public String listContractsHistory(Model model) {
        model.addAttribute("contractsHistoryWithid", new ContractsHistoryWithid());
        model.addAttribute("listContractsHistory", this.contractsHistoryService.listContractsHistory());
        return "contractsHistory";
    }

    //For add and update contractsHistory both
    @RequestMapping(value= "/contractsHistory/add", method = RequestMethod.POST)
    public String addContractsHistory(@ModelAttribute("contractsHistoryWithid") ContractsHistoryWithid p) {
        ContractsHistory a = new ContractsHistory();
        a.setId(p.getId());
        a.setDate(p.getDate());
        a.setRelevance(p.getRelevance());
        a.setTariffType(p.getTariffType());
        a.setTime(p.getTime());
        a.setAccount(accountsService.getAccountsById(p.getAccountId()));
        a.setCallTariff(callTariffsService.getCallTariffsById(p.getCallTariffId()));
        a.setSmsTariff(smsTariffsService.getSmsTariffsById(p.getSmsTariffId()));
        a.setInternetTariff(internetTariffsService.getInternetTariffsById(p.getInternetTariffId()));

        try {
            if (p.getId() == null) {
                //new contractsHistory, add it
                this.contractsHistoryService.addContractsHistory(a);
            } else {
                //existing contractsHistory, call update
                this.contractsHistoryService.updateContractsHistory(a);
            }
        } catch (Exception e) {
            return "error";
        }
        return "redirect:/contractsHistory";

    }

    @RequestMapping("/contractsHistory/remove/{id}")
    public String removeContractsHistory(@PathVariable("id") Integer id){
        try {
            this.contractsHistoryService.removeContractsHistory(id);
            return "redirect:/contractsHistory";
        } catch (Exception e) {
            return "error";
        }
    }

    @RequestMapping("/contractsHistory/edit/{id}")
    public String editContractsHistory(@PathVariable("id") Integer id, Model model){
        ContractsHistory a = this.contractsHistoryService.getContractsHistoryById(id);
        model.addAttribute("contractsHistory", a);
        model.addAttribute("contractsHistoryWithid", new ContractsHistoryWithid(a));
        model.addAttribute("listContractsHistory", this.contractsHistoryService.listContractsHistory());
        return "contractsHistory";
    }

}

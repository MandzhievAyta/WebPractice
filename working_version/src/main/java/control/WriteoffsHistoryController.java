package control;

import models.WriteoffsHistory;
import models.WriteoffsHistoryWithid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.AccountsService;
import service.ContractsHistoryService;
import service.WriteoffsHistoryService;


@Controller
public class WriteoffsHistoryController {

    private WriteoffsHistoryService writeoffsHistoryService;
    private ContractsHistoryService contractsHistoryService;
    private AccountsService accountsService;

    @Autowired(required=true)
    @Qualifier(value="writeoffsHistoryService")
    public void setWriteoffsHistoryService(WriteoffsHistoryService ps){
        this.writeoffsHistoryService = ps;
    }

    @Autowired(required=true)
    @Qualifier(value="accountsService")
    public void setAccountsService(AccountsService ps){
        this.accountsService = ps;
    }

    @Autowired(required=true)
    @Qualifier(value="contractsHistoryService")
    public void setContractsHistoryService(ContractsHistoryService ps){
        this.contractsHistoryService = ps;
    }

    @RequestMapping(value = "/writeoffsHistory", method = RequestMethod.GET)
    public String listWriteoffsHistory(Model model) {
        model.addAttribute("writeoffsHistoryWithid", new WriteoffsHistoryWithid());
        model.addAttribute("listWriteoffsHistory", this.writeoffsHistoryService.listWriteoffsHistory());
        return "writeoffsHistory";
    }

    //For add and update writeoffsHistory both
    @RequestMapping(value= "/writeoffsHistory/add", method = RequestMethod.POST)
    public String addWriteoffsHistory(@ModelAttribute("writeoffsHistoryWithid") WriteoffsHistoryWithid p) {

        try {
            WriteoffsHistory a = new WriteoffsHistory();
            a.setId(p.getId());
            a.setContractsHistory(contractsHistoryService.getContractsHistoryById(p.getContractsHistoryId()));
            a.setValue(p.getValue());
            a.setAccount(accountsService.getAccountsById(p.getAccountId()));
            a.setDate(p.getDate());
            a.setTime(p.getTime());
            if (p.getId() == null) {
                //new writeoffsHistory, add it
                this.writeoffsHistoryService.addWriteoffsHistory(a);
            } else {
                //existing writeoffsHistory, call update
                this.writeoffsHistoryService.updateWriteoffsHistory(a);
            }
        } catch (Exception e) {
            return "error";
        }
        return "redirect:/writeoffsHistory";

    }

    @RequestMapping("/writeoffsHistory/remove/{id}")
    public String removeWriteoffsHistory(@PathVariable("id") Integer id){
        try {
            this.writeoffsHistoryService.removeWriteoffsHistory(id);
            return "redirect:/writeoffsHistory";
        } catch (Exception e) {
            return "error";
        }
    }

    @RequestMapping("/writeoffsHistory/edit/{id}")
    public String editWriteoffsHistory(@PathVariable("id") Integer id, Model model){
        WriteoffsHistory a = this.writeoffsHistoryService.getWriteoffsHistoryById(id);
        model.addAttribute("writeoffsHistory", a);
        model.addAttribute("writeoffsHistoryWithid", new WriteoffsHistoryWithid(a));
        model.addAttribute("listWriteoffsHistory", this.writeoffsHistoryService.listWriteoffsHistory());
        return "writeoffsHistory";
    }

}

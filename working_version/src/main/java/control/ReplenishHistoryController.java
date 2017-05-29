package control;

import models.ReplenishHistory;
import models.ReplenishHistoryWithid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.AccountsService;
import service.ReplenishHistoryService;


@Controller
public class ReplenishHistoryController {

    private ReplenishHistoryService replenishHistoryService;
    private AccountsService accountsService;

    @Autowired(required=true)
    @Qualifier(value="replenishHistoryService")
    public void setReplenishHistoryService(ReplenishHistoryService ps){
        this.replenishHistoryService = ps;
    }

    @Autowired(required=true)
    @Qualifier(value="accountsService")
    public void setAccountsService(AccountsService ps){
        this.accountsService = ps;
    }

    @RequestMapping(value = "/replenishHistory", method = RequestMethod.GET)
    public String listReplenishHistory(Model model) {
        model.addAttribute("replenishHistoryWithid", new ReplenishHistoryWithid());
        model.addAttribute("listReplenishHistory", this.replenishHistoryService.listReplenishHistory());
        return "replenishHistory";
    }

    //For add and update replenishHistory both
    @RequestMapping(value= "/replenishHistory/add", method = RequestMethod.POST)
    public String addReplenishHistory(@ModelAttribute("replenishHistoryWithid") ReplenishHistoryWithid p) {
        ReplenishHistory a = new ReplenishHistory();
        a.setTime(p.getTime());
        a.setDate(p.getDate());
        a.setAmount(p.getAmount());
        a.setId(p.getId());
        a.setAccount(accountsService.getAccountsById(p.getAccountId()));
        try {
            if (p.getId() == null) {
                //new replenishHistory, add it
                this.replenishHistoryService.addReplenishHistory(a);
            } else {
                //existing replenishHistory, call update
                this.replenishHistoryService.updateReplenishHistory(a);
            }
        } catch (Exception e) {
            return "error";
        }
        return "redirect:/replenishHistory";

    }

    @RequestMapping("/replenishHistory/remove/{id}")
    public String removeReplenishHistory(@PathVariable("id") Integer id){
        try {
            this.replenishHistoryService.removeReplenishHistory(id);
            return "redirect:/replenishHistory";
        } catch (Exception e) {
            return "error";
        }
    }

    @RequestMapping("/replenishHistory/edit/{id}")
    public String editReplenishHistory(@PathVariable("id") Integer id, Model model){
        ReplenishHistory a = this.replenishHistoryService.getReplenishHistoryById(id);
        model.addAttribute("replenishHistory", a);
        model.addAttribute("replenishHistoryWithid", new ReplenishHistoryWithid(a));
        model.addAttribute("listReplenishHistory", this.replenishHistoryService.listReplenishHistory());
        return "replenishHistory";
    }

}

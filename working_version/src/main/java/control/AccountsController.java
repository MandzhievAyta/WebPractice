package control;

import models.Accounts;
import models.AccountsWithid;
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
public class AccountsController {

    private AccountsService accountsService;
    private ClientsService clientsService;
    private ContractsHistoryService contractsHistoryService;
    private WriteoffsHistoryService writeoffsHistoryService;
    private ReplenishHistoryService replenishHistoryService;

    @Autowired(required=true)
    @Qualifier(value="accountsService")
    public void setAccountsService(AccountsService ps){
        this.accountsService = ps;
    }


    @Autowired(required=true)
    @Qualifier(value="clientsService")
    public void setClientsService(ClientsService ps){
        this.clientsService = ps;
    }


    @Autowired(required=true)
    @Qualifier(value="contractsHistoryService")
    public void setContractsHistoryService(ContractsHistoryService ps){
        this.contractsHistoryService = ps;
    }


    @Autowired(required=true)
    @Qualifier(value="replenishHistoryService")
    public void setReplenishHistoryService(ReplenishHistoryService ps){
        this.replenishHistoryService = ps;
    }


    @Autowired(required=true)
    @Qualifier(value="writeoffsHistoryService")
    public void setWriteoffsHistoryService(WriteoffsHistoryService ps){
        this.writeoffsHistoryService = ps;
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public String listAccounts(Model model) {
        model.addAttribute("accountsWithid", new AccountsWithid());
        model.addAttribute("listAccounts", this.accountsService.listAccounts());
        return "accounts";
    }

    //For add and update accounts both
    @RequestMapping(value= "/accounts/add", method = RequestMethod.POST)
    public String addAccounts(@ModelAttribute("accountsWithid") AccountsWithid p) {
        Accounts a = new Accounts();
        a.setId(p.getId());
        a.setBalance(p.getBalance());
        a.setMaxDebt(p.getMaxDebt());
        a.setPayDebtDate(p.getPayDebtDate());
        a.setPayDebtTime(p.getPayDebtTime());
        a.setPhoneNumber(p.getPhoneNumber());
        a.setClient(clientsService.getClientsById(p.getClientId()));
        try {
            if (p.getId() == null) {
                //new accounts, add it
                this.accountsService.addAccounts(a);
            } else {
                //existing accounts, call update
                this.accountsService.updateAccounts(a);
                return "redirect:/accounts/edit/" + p.getId();
            }
        } catch (Exception e) {
            return "error";
        }
        return "redirect:/accounts";

    }

    @RequestMapping("/accounts/remove/{id}")
    public String removeAccounts(@PathVariable("id") Integer id){
        try {
            this.accountsService.removeAccounts(id);
            return "redirect:/accounts";
        } catch (Exception e) {
            return "error";
        }
    }

    @RequestMapping("/accounts/edit/{id}")
    public String editAccounts(@PathVariable("id") Integer id, Model model){
        Accounts a = this.accountsService.getAccountsById(id);
        model.addAttribute("accounts", a);
        model.addAttribute("accountsWithid", new AccountsWithid(a));
        model.addAttribute("listAccounts", this.accountsService.listAccounts());
        model.addAttribute("listReplenishHistory", this.replenishHistoryService.getReplenishHistoryByAccountId(id));
        model.addAttribute("listContractsHistory", this.contractsHistoryService.getContractsHistoryByAccountId(id));
        model.addAttribute("listWriteoffsHistory", this.writeoffsHistoryService.getWriteoffsHistoryByAccountId(id));
        return "accountsPersonal";
    }

}

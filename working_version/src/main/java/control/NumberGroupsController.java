package control;

import models.Accounts;
import models.NumberGroups;
import models.NumberGroupsWithid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.AccountsService;
import service.NumberGroupsService;


@Controller
public class NumberGroupsController {

    private NumberGroupsService numberGroupsService;
    private AccountsService accountsService;

    @Autowired(required=true)
    @Qualifier(value="numberGroupsService")
    public void setNumberGroupsService(NumberGroupsService ps){
        this.numberGroupsService = ps;
    }

    @Autowired(required=true)
    @Qualifier(value="accountsService")
    public void setAccountsService(AccountsService ps){
        this.accountsService = ps;
    }

    @RequestMapping(value = "/numberGroups", method = RequestMethod.GET)
    public String listNumberGroups(Model model) {
        model.addAttribute("numberGroupsWithid", new NumberGroupsWithid());
        model.addAttribute("listNumberGroups", this.numberGroupsService.listNumberGroups());
        return "numberGroups";
    }

    //For add and update numberGroups both
    @RequestMapping(value= "/numberGroups/add", method = RequestMethod.POST)
    public String addNumberGroups(@ModelAttribute("numberGroupsWithid") NumberGroupsWithid p) {
        NumberGroups a = new NumberGroups();
        a.setId(p.getId());
        a.setGroupNumber(p.getGroupNumber());
        a.setAccount(accountsService.getAccountsById(p.getAccountId()));
        try {
            if (p.getId() == null) {
                //new numberGroups, add it
                this.numberGroupsService.addNumberGroups(a);
            } else {
                //existing numberGroups, call update
                this.numberGroupsService.updateNumberGroups(a);
            }
        } catch (Exception e) {
            return "error";
        }
        return "redirect:/numberGroups";

    }

    @RequestMapping("/numberGroups/remove/{id}")
    public String removeNumberGroups(@PathVariable("id") Integer id){
        try {
            this.numberGroupsService.removeNumberGroups(id);
            return "redirect:/numberGroups";
        } catch (Exception e) {
            return "error";
        }
    }

    @RequestMapping("/numberGroups/edit/{id}")
    public String editNumberGroups(@PathVariable("id") Integer id, Model model){
        NumberGroups a = this.numberGroupsService.getNumberGroupsById(id);
        model.addAttribute("numberGroups", a);
        model.addAttribute("numberGroupsWithid", new NumberGroupsWithid(a));
        model.addAttribute("listNumberGroups", this.numberGroupsService.listNumberGroups());
        return "numberGroups";
    }

}

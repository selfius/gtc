package local.self.gtc.controller;

import local.self.gtc.model.Balance;
import local.self.gtc.service.TheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/gtc/")
public class TheController {

    @Autowired
    private TheService service;

    @RequestMapping(value = "{username}", method = GET)
    @ResponseBody
    public Balance balance(@PathVariable("username") String username) {
        //I know that using domain model as dto is bad.. fuck off
        return service.findOrCreateBalance(username);
    }
}

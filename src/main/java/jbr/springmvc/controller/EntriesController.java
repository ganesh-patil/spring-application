package jbr.springmvc.controller;

import com.sun.tracing.dtrace.ModuleAttributes;
import jbr.springmvc.model.Entries;
import jbr.springmvc.model.User;
import jbr.springmvc.service.EntriesHiberService;
import jbr.springmvc.service.UserHiberService;
import jbr.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class EntriesController {
    @Autowired
    private EntriesHiberService entriesHiberService;

    @Autowired
    private UserHiberService userHiberService;

    @RequestMapping(value = "entries", method = RequestMethod.GET)
    public ModelAndView listEntries(HttpServletRequest request){

        ModelAndView mav = new ModelAndView("entries");
        mav.addObject("entries", entriesHiberService.getAllEntries());
        return mav;
    }

    @RequestMapping(value = "entry/new", method = RequestMethod.GET)
    public ModelAndView addEntry()
    {
        ModelAndView mav = new ModelAndView("addEntry");
        mav.addObject("entry", new Entries());
        return mav;
    }


    @RequestMapping(value =  "entry/newProcess", method = RequestMethod.POST)
    public ModelAndView processEntry(@ModelAttribute("entry") Entries entry, RedirectAttributes redirectAttributes) throws Exception{
        ModelAndView mav;
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = userDetails.getUsername();

        User user   = userHiberService.getUserByUserName(userName);
        entry.setUser(user);
        entriesHiberService.addEntry(entry);
        entriesHiberService.sendEntryDetails(entry);
        mav = new ModelAndView("redirect:/entries");
        redirectAttributes.addFlashAttribute("success", "Entry added successfully");


//        mav = new ModelAndView("addEntry");
//        mav.addObject("error", "Errors while adding entries");
//        mav.addObject("entry", entry);
        return mav;

    }

}

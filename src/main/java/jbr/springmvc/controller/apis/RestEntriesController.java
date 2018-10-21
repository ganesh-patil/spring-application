package jbr.springmvc.controller.apis;

import jbr.springmvc.model.Entries;
import jbr.springmvc.model.User;
import jbr.springmvc.service.EntriesHiberService;
import jbr.springmvc.service.UserHiberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/entries")
public class RestEntriesController {

    @Autowired
    private EntriesHiberService entriesHiberService;
    @Autowired
    private UserHiberService userHiberService;

    @GetMapping
    public List getEntries(){
        return entriesHiberService.getAllEntries();
    }



    @PostMapping
    public  Entries addEntry(@RequestBody Entries entry){
        entry.setId(0);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = userDetails.getUsername();
        User user   = userHiberService.getUserByUserName(userName);
        entry.setUser(user);
        entriesHiberService.addEntry(entry);
        return entry;
   }

   @PutMapping
   public Entries editEntry(@RequestBody Entries entry){
        entriesHiberService.updateEntry(entry);
        return entry;
   }

   @DeleteMapping("/{entryId}")
    public String  deleteEntry(@PathVariable int entryId){
        entriesHiberService.deleteEntry(entryId);
        return  "Entry with id"+entryId+ "Deleted Successfully";
   }


}

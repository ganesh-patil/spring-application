package jbr.springmvc.controller.apis;

import jbr.springmvc.model.Entries;
import jbr.springmvc.service.EntriesHiberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/entries")
public class RestEntriesController {

    @Autowired
    private EntriesHiberService entriesHiberService;

    @GetMapping
    public List getEntries(){
     //   return entriesHiberService.getAllEntries();
        List entries = new ArrayList();
        entries.add(new Entries());
        entries.add(new Entries());
        entries.add(new Entries());
        return entries;
    }



    @PostMapping
    public  Entries addEntry(@RequestBody Entries entry){
        entry.setId(0);
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
//        Entries entry = entriesHiberService.getEntryById(entryId);
        entriesHiberService.deleteEntry(entryId);
        return  "Entry with id"+entryId+ "Deleted Successfully";
   }


}

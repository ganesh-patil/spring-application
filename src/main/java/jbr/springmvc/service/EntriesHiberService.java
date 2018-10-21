package jbr.springmvc.service;

import jbr.springmvc.dao.EntriesDao;
import jbr.springmvc.model.Entries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class EntriesHiberService {

    @Autowired
    private MailService mailService;
    @Autowired
    @Qualifier("entriesDao")
    private EntriesDao entriesHiberDeo;

    public Entries getEntryById(int entryId){

        return entriesHiberDeo.getEntryById(entryId);
    }
    public List<Entries> getAllEntries() {
        return entriesHiberDeo.getAllEntries();
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void addEntry(Entries entry) {
//        DebugUtils.transactionRequired("EntriesHiberService.addEntry");
        entriesHiberDeo.addEntry(entry);

//        Entries en = new Entries();  enable to test transactions
//        en.setTitle(null);
//        entriesHiberDeo.addEntry(en);
    }

    public void updateEntry(Entries entry){
        entriesHiberDeo.updateEntry(entry);
    }

    public void deleteEntry(int entryId){
        entriesHiberDeo.deleteEntry(entryId);
    }



    public void sendEntryDetails(Entries entry) {
        mailService.sendEmail(entry);
    }


}

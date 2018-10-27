package jbr.springmvc.service;

import jbr.springmvc.dao.EntriesDao;
import jbr.springmvc.model.Entries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EntriesHiberService {

    @Autowired
    private MailService mailService;
//    @Qualifier("entriesDao")
    @Autowired
    private EntriesDao entriesDao;

    public Entries getEntryById(int entryId){

//        return entriesDao.getEntryById(entryId);
          return entriesDao.findOne(entryId);
    }
    public List<Entries> getAllEntries() {
        return entriesDao.findAll();
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void addEntry(Entries entry) {
//        DebugUtils.transactionRequired("EntriesHiberService.addEntry");
//        entriesDao.addEntry(entry);

//        Entries en = new Entries();  enable to test transactions
//        en.setTitle(null);
//        entriesDao.addEntry(en);

        entriesDao.save(entry);
    }

    public void updateEntry(Entries entry){
//        entriesDao.updateEntry(entry);
        entriesDao.save(entry);
    }

    public void deleteEntry(int entryId){
//      entryId  entriesDao.deleteEntry(entryId);
        entriesDao.delete(entryId);
    }



    public void sendEntryDetails(Entries entry) {
//        mailService.sendEmail(entry);
    }




}

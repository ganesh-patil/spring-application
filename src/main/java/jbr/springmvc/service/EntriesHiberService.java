package jbr.springmvc.service;

import jbr.springmvc.dao.EntriesHiberDaoImpl;
import jbr.springmvc.model.Entries;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EntriesHiberService {
    @Autowired
    private EntriesHiberDaoImpl entriesDao;

    public Entries getEntryById(int entryId){

        return entriesDao.getEntryById(entryId);
    }
    public List<Entries> getAllEntries() {
        return entriesDao.getAllEntries();
    }
    public void addEntry(Entries entry) {
        entriesDao.addEntry(entry);
    }

    public void updateEntry(Entries entry){
        entriesDao.updateEntry(entry);
    }

    public void deleteEntry(int entryId){
        entriesDao.deleteEntry(entryId);
    }


}

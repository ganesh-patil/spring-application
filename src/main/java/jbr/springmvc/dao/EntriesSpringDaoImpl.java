package jbr.springmvc.dao;

import jbr.springmvc.controller.apis.EntryNotFoundException;
import jbr.springmvc.model.Entries;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional

public class EntriesSpringDaoImpl implements EntriesDao {


    public List<Entries> getAllEntries() {
        return null;
    }

    public void addEntry(Entries entry) {

    }

    public void updateEntry(Entries entry) {

    }

    public Entries getEntryById(int entryId) {
        return null;
    }

    public void deleteEntry(int entryId) {

    }
}

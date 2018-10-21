package jbr.springmvc.dao;

import jbr.springmvc.controller.apis.EntryNotFoundException;
import jbr.springmvc.model.Entries;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional

public class EntriesHiberDaoImpl implements EntriesDao {

    @Autowired
    private SessionFactory sessionFactory;
    public List<Entries> getAllEntries() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Entries ").list();
    }

    public void addEntry(Entries entry) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(entry);
        session.flush();
        //session.close();
    }

    public void updateEntry(Entries entry){
        Session session = sessionFactory.openSession();
        session.update(entry);
        session.flush();
        session.close();
    }

    public  void deleteEntry(int entryId){
        Session session = sessionFactory.openSession();
        Entries entry =  (Entries) session.get(Entries.class, entryId);
        if(entry == null){
            session.close();
            throw new EntryNotFoundException("Entry with id"+entryId+ "Not found");
        }
        session.delete(entry);
        session.flush();
        session.close();
    }

    public Entries getEntryById(int entryId){
        Session session = sessionFactory.getCurrentSession();
        Entries entry =  (Entries) session.get(Entries.class, 2);
        session.delete(entry);
        session.close();
        return entry;
    }
}

package jbr.springmvc.dao;

import jbr.springmvc.model.Entries;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EntriesHiberDaoImpl implements EntriesDao {

    @Autowired
    private SessionFactory sessionFactory;
    public List<Entries> getAllEntries() {
        return sessionFactory.openSession().createQuery("from Entries ").list();
    }

    public void addEntry(Entries entry) {
        Session session = sessionFactory.openSession();
        session.persist(entry);
        session.flush();
        session.close();
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

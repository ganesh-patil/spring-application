package jbr.springmvc.dao;

import jbr.springmvc.model.Entries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntriesDao extends JpaRepository<Entries, Integer> {
   /* public List<Entries> getAllEntries();
    public void addEntry(Entries entry);
    public void updateEntry(Entries entry);
    public Entries getEntryById(int entryId);
    public  void deleteEntry(int entryId);*/
}

package jbr.springmvc.dao;

import jbr.springmvc.model.Entries;

import java.util.List;

public interface EntriesDao {
    public List<Entries> getAllEntries();
    public void addEntry(Entries entry);
    public void updateEntry(Entries entry);
    public Entries getEntryById(int entryId);
    public  void deleteEntry(int entryId);
}

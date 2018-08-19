package jbr.springmvc.dao;

import jbr.springmvc.model.FileOperations;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FileOperationsHiberDaoImpl implements FileOperationsDao{
    @Autowired
    private SessionFactory sessionFactory;

    public void saveFileDetails(FileOperations fileDetails) {
        Session session = sessionFactory.openSession();
        session.persist(fileDetails);
        session.flush();
        session.close();
    }

    public List<FileOperations> getAllFiles(){

        Session session = sessionFactory.openSession();
        return session.createQuery("from FileOperations").list();
    }
}

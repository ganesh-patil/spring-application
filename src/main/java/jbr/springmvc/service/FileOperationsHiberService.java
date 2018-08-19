package jbr.springmvc.service;

import jbr.springmvc.dao.FileOperationsHiberDaoImpl;
import jbr.springmvc.model.FileOperations;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;

public class FileOperationsHiberService {
    @Autowired
    private FileOperationsHiberDaoImpl fileOperationsHiberDaoImpl;

    public void addFileDetails(FileOperations fileDetails){
        fileOperationsHiberDaoImpl.saveFileDetails(fileDetails);
    }

    public List<FileOperations>  getAllFiles(){
        return fileOperationsHiberDaoImpl.getAllFiles();
    }

}

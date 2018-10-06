package jbr.springmvc.controller.apis;

import jbr.springmvc.model.Entries;
import jbr.springmvc.model.FileOperations;
import jbr.springmvc.model.User;
import jbr.springmvc.service.EntriesHiberService;
import jbr.springmvc.service.FileOperationsHiberService;
import jbr.springmvc.service.UserHiberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/file")
public class RestFileOperationsController {

    @Autowired
    public FileOperationsHiberService fileOperationsService;

    @GetMapping
    public List getFiles(){
        return fileOperationsService.getAllFiles();
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public  String uploadFile(HttpServletRequest request, @RequestPart("fileData") MultipartFile file, FileOperations fileData
                ,RedirectAttributes redirectAttributes) throws  Exception {
        try {
            String uploadsDir = "/uploads/";
            String realPathtoUploads = request.getServletContext().getRealPath(uploadsDir);
            if (!new File(realPathtoUploads).exists()) {
                new File(realPathtoUploads).mkdir();
            }
            byte[] bytes = null;
            bytes = file.getBytes();
            new File(realPathtoUploads + File.separator + file.getOriginalFilename()).createNewFile();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(realPathtoUploads + File.separator + file.getOriginalFilename())));
            stream.write(bytes);
            stream.close();
            fileData.setFileName(file.getOriginalFilename());
            fileOperationsService.addFileDetails(fileData);
            redirectAttributes.addFlashAttribute("isUploaded", true);
        } catch (IOException e) {
            throw  new Exception(e.getMessage());
        }
        return "uploaded file";

    }

}

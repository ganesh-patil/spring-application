package jbr.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbr.springmvc.model.FileOperations;
import jbr.springmvc.service.FileOperationsHiberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.service.UserHiberService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.*;

@Controller
public class FileOperationsController {
	
	@Autowired
	  public FileOperationsHiberService fileOperationsService;

	@RequestMapping(value = "/files", method = RequestMethod.GET)
    public ModelAndView listFiles(HttpServletRequest request, HttpServletResponse response){
	    ModelAndView mav = new ModelAndView("fileList");
	    mav.addObject("allFiles", fileOperationsService.getAllFiles());
	    return mav;
    }

    @RequestMapping(value = "/file/{file_name}", method = RequestMethod.GET)
    @ResponseBody
    public void getFile(HttpServletRequest request,HttpServletResponse response,  @PathVariable("file_name") String fileName) throws FileNotFoundException, IOException {
        String uploadsDir = "/uploads/";
        String realPathtoUploads =  request.getServletContext().getRealPath(uploadsDir);
        String filePath = realPathtoUploads+File.separator+fileName+".jpg";
        File downloadFile = new File(filePath);
        FileInputStream inputStream = new FileInputStream(downloadFile);
        String mimeType = request.getServletContext().getMimeType(filePath);
        if (mimeType == null) {
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());

        // set headers for the response
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                downloadFile.getName());
        response.setHeader(headerKey, headerValue);

        // get output stream of the response
        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[4096];
        int bytesRead = -1;

        // write bytes read from the input stream into the output stream
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outStream.close();
    }
	@RequestMapping(value = "/file_upload", method = RequestMethod.GET)
	public ModelAndView fileUploadForm(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav =  new ModelAndView("FileOperations");
		mav.addObject("FileOperations", new FileOperations());
		return mav;
		
	}

	@RequestMapping(value = "/fileProcess", method = RequestMethod.POST)
	public ModelAndView processFile( HttpServletRequest request, @ModelAttribute("FileOperations")  FileOperations fileData
								, Model model, RedirectAttributes redirectAttributes){
        MultipartFile file = fileData.getFileData();
		ModelAndView mav =  new ModelAndView("FileOperations");
		try{
			String uploadsDir = "/uploads/";
			String realPathtoUploads =  request.getServletContext().getRealPath(uploadsDir);
			if(! new File(realPathtoUploads).exists())
			{
				new File(realPathtoUploads).mkdir();
			}
			byte[] bytes = null;
			bytes = file.getBytes();
			new File(realPathtoUploads+File.separator+file.getOriginalFilename()).createNewFile();
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(realPathtoUploads+File.separator+file.getOriginalFilename())));
			stream.write(bytes);
			stream.close();
            fileData.setFileName(file.getOriginalFilename());
			fileOperationsService.addFileDetails(fileData);
            redirectAttributes.addFlashAttribute("isUploaded", true);
            mav =  new ModelAndView("redirect:/files");
            return mav;

		}
		catch (IOException e) {
			mav.addObject("error", e.getMessage());
		}
        mav.addObject("FileOperations", new FileOperations());
        return mav;
	}

}

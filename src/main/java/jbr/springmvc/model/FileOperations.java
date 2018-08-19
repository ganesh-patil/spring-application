package jbr.springmvc.model;

import javax.persistence.*;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="files")
public class FileOperations {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "ID")
    private int id;

  @Column(name = "filename", nullable = false)	
  private String fileName;
  
  @Column(name = "fileDescription", nullable = false)	
  private String description;

  @Transient
  private MultipartFile fileData;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public MultipartFile getFileData() {
		return fileData;
	}
	
	public void setFileData(MultipartFile fileData) {
		this.fileData = fileData;
	}
  
  
  

}
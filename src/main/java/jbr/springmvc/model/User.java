package jbr.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
import org.hibernate.annotations.Type;

@Entity
@Table(name="users")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "ID")
    private int id;

  @Column(name = "username", nullable = false)	
  private String username;
  @Column(name = "password", nullable = false)	
  private String password;
  @Column(name = "firstname", nullable = false)	
  private String firstname;
  @Column(name = "lastname", nullable = false)	
  private String lastname;
  @Column(name = "email", nullable = false)	
  private String email;
  @Column(name = "address", nullable = false)	
  private String address;
  @Column(name = "phone", nullable = false)	
  private int phone;
  
  
  public int getId() {
      return id;
  }

  public void setId(int id) {
      this.id = id;
  }
  
  public String getUsername() {
  return username;
  }
  public void setUsername(String username) {
  this.username = username;
  }
  public String getPassword() {
  return password;
  }
  public void setPassword(String password) {
  this.password = password;
  }
  public String getFirstname() {
  return firstname;
  }
  public void setFirstname(String firstname) {
  this.firstname = firstname;
  }
  public String getLastname() {
  return lastname;
  }
  public void setLastname(String lastname) {
  this.lastname = lastname;
  }
  public String getEmail() {
  return email;
  }
  public void setEmail(String email) {
  this.email = email;
  }
  public String getAddress() {
  return address;
  }
  public void setAddress(String address) {
  this.address = address;
  }
  public int getPhone() {
  return phone;
  }
  public void setPhone(int phone) {
  this.phone = phone;
  }
}
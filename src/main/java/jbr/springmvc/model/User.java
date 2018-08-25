package jbr.springmvc.model;

import java.util.Collection;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import jbr.springmvc.model.User;

@Entity
@Table(name="users")
public class User  implements UserDetails, Comparable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "ID")
    private int id;

  @Column(name = "username", nullable = false)	
  @NotEmpty(message = "Please enter username")
  private String username;
  @Column(name = "password", nullable = false)	
  @NotEmpty
  private String password;
  @Column(name = "firstname", nullable = false)	
  private String firstname;
  @Column(name = "lastname", nullable = false)	
  private String lastname;
  @Column(name = "email", nullable = false)	
  @Email(message = "This is invalid email")
  private String email;
  @Column(name = "address", nullable = false)	
  private String address;
  @Column(name = "phone", nullable = false)	
  private int phone;

  @OneToMany(mappedBy = "user")
  private Set<Entries> entries;
  
  
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

  public Set<Entries> getEntries() {
    return entries;
  }

  public void setEntries(Set<Entries> entries) {
    this.entries = entries;
  }

public Collection<? extends GrantedAuthority> getAuthorities() {
	// TODO Auto-generated method stub
	return null;
}

public boolean isAccountNonExpired() {
	// TODO Auto-generated method stub
	return false;
}

public boolean isAccountNonLocked() {
	// TODO Auto-generated method stub
	return false;
}

public boolean isCredentialsNonExpired() {
	// TODO Auto-generated method stub
	return false;
}

public boolean isEnabled() {
	// TODO Auto-generated method stub
	return false;
}

public int compareTo(Object o) {
	// TODO Auto-generated method stub
	User newUser  = (User) o;
	if(this.id < newUser.id) {
		return 1;
	}
	return -1;
}
}
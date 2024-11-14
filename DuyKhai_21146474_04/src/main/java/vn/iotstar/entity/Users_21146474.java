package vn.iotstar.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
@Entity
@Table(name = "users")
@NamedQuery(name = "Users_21146474.findAll",query = "SELECT u FROM Users_21146474 u")
public class Users_21146474 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	
	@Column(name = "email",columnDefinition = "VARCHAR(50) NULL")
	private String email;
	
	@Column(name = "Fullname",columnDefinition = "VARCHAR(50) NULL")
	private String fullname;
	
	@Column(name = "Phone")
	private int phone;
	
	@Column(name = "Passwd",columnDefinition = "VARCHAR(32) NULL")
	private String psw;
	
	@Column(name = "Signup_date",columnDefinition = "DATETIME")
	private LocalDateTime signup_date;
	
	@Column(name = "Last_login",columnDefinition = "DATETIME")
	private LocalDateTime last_login;
	
	@Column(name = "Is_admin")
	private Boolean is_admin;

	public Users_21146474() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public LocalDateTime getSignup_date() {
		return signup_date;
	}

	public void setSignup_date(LocalDateTime signup_date) {
		this.signup_date = signup_date;
	}

	public LocalDateTime getLast_login() {
		return last_login;
	}

	public void setLast_login(LocalDateTime last_login) {
		this.last_login = last_login;
	}

	public Boolean getIs_admin() {
		return is_admin;
	}

	public void setIs_admin(Boolean is_admin) {
		this.is_admin = is_admin;
	}
	
	
	
}

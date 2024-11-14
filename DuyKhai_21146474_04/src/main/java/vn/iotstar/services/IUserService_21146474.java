package vn.iotstar.services;

import java.util.List;

import vn.iotstar.entity.Users_21146474;

public interface IUserService_21146474 {
	
	List<Users_21146474> findAll();
	
	Users_21146474 findById(int id);
	
	void insert(Users_21146474 user);
	
	void delete(int id) throws Exception;
	
	Users_21146474 UpdateByUser(String user, String fullname, int phone);
	
	void UpdatePswbyUser(String user,String psw);
	
	boolean CheckEmailExist(String Email);
	
	boolean CheckEmailDuplicate(String Email,String EmailDuplicate);
	
	boolean CheckUserExist(String User);
	
	Users_21146474 findbyUser(String User)throws Exception;
}

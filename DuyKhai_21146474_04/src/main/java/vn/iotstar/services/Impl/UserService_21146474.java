package vn.iotstar.services.Impl;

import java.util.List;

import vn.iotstar.dao.IUserDao_21146475;
import vn.iotstar.dao.impl.UserDao_21146474;
import vn.iotstar.entity.Users_21146474;
import vn.iotstar.services.IUserService_21146474;

public class UserService_21146474 implements IUserService_21146474 {
	IUserDao_21146475 userDao = new UserDao_21146474();
	@Override
	public Users_21146474 findById(int id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	@Override
	public void insert(Users_21146474 user) {
		// TODO Auto-generated method stub
		userDao.insert(user);
	}

	@Override
	public Users_21146474 UpdateByUser(String user, String fullname, int phone) {
		// TODO Auto-generated method stub
		return userDao.UpdateByUser(user, fullname, phone);
	}

	@Override
	public void UpdatePswbyUser(String user, String psw) {
		// TODO Auto-generated method stub
		userDao.UpdatePswbyUser(user, psw);
	}

	@Override
	public boolean CheckEmailExist(String Email) {
		// TODO Auto-generated method stub
		return userDao.CheckEmailExist(Email);
	}

	@Override
	public boolean CheckEmailDuplicate(String Email, String EmailDuplicate) {
		// TODO Auto-generated method stub
		return userDao.CheckEmailDuplicate(Email, EmailDuplicate);
	}

	@Override
	public boolean CheckUserExist(String User) {
		// TODO Auto-generated method stub
		return userDao.CheckUserExist(User);
	}

	@Override
	public Users_21146474 findbyUser(String User) throws Exception {
		// TODO Auto-generated method stub
		return userDao.findbyUser(User);
	}

	@Override
	public List<Users_21146474> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		userDao.delete(id);
	}

}

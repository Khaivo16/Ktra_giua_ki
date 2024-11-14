package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.entity.Books_21146474;


public interface IBooksDao_21146475 {
	int count();

	List<Books_21146474> findAll(int page, int pagesize);

	List<Books_21146474> searchByName(String bookName);

	Books_21146474 findByBookname(String name) throws Exception;

	List<Books_21146474> findAll();

	Books_21146474 findById(int bookid);

	void delete(int bookid) throws Exception;

	void update(Books_21146474 book);

	void insert(Books_21146474 book);
}

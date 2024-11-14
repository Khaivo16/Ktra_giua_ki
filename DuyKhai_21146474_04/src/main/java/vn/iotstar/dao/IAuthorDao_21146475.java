package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.entity.Author_21146474;



public interface IAuthorDao_21146475 {
	int count();

	List<Author_21146474> findAll(int page, int pagesize);

	List<Author_21146474> searchByName(String authorName);

	Author_21146474 findByBookname(String name) throws Exception;

	List<Author_21146474> findAll();

	Author_21146474 findById(int authorid);

	void delete(int authorid) throws Exception;

	void update(Author_21146474 author);

	void insert(Author_21146474 author);
}

package vn.iotstar.dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import vn.iotstar.configs.JPAconfig;
import vn.iotstar.dao.IBooksDao_21146475;
import vn.iotstar.entity.Books_21146474;

public class BooksDao_21146474 implements IBooksDao_21146475 {

	@Override
	public int count() {
		// TODO Auto-generated method stub
		EntityManager enma = JPAconfig.getEntityManager();

		String jpql = "SELECT count(b) FROM Books_21146474 b";

		Query query = enma.createQuery(jpql);

		return ((Long) query.getSingleResult()).intValue();
	}

	@Override
	public List<Books_21146474> findAll(int page, int pagesize) {
		// TODO Auto-generated method stub
		EntityManager enma = JPAconfig.getEntityManager();

		TypedQuery<Books_21146474> query = enma.createNamedQuery("Books_21146474.findAll", Books_21146474.class);

		query.setFirstResult(page * pagesize);

		query.setMaxResults(pagesize);

		return query.getResultList();
	}

	@Override
	public List<Books_21146474> searchByName(String bookName) {
		// TODO Auto-generated method stub
		EntityManager enma = JPAconfig.getEntityManager();

		String jpql = "SELECT b FROM Books_21146474 b WHERE b.title like :bookTitle";

		TypedQuery<Books_21146474> query = enma.createQuery(jpql, Books_21146474.class);

		query.setParameter("bookTitle", "%" + bookName + "%");

		return query.getResultList();
	}

	@Override
	public Books_21146474 findByBookname(String name) throws Exception {
		// TODO Auto-generated method stub
		EntityManager enma = JPAconfig.getEntityManager();

		String jpql = "SELECT b FROM Books_21146474 b WHERE b.titile =:bookTitle";

		try {

			TypedQuery<Books_21146474> query = enma.createQuery(jpql, Books_21146474.class);

			query.setParameter("catename", name);

			Books_21146474 book = query.getSingleResult();

			if (book == null) {

				throw new Exception("Book khong tồn tại");

			}

			return book;

		} finally {

			enma.close();

		}
	}

	@Override
	public List<Books_21146474> findAll() {
		// TODO Auto-generated method stub
		EntityManager enma = JPAconfig.getEntityManager();
		TypedQuery<Books_21146474> query = enma.createNamedQuery("Books_21146474.findAll", Books_21146474.class);
		return query.getResultList();
	}

	@Override
	public Books_21146474 findById(int bookid) {
		// TODO Auto-generated method stub
		EntityManager enma = JPAconfig.getEntityManager();
		Books_21146474 book = enma.find(Books_21146474.class, bookid);
		return book;
	}

	@Override
	public void delete(int bookid) throws Exception {
		// TODO Auto-generated method stub
		EntityManager enma = JPAconfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {
			trans.begin();
			// Gọi phương thức để insert, update, delete
			Books_21146474 book = enma.find(Books_21146474.class, bookid);
			if (book != null) {
				enma.remove(book);
			} else {
				throw new Exception("Không tìm thấy");
			}

			trans.commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	@Override
	public void update(Books_21146474 book) {
		// TODO Auto-generated method stub
		EntityManager enma = JPAconfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {
			trans.begin();
			enma.merge(book);
			trans.commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	@Override
	public void insert(Books_21146474 book) {
		// TODO Auto-generated method stub
		EntityManager enma = JPAconfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {
			trans.begin();
			enma.persist(book);
			trans.commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

}

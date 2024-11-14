package vn.iotstar.dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import vn.iotstar.configs.JPAconfig;
import vn.iotstar.dao.IUserDao_21146475;
import vn.iotstar.entity.Books_21146474;
import vn.iotstar.entity.Users_21146474;

public class UserDao_21146474 implements IUserDao_21146475 {

	@Override
	public List<Users_21146474> findAll() {
		// TODO Auto-generated method stub
		EntityManager enma = JPAconfig.getEntityManager();
		TypedQuery<Users_21146474> query = enma.createNamedQuery("Users_21146474.findAll", Users_21146474.class);
		return query.getResultList();
	}

	@Override
	public Users_21146474 findById(int id) {
		// TODO Auto-generated method stub
		EntityManager enma = JPAconfig.getEntityManager();
		Users_21146474 user = enma.find(Users_21146474.class, id);
		return user;
	}

	@Override
	public void insert(Users_21146474 user) {
		// TODO Auto-generated method stub
		EntityManager enma = JPAconfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {
			trans.begin();
			enma.persist(user);
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
	public Users_21146474 UpdateByUser(String user, String fullname, int phone) {
		// TODO Auto-generated method stub
		EntityManager enma = JPAconfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
            trans.begin();
            Users_21146474 existingUser = findbyUser(user);
            if (existingUser != null) {
                existingUser.setFullname(fullname);
                existingUser.setPhone(phone);
                enma.merge(existingUser);
                trans.commit();
                return existingUser;
            } else {
                trans.rollback();
                return null;
            }
        } catch (Exception e) {
            if (enma.getTransaction().isActive()) {
                enma.getTransaction().rollback();
            }
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public void UpdatePswbyUser(String user, String psw) {
		// TODO Auto-generated method stub
		EntityManager enma = JPAconfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
            trans.begin();
            Users_21146474 existingUser = findbyUser(user);
            if (existingUser != null) {
                existingUser.setPsw(psw);
                enma.merge(existingUser);
                trans.commit();
            } else {
                enma.getTransaction().rollback();
            }
        } catch (Exception e) {
            if (trans.isActive()) {
                trans.rollback();
            }
            e.printStackTrace();
        }
	}

	@Override
	public boolean CheckEmailExist(String Email) {
		// TODO Auto-generated method stub
		EntityManager enma = JPAconfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
            TypedQuery<Long> query = enma.createQuery(
                "SELECT COUNT(u) FROM Users_21146474 u WHERE u.email = :email", Long.class);
            query.setParameter("email", Email);
            Long count = query.getSingleResult();
            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
	}

	@Override
	public boolean CheckEmailDuplicate(String Email, String EmailDuplicate) {
		// TODO Auto-generated method stub
		return Email.equals(EmailDuplicate);
	}

	@Override
	public boolean CheckUserExist(String User) {
		// TODO Auto-generated method stub
		EntityManager enma = JPAconfig.getEntityManager();
		try {
            TypedQuery<Long> query = enma.createQuery(
                "SELECT COUNT(u) FROM Users_21146474 u WHERE u.fullname = :username", Long.class);
            query.setParameter("username", User);
            Long count = query.getSingleResult();
            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
	}

	@Override
	public Users_21146474 findbyUser(String User) throws Exception {
		// TODO Auto-generated method stub
		EntityManager enma = JPAconfig.getEntityManager();

		String jpql = "SELECT u FROM Users_21146474 u WHERE u.fullname =:name";

		try {

			TypedQuery<Users_21146474> query = enma.createQuery(jpql, Users_21146474.class);

			query.setParameter("name", User);

			Users_21146474 user = query.getSingleResult();

			if (user == null) {

				throw new Exception("Book khong tồn tại");

			}

			return user;

		} finally {

			enma.close();

		}
	}

	@Override
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		EntityManager enma = JPAconfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {
			trans.begin();
			// Gọi phương thức để insert, update, delete
			Users_21146474 user = enma.find(Users_21146474.class, id);
			if (user != null) {
				enma.remove(user);
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

}

package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import customTools.DBUtil;
import business.TUser;

public class TuserDB {

	public static void insert(Tuser user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(user);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(Tuser user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(user);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void delete(Tuser user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(user));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
    //may not need this one
	public static List<TUser> selectAll() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		List<TUser> tList = new ArrayList<TUser>();
		String qString = "select e from Tuser e";
		TypedQuery<TUser> q = (TypedQuery<TUser>) em.createQuery(qString, TUser.class);
		List<TUser> tuser = null;
		trans.begin();
		try {
			tuser = q.getResultList();
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
		return tList;
	}
	
	public static TUser selectUser(String loginName) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		String qString = "select e from Tuser e where e.loginname = :loginName";
		TypedQuery<TUser> q = (TypedQuery<TUser>) em.createQuery(qString, TUser.class);
		TUser tuser = null;
		trans.begin();
		try {
			tuser = q.getSingleResult();
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
		return tuser;
	}
}

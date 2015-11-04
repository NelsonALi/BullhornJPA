package business;

import javax.persistence.EntityManager;
import customTools.DBUtil;

public class grabUser {

	public static void main(String[] args) {
		javax.persistence.EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			model.Tuser tuser = em.find(model.Tuser.class, (long) 2);
			System.out.println(tuser.getLoginname());
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
			System.out.println("cerrado!");
		}

	}

}

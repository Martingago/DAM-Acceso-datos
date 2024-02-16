package controllers;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class JoinController {

	public static void joinTablas() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		//Se inicia una transaccion
		session.beginTransaction();
		
		String hql = "SELECT e.id, e.nombre, e.sueldo, d.nombre FROM Empleado e INNER JOIN Departamento d on e.departamento = d.id";
		Query query = session.createQuery(hql);
		
		List<Object[]> resultados = query.list();
		
		session.getTransaction().commit();
		session.close();
		
		for(Object[] resultado : resultados) {
			System.out.println(Arrays.toString(resultado));
		}
		
	}
	
	
}

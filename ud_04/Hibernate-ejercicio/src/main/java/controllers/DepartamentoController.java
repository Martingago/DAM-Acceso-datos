package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.modelos.Departamento;
import com.modelos.Empleado;

public class DepartamentoController {
	
	
	public String getDepartamento(int id) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Departamento.class).buildSessionFactory();
		//se abre la sesión
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			Departamento departamento = session.get(Departamento.class, id);
			
			session.getTransaction().commit();
			sessionFactory.close();
			return departamento.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "No se ha podido encontrar el departamento";
	}
	
	/**
	 * Funcion que crea un departamento en la BBDD
	 * @param nombre
	 * @return
	 */
	public String createDepartamento(String nombre) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Departamento.class).buildSessionFactory();
		//se abre la sesión
		Session session = sessionFactory.openSession();
		
		try {
			Departamento departamento = new Departamento(nombre);
			
			session.beginTransaction();
			session.save(departamento);
			session.getTransaction().commit();
			sessionFactory.close();
			return "Departamento creado con éxito";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "Error al crear el departamento";
	}
	
	/**
	 * Elimina un departamento de la BBDD
	 * @param id
	 * @return
	 */
	public String deleteDepartamento(int id) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Departamento.class).buildSessionFactory();

		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			
			Departamento departamento = session.get(Departamento.class, id);
			
			session.delete(departamento);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Departamento con id: " + departamento.getId() + " eliminado con éxito";
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return "Se ha producido un error al eliminar departamento";
	}
	
	/**
	 * Actualiza los datos de un departamento en la BBDD
	 * @param id
	 * @param nombre
	 * @return
	 */
	public String updateDepartamento(int id, String nombre) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Departamento.class).buildSessionFactory();

		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			
			Departamento departamento = session.get(Departamento.class, id);
			//Se actualizan los campos del empleado
			departamento.setNombre(nombre);
			
			session.update(departamento);
			
			session.getTransaction().commit();
			// Cierra la conexion con la BBDD
			sessionFactory.close();
			
			return "Departamento actualizado con éxito";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "Error al actualizar el departamento";
	}
	
	

}

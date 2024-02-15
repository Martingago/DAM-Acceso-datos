package controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.modelos.Empleado;



public class EmpleadoController {

	
	
	public String getEmpleado(int id) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		//se abre la sesión
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			Empleado empleado = session.get(Empleado.class, id);
			
			session.getTransaction().commit();
			sessionFactory.close();
			return empleado.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "No se ha podido encontrar el departamento";
	}
	
	
	
	/**
	 * Crea un Empleado en la BBDD
	 * 
	 * @param nombre
	 * @param sueldo
	 * @param departamento
	 * @return
	 */
	public String createUsuario(String nombre, double sueldo, int departamento) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Empleado.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		try {
			// Crea una instancia del nuevo usuario
			Empleado empleado = new Empleado(nombre, sueldo, departamento);
			// abre puente de transacciones entre mi aplicación java y la BBDD de mySQL
			session.beginTransaction();
			// Guarda los cambios del nuevo usuario
			session.save(empleado);
			// Graba los cambios anteriores en la BBDD (INSERT into ....)
			session.getTransaction().commit();
			// Cierra la conexion con la BBDD
			sessionFactory.close();
			return "Usuario creado";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Error al registrar empleado";
	}

	/**
	 * Elimina un empleado de la BBDD
	 * @param id
	 * @return
	 */
	public String deleteEmpleado(int id) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Empleado.class).buildSessionFactory();

		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			
			Empleado empleado = session.get(Empleado.class, id);
			
			session.delete(empleado);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Empleado con id: " + empleado.getId() + " eliminado con éxito";
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return "Se ha producido un error al eliminar empleado";
	}
	
	/**
	 * Actualiza la informacion de empleado
	 * @param id
	 * @param nombre
	 * @param sueldo
	 * @param departamento
	 * @return
	 */
	public String updateEmpleado(int id, String nombre, double sueldo, int departamento) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Empleado.class).buildSessionFactory();

		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			
			Empleado empleado = session.get(Empleado.class, id);
			//Se actualizan los campos del empleado
			empleado.setNombre(nombre);
			empleado.setSueldo(sueldo);
			empleado.setDepartamento(departamento);
			
			session.update(empleado);
			
			session.getTransaction().commit();
			// Cierra la conexion con la BBDD
			sessionFactory.close();
			
			return "Empleado actualizado con éxito";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "Error al actualizar el empleado";
	}
	
	/**
	 * Lista la tabla de empleados
	 */
	public static void listTablaEmpleados() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Empleado.class).buildSessionFactory();

		Session session = sessionFactory.openSession();
		//session.beginTransaction();
		 Query query = session.createQuery("FROM Empleado");
		 List<Empleado> empleados = query.list();
		 for (Empleado empleado : empleados) {
		           System.out.println(empleado.toString());
		 }
		
	}
	
	

}

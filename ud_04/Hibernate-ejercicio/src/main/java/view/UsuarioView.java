package view;

import controllers.DepartamentoController;
import controllers.EmpleadoController;
import controllers.JoinController;

public class UsuarioView {
	public static void main(String[] args) {
		
		//JoinController.joinTablas();
		
		/**
		 * ==========================================================================
		 *                             DEPARTAMENTO
		 * ==========================================================================
		 */
		
		
		//String departamento = new DepartamentoController().createDepartamento("CONTABILIDAD");
		//String departamento2 = new DepartamentoController().createDepartamento("COMPRAS");
		//String departamento3 = new DepartamentoController().createDepartamento("COMERCIAL");
		//System.out.println(departamento);
		
		//String borrarDepartamento = new DepartamentoController().deleteDepartamento(3);
		//System.out.println(borrarDepartamento);
		
		
		//String actualizarDepartamento = new DepartamentoController().updateDepartamento(2, "VENTAS");
		//System.out.println(actualizarDepartamento);
		
		
		//String getDepartamento = new DepartamentoController().getDepartamento(2);
		//System.out.println(getDepartamento);
		
		
		//DepartamentoController.listTablaDepartamento();
		
		/**
		 * ==========================================================================
		 *                             EMPLEADO
		 * ==========================================================================
		 */
		
		//String empleado = new EmpleadoController().createEmpleado("Martin", 2000.00, 1);
		//System.out.println(empleado);
		
		//String borrarEmpleado = new EmpleadoController().deleteEmpleado(7);
		//System.out.println(borrarEmpleado);
		
		String updateEmpleado = new EmpleadoController().updateEmpleado(10, "Maria", 2000, 1);
		System.out.println(updateEmpleado);
		
		//String getEmpleado = new EmpleadoController().getEmpleado(10);
		//System.out.println(getEmpleado);
		//EmpleadoController.listTablaEmpleados();
		

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

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
		
		
		DepartamentoController.listTablaDepartamento();
		
		/**
		 * ==========================================================================
		 *                             EMPLEADO
		 * ==========================================================================
		 */
		
		
		//String empleado = new EmpleadoController().createUsuario("Sara", 2000.23, 2);
		//String empleado2 = new EmpleadoController().createUsuario("Pedro", 2600.23, 1);
		//System.out.println(empleado);
		
		//String borrarEmpleado = new EmpleadoController().deleteEmpleado(7);
		//System.out.println(borrarEmpleado);
		
		//String updateEmpleado = new EmpleadoController().updateEmpleado(5, "Martin", 1900, 1);
		//System.out.println(updateEmpleado);
		
		//String getEmpleado = new EmpleadoController().getEmpleado(5);
		//System.out.println(getEmpleado);
		//EmpleadoController.listTablaEmpleados();
		

	}

}

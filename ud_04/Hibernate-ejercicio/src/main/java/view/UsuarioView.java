package view;

import controllers.DepartamentoController;
import controllers.EmpleadoController;
import controllers.JoinController;

public class UsuarioView {
	public static void main(String[] args) {
		
		// PARA IR EJECUTANDO LAS FUNCIONES DESCOMENTAR LO DE ABAJO!!
		System.out.println("PARA EJECUTAR LAS FUNCIONES DEL EJERCICIO DESCOMENTAR LAS FUNCIONES DE: view.UsuarioView.java");
		
		/**
		 * ==========================================================================
		 *                             DEPARTAMENTO
		 * ==========================================================================
		 */
		
		// ---------------------- SE AÑADEN DEPARTAMENTOS ---------------------------
		
		//String departamento1 = new DepartamentoController().createDepartamento("CONTABILIDAD");
		//String departamento2 = new DepartamentoController().createDepartamento("COMPRAS");
		//String departamento3 = new DepartamentoController().createDepartamento("COMERCIAL");
		//System.out.println(departamento1);
		//System.out.println(departamento2);
		//System.out.println(departamento3);
		
		
		// ---------------------- SE BORRAN DEPARTAMENTOS ---------------------------
		
		//String borrarDepartamento = new DepartamentoController().deleteDepartamento(2);
		//System.out.println(borrarDepartamento);
		
		
		// ---------------------- SE ACTUALIZAN DEPARTAMENTOS ---------------------------
		
		//String actualizarDepartamento = new DepartamentoController().updateDepartamento(2, "VENTAS");
		//System.out.println(actualizarDepartamento);
		
		
		// ---------------------- SE OBTIENE DATO DE 1 DEPARTAMENTO ---------------------------
		
		//String getDepartamento = new DepartamentoController().getDepartamento(2);
		//System.out.println(getDepartamento);
		
		
		// ---------------------- SE LISTAN TODOS LOS DEPARTAMENTOS ---------------------------
		
		//DepartamentoController.listTablaDepartamento();
		
		/**
		 * ==========================================================================
		 *                             EMPLEADO
		 * ==========================================================================
		 */
		
		
		// ---------------------- SE AÑADEN EMPLEADOS ---------------------------
		
		//String empleado1 = new EmpleadoController().createEmpleado("Martin", 2000.00, 1);
		//String empleado2 = new EmpleadoController().createEmpleado("Sara", 4000.00, 2);
		//String empleado3 = new EmpleadoController().createEmpleado("Pedro", 1000.00, 1);
		//System.out.println(empleado1);
		//System.out.println(empleado2);
		//System.out.println(empleado3);
		
		
		// ---------------------- SE ELIMINAN EMPLEADOS ---------------------------
		
		//String borrarEmpleado = new EmpleadoController().deleteEmpleado(2);
		//System.out.println(borrarEmpleado);
		
		
		// ---------------------- SE ACTUALIZAN EMPLEADOS ---------------------------
		
		//String updateEmpleado = new EmpleadoController().updateEmpleado(1, "Maria", 2000, 1);
		//System.out.println(updateEmpleado);
		
		
		// ---------------------- SE OBTIENE 1 EMPLEADO ---------------------------
		
		//String getEmpleado = new EmpleadoController().getEmpleado(1);
		//System.out.println(getEmpleado);
		
		
		// ---------------------- SE LISTAN TODOS LOS EMPLEADOS ---------------------------
		
		//EmpleadoController.listTablaEmpleados();
		
		
		
		/**
		 * ==========================================================================
		 *                             JOIN DE LAS TABLAS
		 * ==========================================================================
		 */
		
		
		// ----------- SE LISTAN LOS EMPLEADOS CON JOIN DE DEPARTAMENTOS ------------
		
		//JoinController.joinTablas();
		

	}

}

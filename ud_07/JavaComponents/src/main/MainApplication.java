package main;

import componente.MatriculaAlumnoBean;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Vector;

public class MainApplication {

    public static MatriculaAlumnoBean matriculaBean;

    public static void main(String[] args) {
        matriculaBean = new MatriculaAlumnoBean();

        // Agregar un PropertyChangeListener para capturar los eventos que ocurren en el código:
        matriculaBean.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("matriculasRecargadas")) {
                    System.out.println("Matrículas recargadas");
                } else if (evt.getPropertyName().equals("matriculaAgregada")) {
                    System.out.println("Nueva matrícula agregada");
                }
            }
        });
        //Se listan TODAS las matriculas
        printMatriculas(matriculaBean.listarMatriculas());
        
        
        //Se listan las matriculas con el DNI especificado:
        String DNI = "12345678A";
        System.out.println("\nListado matriculas con DNI: " + DNI);
        printMatriculas(matriculaBean.listarMatriculasPorDNI(DNI));
        
        //Se añade un nuevo registro de matrícula:
        matriculaBean.agregarMatricula(DNI, "Test nueva Matrícula", "23-24", 9.99);
        
        //Se lista nuevamente el DNI
        System.out.println("\nListado matriculas con DNI: " + DNI);
        printMatriculas(matriculaBean.listarMatriculasPorDNI(DNI));

    }

    //Funcion para imprimir un listado de matriculas pasado como parámetro:
    public static void printMatriculas(Vector<MatriculaAlumnoBean.Matricula> matriculas) {
        System.out.println("Listado de matrículas:");
        for (MatriculaAlumnoBean.Matricula matricula : matriculas) {
            System.out.println(matricula.getDNI() + ", " + matricula.getNombreModulo() + ", " + matricula.getCurso() + ", " + matricula.getNota());
        }
    }

}

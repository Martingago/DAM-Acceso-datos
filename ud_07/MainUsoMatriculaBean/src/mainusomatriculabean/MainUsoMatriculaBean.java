package mainusomatriculabean;

import componente.MatriculaAlumnoBean;

public class MainUsoMatriculaBean {

    public static MatriculaAlumnoBean matriculaBean;

    public static void main(String[] args) {

        matriculaBean = new MatriculaAlumnoBean();

        //Se listan las matriculas (Al no cambiar el modo se cargarán por defecto TODAS LAS MATRICULAS)
        matriculaBean.listarMatriculas();

        //Se selecciona dentro de TODO el listado de matriculas, la correspondiente a la línea 2:
        int fila = 1;

        matriculaBean.seleccionarFila(
                1);
        System.out.println(
                "\nSe ha seleccionado al alumno con DNI: " + matriculaBean.getDNI() + " correspondiente a la fila: " + (fila + 1));

        //Sobre el elemento seleccionado, se muestra el listado de matriculas correspondiente a ESE DNI:
        matriculaBean.recargarDNI();

        //De ese DNI se muestran las MATRICULAS asociadas:
        System.out.println(
                "Listado de las matriculas con DNI: " + matriculaBean.getDNI());
        matriculaBean.listarMatriculas();

        //Se establecen los datos necesarios para añadir una nueva matricula al DNI seleccionado:
        matriculaBean.setCurso(
                "23-24");
        matriculaBean.setNombreModulo(
                "Bases de datos");
        matriculaBean.setNota(
                8.7);

        //Se añade una matricula al alumno con el DNI seleccionado y se listan sus matriculas:
        matriculaBean.addMatricula();

        matriculaBean.listarMatriculas();

        //Se vuelve al modo global de datos y se listan las nuevas filas existentes
        matriculaBean.recargarFilas();

        matriculaBean.listarMatriculas();

    }
}

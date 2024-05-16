package componente;

import java.util.ArrayList;
import java.util.List;

public class GestorEventosMatricula {

    /**
     * Clase encargada de gestionar los eventos del componente Matricula
     */
    private List<MatriculaListener> listeners = new ArrayList<>(); //lista que contiene los listeners del componente

    //Metodo para añadir el listener:
    public void addMatriculaListener(MatriculaListener listener) {
        listeners.add(listener);
    }

    // Método para remover un listener
    public void removeMatriculaListener(MatriculaListener listener) {
        listeners.remove(listener);
    }

    /**
     * Se inicializan por defecto dentro del Bean cuales son los listeners que
     * realizará el componente cuando sucede algun evento
     */
    public void inicializarListeners() {
        // Agregar los listeners por defecto
        MatriculaListener listener = new MatriculaListener() {
            @Override
            public void matriculasRecargadaSistema(MatriculaEvent event) {
                // Código para manejar el evento de matrículas recargadas del sistema
                System.out.println("\n=====================================");
                System.out.println("MODO ESTABLECIDO: MATRICULAS SISTEMA ");
                System.out.println("=====================================\n");
            }

            @Override
            public void matriculasRecargadaEspecifica(MatriculaEvent event) {
                // Código para manejar el evento de matrículas recargadas específicas
                System.out.println("\n=====================================");
                System.out.println(" MODO ESTABLECIDO: USUARIO CONCRETO  ");
                System.out.println("=====================================\n");
            }

            @Override
            public void matriculaAgregada(MatriculaEvent event) {
                // Código para manejar el evento de matrícula agregada
                System.out.println("\n=====================================");
                System.out.println("Una nueva matrícula ha sido agregada.");
                System.out.println("=====================================\n");
            }
        };
        // Agregar el listener al componente
        addMatriculaListener(listener);
    }

    /**
     * Metodo para notificar del suceso de un evento
     *
     * @param eventType
     */
    public void lanzarMatriculaEvent(String eventType) {
        MatriculaEvent event = new MatriculaEvent(this, eventType);
        for (MatriculaListener listener : listeners) {
            switch (eventType) {
                case "matriculasRecargadaSistema":
                    listener.matriculasRecargadaSistema(event);
                    break;
                case "matriculasRecargadaEspecifica":
                    listener.matriculasRecargadaEspecifica(event);
                    break;
                case "matriculaAgregada":
                    listener.matriculaAgregada(event);
                    break;
                default:
                    break;
            }
        }
    }

}

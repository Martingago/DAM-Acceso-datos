package componente;

import java.util.EventListener;

public interface MatriculaListener extends EventListener {
    void matriculasRecargadaSistema(MatriculaEvent event);
    void matriculasRecargadaEspecifica(MatriculaEvent event);
    void matriculaAgregada(MatriculaEvent event);
}

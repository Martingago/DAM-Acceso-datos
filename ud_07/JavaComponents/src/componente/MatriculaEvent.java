package componente;

import java.util.EventObject;

public class MatriculaEvent extends EventObject {
    private String eventType;

    public MatriculaEvent(Object source, String eventType) {
        super(source);
        this.eventType = eventType;
    }

    public String getEventType() {
        return eventType;
    }
}

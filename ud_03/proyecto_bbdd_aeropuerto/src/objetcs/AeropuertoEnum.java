package objetcs;

public enum AeropuertoEnum {

        MADRID("MADRID"),
        BARCELONA("BARCELONA"),
        GRANADA("GRANADA"),
        CORUÑA("A CORUÑA"),
        VALENCIA("VALENCIA"),
        BILBAO("BILBAO"),
        BRUSELAS("BRUSELAS"),
        MOSCÚ("MOSCÚ"),
        ROMA("ROMA");

    private final String nombre;

    AeropuertoEnum(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

}

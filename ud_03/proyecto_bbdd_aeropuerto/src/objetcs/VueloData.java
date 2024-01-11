package objetcs;

import java.time.LocalDateTime;

public class VueloData {

    String COD_VUELO;
    LocalDateTime HORA_SALIDA;
    AeropuertoEnum DESTINO;
    AeropuertoEnum PROCEDENCIA;
    int PLAZAS_FUMADOR;
    int PLAZAS_NO_FUMADOR;
    int PLAZAS_TURISTA;
    int PLAZAS_PRIMERA;

    public VueloData(String COD_VUELO, LocalDateTime HORA_SALIDA, AeropuertoEnum DESTINO, 
            AeropuertoEnum PROCEDENCIA, int PLAZAS_FUMADOR, int PLAZAS_NO_FUMADOR, int PLAZAS_TURSITA, int PLAZAS_PRIMERA) {
        this.COD_VUELO = COD_VUELO;
        this.HORA_SALIDA = HORA_SALIDA;
        this.DESTINO = DESTINO;
        this.PROCEDENCIA = PROCEDENCIA;
        this.PLAZAS_FUMADOR = PLAZAS_FUMADOR;
        this.PLAZAS_NO_FUMADOR = PLAZAS_NO_FUMADOR;
        this.PLAZAS_TURISTA = PLAZAS_TURISTA;
        this.PLAZAS_PRIMERA = PLAZAS_PRIMERA;
    }

    public String getCOD_VUELO() {
        return COD_VUELO;
    }

    public void setCOD_VUELO(String COD_VUELO) {
        this.COD_VUELO = COD_VUELO;
    }

    public LocalDateTime getHORA_SALIDA() {
        return HORA_SALIDA;
    }

    public void setHORA_SALIDA(LocalDateTime HORA_SALIDA) {
        this.HORA_SALIDA = HORA_SALIDA;
    }

    public AeropuertoEnum getDESTINO() {
        return DESTINO;
    }

    public void setDESTINO(AeropuertoEnum DESTINO) {
        this.DESTINO = DESTINO;
    }

    public AeropuertoEnum getPROCEDENCIA() {
        return PROCEDENCIA;
    }

    public void setPROCEDENCIA(AeropuertoEnum PROCEDENCIA) {
        this.PROCEDENCIA = PROCEDENCIA;
    }

    public int getPLAZAS_FUMADOR() {
        return PLAZAS_FUMADOR;
    }

    public void setPLAZAS_FUMADOR(int PLAZAS_FUMADOR) {
        this.PLAZAS_FUMADOR = PLAZAS_FUMADOR;
    }

    public int getPLAZAS_NO_FUMADOR() {
        return PLAZAS_NO_FUMADOR;
    }

    public void setPLAZAS_NO_FUMADOR(int PLAZAS_NO_FUMADOR) {
        this.PLAZAS_NO_FUMADOR = PLAZAS_NO_FUMADOR;
    }

    public int getPLAZAS_TURISTA() {
        return PLAZAS_TURISTA;
    }

    public void setPLAZAS_TURISTA(int PLAZAS_TURISTA) {
        this.PLAZAS_TURISTA = PLAZAS_TURISTA;
    }

    public int getPLAZAS_PRIMERA() {
        return PLAZAS_PRIMERA;
    }

    public void setPLAZAS_PRIMERA(int PLAZAS_PRIMERA) {
        this.PLAZAS_PRIMERA = PLAZAS_PRIMERA;
    }

    @Override
    public String toString() {
        return "VueloData{" + "COD_VUELO=" + COD_VUELO + ", HORA_SALIDA=" + HORA_SALIDA + ", DESTINO=" + DESTINO + ", PROCEDENCIA=" + PROCEDENCIA + ", PLAZAS_FUMADOR=" + PLAZAS_FUMADOR + ", PLAZAS_NO_FUMADOR=" + PLAZAS_NO_FUMADOR + ", PLAZAS_TURISTA=" + PLAZAS_TURISTA + ", PLAZAS_PRIMERA=" + PLAZAS_PRIMERA + '}';
    }
}

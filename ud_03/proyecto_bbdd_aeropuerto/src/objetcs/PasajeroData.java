package objetcs;


public class PasajeroData {

    int NUM;
    String COD_VUELO;
    PasajeroDataEnum.Tipo_plaza TIPO_PLAZA;
    PasajeroDataEnum.Fumador FUMADOR;

    public PasajeroData(int NUM, String COD_VUELO, PasajeroDataEnum.Tipo_plaza TIPO_PLAZA, PasajeroDataEnum.Fumador FUMADOR) {
        this.NUM = NUM;
        this.COD_VUELO = COD_VUELO;
        this.TIPO_PLAZA = TIPO_PLAZA;
        this.FUMADOR = FUMADOR;
    }

    public int getNUM() {
        return NUM;
    }

    public void setNUM(int NUM) {
        this.NUM = NUM;
    }

    public String getCOD_VUELO() {
        return COD_VUELO;
    }

    public void setCOD_VUELO(String COD_VUELO) {
        this.COD_VUELO = COD_VUELO;
    }

    public PasajeroDataEnum.Tipo_plaza getTIPO_PLAZA() {
        return TIPO_PLAZA;
    }

    public void setTIPO_PLAZA(PasajeroDataEnum.Tipo_plaza TIPO_PLAZA) {
        this.TIPO_PLAZA = TIPO_PLAZA;
    }

    public PasajeroDataEnum.Fumador getFUMADOR() {
        return FUMADOR;
    }

    public void setFUMADOR(PasajeroDataEnum.Fumador FUMADOR) {
        this.FUMADOR = FUMADOR;
    }
    
    

    
}

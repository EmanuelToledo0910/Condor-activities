        package Activities.actListaDeMails;

public class InstruccionParticular {
    private Boolean excluir;
    private Character flag;
    private String tipoOrden;

    public InstruccionParticular(Boolean Excluir, Character Flag, String TipoOrden) {
        this.excluir = Excluir;
        this.flag = Flag;
        this.tipoOrden = TipoOrden;
    }

    public Boolean getExcluir() {
        return excluir;
    }

    public Character getFlag() {
        return flag;
    }

    public String getTipoOrden() {
        return tipoOrden;
    }
}

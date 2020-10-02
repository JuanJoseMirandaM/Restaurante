package bo.com.is.evaluation.dto;

public class RestauranteAmbienteDto {
    private Integer id;
    private Integer idTipoAmbiente;
//    private String nombre;
    private TipoAmbienteDto tipoAmbiente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdTipoAmbiente() {
        return idTipoAmbiente;
    }

    public void setIdTipoAmbiente(Integer idTipoAmbiente) {
        this.idTipoAmbiente = idTipoAmbiente;
    }

    public TipoAmbienteDto getTipoAmbiente() {
        return tipoAmbiente;
    }

    public void setTipoAmbiente(TipoAmbienteDto tipoAmbiente) {
        this.tipoAmbiente = tipoAmbiente;
    }


}

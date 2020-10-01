package bo.com.is.evaluation.dto;

import java.util.List;

public class RestauranteDto {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer telefono;
    private String estado;
    private String logo;
    private String horario;
    private String latitud;
    private String longitud;
    private String direccion;
    private Integer idTipoComida;
    private TipoComidaDto tipoComida;
    private List<RestauranteAmbienteDto> restauranteAmbientes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getIdTipoComida() {
        return idTipoComida;
    }

    public void setIdTipoComida(Integer idTipoComida) {
        this.idTipoComida = idTipoComida;
    }

    public TipoComidaDto getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(TipoComidaDto tipoComida) {
        this.tipoComida = tipoComida;
    }

    public List<RestauranteAmbienteDto> getRestauranteAmbientes() {
        return restauranteAmbientes;
    }

    public void setRestauranteAmbientes(List<RestauranteAmbienteDto> restauranteAmbientes) {
        this.restauranteAmbientes = restauranteAmbientes;
    }
}

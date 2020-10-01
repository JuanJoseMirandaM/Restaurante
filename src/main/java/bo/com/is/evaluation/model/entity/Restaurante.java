package bo.com.is.evaluation.model.entity;

import bo.com.is.evaluation.dto.TipoComidaDto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "RES_RESTAURANTES")
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 2, max = 30)
    private String nombre;

    @NotNull
    @Size(max = 30)
    private String descripcion;

    @NotNull
    private Integer telefono;

    @NotNull
    @Size(min=1, max = 10)
    private String estado;

    @NotNull
    @Size(max = 300)
    private String logo;

    @NotNull
    @Size(max = 30)
    private String horario;

    @NotNull
    @Size(max = 300)
    private String latitud;

    @NotNull
    @Size(max = 300)
    private String longitud;

    @NotNull
    @Size(max = 300)
    private String direccion;

    @Column(name = "id_tipo_comida")
    @NotNull
    private Integer idTipoComida;

    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;

    @Column(name = "id_usuario_alta")
    private Integer idUsuarioAlta;

    @Column(name = "fecha_baja")
    private LocalDateTime fechaBaja;

    @Column(name = "id_usuario_baja")
    private Integer idUsuarioBaja;

    @Column(name = "fecha_desde")
    private LocalDateTime fechaDesde;

    @Column(name = "id_usuario_desde")
    private Integer idUsuarioDesde;

    @Column(name = "fecha_hasta")
    private LocalDateTime fechaHasta;

    @Column(name = "id_usuario_hasta")
    private Integer idUsuarioHasta;

    @OneToMany(mappedBy = "restaurante")
    private List<RestauranteAmbiente> ambientes;

    @ManyToOne
    @JoinColumn(name = "id_tipo_comida", insertable = false, updatable = false)
    private TipoComida tipoComida;

    public List<RestauranteAmbiente> getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(List<RestauranteAmbiente> ambientes) {
        this.ambientes = ambientes;
    }

    public TipoComida getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(TipoComida tipoComida) {
        this.tipoComida = tipoComida;
    }

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

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Integer getIdUsuarioAlta() {
        return idUsuarioAlta;
    }

    public void setIdUsuarioAlta(Integer idUsuarioAlta) {
        this.idUsuarioAlta = idUsuarioAlta;
    }

    public LocalDateTime getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDateTime fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public Integer getIdUsuarioBaja() {
        return idUsuarioBaja;
    }

    public void setIdUsuarioBaja(Integer idUsuarioBaja) {
        this.idUsuarioBaja = idUsuarioBaja;
    }

    public LocalDateTime getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(LocalDateTime fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Integer getIdUsuarioDesde() {
        return idUsuarioDesde;
    }

    public void setIdUsuarioDesde(Integer idUsuarioDesde) {
        this.idUsuarioDesde = idUsuarioDesde;
    }

    public LocalDateTime getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(LocalDateTime fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public Integer getIdUsuarioHasta() {
        return idUsuarioHasta;
    }

    public void setIdUsuarioHasta(Integer idUsuarioHasta) {
        this.idUsuarioHasta = idUsuarioHasta;
    }
}

package bo.com.is.evaluation.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "res_tipo_ambientes")
public class TipoAmbiente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String descripcion;

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

    @OneToMany(mappedBy = "tipoAmbiente")
    private List<RestauranteAmbiente> restaurantes;

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

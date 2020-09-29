package bo.com.is.evaluation.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "RES_RESTAURANTE_AMBIENTES")
public class RestauranteAmbiente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_restaurante")
    private Integer idRestaurante;

    @Column(name = "id_tipo_ambiente")
    private Integer idTipoAmbiente;

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

    @ManyToOne
    @JoinColumn(name = "id_restaurante", insertable = false, updatable = false)
    private Restaurante restaurante;

    @ManyToOne
    @JoinColumn(name = "id_tipo_ambiente", insertable = false, updatable = false)
    private TipoAmbiente tipoAmbiente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

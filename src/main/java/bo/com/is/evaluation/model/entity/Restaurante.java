package bo.com.is.evaluation.model.entity;

import bo.com.is.evaluation.dto.TipoComidaDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data @Builder @AllArgsConstructor @NoArgsConstructor
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

    @OneToMany(mappedBy = "restaurante", cascade = {CascadeType.ALL})
    private List<RestauranteAmbiente> restauranteAmbientes;

    @ManyToOne
    @JoinColumn(name = "id_tipo_comida", insertable = false, updatable = false)
    private TipoComida tipoComida;
}

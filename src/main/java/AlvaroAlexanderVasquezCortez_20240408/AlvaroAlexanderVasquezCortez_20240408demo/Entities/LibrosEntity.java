package AlvaroAlexanderVasquezCortez_20240408.AlvaroAlexanderVasquezCortez_20240408demo.Entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name="LIBROS")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class LibrosEntity {
    @Id
    @Column(name="ID")
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "seq_libros")
    @SequenceGenerator(name = "seq_libros",sequenceName = "seq_libros",allocationSize = 1)
    private Long id;

    @Column(name = "TITULO",nullable = false, length = 200)
    private String titulo;

    @Column(name = "ISBN",unique = true, length = 20)
    private String isbn;

    @Column(name = "ANO_PUBLICACION",nullable = false)
    private Date ano_publicacion;

    @Column(name = "GENERO",nullable = false, length = 50)
    private String genero;

    @Column(name = "AUTOR_ID",nullable = false)
    private Long autor_id;

}

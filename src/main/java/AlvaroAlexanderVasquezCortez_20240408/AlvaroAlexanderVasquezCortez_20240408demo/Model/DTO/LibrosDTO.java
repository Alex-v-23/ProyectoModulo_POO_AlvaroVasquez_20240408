package AlvaroAlexanderVasquezCortez_20240408.AlvaroAlexanderVasquezCortez_20240408demo.Model.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class LibrosDTO {
    private Long id;

    @NotNull(message = "No puede ir vacio")
    @Size (max = 200,message = "No puede exceder mas de 200 caracter")
    private String titulo;

    @NotNull(message = "No puede ir vacio")
    @Size (max =20,message = "No puede exceder mas de 20 caracter")
    private String isbn;

    @NotNull(message = "No puede ir vacio")
    @Future(message = "No puede ser fecha futura")
    @DecimalMin(value = "0.0", message = "la fecha no puede tener numeros negativos")
    private Date ano_publicacion;

    @NotNull(message = "No puede ir vacio")
    @Size (max =50,message = "No puede exceder mas de 50 caracter")
    private String genero;

    @NotNull(message = "No puede ir vacio")
    private Long autor_id;
}

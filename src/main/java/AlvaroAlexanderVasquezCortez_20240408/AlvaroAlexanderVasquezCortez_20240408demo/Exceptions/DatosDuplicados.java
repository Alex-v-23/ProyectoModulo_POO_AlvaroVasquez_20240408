package AlvaroAlexanderVasquezCortez_20240408.AlvaroAlexanderVasquezCortez_20240408demo.Exceptions;

import lombok.Getter;

public class DatosDuplicados extends RuntimeException {

    @Getter
    private String campoduplicado;
    public Exception LibrosExceptions(String message) {
        super(message);
    }

    public Exception LibrosExceptions(String message, String campoduplicado) {
        super(message);
        this.campoduplicado = campoduplicado;
    }
}

package AlvaroAlexanderVasquezCortez_20240408.AlvaroAlexanderVasquezCortez_20240408demo.Controller;

import AlvaroAlexanderVasquezCortez_20240408.AlvaroAlexanderVasquezCortez_20240408demo.Model.DTO.LibrosDTO;
import AlvaroAlexanderVasquezCortez_20240408.AlvaroAlexanderVasquezCortez_20240408demo.Service.LibrosService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/Libros")
public class LibrosControllers {

    @Autowired
    private LibrosService service;

    @GetMapping("/ConsultarLibro")
    public ResponseEntity<List<LibrosDTO>> obtenerLibros(){
        return ResponseEntity.ok(service.ObtenerLibros());
    }

    @PostMapping("/InsertarLibros")
    public ResponseEntity<?> AgregarLibro(@Valid @RequestBody LibrosDTO json, BindingResult bindingResult, HttpServlet resquest) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> errores.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errores);
        }
        try {
            LibrosDTO respuesta = service.AgregarLibro(json);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(Map.of(
                            "status", "Registrado",
                            "data", respuesta
                    ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "status", "Error",
                    "message", "Error al registrar libro",
                    "detail", e.getMessage()
            ));
        }
    }
}

package AlvaroAlexanderVasquezCortez_20240408.AlvaroAlexanderVasquezCortez_20240408demo.Controller;

import AlvaroAlexanderVasquezCortez_20240408.AlvaroAlexanderVasquezCortez_20240408demo.Service.LibrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/Libros")
public class LibrosControllers {
    @Autowired
    private LibrosService service;
}

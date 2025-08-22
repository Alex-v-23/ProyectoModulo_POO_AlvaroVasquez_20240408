package AlvaroAlexanderVasquezCortez_20240408.AlvaroAlexanderVasquezCortez_20240408demo.Service;

import AlvaroAlexanderVasquezCortez_20240408.AlvaroAlexanderVasquezCortez_20240408demo.Entities.LibrosEntity;
import AlvaroAlexanderVasquezCortez_20240408.AlvaroAlexanderVasquezCortez_20240408demo.Model.DTO.LibrosDTO;
import AlvaroAlexanderVasquezCortez_20240408.AlvaroAlexanderVasquezCortez_20240408demo.Repositories.LibrosRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class LibrosService {
    @Autowired
    private LibrosRepository repo;

    public List<LibrosDTO>ObtenerLibros(){
        List<LibrosEntity> list =repo.findAll();
        return list.Stream().
    }

}

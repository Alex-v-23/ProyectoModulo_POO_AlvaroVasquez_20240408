package AlvaroAlexanderVasquezCortez_20240408.AlvaroAlexanderVasquezCortez_20240408demo.Service;

import AlvaroAlexanderVasquezCortez_20240408.AlvaroAlexanderVasquezCortez_20240408demo.Entities.LibrosEntity;
import AlvaroAlexanderVasquezCortez_20240408.AlvaroAlexanderVasquezCortez_20240408demo.Exceptions.ExceptionLibroNoEncontrado;
import AlvaroAlexanderVasquezCortez_20240408.AlvaroAlexanderVasquezCortez_20240408demo.Model.DTO.LibrosDTO;
import AlvaroAlexanderVasquezCortez_20240408.AlvaroAlexanderVasquezCortez_20240408demo.Repositories.LibrosRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class LibrosService {
    @Autowired
    private LibrosRepository repo;

    public List<LibrosDTO>ObtenerLibros(){
        List<LibrosEntity> list =repo.findAll();
        return list.stream()
                .map(this::ConvertirADTO)
                .collect(Collectors.toList());
    }
    /**
     * @param data
     * @ return
     */
    private LibrosEntity ConvertirAEntity (LibrosDTO data){
        LibrosEntity entity = new LibrosEntity();
        entity.setId(data.getId());
        entity.setTitulo(data.getTitulo());
        entity.setIsbn(data.getIsbn());
        entity.setGenero(data.getGenero());
        entity.setAutor_id(data.getAutor_id());
        return entity;
    }

    /**
     * @param entity
     * @return
     */
    private LibrosDTO ConvertirADTO(LibrosEntity entity){
        LibrosDTO dto = new LibrosDTO();
        dto.setId(entity.getId());
        dto.setTitulo(entity.getTitulo());
        dto.setIsbn(entity.getIsbn());
        dto.setGenero(entity.getGenero());
        dto.setAutor_id(entity.getAutor_id());
        return dto;
    }

    public LibrosDTO AgregarLibro (@Valid LibrosDTO data){
        if (data == null || data.getTitulo() == null|| data.getTitulo().isEmpty()){
            throw new IllegalArgumentException("campo o puede ser nulo");
        }
        try{
            LibrosEntity entity = ConvertirAEntity(data);
            LibrosEntity EventoGuardado = repo.save(entity);
            return ConvertirADTO(EventoGuardado);
        }catch (Exception e){
            log.error("error al registrar"+ e.getMessage());
            throw new ExceptionLibroNoEncontrado("Error al registrar lIBRO"+ e.getMessage());
        }
    }

}

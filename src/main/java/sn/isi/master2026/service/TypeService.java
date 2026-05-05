package sn.isi.master2026.service;


import sn.isi.master2026.dto.TypeDTO;
import sn.isi.master2026.mapper.TypeMapper;
import sn.isi.master2026.model.Type;
import sn.isi.master2026.repository.TypeRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TypeService {

    private final TypeRepository repository = new TypeRepository();

    // Récupère tous les types sous forme de DTO
    public List<TypeDTO> getAll() {
        List<TypeDTO> typeDTOS = new ArrayList<>();
        List<Type> types = repository.getAll() ;

        for (Type type : types) {
            typeDTOS.add(TypeMapper.toDTO(type));
        }
        return typeDTOS;

    }
    // Récupère un type par id
    public TypeDTO getById(int id) {
        return TypeMapper.toDTO(repository.getById(id));
    }

    // Ajoute un nouveau type
    public void add(TypeDTO dto) {
        Type type = TypeMapper.toEntity(dto);
        type.setDateCreation(LocalDate.now());
        repository.add(type);  // DTO → Entité
    }

    // Modifie un type existant
    public void update(TypeDTO dto) {
        repository.update(TypeMapper.toEntity(dto));
    }

    // Supprime un type
    public void delete(int id) {
        repository.delete(id);
    }
}


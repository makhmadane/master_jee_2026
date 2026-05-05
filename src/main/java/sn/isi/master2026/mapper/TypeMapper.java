package sn.isi.master2026.mapper;


import sn.isi.master2026.dto.TypeDTO;
import sn.isi.master2026.model.Type;

public class TypeMapper {

    // Entité → DTO  (pour envoyer vers la vue)
    public static TypeDTO toDTO(Type type) {
        if (type == null) return null;
        TypeDTO dto = new TypeDTO();
        dto.setId(type.getId());
        dto.setLibelle(type.getLabel());
        return dto;
    }

    // DTO → Entité  (pour sauvegarder en base)
    public static Type toEntity(TypeDTO dto) {
        if (dto == null) return null;
        Type type = new Type();
        type.setId(dto.getId());
        type.setLabel(dto.getLibelle());
        return type;
    }
}

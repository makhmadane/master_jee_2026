package sn.isi.master2026.mapper;


import sn.isi.master2026.dto.UtilisateurDTO;
import sn.isi.master2026.model.Utilisateur;

public class UtilisateurMapper {

    // Convertit l'entité en DTO (sans le mot de passe)
    public static UtilisateurDTO toDTO(Utilisateur utilisateur) {
        if (utilisateur == null) return null;
        UtilisateurDTO dto = new UtilisateurDTO();
        dto.setId(utilisateur.getId());
        dto.setLogin(utilisateur.getLogin());
        return dto;
    }
}

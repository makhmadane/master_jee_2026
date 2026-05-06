package sn.isi.master2026.service;


import org.mindrot.jbcrypt.BCrypt;
import sn.isi.master2026.dto.UtilisateurDTO;
import sn.isi.master2026.mapper.UtilisateurMapper;
import sn.isi.master2026.model.Utilisateur;
import sn.isi.master2026.repository.UtilisateurRepository;

public class UtilisateurService {

    private final UtilisateurRepository repository = new UtilisateurRepository();

    // Authentifie un utilisateur : retourne son DTO si OK, null sinon
    public UtilisateurDTO authenticate(String login, String password) {
        Utilisateur utilisateur = repository.findByLogin(login);

        if (utilisateur == null) return null;
        if (!BCrypt.checkpw(password, utilisateur.getPassword())) return null;

        return UtilisateurMapper.toDTO(utilisateur);
    }

    // Enregistre un utilisateur avec mot de passe haché
    public void register(String login, String password) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setLogin(login);
        utilisateur.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
        repository.add(utilisateur);
    }
}

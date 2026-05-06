package sn.isi.master2026.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import sn.isi.master2026.dto.UtilisateurDTO;
import sn.isi.master2026.service.UtilisateurService;

import java.io.IOException;

@WebServlet(name = "authServlet", value = "/login")
public class AuthServlet extends HttpServlet {

    private UtilisateurService utilisateurService;

    @Override
    public void init() {
        utilisateurService = new UtilisateurService();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        // Cas déconnexion : /login?action=logout
        if ("logout".equals(action)) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        // Si déjà connecté, rediriger vers l'accueil
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("utilisateur") != null) {
            response.sendRedirect(request.getContextPath() + "/personne");
            return;
        }

        // Afficher le formulaire de connexion
        RequestDispatcher dispatcher =
                request.getRequestDispatcher((action.equals("register")) ? "register.jsp" :  "login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        String login    = request.getParameter("login");
        String password = request.getParameter("password");

        switch (action){
            case "register" :

                if (login == null || login.trim().isEmpty() ||
                        password == null || password.trim().isEmpty()) {
                    request.setAttribute("Erreur", "Login et mot de passe obligatoires.");
                    RequestDispatcher dispatcher =
                            request.getRequestDispatcher("registrer.jsp");
                    dispatcher.forward(request, response);

                }
                try {
                    utilisateurService.register(login, password);
                    response.sendRedirect(request.getContextPath() + "/assurance");
                } catch (Exception e) {
                    request.setAttribute("error", "Erreur : " + e.getMessage());
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                }



                break;
            case  "login":

                UtilisateurDTO utilisateur =
                        utilisateurService.authenticate(login, password);

                // Echec → ré-afficher le formulaire avec un message d'erreur
                if (utilisateur == null) {
                    request.setAttribute("erreur",
                            "Login ou mot de passe incorrect.");
                    RequestDispatcher dispatcher =
                            request.getRequestDispatcher("login.jsp");
                    dispatcher.forward(request, response);
                    return;
                }

                // Succès → créer la session et rediriger
                HttpSession session = request.getSession();
                session.setAttribute("utilisateur", utilisateur);
                session.setMaxInactiveInterval(30 * 60);  // 30 min

        }


        response.sendRedirect(request.getContextPath() + "/assurance");
    }
}

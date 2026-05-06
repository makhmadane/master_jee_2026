

<%@include file="header.jsp"%>

<div class="card" style="max-width:400px; margin:100px auto; padding:2rem;">
    <h4 class="text-center mb-4">Register</h4>

    <!-- Affiche l'erreur si le servlet en a mis une dans request -->
    <% if (request.getAttribute("erreur") != null) { %>
    <div class="alert alert-danger">
        <%= request.getAttribute("erreur") %>
    </div>
    <% } %>

    <!-- Le formulaire envoie les données en POST vers /login -->
    <form action="?action=register" method="post">
        <div class="mb-3">
            <label for="login">Login</label>
            <input type="text" name="login" id="login"
                   class="form-control" required>
        </div>
        <div class="mb-3">
            <label for="password">Mot de passe</label>
            <input type="password" name="password" id="password"
                   class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary w-100">
            Se connecter
        </button>
    </form>
</div>
<%@include file="footer.jsp"%>

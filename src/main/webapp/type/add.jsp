<%@include file="../header.jsp" %>
<div class="container mt-5">
    <h4>Ajouter un type</h4>
    <form action="?action=saveType" method="post">
        <div class="mb-3">
            <label for="libelle">Libelle</label>
            <input type="text" name="libelle" id="libelle"
                   class="form-control" required>
        </div>
        <button type="submit" class="btn btn-success">
            Enregistrer
        </button>
        <a href="?action=" class="btn btn-secondary">Annuler</a>
    </form>
</div>

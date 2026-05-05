<%@ page import="sn.isi.master2026.dto.TypeDTO" %>
<%@include file="../header.jsp" %>

<%
    TypeDTO t = (TypeDTO) request.getAttribute("type");
%>

<div class="container mt-5">
    <h4>Modifier le type</h4>
    <form action="?action=editType" method="post">
        <!-- Champ caché pour transmettre l'id -->
        <input type="hidden" name="id" value="<%= t.getId() %>">
        <div class="mb-3">
            <label for="libelle">Libelle</label>
            <input type="text" name="libelle" id="libelle"
                   class="form-control"
                   value="<%= t.getLibelle() %>" required>
        </div>
        <button type="submit" class="btn btn-primary">
            Modifier
        </button>
        <a href="?action=" class="btn btn-secondary">Annuler</a>
    </form>
</div>

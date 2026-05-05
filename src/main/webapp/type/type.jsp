<%@ page import="sn.isi.master2026.dto.TypeDTO" %>
<%@ page import="java.util.List" %>
<%@include file="../header.jsp" %>

<%
    List<TypeDTO> list = (List<TypeDTO>) request.getAttribute("types");
%>

<div class="container">
    <a href="?action=addType" class="mt-5 btn btn-success">
        Ajouter
    </a>

    <table class="table table-striped mt-5">
        <tr>
            <th>Id</th>
            <th>Libelle</th>
            <th>Options</th>
        </tr>
        <% for (TypeDTO t : list) { %>
        <tr>
            <td><%= t.getId() %></td>
            <td><%= t.getLibelle() %></td>
            <td>
                <a class="btn btn-danger"
                   href="?action=deleteType&id=<%= t.getId() %>">
                    Supprimer
                </a>
                <a class="btn btn-primary"
                   href="?action=updateType&id=<%= t.getId() %>">
                    Modifier
                </a>
            </td>
        </tr>
        <% } %>
    </table>
</div>

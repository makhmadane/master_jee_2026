<%@ page import="java.util.List" %>
<%@ page import="sn.isi.master2026.model.Assurance" %><%--
  Created by IntelliJ IDEA.
  User: dane7
  Date: 11/04/2026
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Assurance> list = (List<Assurance>) request.getAttribute("tabAssurances");
%>

    <%@include file="../header.jsp"%>

    <div class="container mt-5">
        <a class="btn btn-success" href="?action=add">Ajouter </a>
        <table class="table table-striped">
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Numero</th>
                <th>CNI</th>
                <th>Date de creation</th>
                <th>Actions</th>
            </tr>

            <% for (Assurance a : list) { %>
            <tr>
                <td><%= a.getId()  %> </td>
                <td><%= a.getNomClient()  %> </td>
                <td><%= a.getNumero()  %> </td>
                <td><%= a.getCni()  %> </td>
                <td><%= a.getDateCreation()  %> </td>
                <td>
                    <a class="btn btn-primary" href="?action=edit&&id=<%=a.getId()%>">Modifier </a>
                    <a class="btn btn-danger" href="?action=delete&&id=<%=a.getId()%>">Supprimer </a>
                </td>
            </tr>

            <% } %>

        </table>
    </div>
<%@include file="../footer.jsp"%>

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
<html>
<head>
    <title>Title</title>
</head>
<body>
        <table>
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>CNI</th>
                <th>Date de creation</th>
            </tr>

            <% for (Assurance a : list) { %>
                <tr>
                    <td><%= a.getId()  %> </td>
                    <td><%= a.getNomClient()  %> </td>
                    <td><%= a.getCni()  %> </td>
                    <td><%= a.getDateCreation()  %> </td>
                </tr>

            <% } %>

        </table>
</body>
</html>

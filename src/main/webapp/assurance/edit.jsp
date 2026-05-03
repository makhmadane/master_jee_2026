<%@ page import="sn.isi.master2026.model.Assurance" %><%--
  Created by IntelliJ IDEA.
  User: dane7
  Date: 03/05/2026
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../header.jsp"%>
<%
    Assurance assurance = (Assurance) request.getAttribute("assurance");
%>
       <div class="container mt-5">
           <form method="post" action="?action=update">
               <input type="text"  class="form-control" name="id" value="<%= assurance.getId() %>" hidden>
               <label>Nom du Client</label>
               <input type="text"  class="form-control" name="nom" value="<%= assurance.getNomClient() %>">
               <label>Numero</label>
               <input type="text"  class="form-control" name="numero" value="<%= assurance.getNumero() %>">
               <label>CNI</label>
               <input type="text"  class="form-control" name="cni" value="<%=  assurance.getCni() %>">
                <br>
               <button class="btn btn-info" name="update">Modifier</button>
           </form>
       </div>
<%@include file="../footer.jsp"%>

<%--
  Created by IntelliJ IDEA.
  User: dane7
  Date: 03/05/2026
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../header.jsp"%>
       <div class="container mt-5">
           <form method="post" action="?action=save">
               <label>Nom du Client</label>
               <input type="text"  class="form-control" name="nom">
               <label>Numero</label>
               <input type="text"  class="form-control" name="numero">
               <label>CNI</label>
               <input type="text"  class="form-control" name="cni">
                <br>
               <button class="btn btn-info" name="save">Save</button>
           </form>
       </div>
<%@include file="../footer.jsp"%>

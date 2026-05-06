<!--uri = "http://java.sun.com/jsp/jstl/core" tomcat 9 javax-->
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <%@include file="../header.jsp"%>

    <div class="container mt-5">
        <a class="btn btn-success" href="?action=add">Ajouter </a>

        <c:choose>
            <c:when test="${empty tabAssurances}">
                Aucune Assurance trouvée
            </c:when>

            <c:otherwise>
                <table class="table table-striped">
                    <tr>
                        <th>ID</th>
                        <th>Nom</th>
                        <th>Numero</th>
                        <th>CNI</th>
                        <th>Date de creation</th>
                        <th>Actions</th>
                    </tr>

                    <c:forEach items="${tabAssurances}" var="a"  >
                        <tr>
                            <td> ${a.getId()} </td>
                            <td>${ a.getNomClient()  } </td>
                            <td>${ a.getNumero()  } </td>
                            <td>${ a.getCni()  } </td>
                            <td>${ a.getDateCreation()  } </td>
                            <td>
                                <a class="btn btn-primary" href="?action=edit&&id=${a.getId()}">Modifier </a>
                                <a class="btn btn-danger" href="?action=delete&&id=${a.getId()}">Supprimer </a>
                            </td>
                        </tr>

                    </c:forEach>


                </table>
            </c:otherwise>
        </c:choose>

    </div>
<%@include file="../footer.jsp"%>

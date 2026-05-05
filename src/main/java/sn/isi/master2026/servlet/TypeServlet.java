package sn.isi.master2026.servlet;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.isi.master2026.dto.TypeDTO;
import sn.isi.master2026.service.TypeService;

import java.io.IOException;

@WebServlet("/type")
public class TypeServlet extends HttpServlet {

    private TypeService typeService;

    @Override
    public void init() {
        typeService = new TypeService();  // instancié une seule fois
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action") != null
                ? request.getParameter("action") : "";
        RequestDispatcher dispatcher;

        switch (action) {
            case "addType":
                dispatcher = request.getRequestDispatcher("type/add.jsp");
                dispatcher.forward(request, response);
                break;

            case "deleteType":
                typeService.delete(
                        Integer.parseInt(request.getParameter("id")));
                response.sendRedirect("?action=");
                break;

            case "updateType":
                request.setAttribute("type",
                        typeService.getById(
                                Integer.parseInt(request.getParameter("id"))));
                dispatcher = request.getRequestDispatcher("type/edit.jsp");
                dispatcher.forward(request, response);
                break;

            default:
                request.setAttribute("types", typeService.getAll());
                dispatcher = request.getRequestDispatcher("type/type.jsp");
                dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action") != null
                ? request.getParameter("action") : "";

        switch (action) {
            case "saveType":
                TypeDTO dto = new TypeDTO();
                dto.setLibelle(request.getParameter("libelle"));
                typeService.add(dto);
                response.sendRedirect("?action=");
                break;

            case "editType":
                TypeDTO editDto = new TypeDTO();
                editDto.setId(
                        Integer.parseInt(request.getParameter("id")));
                editDto.setLibelle(request.getParameter("libelle"));
                typeService.update(editDto);
                response.sendRedirect("?action=");
                break;
        }
    }
}


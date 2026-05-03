package sn.isi.master2026.servlet;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.isi.master2026.model.Assurance;
import sn.isi.master2026.repository.AssuranceRepository;

import java.io.IOException;
import java.lang.reflect.Parameter;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/assurance")
public class AssuranceServlet  extends HttpServlet {

    private  AssuranceRepository assuranceRepository;

    public AssuranceServlet(){
        this.assuranceRepository = new AssuranceRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action") == null ? "list" : req.getParameter("action");
        RequestDispatcher dispatcher;
        switch (action){
            case  "list" :
                List<Assurance> assurances =  this.assuranceRepository.getAll();
                // appele la page view
                req.setAttribute("tabAssurances",assurances); // add du tableau dans la req
                dispatcher = req.getRequestDispatcher("assurance/list.jsp"); // redirection
                dispatcher.forward(req,resp);  //transfert req et du resp a list.jsp
                break;

            case  "add":
                dispatcher = req.getRequestDispatcher("assurance/add.jsp"); // redirection
                dispatcher.forward(req,resp);  //transfert req et du resp a list.jsp
                break;
            case "delete" :
                int id = Integer.parseInt(req.getParameter("id"));
                this.assuranceRepository.delete(id);
                resp.sendRedirect("?action=list");
                break;
            case "edit" :
                int idEdit = Integer.parseInt(req.getParameter("id"));
                Assurance assurance = assuranceRepository.getById(idEdit);
                req.setAttribute("assurance",assurance);
                dispatcher = req.getRequestDispatcher("assurance/edit.jsp"); // redirection
                dispatcher.forward(req,resp);  //transfert req et du resp a list.jsp


        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action") == null ? "list" : req.getParameter("action");
        RequestDispatcher dispatcher;
        switch (action){
            case "save" :
                Assurance assurance =  Assurance.
                        builder().
                        cni(req.getParameter("cni")).
                        numero( req.getParameter("numero")).
                        nomClient( req.getParameter("nom")).
                        dateCreation(LocalDate.now()).
                        build();
                assuranceRepository.add(assurance);
                resp.sendRedirect("?action=list");
                break;
            case "update" :
                Assurance assuranceUpd =  Assurance.
                        builder().
                        id(Integer.parseInt(req.getParameter("id"))).
                        cni(req.getParameter("cni")).
                        numero( req.getParameter("numero")).
                        nomClient( req.getParameter("nom")).
                        dateCreation(LocalDate.now()).
                        build();
                assuranceRepository.update(assuranceUpd);
                resp.sendRedirect("?action=list");

        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}

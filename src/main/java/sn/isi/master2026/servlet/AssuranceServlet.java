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
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/assurance")
public class AssuranceServlet  extends HttpServlet {

    private  AssuranceRepository assuranceRepository;

    public AssuranceServlet(){
        this.assuranceRepository = new AssuranceRepository();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       List<Assurance> assurances =  this.assuranceRepository.getAll();
       // appele la page view
        req.setAttribute("tabAssurances",assurances); // add du tableau dans la req
        RequestDispatcher dispatcher = req.getRequestDispatcher("assurance/list.jsp"); // redirection
        dispatcher.forward(req,resp);  //transfert req et du resp a list.jsp
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}

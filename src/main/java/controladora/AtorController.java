package controladora;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import DAO.AtorDAO;
import dominio.Ator;
import javax.servlet.*;
@WebServlet("/AtorController")
public class AtorController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "add":
                    addAtor(request, response);
                    break;
                // Outras ações como edit e delete
            }
        }
    }

    private void addAtor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");

        Ator ator = new Ator();
        ator.setNome(nome);

        AtorDAO.addAtor(ator); //
        response.sendRedirect("ator.jsp");
    }

}

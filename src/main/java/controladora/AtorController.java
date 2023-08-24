package controladora;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import DAO.AtorDAO;
import dominio.Ator;

import javax.servlet.*;

import static DAO.AtorDAO.getAtorById;
import static java.lang.System.out;

@WebServlet(value = "/AtorController", loadOnStartup = 1)
public class AtorController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "edit":
                    editarAtor(request, response);
                    break;
                case "delete":
                    deletarAtor(request, response);
                    break;
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("atualizar".equals(action)) {
            atualizarAtor(request, response);
        } else if ("add".equals(action)){
            addAtor(request,response);
        }
    }



    private void addAtor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");

        Ator ator = new Ator();
        ator.setNome(nome);

        AtorDAO.addAtor(ator); //
        response.sendRedirect("ator.jsp");
    }

    private void atualizarAtor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String nomeClasse = request.getParameter("classe");

        // Lógica para atualizar o ator com os novos detalhes
        Ator ator = AtorDAO.getAtorById(id);
        if (ator != null) {
            ator.setNome(nome);

            AtorDAO.atualizarAtor(ator);
        }

        // Redirecionamento para a lista de atores após a atualização
        listAtores(request, response);
    }

    private void editarAtor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtenha o ID do ator da requisição
        out.println("to entrando aq");
        String idStr = request.getParameter("id");
        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);

            // Lógica para carregar os dados do ator a ser editado
            Ator ator = AtorDAO.getAtorById(id);

            if (ator != null) {
                // Defina o ator como atributo da requisição e encaminhe para a página de edição
                request.setAttribute("ator", ator);
                request.getRequestDispatcher("editarAtor.jsp").forward(request, response);
            }
        }
    }

    private void deletarAtor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtenha o ID do ator da requisição
        String idStr = request.getParameter("id");
        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);

            // Lógica para excluir o ator
            AtorDAO.deletarAtor(id);

            // Redirecione de volta para a lista de atores após a exclusão
            listAtores(request, response);
        }
    }

    private void listAtores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Ator> atores = AtorDAO.getLista();
        request.setAttribute("atores", atores);
        request.getRequestDispatcher("ator.jsp").forward(request, response);
    }


}

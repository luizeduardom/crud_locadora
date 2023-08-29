package controladora;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import DAO.ClasseDAO;
import dominio.Classe;

import javax.servlet.*;

import static DAO.ClasseDAO.getClasseById;
import static java.lang.System.out;

@WebServlet(value = "/ClasseController", loadOnStartup = 1)
public class ClasseController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "edit":
                    editarClasse(request, response);
                    break;
                case "delete":
                    deletarClasse(request, response);
                    break;
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("atualizar".equals(action)) {
            atualizarClasse(request, response);
        } else if ("add".equals(action)){
            addClasse(request,response);
        }
    }



    private void addClasse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");
        float valor = Float.parseFloat(request.getParameter("valor"));
        int prazo = Integer.parseInt(request.getParameter("prazoDevolucao"));

        Classe classe = new Classe();
        classe.setNome(nome);
        classe.setValor(valor);
        classe.setPrazoDevolucao(prazo);

        ClasseDAO.addClasse(classe); //
        response.sendRedirect("classe.jsp");
    }

    private void atualizarClasse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        float valor = Float.parseFloat(request.getParameter("valor"));
        int prazo = Integer.parseInt(request.getParameter("prazo"));

        // Lógica para atualizar a classe com os novos detalhes
        Classe classe = ClasseDAO.getClasseById(id);
        if (classe != null) {
            classe.setNome(nome);
            classe.setValor(valor);
            classe.setPrazoDevolucao(prazo);
            ClasseDAO.atualizarClasse(classe);
        }

        // Redirecionamento para a lista de atores após a atualização
        listClasse(request, response);
    }

    private void editarClasse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtenha o ID da classe da requisição
        String idStr = request.getParameter("id");
        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);

            // Lógica para carregar os dados da classe a ser editada
            Classe classe = ClasseDAO.getClasseById(id);

            if (classe != null) {
                // Defina a classe como atributo da requisição e encaminhe para a página de edição
                request.setAttribute("classe", classe);
                request.getRequestDispatcher("editarClasse.jsp").forward(request, response);
            }
        }
    }

    private void deletarClasse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtenha o ID da Classe da requisição
        String idStr = request.getParameter("id");
        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);

            // Lógica para excluir a classe
            ClasseDAO.deletarClasse(id);

            // Redirecione de volta para a lista de classes após a exclusão
            listClasse(request, response);
        }
    }

    private void listClasse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Classe> classes = ClasseDAO.getLista();
        request.setAttribute("classes", classes);
        request.getRequestDispatcher("classe.jsp").forward(request, response);
    }


}

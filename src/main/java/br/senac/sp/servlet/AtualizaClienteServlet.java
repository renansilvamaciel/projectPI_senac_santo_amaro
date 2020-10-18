package br.senac.sp.servlet;

import br.senac.sp.dao.ClientesDAO;
import br.senac.sp.entidade.Cliente;
import br.senac.sp.util.Utils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Azazel
 */
public class AtualizaClienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cliente cliente = new Cliente();

        cliente.setNome(request.getParameter("nome"));
        cliente.setSexo(request.getParameter("sexo"));
        cliente.setData_nascimento(request.getParameter("data_nascimento"));
        cliente.setCpf(request.getParameter("cpf"));
        cliente.setRua(request.getParameter("rua"));
        cliente.setCep(request.getParameter("cep"));
        cliente.setNumero_casa(Integer.parseInt(request.getParameter("numero_casa")));
        cliente.setBairro(request.getParameter("bairro"));
        cliente.setEmail(request.getParameter("email"));
        cliente.setTelefone(request.getParameter("telefone"));
        cliente.setAssinatura(request.getParameter("assinatura"));
        cliente.setTipo_assinatura(request.getParameter("tipo_assinatura"));

        try {

            if (cliente.validacaoIdade(cliente.getData_nascimento())) {
                ClientesDAO clienteDao = new ClientesDAO();
                clienteDao.updateClient(cliente);
                Utils.mostrarTelaSucesso(response);
            } else {
                Utils.mostrarTelaErroIdade(response);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AtualizaClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AtualizaClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
        }
    }

}

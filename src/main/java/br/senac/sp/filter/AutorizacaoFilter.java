/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.filter;

import br.senac.sp.entidade.Funcionario;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Juliano
 */
public class AutorizacaoFilter implements Filter {

    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public AutorizacaoFilter() {
    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession sessao = httpRequest.getSession();
        if (sessao.getAttribute("usuario") == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/Login.jsp");
        }
        // sessao.setAttribute("usuario", usuario);

        Funcionario usuario = (Funcionario) sessao.getAttribute("usuario");
        String url = httpRequest.getRequestURI();

        // ****GERENTE***
        if (url.contains("relatorio.jsp") && !usuario.isGerente()) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/AcessoNaoAutorizado.jsp");
        }

        // ****FUNCIONARIO****
        if (url.contains("Venda") && !usuario.isVendedor()) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/AcessoNaoAutorizado.jsp");
        }

        if (url.contains("VendaPlanos.jsp") && !usuario.isVendedor()) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/AcessoNaoAutorizado.jsp");
        }

        if (url.contains("VendaAssinantes.jsp") && !usuario.isVendedor()) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/AcessoNaoAutorizado.jsp");
        }

        if (url.contains("Cliente.jsp") && !usuario.isVendedor()) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/AcessoNaoAutorizado.jsp");
        }

        if (url.contains("ClienteServlet") && !usuario.isVendedor()) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/AcessoNaoAutorizado.jsp");
        }

        // ****BACKOFFICE****
        if (url.contains("Funcionario.jsp") && !usuario.isBackoffice()) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/AcessoNaoAutorizado.jsp");
        }

        if (url.contains("FuncionarioServlet") && !usuario.isBackoffice()) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/AcessoNaoAutorizado.jsp");
        }
        if (url.contains("/Produto") && !usuario.isBackoffice()) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/AcessoNaoAutorizado.jsp");
        }

        if (url.contains("/PlanoServlet") && !usuario.isBackoffice()) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/AcessoNaoAutorizado.jsp");
        }

        if (url.contains("/FilialServlet") && !usuario.isBackoffice()) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/AcessoNaoAutorizado.jsp");
        }

    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {

    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        if (debug) {
            log("AutorizacaoFilter:doFilter()");
        }

        doBeforeProcessing(request, response);

        Throwable problem = null;
        try {
            chain.doFilter(request, response);
        } catch (Throwable t) {
            // If an exception is thrown somewhere down the filter chain,
            // we still want to execute our after processing, and then
            // rethrow the problem after that.
            problem = t;
            t.printStackTrace();
        }

        doAfterProcessing(request, response);

        // If there was a problem, we want to rethrow it if it is
        // a known type, otherwise log it.
        if (problem != null) {
            if (problem instanceof ServletException) {
                throw (ServletException) problem;
            }
            if (problem instanceof IOException) {
                throw (IOException) problem;
            }
            sendProcessingError(problem, response);
        }
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("AutorizacaoFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("AutorizacaoFilter()");
        }
        StringBuffer sb = new StringBuffer("AutorizacaoFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}

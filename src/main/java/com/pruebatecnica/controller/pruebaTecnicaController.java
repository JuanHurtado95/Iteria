/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebatecnica.controller;

import com.pruebatecnica.dao.ClienteDao;
import com.pruebatecnica.dao.ProductoDao;
import com.pruebatecnica.entity.Cliente;
import com.pruebatecnica.entity.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class pruebaTecnicaController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion =request.getParameter("opcion");
        
        String opcion2 = "";
        if(opcion.contains("?")){
            String[] parts = opcion.split("=");
            opcion2= parts[1];
            opcion = parts[0];
            //String id = opcion2.split("?")[1].split("=")[1];
        }
        if(opcion.equals("menu_cliente")){
            System.out.println("menu_cliente");
            ClienteDao clienteDao = new ClienteDao();
            List<Cliente> clientes = clienteDao.Listar();
            request.setAttribute("lista", clientes);
            RequestDispatcher rd = request.getRequestDispatcher("cliente.jsp");
            rd.forward(request, response);
            
        }else if(opcion.equals("menu_cliente_crear")){
            System.out.println("menu_cliente_crear");
            
            RequestDispatcher rd = request.getRequestDispatcher("cliente_crear.jsp");
            rd.forward(request, response);
            
        }else if(opcion.equals("delete_cliente?id")){
            ClienteDao dao = new ClienteDao();
            Cliente cliente = new Cliente();
            cliente.setId(Integer.parseInt(opcion2));
            dao.eliminar(cliente);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
        
        
        if(opcion.equals("menu_producto")){
            System.out.println("menu_producto");
            ProductoDao productoDao = new ProductoDao();
            List<Producto> productos = productoDao.Listar();
            request.setAttribute("lista", productos);
            RequestDispatcher rd = request.getRequestDispatcher("producto.jsp");
            rd.forward(request, response);
            
        }else if(opcion.equals("menu_producto_crear")){
            System.out.println("menu_producto_crear");
            
            RequestDispatcher rd = request.getRequestDispatcher("producto_crear.jsp");
            rd.forward(request, response);
            
        }else if(opcion.equals("delete_producto?id")){
            ProductoDao dao = new ProductoDao();
            Producto producto = new Producto();
            producto.setId(Integer.parseInt(opcion2));
            dao.eliminar(producto);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String opcion=request.getParameter("opcion");
        
        if(opcion.equals("guardar_cliente")){
            ClienteDao dao = new ClienteDao();
            Cliente cliente = new Cliente();
            cliente.setPrimer_nombre(request.getParameter("nombre"));
            cliente.setSegundo_nombre(request.getParameter("snombre"));
            cliente.setPrimer_apellido(request.getParameter("apellido"));
            cliente.setSegundo_apellido(request.getParameter("sapellido"));
            cliente.setNum_contact(request.getParameter("contacto"));
            dao.guardar(cliente);
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.forward(request, response);
        }
        
        if(opcion.equals("guardar_producto")){
            ProductoDao dao = new ProductoDao();
            Producto producto = new Producto();
            producto.setNom_prod(request.getParameter("nombre"));
            producto.setDes_prod(request.getParameter("descripcion"));
            producto.setValor_prod(request.getParameter("valor"));
            dao.guardar(producto);
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.forward(request, response);
        }
        
        
        
        //processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

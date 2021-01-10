/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

public class Servidor extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servidor</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servidor at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // recuperamos los datos recividos con request
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));

        String json = "";//un objeto string para almacenar los datos
        json = br.readLine();//igualamos lo objetnido mediante readLine al string
        PrintWriter out = null;//objeto que nos sirve para imprimir 
        try {//try-catch opcional para poder verificar algun problema en la conversion de cadena string a json
            out = response.getWriter();
            JSONObject jsonObject = new JSONObject(json);//un objeto de tipo JSONObject para almacenar lo obtenido, convertimos la cadena string a un objeto json,
            //se usa esta libreria https://mvnrepository.com/artifact/org.json/json/20201115
            jsonObject.put("saludo", "hola como estas");//agregamos un nuevo dato
            System.out.println(jsonObject.getString("saludo"));//imprimimos por consola
            out.print(jsonObject);//imprimimos los datos objtenidos
            out.close();//cerramos 
            jsonObject = null;//limpiamos

        } catch (JSONException err) {
            System.out.println(err.getMessage());
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

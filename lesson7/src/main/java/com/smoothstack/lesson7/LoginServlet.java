package com.smoothstack.lesson7;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "LoginServlet", value = "/handle-login")
public class LoginServlet extends HttpServlet {

    private final String valid_username = "admin";
    private final String valid_password = "password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || password == null) {
            response.setContentType("text/html");
            response.setStatus(400);

            writeResponse(response.getWriter(), "Invalid Form");
            return;
        }

        if (username.equals(valid_username) && password.equals(valid_password)) {
            response.setContentType("text/html");
            response.setStatus(200);

            writeResponse(response.getWriter(), "Successfully logged in as " + valid_username + "!");
        } else {
            response.setContentType("text/html");
            response.setStatus(403);

            writeResponse(response.getWriter(), "Invalid username or password!");
        }
    }

    private static void writeResponse(PrintWriter writer, String message) {
        writer.println("<html><body>");
        writer.println("<h1>" + message + "</h1>");
        writer.println("</body></html>");
    }
}

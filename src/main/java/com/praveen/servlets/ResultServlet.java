package com.praveen.servlets;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String rollStr = request.getParameter("rollno");
        int roll = Integer.parseInt(rollStr);
        

        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to DB
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "");

            PreparedStatement ps = con.prepareStatement("SELECT * FROM students WHERE roll_no = ?");
            ps.setInt(1, roll);

            ResultSet rs = ps.executeQuery();
            
            out.println("<html><head><title>Result</title>");
            out.println("<style>");
            out.println("body { background-color: lightyellow; text-align: center; font-family: Arial; }");
            out.println(".box { margin-top: 100px; display: inline-block; padding: 20px; background-color: white; border: 1px solid #ccc; }");
            out.println("</style></head><body>");
            out.println("<div class='box'>");

            if (rs.next()) {
                out.println("<h2>Result</h2>");
                out.println("<p>Roll Number: " + rs.getInt("roll_no") + "</p>");
                out.println("<p>Name: " + rs.getString("name") + "</p>");
                out.println("<p>Marks: " + rs.getInt("marks") + "</p>");
            } else {
                out.println("<h3>No result found for Roll No: " + roll + "</h3>");
            }

            out.println("</div></body></html>");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}

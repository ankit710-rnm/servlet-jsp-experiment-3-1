package com.example;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class EmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String empID = request.getParameter("EmpID");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college_portal", "root", "root");

            String query;
            if (empID != null && !empID.isEmpty()) {
                query = "SELECT * FROM employee WHERE EmpID=" + empID;
            } else {
                query = "SELECT * FROM employee";
            }

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            out.println("<h2>Employee Records</h2>");
            out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Salary</th></tr>");
            while (rs.next()) {
                out.println("<tr><td>" + rs.getInt("EmpID") + "</td><td>" +
                        rs.getString("Name") + "</td><td>" + rs.getDouble("Salary") + "</td></tr>");
            }
            out.println("</table>");
            out.println("<br><a href='employees.html'>Go Back</a>");

            con.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}

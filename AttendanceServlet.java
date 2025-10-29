package com.example;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AttendanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int sid = Integer.parseInt(request.getParameter("StudentID"));
        String date = request.getParameter("Date");
        String status = request.getParameter("Status");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college_portal", "root", "root");
            PreparedStatement ps = con.prepareStatement("INSERT INTO attendance VALUES (?, ?, ?)");
            ps.setInt(1, sid);
            ps.setString(2, date);
            ps.setString(3, status);
            ps.executeUpdate();

            RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}

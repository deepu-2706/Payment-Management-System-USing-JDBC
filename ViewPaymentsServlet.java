package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewPaymentsServlet")
public class ViewPaymentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/deepu";
        String username = "root";
        String password = "webstudent"
        		+ "";

        // SQL query to fetch payment data
        String query = "SELECT * FROM Payment";

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            try (Connection connection = DriverManager.getConnection(url, username, password);
                 PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {

                // Output HTML table with CSS styles
                out.println("<style>");
                out.println("table {");
                out.println("    font-family: Arial, sans-serif;");
                out.println("    border-collapse: collapse;");
                out.println("    width: 100%;");
                out.println("}");
                out.println("th, td {");
                out.println("    border: 1px solid #dddddd;");
                out.println("    text-align: left;");
                out.println("    padding: 8px;");
                out.println("}");
                out.println("tr:nth-child(even) {");
                out.println("    background-color: #f2f2f2;");
                out.println("}");
                out.println("</style>");

                out.println("<table>");
                out.println("<tr>");
                out.println("<th>Payment ID</th>");
                out.println("<th>Customer ID</th>");
                out.println("<th>Amount</th>");
                out.println("<th>Date</th>");
                out.println("<th>Payment Method</th>");
                out.println("</tr>");

                // Iterate over the result set and display each row
                while (resultSet.next()) {
                    out.println("<tr>");
                    out.println("<td>" + resultSet.getInt("payment_id") + "</td>");
                    out.println("<td>" + resultSet.getInt("customer_id") + "</td>");
                    out.println("<td>" + resultSet.getDouble("amount") + "</td>");
                    out.println("<td>" + resultSet.getDate("date") + "</td>");
                    out.println("<td>" + resultSet.getString("payment_method") + "</td>");
                    out.println("</tr>");
                }

                out.println("</table>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            out.println("<h1>Error: " + e.getMessage() + "</h1>");
        }

        // Provide a link to return home
        out.println("<a href='welcome.jsp'>Home</a>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

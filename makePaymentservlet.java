package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/makePaymentservlet")
public class makePaymentservlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to the appropriate JSP page
        request.getRequestDispatcher("makePayment.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        int customerId = Integer.parseInt(request.getParameter("customer_id"));
        double amount = Double.parseDouble(request.getParameter("amount"));
        String date = request.getParameter("date");
        String paymentMethod = request.getParameter("payment_method");

        // Perform database operation to insert payment
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/deepu", "root", "webstudent"
            		+ "");
            String query = "INSERT INTO Payment (customer_id, amount, date, payment_method) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, customerId);
            stmt.setDouble(2, amount);
            stmt.setString(3, date);
            stmt.setString(4, paymentMethod);
            int rowsAffected = stmt.executeUpdate();
            
            // Redirect to a success page after inserting the payment
            response.sendRedirect("paymentSuccess.jsp");
        } catch (ClassNotFoundException | SQLException e) {
            // Handle exceptions
            e.printStackTrace();
            // Forward to an error page if the insertion fails
            request.getRequestDispatcher("paymentError.jsp").forward(request, response);
        } finally {
            // Close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}

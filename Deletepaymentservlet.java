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

@WebServlet("/Deletepaymentservlet")
public class Deletepaymentservlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to the deletePayment.jsp or any other page you prefer for displaying the form
        request.getRequestDispatcher("deletePayment.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        int paymentId = Integer.parseInt(request.getParameter("payment_id"));

        // Perform database operation to delete payment
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/deepu", "root", "webstudent");
            String query = "DELETE FROM Payment WHERE payment_id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, paymentId);
            int rowsAffected = stmt.executeUpdate();
            
            // Optionally, you can redirect to a success page after deleting the payment
            response.sendRedirect("paymentDeleteSuccess.jsp");
        } catch (ClassNotFoundException | SQLException e) {
            // Handle exceptions
            e.printStackTrace();
            // Optionally, you can forward to an error page if the deletion fails
            request.getRequestDispatcher("paymentDeleteError.jsp").forward(request, response);
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

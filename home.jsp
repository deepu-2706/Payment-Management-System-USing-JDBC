<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Home</title>
    <style>
        /* General styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }

        /* Header styling */
        header {
            background-color: #007bff;
            color: white;
            padding: 20px;
            text-align: center;
        }

        /* Content container */
        .container {
            margin: 20px;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        /* Button styling */
        .btn {
            padding: 10px 20px;
            border-radius: 5px;
            border: none;
            background-color: #007bff;
            color: white;
            cursor: pointer;
        }

        .btn:hover {
            background-color: #0056b3;
        }

        /* Footer styling */
        footer {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 10px 0;
            position: fixed;
            width: 100%;
            bottom: 0;
        }
    </style>
</head>
<body>
    <header>
        <h1>Welcome to the Payment Management System</h1>
    </header>

    <div class="container">
        <h2>Home Page</h2>
        <p>This is the home page of the Payment Management System.</p>
        <p>Explore the system using the navigation options.</p>
        <a href="ViewPaymentsServlet" class="btn">View Payments</a>
        <a href="makePayment.jsp" class="btn">Add Payment</a>
        <a href="deletePayment.jsp" class="btn">Delete Payment</a>
        <a href="updatePayment.jsp" class="btn">Update Payment</a>
        <a href="welcome.jsp" class="btn">Back to Welcome Page</a>
    </div>

    <footer>
        <p>&copy; 2024 Payment Management System</p>
    </footer>
</body>
</html>

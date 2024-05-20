<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="menu.jsp" %>



<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Payment</title>
    <style>
        /* General styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        /* Form container styling */
        .form-container {
            width: 50%;
            text-align: center;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        /* Form input styling */
        .form-container label {
            display: block;
            margin-bottom: 10px;
        }

        .form-container input[type="text"],
        .form-container input[type="submit"] {
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            margin-bottom: 10px;
            width: 100%;
            box-sizing: border-box;
        }

        /* Submit button styling */
        .form-container input[type="submit"] {
            background-color: #dc3545;
            color: white;
            cursor: pointer;
        }

        .form-container input[type="submit"]:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
    <h2>Delete Payment</h2>
    <div class="form-container">
        <form action="Deletepaymentservlet" method="post">
            <label for="payment_id">Payment ID:</label>
            <input type="text" id="payment_id" name="payment_id"><br><br>
            
            <input type="submit" value="Delete">
        </form>
    </div>
</body>
</html>

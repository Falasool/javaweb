<%--
  Created by IntelliJ IDEA.
  User: pika
  Date: 2025/12/6
  Time: 09:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Category</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
        }

        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            max-width: 500px;
            margin: auto;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
        }

        .form-group input {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .button {
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            background-color: #28a745;
            color: white;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Add New Category</h2>
    <form action="add" method="POST">
        <div class="form-group">
            <label for="categoryName">Category Name:</label>
            <input type="text" id="categoryName" name="categoryName" required>
        </div>
        <div class="form-group">
            <label for="createTime">Create Time:</label>
            <input type="datetime-local" id="createTime" name="createTime" required>
        </div>
        <button type="submit" class="button">Confirm</button>
    </form>
</div>
</body>
</html>
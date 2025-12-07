<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<head>
    <title>Category List</title>
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
        }
        .header-controls {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }
        .search-bar {
            display: flex;
            gap: 10px;
        }
        .search-bar input[type="text"] {
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            width: 200px;
        }
        .button {
            padding: 8px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
        }
        .button-primary {
            background-color: #007bff;
            color: white;
        }
        .button-secondary {
            background-color: #6c757d;
            color: white;
        }
        .button-success {
            background-color: #28a745;
            color: white;
        }
        .button-danger {
            background-color: #dc3545;
            color: white;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .actions {
            display: flex;
            gap: 5px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header-controls">
            <div class="search-bar">
                <input type="text" placeholder="Search categories...">
                <button class="button button-secondary">Search</button>
            </div>
            <div>
                <button class="button button-success">Add New Category</button>
                <button class="button button-primary">Update Categories</button>
            </div>
        </div>

        <h2>Category List</h2>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Create Time</th>
                </tr>
            </thead>
            <tbody>
                <%-- Example row - will be replaced by dynamic data --%>
                <c:forEach var="category" items="${categories}">
                    <tr>
                        <td><c:out value="${category.id}"/></td>
                        <td><c:out value="${category.categoryName}"/></td>
                        <td class="actions">
                            <button class="button button-primary">Edit</button>
                            <button class="button button-danger">Delete</button>
                        </td>
                    </tr>
                </c:forEach>
                <%-- End example rows --%>
            </tbody>
        </table>
    </div>
</body>
</html>
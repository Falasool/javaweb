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
                <button class="button button-primary" id="updateCategoriesButton">Update Categories</button>
            </div>
        </div>

        <h2>Category List</h2>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Create Time</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="category" items="${categories}">
                    <tr>
                        <td><c:out value="${category.id}"/></td>
                        <td><c:out value="${category.categoryName}"/></td>
                        <td><c:out value="${category.createTime}"/></td>
                        <td class="actions">
                            <a href="category/edit?id=${category.id}" class="button button-primary">Edit</a>
                            <a href="${pageContext.request.contextPath}/delete?id=${category.id}" class="button button-danger" onclick="return confirm('Are you sure you want to delete this category?');">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <script>
        document.getElementById('updateCategoriesButton').addEventListener('click', function() {
            window.location.href = '${pageContext.request.contextPath}';
        });
    </script>
</body>
</html>
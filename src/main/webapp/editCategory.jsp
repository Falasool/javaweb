<form action="edit" method="POST">
    <input type="hidden" name="id" value="${category.id}">

    <div class="form-group">
        <label for="categoryName">Category Name:</label>
        <input type="text"
               id="categoryName"
               name="categoryName"
               value="${category.categoryName}"
               required>
    </div>

    <div class="form-group">
        <label for="createTime">Create Time:</label>
        <input type="datetime-local"
               id="createTime"
               name="createTime"
               value="${category.createTime}"
               required>
    </div>

    <button type="submit">Submit</button>
</form>

<%@ page import="com.example.practical.entity.Product" %><%
    Product obj = (Product) request.getAttribute("obj");
%>
<!DOCTYPE html>
<html>
    <title>W3.CSS</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<body>
    <div class="container col-md-10" style="margin-top: 50px">
        <form style="padding: 20px" class="w3-container w3-card-4" action="/products/edit" method="post">
            <h2 class="w3-text-blue">Edit Product</h2>
            <p>
                <label class="w3-text-blue"><b>Name</b></label>
                <input type="hidden" name="id" value="<%=obj.getId()%>">
                <input class="w3-input w3-border" name="name" type="text" value="<%=obj.getName()%>">
            </p>
            <p>
                <label class="w3-text-blue"><b>Price</b></label>
                <input class="w3-input w3-border" name="price" type="number" value="<%=obj.getPrice()%>">
            </p>
            <p>
                <label class="w3-text-blue"><b>Status</b></label>
                <input class="w3-input w3-border" name="amount" type="number" value="<%=obj.getAmount()%>">
            </p>
            <p>
                <label class="w3-text-blue"><b>Details</b></label>
                <input class="w3-input w3-border" name="details" type="text" value="<%=obj.getDetails()%>">
            </p>
            <p>
                <button class="w3-btn w3-blue">Update</button>
                <input type="reset" class="w3-btn w3-teal" value="Reset"/>
            </p>
        </form>
    </div>
</body>
</html>

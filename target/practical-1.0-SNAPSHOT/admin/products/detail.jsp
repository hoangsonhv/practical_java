<%@ page import="com.example.practical.entity.Product" %><%
    Product obj = (Product) request.getAttribute("obj");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <title>W3.CSS</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<body>
    <div class="container col-md-10" style="margin-top: 50px">
        <h2 class="w3-text-blue" style="text-align: center; margin-bottom: 20px">Product Detail</h2>
        <div class="col-md-6" style="float: right">
            <p>
                <label class="w3-text-blue"><b>Name :</b></label>
                <span><%=obj.getName()%></span>
            </p>

            <p>
                <label class="w3-text-blue"><b>Price :</b></label>
                <span><%=obj.getPrice()%>(VND)</span>
            </p>
            <p>
                <label class="w3-text-blue"><b>Amount :</b></label>
                <span><%=obj.getAmount()%></span>
            </p>
            <p>
                <label class="w3-text-blue"><b>Details :</b></label>
                <span><%=obj.getDetails()%></span>
            </p>
        </div>
    </div>
</body>
</html>
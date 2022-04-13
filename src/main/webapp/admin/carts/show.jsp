<%@ page import="java.util.List" %>
<%@ page import="com.example.demo_web.entity.Student" %>
<%@ page import="com.example.demo_web.entity.Product" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="com.example.demo_web.entity.ShoppingCart" %>
<%@ page import="com.example.demo_web.entity.CartItem" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    ShoppingCart shoppingCart = (ShoppingCart) request.getAttribute("shoppingCart");
%>
<!DOCTYPE html>
<html>
<title>List Student</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<body>

<div class="container col-md-10">
    <h2 style="text-align: center">Shopping Cart</h2>
    <a href="/products/list" class="btn btn-primary" style="margin-bottom: 10px">Shopping</a>

    <%if (session.getAttribute("message") != null) {%>
        <div class="alert alert-primary" role = "alert" >
            <h3>Success</h3>
            <%=session.getAttribute("message")%>
        </div>

    <%
        session.removeAttribute("message");
        }
    %>
    <table class="w3-table-all">
        <thead>
        <tr class="w3-light-grey">
            <th>Id</th>
            <th>Name</th>
            <th>Thumbnail</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Option</th>
        </tr>
        </thead>
        <tbody>
        <%
            ArrayList<CartItem> cartItems = shoppingCart.getListItems();
            for (int i = 0; i < shoppingCart.getListItems().size(); i++) {
                CartItem obj = shoppingCart.getListItems().get(i);
        %>
        <tr>
            <td><%=obj.getProductId()%>
            </td>
            <td><%=obj.getProductName()%>
            </td>
            <td><img src="<%=obj.getProductThumbnail()%>" width="150px"></td>
            <td><%=obj.getProductPrice()%> vnd</td>
            <td><%=obj.getQuantity()%>
            </td>
            <td>
                <a href="/products/detail?id=<%=obj.getProductId()%>">Detail</a>&nbsp;&nbsp;|&nbsp;
                <a href="/products/edit?id=<%=obj.getProductId()%>">Edit</a>&nbsp;&nbsp;|&nbsp;
                <a href="/products/delete?id=<%=obj.getProductId()%>" class="btn-delete">Delete</a>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        // let listDeleteButton = document.querySelectorAll('.btn-delete');
        // for (let i = 0; i < listDeleteButton.length; i++) {
        //     listDeleteButton[i].addEventListener('click', function (event){
        //         event.preventDefault();
        //         if (confirm('Are you sure?')){
        //             let xhr = new XMLHttpRequest();
        //             xhr.onreadystatechange = function (){
        //                 if (xhr.readyState == 4 && xhr.status == 200){
        //                     alert('Delete success.');
        //                     window.location.href = "/products/list";
        //                 }
        //             }
        //             xhr.open('POST', this.href, false);
        //             xhr.send();
        //         }
        //     })
        // }
    })
</script>
</body>
</html>

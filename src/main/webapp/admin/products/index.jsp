<%@ page import="java.util.List" %>
<%@ page import="com.example.practical.entity.Product" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="com.example.practical.entity.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    List<Product> list = (List<Product>)request.getAttribute("listObject");
    User account = (User) session.getAttribute("currenUser");
    boolean isLogin = false;
    if (account != null){
        isLogin = true;
    }
    String currenUsername = account == null ? "Plesase to login!" : account.getUsername();
%>
<!DOCTYPE html>
<html>
    <title>List Product</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<body>

<div class="container col-md-10">
    <div class="container">
        <%if (isLogin){%>
        <div class="row">
            <div class="col-md-6" style="text-align: center">
                <h3><%=currenUsername%></h3>
            </div>
            <div class="col-md-6"  style="text-align: center">
                <a href="/logout">Đăng xuất</a>
            </div>
        </div>
        <%}else {%>
            <p><a href="/login">Đăng nhập.</a>. <a href="/register"> Chưa có tk thì đăng ký.</a></p>
        <%}%>
        <h3></h3>
    </div>
    <h2 style="text-align: center">List Product</h2>
    <a href="/products/create" class="btn btn-primary" style="margin-bottom: 10px">Create new Product</a>
    <table class="w3-table-all">
        <thead>
        <tr class="w3-light-grey">
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Amount</th>
            <th>Details</th>
            <th>Option</th>
        </tr>
        </thead>
        <tbody>
            <%
                for (int i = 0; i < list.size(); i++) {
                    Product obj = list.get(i);
            %>
            <tr>
                <td><%=obj.getId()%></td>
                <td><%=obj.getName()%></td>
                <td><%=obj.getPrice()%> vnd</td>
                <td><%=obj.getAmount()%></td>
                <td><%=obj.getDetails()%></td>
                <td>
                    <a href="/products/detail?id=<%=obj.getId()%>">Detail</a>&nbsp;&nbsp;|&nbsp;
                    <a href="/products/edit?id=<%=obj.getId()%>">Edit</a>&nbsp;&nbsp;|&nbsp;
                    <a href="/products/delete?id=<%=obj.getId()%>" class="btn-delete">Delete</a>
                </td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
<script>
    document.addEventListener('DOMContentLoaded', function (){
        let listDeleteButton = document.querySelectorAll('.btn-delete');
        for (let i = 0; i < listDeleteButton.length; i++) {
            listDeleteButton[i].addEventListener('click', function (event){
                event.preventDefault();
                if (confirm('Are you sure?')){
                    let xhr = new XMLHttpRequest();
                    xhr.onreadystatechange = function (){
                        if (xhr.readyState == 4 && xhr.status == 200){
                            alert('Delete success.');
                            window.location.href = "/products/list";
                        }
                    }
                    xhr.open('POST', this.href, false);
                    xhr.send();
                }
            })
        }
    })
</script>
</body>
</html>

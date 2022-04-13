<%@ page import="java.util.List" %>
<%@ page import="com.example.demo_web.entity.Student" %>
<%@ page import="com.example.demo_web.entity.Product" %>
<%@ page import="java.util.HashSet" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    List<Product> list = (List<Product>)request.getAttribute("listObject");
    HashSet<Product> recentView = (HashSet<Product>) session.getAttribute("recentReviewProduct");
%>
<!DOCTYPE html>
<html>
    <title>List Student</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<body>

<div class="container col-md-10">
    <h2 style="text-align: center">List Product</h2>
    <a href="/products/create" class="btn btn-primary" style="margin-bottom: 10px">Create new Product</a>
    <table class="w3-table-all">
        <thead>
        <tr class="w3-light-grey">
            <th>Id</th>
            <th>Name</th>
            <th>Thumbnail</th>
            <th>Price</th>
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
                <td><img src="<%=obj.getThumbnail()%>" width="150px"></td>
                <td><%=obj.getPrice()%> vnd</td>
                <td>
                    <a href="/shopping-cart/add?productId=<%=obj.getId()%>&quantity=1">Add To Cart</a>&nbsp;&nbsp;|&nbsp;
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
    <%if (recentView != null && recentView.size() > 0){%>
    <ul class="w3-ul w3-card-4">
       <%
           for (Product product: recentView) {%>
                <li class="w3-bar">
                    <span onclick="this.parentElement.style.display='none'" class="w3-bar-item w3-button w3-white w3-xlarge w3-right">×</span>
                    <img src="<%=product.getThumbnail()%>" class="w3-bar-item w3-circle w3-hide-small" style="width:85px">
                    <div class="w3-bar-item">
                        <span class="w3-large"><%=product.getName()%></span><br>
                        <span><%=product.getPrice()%></span>
                    </div>
                </li>
        <%}%>
    </ul>
    <%}%>
</div>
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

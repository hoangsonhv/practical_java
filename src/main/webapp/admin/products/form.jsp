<%@ page import="java.util.HashMap" %>
<%
    HashMap<String,String> errors = (HashMap<String, String>) request.getAttribute("errors");
    if (errors == null){
        errors = new HashMap<>();
    }
%>

<!DOCTYPE html>
<html>
    <title>W3.CSS</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<body>
    <div class="container col-md-10" style="margin-top: 50px">
        <form style="padding: 20px" name="create-form" class="w3-container w3-card-4" action="/products/create" method="post">
            <h2 class="w3-text-blue">Create new Product</h2>
            <%
                if (errors != null && errors.size() > 0){
            %>
                <div class="alert alert-warning">
                    <strong>Warning!</strong>
                    <ul>
                        <%
                            for (String message:
                                errors.values()) {
                        %>
                            <li><%=message%></li>
                        <%
                            }
                        %>
                    </ul>
                    </div>
            <%
                }
            %>
            <p>
                <label class="w3-text-blue"><b>Name</b></label>
                <input class="w3-input w3-border" name="name" type="text">
                <%if (errors.containsKey("name")){%>
                    <span class="w3-text-red">* <%=errors.get("name")%></span>
                <%}%>
            </p>
            <p>
                <label class="w3-text-blue"><b>Thumbnail</b></label>
                <input class="w3-input w3-border" name="thumbnail" type="hidden">
                <img src="" class="w3-ground image-preview hide" id="image-preview">
                <button id="upload_widget" type="button" class="w3-button w3-black">Upload files</button>

                <%if (errors.containsKey("thumbnail")){%>
                    <span class="w3-text-red">* <%=errors.get("thumbnail")%></span>
                <%}%>
            </p>
            <p>
                <label class="w3-text-blue"><b>Price</b></label>
                <input class="w3-input w3-border" name="price" type="number" value="0">
                <%if (errors.containsKey("price")){%>
                    <span class="w3-text-red">* <%=errors.get("price")%></span>
                <%}%>
            </p>
            <p>
                <button class="w3-btn w3-blue">Submit</button>
                <input type="reset" class="w3-btn w3-teal" value="Reset"/>
            </p>
        </form>
    </div>
<script src="https://upload-widget.cloudinary.com/global/all.js" type="text/javascript"></script>
<script type="text/javascript">
    var myWidget = cloudinary.createUploadWidget({
        cloudName: 'tnhh-1-th-nh-vi-n-ok',
        uploadPreset: 'mnja4jgg'}, (error, result) => {
        if (!error && result && result.event === "success") {
            console.log('Done! Here is the image info: ', result.info.url);
            var img = document.getElementById("image-preview");
            img.classList.remove("hide");
            img.src = result.info.url;
            document.forms['create-form']['thumbnail'].value = result.info.url;
        }
    })
    document.getElementById("upload_widget").addEventListener("click", function(){
        myWidget.open();
    }, false);
</script>
</body>
</html>

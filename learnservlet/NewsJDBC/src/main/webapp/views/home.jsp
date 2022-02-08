<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

<!--  <form action="login?action=login"  method="post">
    tk:<input type="text" name="userName">
    mk:<input type="password" name="password">
    <input type="submit" value="dang nhap">
</form>-->



<form id="formLogin" method="post">
    tk:<input id="userName" type="text" name="userName">
    mk:<input type="password" name="password">
    <!-- <input type="submit" value="dang nhap"> -->
    <button id="btnLogin" type="submit">dang nhap</button>
</form>
<script>
   $('#btnLogin').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formLogin').serializeArray();
        $.each(formData, function (i, v) {
            data["" + v.name + ""] = v.value;
        });
        $.ajax({
            url: "http://localhost:8080/NewsJDBC/login?action=login",
            type: "POST",
            contentType: 'application/json;charset=utf-8',
            dataType: "json",
            data: JSON.stringify(data),
            success: function (result) {
                /*console.log("data:" + result);
                var url = 'http://localhost:8080' + result.url;
                console.log("url:" + url);
                window.location.href = url;
                if (result.token !== undefined && result.token !== null){
                    localStorage.setItem("access-token",result.token);
                }*/
                console.log(result.url);
            },
            error: function (result) {
                console.log("fail "+result);
            }
        });
    });
</script>


</body>
</html>
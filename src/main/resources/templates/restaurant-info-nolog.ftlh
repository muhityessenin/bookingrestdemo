<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${restaurant.name}</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 20px;
            padding: 20px;
            background-color: #f8f8f8;
        }

        h1 {
            color: #333;
        }

        h4 {
            color: #333;
        }

        img {
            max-height: 150px;
            margin-bottom: 10px;
        }

        b {
            color: #333;
        }

        form {
            margin-top: 20px;
        }

        input[type="submit"] {
            padding: 8px 15px;
            background-color: #d9534f;
            color: #fff;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #c9302c;
        }
        .user-icon {
            float: right;
            margin-right: 20px;
            font-size: 24px;
            color: #428bca;
            cursor: pointer;
        }

        .login-register-buttons {
            float: right;
            margin-right: 20px;
            margin-top: 5px;
        }
    </style>
</head>
<body>
<h1>${restaurant.name}</h1>
<hr>
<h4>Restaurant details</h4>
<div class="user-icon">&#128100;</div>
<div class="login-register-buttons">
    <a href="/login_page">Вход</a>
    <a href="/register">Регистрация</a>
</div>
<#list images as img>
    <img src="/images/${img.id}" alt="Restaurant Image"/><br><br>
</#list>

<b>Name restaurant:</b> ${restaurant.name}<br>
<b>Description:</b> ${restaurant.description}<br>
<b>Menu:</b> ${restaurant.menu}</br>
<b>Contacts:</b> ${restaurant.contacts}</br>
<hr>
Log in or sign up to book on this ${restaurant.name}
</body>
</html>

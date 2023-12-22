<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ReservEase</title>
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

        form {
            margin-bottom: 20px;
        }

        input[type="text"] {
            padding: 8px;
            width: 200px;
        }

        input[type="submit"] {
            padding: 8px 15px;
            background-color: #4caf50;
            color: #fff;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        h3 {
            color: #d9534f;
        }

        .restaurant {
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 5px;
            padding: 10px;
            margin-bottom: 10px;
        }

        a {
            color: #428bca;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
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
        .user-menu{
            float: right;
            margin-top: 50px;
            margin-right: 0px;
        }
        .user-name{
            float: right;
        }
    </style>
</head>
<body>
<div class="user-icon">&#128100;</div>
<div class="user-name">
</div>
<div class="user-menu">
    <a href="/mybookings/">My bookings</a>
</div>

<h1>Welcome to ReservEase</h1>
<hr>

<form action="/home" method="get">
    Search by Restaurant Name: <input type="text" name="name">
    <input type="submit" value="Search">
</form>

<#if restaurants?has_content>
    <#list restaurants as restaurant>
        <div class="restaurant">
            <p>
                <strong> ${restaurant.name} </strong>  | ${restaurant.description} | <a href="/restaurant/${restaurant.restaurant_id}">Details...</a>
            </p>
        </div>
    </#list>
<#else>
    <h3>No Restaurants Found</h3>
</#if>

<hr>
</body>
</html>

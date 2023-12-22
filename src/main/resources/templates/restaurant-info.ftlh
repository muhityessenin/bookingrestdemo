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
    </style>
</head>
<body>
<h1>${restaurant.name}</h1>
<hr>
<h4>Restaurant Details</h4>
<div class="user-icon">&#128100;</div>
<#list images as img>
    <img src="/images/${img.id}" alt="Restaurant Image"/><br><br>
</#list>

<b>Name restaurant:</b> ${restaurant.name}<br>
<b>Description:</b> ${restaurant.description}<br>
<b>Menu:</b> ${restaurant.menu}</br>
<b>Contacts:</b> ${restaurant.contacts}</br>
<hr>
<form action="/reservation/reserve" method="post">
    <label for="people_for_reservation">People:</label>
    <input type="number" name="people_for_reservation" required>

    <label for="reservationDateTime">Date:</label>
    <input type="datetime-local" name="reservationDateTime" required>

    <input type="hidden" name="restaurant_id" value="${restaurant.restaurant_id}">
    <input type="hidden" name="restaurant_name" value="${restaurant.name}">
    <label for="user_email">Your email:</label>
    <input type="email" name="user_email" required>

    <input type="submit" value="Book this place">
</form>

</body>
</html>

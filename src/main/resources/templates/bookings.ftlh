<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>My Reservations</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        .container {
            max-width: 800px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
        }

        .reservation-list {
            margin-top: 20px;
        }

        .reservation-item {
            border: 1px solid #ddd;
            border-radius: 8px;
            padding: 15px;
            margin-bottom: 15px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #fff;
            transition: transform 0.2s ease-in-out;
        }

        .reservation-item:hover {
            transform: scale(1.02);
        }

        .reservation-details h2 {
            margin-bottom: 8px;
            color: #333;
        }

        .delete-button {
            background-color: #e74c3c;
            color: #fff;
            border: none;
            padding: 8px 12px;
            border-radius: 4px;
            cursor: pointer;
        }

        .delete-button:hover {
            background-color: #c0392b;
        }

    </style>
</head>
<body>

<div class="container">
    <h1>My Reservations</h1>

    <div class="reservation-list">
        <#if reservations?has_content>
        <#list reservations as reservation>
            <div class="reservation-item">
                <div class="reservation-details">
                    <h2>${reservation.restaurant_name}</h2>
                    <p>Date: ${reservation.reservationDateTime}</p>
                    <p>People: ${reservation.people_for_reservation}</p>
                </div>
                <form action="/reservation/cancel/${reservation.reservation_id}" method="post">
                    <button type="submit" class="delete-button">Delete</button>
                </form>
            </div>
        </#list>
        <#else>
            <h3>You have no reservations</h3>
        </#if>
    </div>
</div>

</body>
</html>

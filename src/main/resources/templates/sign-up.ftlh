<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f8f8f8;
        }

        .container {
            background-color: #fff;
            border-radius: 5px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin-bottom: 8px;
        }

        input {
            padding: 8px;
            margin-bottom: 16px;
        }

        button {
            padding: 10px;
            background-color: #4caf50;
            color: #fff;
            border: none;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="container">
    <form action="/users/register" method="post">
        <h2>Sign Up</h2>
        <label for="username">Username:</label>
        <input type="text" name="username">

        <label for="user_email">Email:</label>
        <input type="email"  name="user_email">

        <label for="password">Password:</label>
        <input type="password" name="password" >
        <button type="submit">Sign Up</button>
    </form>
</div>
</body>
</html>

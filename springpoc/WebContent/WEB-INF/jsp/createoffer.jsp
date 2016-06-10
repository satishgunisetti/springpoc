<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign Up Form</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css">
        <link href='http://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adding Offer</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/docreate" method="post">
      
        <h1>Create Advert</h1>
        
        <fieldset>
          <legend><span class="number">1</span>Enter info</legend>
         
          <label for="name">Name:</label>
          <input type="text" id="name" name="name">
          
          <label for="mail">Email:</label>
          <input type="email" id="mail" name="email">
          
          <legend><span class="number">2</span>Your Offer</legend>
          <label for="bio">Offer:</label>
          <textarea id="bio" name="text"></textarea>
        </fieldset>
        
        <button type="submit">Submit Advert</button>
      </form>



</body>
</html>
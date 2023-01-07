<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>	
<form method="POST">
	<pre>${errorMessage}</pre>
 	<label>Name:</label>
 	<input type="text" name="name" />
   	<br />
  	<label>Password:</label>
 	<input type="password" name="password" />
 	<br />
 	<input type="submit" />
 	<br />
 </form>\
<%@ include file="common/footer.jspf" %>

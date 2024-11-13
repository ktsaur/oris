<%@ page contentType="text/html; UTF-8" language="java" %>

<html>
<head>
  <title>Main page</title>
</head>

<body>
<%
  String user = null;
  String sessionUser = String.valueOf(session.getAttribute("user"));
  if (sessionUser == null) {
    response.sendRedirect("login.html");
  } else {
    user = sessionUser;
  }

  String cookieUser = null;
  String sessionid = null;
  Cookie[] cookies = request.getCookies();
  if (cookies != null) {
    for (Cookie c : cookies) {
      if ("user".equalsIgnoreCase(c.getName())){
        cookieUser = c.getValue();
      } else if ("jsessionid".equalsIgnoreCase(c.getName())) {
        sessionid = c.getValue();
      } else {
        sessionid = session.getId();
      }
    }
  }
%>
</body>

<h3>
  Hello, <%=user%>! Login succesfull!
  <br>
  Session ID = <%=sessionid%>
  <br>
  Cookie user =<%=cookieUser%>
</h3>


</html>
<html>
<%@ page import="java.util.LinkedList, com.seller.beans.Product" %>
<body>
<%
    LinkedList<Product> products = (LinkedList<Product>)request.getAttribute("Products");
    for(Product s : products){
%>
<br />
    <%= s.getProductName() %>



<%
    }
%>


</body>
</html>
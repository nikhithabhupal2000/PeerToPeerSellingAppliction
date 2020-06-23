<html>
<%@ page import="java.util.LinkedList, com.seller.beans.SubCategory" %>
<body>
<form action = "products" method = "get">
<%
    LinkedList<SubCategory> subCategories = (LinkedList<SubCategory>)request.getAttribute("SubCategories");
%>
    <select name = "subCategory">
<%
    for(SubCategory s : subCategories){
%>

    <option> <%= s.getSubCategoryName() %> </option>



<%
    }
%>
<br />
</select>
<input type = "submit" />
</form>

</body>
</html>
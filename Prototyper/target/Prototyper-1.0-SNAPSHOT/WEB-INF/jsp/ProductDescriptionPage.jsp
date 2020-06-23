<html>
<body>
<form action = "confirmationPage" method = "POST">
<br />
Name : <input type = "text" name = "productName" />
<br />
Category :  <select name="category">
             <option >Groceries</option>
             <option >KidsFashion</option>
             <option >Furniture</option>
             <option >Stationery</option>
            </select>

           <% %>
           <br />
Sub Category :
              <select name = "subCategory">
               <option >Milk</option>
               <option >Tables</option>
               <option >Deskss</option>
              </select>
              <br />
Price : <input type = "text" name = "price" />
<br />
image : <input type = "file" name = "image" />
<br />
<input type = "submit" value = "ADD PRODUCT" />
<br />
</form>
</body>
</html>
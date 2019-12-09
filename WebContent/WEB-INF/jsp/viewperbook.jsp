<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h1>Book List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Book Code</th><th>Book Name</th><th>Book Type</th><th>Price</th><th>Description</th><th>Edit</th><th>Delete</th></tr>  
    <c:forEach var="book" items="${list}"> 
    
  
   <tr>  
   <td>${book.bookcode}</td>  
   <td>${book.bookname}</td>  
   <td>${book.booktype}</td>  
   <td>${book.price}</td>  
    <td>${book.description}</td> 
   <td><a href="editbook/${book.bookcode}">Edit</a></td>  
   <td><a href="deletebook/${book.bookcode}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="bookreg">Add New Book</a>
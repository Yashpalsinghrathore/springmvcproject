<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<html>

<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">

function deleteData(id)
{
	
		
		$.ajax({
			type :"DELETE",
			url:"deleteproduct/"+id,
			success: function(){
				
				
				$("#"+id).hide();
				
				
			},
			error:function()
			{
				alert('error');
				
			}
			
			
			
		});
		
		

	
	
	}
function editData(id)
{
	
		
		$.ajax({
			type :"PUT",
			url:"editproduct/"+id,
			success: function(json){
				
				
				
				
				
				document.getElementById("proname").value =  json['productName'];
				document.getElementById("pri").value =  json['price'];
				document.getElementById("dis").value =  json['description'];
				document.getElementById("exd").value =  json['expiryDate'];
				document.getElementById("pid").value =  json['id'];
				
				
				
			},
			error:function()
			{
				
				alert('error');
				
			}
			
			
			
		});
		
		

	
	
	}

</script>

<style>  
.error{color:red}  
</style>


</head>




<body>
	<form:form method="POST" modelAttribute="Product"  action="product.do" >
		<table width="100%" border="0">
			
			
			<tr >
				<td align="center">
					productName <form:input path="productName" id="proname"/>
					<form:errors path="productName" cssClass="error" ></form:errors>
				</td>
				
			
				<td align="center">
					price <form:input path="price" id="pri"/>
					<form:errors path="price" cssClass="error" ></form:errors>
				</td>
				
			</tr>
			
			
			<tr>
				<td align="center">
					description <form:input path="description" id="dis"/>
					<form:errors path="description" cssClass="error"></form:errors>
				</td>
				
			
				<td align="center">
					expiryDate <form:input path="expiryDate" id="exd"/>
					<form:errors path="expiryDate" cssClass="error" ></form:errors>
				</td>
				
				<td>
				<form:hidden path="id" id="pid"/>
				</td>
				
			</tr>
		
		
					
		
			
			
			<tr>
				
				
				<td  align="right" >
				<input type="submit" value="submit">
				</td>

			</tr>

	
			
			


		</table>
		 </form:form>
		 

  
  <form:form>
  
   
   <table width="100%" border="4" align="center" bordercolor="red">
			
			
			<tr>
				
					<td>
					id 
				</td>
				
				
				<td>
					productName 
				</td>
				
			
				<td>
					price 
				</td>
		
				<td>
					description 
				</td>
				
			
				<td>
					expiryDate 
				</td>
				
				
				<td>
					edit
				</td>
				
				
				<td>
					delete 
				</td>
				
			</tr>
			
				
			<c:if test="${listProduct.size()>0}">
			<c:forEach  items="${listProduct}" var="prodOne">
			
			<tr id="${prodOne.id}">
			<td><c:out value="${prodOne.id}"></c:out></td>
			<td><c:out value="${prodOne.productName}"></c:out></td>
			<td><c:out value="${prodOne.price}"></c:out></td>
			<td><c:out value="${prodOne.description}"></c:out></td>
			<td><c:out value="${prodOne.expiryDate}"></c:out></td>
			<td><a href="javascript:void(0);" onClick="editData('${prodOne.id}');">edit</a></td>
		    <td><a href="javascript:void(0);" onClick="deleteData('${prodOne.id}');">delete</a></td>
			
			
			</tr>
			
			
			
			</c:forEach>
			</c:if>
			<c:if test="${listProduct.size()==0}">
			
			<tr>
			
			<td colspan="5">
			
			<h1 align="center">No Data Available</h1>
			
			</td>
			
			</tr>
			
			</c:if>
			
			
   </table>
  </form:form>
   
   
   
   
   
 

 
  


</body>
</html>
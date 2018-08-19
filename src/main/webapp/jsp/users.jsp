<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<rapid:override name="content">  
 <div class="text-center">
<table class="table">
   <tr>
		<th width="80">Id</th>
		<th width="120">User Name</th>
		<th width="120">Firstname</th>
		<th width="60">Lastname</th>
		<th width="60">Email</th>
	</tr>

    <c:forEach items="${users}" var="user">
        <tr>
            <td> <c:out value="${user.id}"/></td>
            <td> <c:out value="${user.username}"/></td>
            <td> <c:out value="${user.firstname}"/></td>
            <td> <c:out value="${user.lastname}"/></td>
            <td> <c:out value="${user.email}"/></td>
        </tr>
    </c:forEach>
</table>
</div>

</rapid:override>  


<jsp:include page="/base.jsp" flush="true" >
        <jsp:param name="Command" value="test"/>
</jsp:include>
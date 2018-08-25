<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<rapid:override name="content">
 <div class="text-center">
<table class="table">
   <tr>
		<th width="80">Id</th>
		<th width="120">Title</th>
		<th width="120">Description</th>
       <th width="120">UserName</th>
	</tr>

    <c:forEach items="${entries}" var="entry">
        <tr>
            <td> <c:out value="${entry.id}"/></td>
            <td> <c:out value="${entry.title}"/></td>
            <td> <c:out value="${entry.description}"/></td>
            <td> <c:out value="${entry.user.username}"/></td>
        </tr>
    </c:forEach>
</table>
</div>

</rapid:override>  


<jsp:include page="/base.jsp" flush="true" >
        <jsp:param name="Command" value="test"/>
</jsp:include>
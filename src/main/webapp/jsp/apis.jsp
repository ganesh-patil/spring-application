<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<rapid:override name="content">  
 <div class="text-center">
<table class="table">
   <tr>
		<th width="80">Rates</th>
	</tr>

    <c:forEach items="${Rates}" var="Rate">
        <tr>
            <td> <c:out value="${Rate.name}"/></td>
        </tr>
        <tr>
            <td> <c:out value="${Rate.code}"/></td>
        </tr>
        <tr>
            <td> <c:out value="${Rate.rate}"/></td>
        </tr>
    </c:forEach>

</table>
</div>

</rapid:override>  


<jsp:include page="/base.jsp" flush="true" >
        <jsp:param name="Command" value="test"/>
</jsp:include>
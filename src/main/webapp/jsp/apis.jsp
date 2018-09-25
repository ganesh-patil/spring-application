<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<rapid:override name="content">  
 <div class="text-center">
<table class="table">
   <tr>
		<th width="80">QuoteDetails</th>
	</tr>


    <tr>
        <td> <c:out value="${Quote.type}"/></td>
    </tr>
    <tr>
        <td> <c:out value="${Quote.value.quote}"/></td>
    </tr>



</table>
</div>

</rapid:override>  


<jsp:include page="/base.jsp" flush="true" >
        <jsp:param name="Command" value="test"/>
</jsp:include>
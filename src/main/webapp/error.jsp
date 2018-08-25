<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<rapid:override name="content">

    This is error page

</rapid:override>


<jsp:include page="/base.jsp" flush="true" >
    <jsp:param name="Command" value="test"/>
</jsp:include>

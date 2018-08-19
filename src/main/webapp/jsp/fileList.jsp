<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<rapid:override name="content">
    <c:if test="${isUploaded == true}">
        <div class="alert alert-success">
            <p>File uploaded successfully.</p>
        </div>
    </c:if>
    <c:if test="${error != null}">
        <div class="alert alert-danger">
            <p>${error}</p>
        </div>
    </c:if>
    <div class="text-center">
        <table class="table">
            <tr>
                <th width="80">Id</th>
                <th width="120">File Name</th>
                <th width="120">Description</th>
                <th width="120">Actions</th>
            </tr>

            <c:forEach items="${allFiles}" var="file">
                <tr>
                    <td> <c:out value="${file.id}"/></td>
                    <td> <c:out value="${file.fileName}"/></td>
                    <td> <c:out value="${file.description}"/></td>
                    <td> <a href="/file/${file.fileName}" target="_blank">Download</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>

</rapid:override>


<jsp:include page="/base.jsp" flush="true" >
    <jsp:param name="Command" value="test"/>
</jsp:include>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<rapid:override name="content">
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <form:form id="entryForm" modelAttribute="entry" action="/entry/newProcess" method="post">
        <table align="center">
            <tr>
                <td>
                    <form:label path="title">Title</form:label>

                </td>
                <td>
                    <form:input path="title" name="title" id="title" />
                    <form:errors path="title" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="description">Description</form:label>
                </td>
                <td>
                    <form:input path="description" name="description" id="description" />
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <form:button id="entry" name="entry">Add</form:button>
                </td>
            </tr>
            <tr></tr>
            <tr>
                <td></td>
                <td><a href="home.jsp">Home</a>
                </td>
            </tr>
        </table>
    </form:form>
</rapid:override>


<jsp:include page="/base.jsp" flush="true" >
    <jsp:param name="Command" value="test"/>
</jsp:include>

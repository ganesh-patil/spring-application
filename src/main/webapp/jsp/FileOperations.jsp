<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<rapid:override name="content">
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <form:form id="fileForm" modelAttribute="FileOperations" action="fileProcess?${_csrf.parameterName}=${_csrf.token}" method="post"  enctype = "multipart/form-data">
        <table align="center">
            <tr>
                <td>
                    <form:label path="fileName">FileName</form:label>

                </td>
                <td>
                    <form:input path="fileName" name="fileName" id="fileName" />
                    <form:errors path="fileName" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="description">fileDescription</form:label>
                </td>
                <td>
                    <form:input path="description" name="description" id="description" />
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="fileData">File</form:label>
                </td>
                <td>
                    <form:input type="file" path="fileData" name="fileData" id="fileData" accept="image/*" />
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <form:button id="fileUpload" name="fileUpload">Submit</form:button>
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

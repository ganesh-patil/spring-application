<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<rapid:override name="content">  
    <div class="text-center">
        <div class="col-md-12">Welcome ${pageContext.request.remoteUser} </div>
        <div class="row">
        <div class="col-md-3 offset-1"> <a href="users" class="btn btn-primary">List all users</a> </div>
        <div class="col-md-3 offset-1"> <a href="file_upload" class="btn btn-primary"> New file upload</a> </div>
        <div class="col-md-3 offset-1"> <a href="files" class="btn btn-primary"> List all files</a></div>
        </div>
    </div>
</rapid:override>  

<jsp:include page="/base.jsp" flush="true" >
        <jsp:param name="Command" value="test"/>
</jsp:include>
    
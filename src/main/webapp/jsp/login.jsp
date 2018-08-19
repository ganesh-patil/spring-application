<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<rapid:override name="content">  
        <div class="text-center">
         <c:url var="loginUrl" value="/login" />
                        <form action="${loginUrl}" method="post" class="form-signin">
                         <c:if test="${param.error != null}">
                                <div class="alert alert-danger">
                                    <p>Invalid username and password.</p>
                                </div>
                            </c:if>
                            <c:if test="${param.logout != null}">
                                <div class="alert alert-success">
                                    <p>You have been logged out successfully.</p>
                                </div>
                            </c:if>
		      <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
		      <label for="inputEmail" class="sr-only">Username</label>
		      <input type="text" class="form-control" class="form-control" id="username" name="ssoId" placeholder="Enter Username" required>
		      <label for="inputPassword" class="sr-only">Password</label>
		       <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
		       <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
		      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		      <p class="mt-5 mb-3 text-muted">© 2017-2018</p>
    </form>
    </div>
</rapid:override>  

<jsp:include page="/base.jsp" flush="true" >
        <jsp:param name="Command" value="test"/>
</jsp:include>

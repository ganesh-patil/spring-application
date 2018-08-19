<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>  
<rapid:override name="content">  
     <main role="main">

      <section class="jumbotron text-center">
        <div class="container">
          <h1 class="jumbotron-heading">Spring application</h1>
          <p class="lead text-muted">Sample spring application</p>
          <p>
            <a href="login" class="btn btn-primary my-2">Login</a>
            <a href="register" class="btn btn-secondary my-2">Register</a>
          </p>
        </div>
      </section>


    </main>
</rapid:override>  


<jsp:include page="base.jsp" flush="true" >
        <jsp:param name="Command" value="test"/>
</jsp:include>


   

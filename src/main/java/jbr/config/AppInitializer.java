package jbr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//    public class AppInitializer  {
    protected Class<?>[] getRootConfigClasses() {
        //return new Class[]{AppConfig.class};
        return null;
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
       // return  null;
    }



    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}

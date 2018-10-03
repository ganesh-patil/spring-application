package jbr.springmvc.security;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import jbr.springmvc.service.AppUserDetailsServiceDAO;
import jbr.springmvc.service.UserHiberService;
import jbr.springmvc.service.UserService;

//import com.journaldev.webapp.spring.dao.AppUserDetailsServiceDAO;


@EnableWebMvcSecurity
@ImportResource({"classpath:jbr/config/user-beans.xml"})
@EnableGlobalMethodSecurity
@ComponentScan("jbr.springmvc")
public class MultiHttpSecurityCustomConfig {
    @Autowired
    public AppUserDetailsServiceDAO appUserDetailsServiceDAO;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and().withUser("admin").password("password")
//                .roles("USER", "ADMIN");

        auth.userDetailsService(appUserDetailsServiceDAO);
        auth.authenticationProvider(authenticationProvider());
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(appUserDetailsServiceDAO);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Configuration
    @Order(1)
    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        protected void configure(HttpSecurity http) throws Exception {
//            http.antMatcher("/api/**").authorizeRequests().anyRequest().hasRole("ADMIN").and().httpBasic();
          //http.authorizeRequests().antMatchers("/api/entries/*").authenticated().and().httpBasic().and().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            http.antMatcher("/api/**").authorizeRequests().anyRequest().hasRole("USER").and().httpBasic().and().csrf().disable();
        }
    }

    @Configuration
    public static class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        public AppUserDetailsServiceDAO appUserDetailsServiceDAO;


        @Override
        public void configure(WebSecurity web) throws Exception {
            web
                    .ignoring()
                    // Spring Security should completely ignore URLs ending with .html
                    .antMatchers("*.html");
        }


        @Override
        protected void configure(HttpSecurity http) throws Exception {
            final String API_URL = "/api/*";
            http.authorizeRequests()
                    .antMatchers("/login", "/register", "/home.jsp","/registerProcess").permitAll()

                    .antMatchers("/*").access("hasAuthority('ROLE_USER')")
//        .antMatchers("/welcome1").access("hasAuthority('ROLE_USER')")
//              .antMatchers("/file_upload").access("hasAuthority('ROLE_USER')")
//              .antMatchers("/fileProcess").access("hasAuthority('ROLE_USER')")
//              .antMatchers("/api/entries/*").authenticated().and().httpBasic().and().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    //   .antMatchers("/api/entries/*").authenticated().and().httpBasic().and().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and().formLogin().loginPage("/login").defaultSuccessUrl("/welcome1")
                    .usernameParameter("ssoId").passwordParameter("password")
                    .and().csrf().requireCsrfProtectionMatcher(new RequestMatcher() {
                private RegexRequestMatcher requestMatcher = new RegexRequestMatcher(API_URL, null);
                public boolean matches(HttpServletRequest request) {
                    // return !requestMatcher.matches(request);
                    return false;
                }
            })
                    .and().exceptionHandling().accessDeniedPage("/Access_Denied");
        }
       /* @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Bean
        public DaoAuthenticationProvider authenticationProvider() {
            DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
            authenticationProvider.setUserDetailsService(appUserDetailsServiceDAO);
            authenticationProvider.setPasswordEncoder(passwordEncoder());
            return authenticationProvider;
        }*/

    }

}



package jbr.springmvc.security;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import jbr.springmvc.service.AppUserDetailsServiceDAO;
import jbr.springmvc.service.UserHiberService;
import jbr.springmvc.service.UserService;

//import com.journaldev.webapp.spring.dao.AppUserDetailsServiceDAO;

@Configuration
@EnableWebMvcSecurity
@ImportResource({"classpath:jbr/config/user-beans.xml"})
@EnableGlobalMethodSecurity
@ComponentScan("jbr.springmvc")
//@EntityScan(basePackages={"org.charts.model"})
//@EnableJpaRepositories(basePackages={"org.charts.repositories"})
//@EnableTransactionManagement
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public AppUserDetailsServiceDAO appUserDetailsServiceDAO;

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
			throws Exception {

		// in-memory authentication
		// auth.inMemoryAuthentication().withUser("pankaj").password("pankaj123").roles("USER");

		// using custom UserDetailsService DAO
		 auth.userDetailsService(appUserDetailsServiceDAO);
		 auth.authenticationProvider(authenticationProvider());

		// using JDBC
	/*	Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx
//				.lookup("java:/comp/env/jdbc/MyLocalDB");
		.lookup("jdbc:mysql://localhost:3306/MyLocalDB");

		final String findUserQuery = "select username,password,enabled "
				+ "from Employees " + "where username = ?";
		final String findRoles = "select username,role " + "from Roles "
				+ "where username = ?";
		
		auth.jdbcAuthentication().dataSource(ds)
				.usersByUsernameQuery(findUserQuery)
				.authoritiesByUsernameQuery(findRoles); */
	}
	
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
                // Spring Security should completely ignore URLs ending with .html
                .antMatchers("*.html");
    }
    
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
       
      http.authorizeRequests()
        .antMatchers("/login").permitAll()
        .antMatchers("/welcome1").access("hasAuthority('ROLE_USER')")
              .antMatchers("/file_upload").access("hasAuthority('ROLE_USER')")
              .antMatchers("/fileProcess").access("hasAuthority('ROLE_USER')")
        .and().formLogin().loginPage("/login").defaultSuccessUrl("/welcome1")
        .usernameParameter("ssoId").passwordParameter("password")
        .and().csrf()
        .and().exceptionHandling().accessDeniedPage("/Access_Denied");
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

}


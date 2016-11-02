package app.config.spring.security;

import org.baali.web.security.MyCustomProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SpringSecurityContext extends WebSecurityConfigurerAdapter
{

    @Autowired
    private MyCustomProvider myCustomProvider;

    @Autowired
    public void managerBuilder(AuthenticationManagerBuilder auth)
    {
        auth.authenticationProvider(myCustomProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        //@formatter:off
        http.authorizeRequests()
             .antMatchers("/").permitAll()
             .antMatchers("/login").permitAll()
             .antMatchers("/logout").permitAll()
             .antMatchers("/api").access("hasRole(\"ROLE_ADMIN\")")
             .antMatchers("/user").access("hasRole('ROLE_USER')")
        .and()
              .formLogin().loginPage("/login").failureForwardUrl("/login?failure")
        .and()
              .logout().logoutUrl("/logout").clearAuthentication(true)
              .invalidateHttpSession(true)
        .and()
              .exceptionHandling().accessDeniedPage("/403")
        .and()
              .csrf().disable();




        // @formatter:on
    }
}

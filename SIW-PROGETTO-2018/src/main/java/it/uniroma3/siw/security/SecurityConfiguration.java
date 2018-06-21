package it.uniroma3.siw.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
    private AccessDeniedHandler accessDeniedHandler;
	
	@Override
	protected void configure (HttpSecurity http) throws Exception{
		http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/", "/home").permitAll()
        .antMatchers("/admin/**").hasAnyRole("ADMIN")
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .defaultSuccessUrl("/admin")
        .failureUrl("/403")       
        .and()
		.logout().permitAll().logoutSuccessUrl("/login")
        .and()
        .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
        		.passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("admin").password("password").roles("ADMIN");
    }
}
package pl.browarmistrz.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import pl.coderslab.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
//		CharacterEncodingFilter filter = new CharacterEncodingFilter();
//        filter.setEncoding("UTF-8");
//        filter.setForceEncoding(true);
//        http.addFilterBefore(filter, CsrfFilter.class);

		http.authorizeRequests()
			.antMatchers("/home").permitAll()
			.antMatchers("/adminpage").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/recipe/addrecipe").access("hasRole('ROLE_USER')")
			.antMatchers("/user/users").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/user/recipes").access("hasRole('ROLE_ADMIN')")
			.and().formLogin().loginPage("/login").loginProcessingUrl("/login")
			.and().exceptionHandling().accessDeniedPage("/Access_Denied");

	}

	@Bean
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}
}

package spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import tm.service.UserService;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "spring.security")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new TourismAuthenticationProvider(userService));

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //添加转码
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        http.addFilterBefore(encodingFilter, CsrfFilter.class);

        http
            .authorizeRequests()
                .regexMatchers("/touristRegister.*").hasRole("ADMIN")
                .regexMatchers("/touristRetrieval.*").hasRole("ADMIN")
                .regexMatchers("/hotelRegister.*").hasRole("ADMIN")
                .regexMatchers("/hotelRetrieval.*").hasRole("ADMIN")
                .regexMatchers("/infoRetrieval.*").hasRole("ADMIN")
                .regexMatchers("/hotel/checkIn.*").hasRole("HOTEL")
                .regexMatchers("/hotel/checkQuery.*").hasRole("HOTEL")
            .and()
            .formLogin()
                .loginPage("/login")
                .loginPage("/message/mustLogin")
                .successForwardUrl("/WEB-INF/layout/closeLogin.jsp")
                .failureUrl("/login/failure")
            .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
            .and()
            .rememberMe()
                .tokenValiditySeconds(86400)
                .key("userKey")
                .rememberMeParameter("remember-me-1")
            .and()
            .rememberMe()
                .tokenValiditySeconds(258200)
                .key("userKey")
                .rememberMeParameter("remember-me-3")
            .and()
            .rememberMe()
                .tokenValiditySeconds(604800)
                .key("userKey")
                .rememberMeParameter("remember-me-7")
            .and()
            .rememberMe()
                .key("userKey")
                .rememberMeParameter("remember-me-14")
            .and()
            .requiresChannel()
                .regexMatchers("/.*");
    }
}

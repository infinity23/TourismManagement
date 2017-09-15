package spring.security.config;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import tm.service.UserService;


class TourismAuthenticationProvider extends DaoAuthenticationProvider {

    TourismAuthenticationProvider(UserService userService) {
        setUserDetailsService(new TourismUserService(userService));
        setHideUserNotFoundExceptions(false);
        setPasswordEncoder(new Md5PasswordEncoder());

        ReflectionSaltSource saltSource = new ReflectionSaltSource();
        saltSource.setUserPropertyToUse("getUsername");
        setSaltSource(saltSource);
    }

}

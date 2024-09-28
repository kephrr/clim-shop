package soft_afric.clim.shop.clim_shop.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private  final PasswordEncoder passwordEncoder;

    //Authentification
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return  daoAuthenticationProvider;
    }

    //Autorisation
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       return http.csrf(AbstractHttpConfigurer::disable)//csrf->csrf.disable()
               .formLogin(form->form
                       .loginPage("/login")
                       .permitAll()
               ).authorizeHttpRequests(auth->auth
                       .requestMatchers("/api/**").permitAll()
                       .requestMatchers("/admin/**").hasAnyAuthority("Admin")
                       .requestMatchers("/client/**").hasAnyAuthority("Client")
                       .anyRequest().authenticated())
               .build();
    }
    /*
    1.20.1
    ça c'est dans le cas où l'on veut changer le forumulaire de connexion par défaut
    il faut créer un dossier securiti dans ressources où on aura les vues de la
    sécurité, créer un controller qui va se charger de nous affiche la page correspondante, 44:14 avant dernier cour
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       return http.csrf(csrf->csrf.disable())
               .formLogin(form -> form
                       .loginPage("/login")
                       .permitAll()
               )
               .build();


    }*/




}

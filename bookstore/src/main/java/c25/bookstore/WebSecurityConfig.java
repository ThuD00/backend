package c25.bookstore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration 
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {

  @Bean 
  public SecurityFilterChain configure(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(authorize -> authorize
      //Enable css when logged out
      .requestMatchers("/css/**").permitAll()
      .anyRequest().authenticated()
    )
    .formLogin(formlogin -> formlogin
      .defaultSuccessUrl("/booklist", true)
      .permitAll()
    )
    .logout(logout -> logout
      .permitAll()
    );
    return http.build();
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
  /*public UserDetailsService userDetailsService() {
    kätevä tapa kerätä usempi käyttäjä yhteen kokoelmaan
    List<UserDetails> users = new ArrayList<>();
    
    PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    UserDetails user = User
      .withUsername("user")
      .password(passwordEncoder.encode("user"))
      .roles("USER")
      .build();

    users.add(user);

    UserDetails admin = User
      .withUsername("admin")
      .password(passwordEncoder.encode("admin"))
      .roles("USER", "ADMIN")
      .build();

    users.add(admin);
    
    return new InMemoryUserDetailsManager(users);*/

}


package com.pitzza.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
// toma las anotaciones de seguridad que estań incluso por fuera de los controladores y las hace efectivas
@EnableMethodSecurity ( securedEnabled = true )
public class SecurityConfig {
  private final JwtFilter jwtFilter;

  public SecurityConfig ( JwtFilter jwtFilter ) {
    this.jwtFilter = jwtFilter;
  }

  @Bean
  public SecurityFilterChain filterChain ( HttpSecurity http ) throws Exception {
    http
        .authorizeHttpRequests(( customizeRequests )  -> {
              customizeRequests
                      // en los matches No se agrega el server.servlet.context-path
                      .requestMatchers ( "/auth/login" ).permitAll ()
                      .requestMatchers ( "/customer/phone"  ).hasRole ( "CUSTOMER" )
                      .requestMatchers ( HttpMethod.GET, "/pizzas/**" ).hasAnyRole ( "ADMIN", "CUSTOMER" )
                      .requestMatchers (HttpMethod.POST ,"/orders/random" ).hasAuthority ( "random_order" ) // no es necesario el post (pero clarifica lo que se hace)
                      .requestMatchers ("/orders/**" ).hasRole ( "ADMIN" )
                      .requestMatchers ( HttpMethod.DELETE ).hasRole ( "ADMIN" )
                      .anyRequest()
                      .authenticated();
            }
        )
        .sessionManagement( session -> session.sessionCreationPolicy ( SessionCreationPolicy.STATELESS ) )
        .csrf( AbstractHttpConfigurer::disable)
        .cors(Customizer.withDefaults())
        // .httpBasic( Customizer.withDefaults ());
        .addFilterBefore ( jwtFilter , UsernamePasswordAuthenticationFilter.class  );
    return http.build();
  }

  /**
  // Usuarios hordcodeados ( autenticacion en memoria )
  @Bean
  public UserDetailsService memoryUser (){
    UserDetails admin = User.builder ()
                                .username ( "admin" )
                                .password ( passwordEncoder ().encode ( "admin123" )  )
                                .roles ( "ADMIN" )
                                .build ();
    UserDetails customer = User.builder ()
                                .username ( "customer" )
                                .password ( passwordEncoder ().encode ( "customer" )  )
                                .roles ( "CUSTOMER" )
                                .build ();
    return new InMemoryUserDetailsManager (admin, customer);
  }*/

  @Bean
  public PasswordEncoder passwordEncoder (){
    return new BCryptPasswordEncoder ();
  }

  @Bean
  public AuthenticationManager authenticationManager ( AuthenticationConfiguration configuration ) throws Exception {
    return configuration.getAuthenticationManager ();
  }
}

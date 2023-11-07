package com.pitzza.web.config;


import com.pitzza.service.UserSecurityService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

  private final JwtUtil jwtUtil;
  private final UserSecurityService userSecurityService;

  public JwtFilter ( JwtUtil jwtUtil, UserSecurityService userSecurityService ) {
    this.jwtUtil = jwtUtil;
    this.userSecurityService = userSecurityService;
  }

  /**
   * Valida los JWT que llegan
   * @param request : peticion
   * @param response : respuesta
   * @param filterChain : filtro
   * @throws ServletException
   * @throws IOException
   */
  @Override
  protected void doFilterInternal ( HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain ) throws ServletException, IOException {


    // 1. validar que sea un Header Authorization valido.
    String authHeader = request.getHeader ( HttpHeaders.AUTHORIZATION );
    System.out.println (authHeader);

    if ( authHeader == null || !authHeader.startsWith ( "Bearer" ) ){
      filterChain.doFilter ( request, response );
      return;
    }

    // 2. Validar que el JWT sea válido.
    String jwt = authHeader.split ( " " )[1].trim ();

    if (!this.jwtUtil.isValid ( jwt )) {
      filterChain.doFilter ( request, response );
      return;
    }
    System.out.println ("====> El token validado " + jwt);

    // 3. Cargar el usuario del UserDetailsService (para este caso UserScurityService).

    String username = this.jwtUtil.getUsername ( jwt );
    User user = ( User ) this.userSecurityService.loadUserByUsername ( username );

    // 4. Cargar al usuario en el contexto de seguridad.
    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken (
         user.getUsername (), user.getPassword (), user.getAuthorities ()
    );

    authenticationToken.setDetails ( new WebAuthenticationDetailsSource ().buildDetails ( request ) );
    SecurityContextHolder.getContext ().setAuthentication ( authenticationToken );
    System.out.println ( authenticationToken );
    filterChain.doFilter ( request, response );
  }
}

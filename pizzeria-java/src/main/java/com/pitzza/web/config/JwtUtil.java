package com.pitzza.web.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {
  private static final String SECRET_KEY = "C4vE_aCcE22O";

  public String create ( String username ){
    return JWT.create ()
                   .withSubject ( username )
                   .withIssuer ( "pizzeria" )
                   .withIssuedAt ( new Date () )
                   .withExpiresAt ( new Date ( System.currentTimeMillis () + TimeUnit.DAYS.toMillis ( 15 ) ) )// 15 dias a milisegundos
                   .sign ( Algorithm.HMAC256 ( SECRET_KEY ) );
  }

  public boolean isValid ( String jwt ){
    try {
          JWT.require ( Algorithm.HMAC256 ( SECRET_KEY ))
                  .build ()
                  .verify ( jwt );
      return true;
    }catch ( JWTVerificationException e ) {
      return false;
    }
  }

  public String getUsername (String jwt ){
    return JWT.require ( Algorithm.HMAC256 ( SECRET_KEY ))
            .build ()
            .verify ( jwt )
            .getSubject ();
  }
}

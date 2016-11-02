package org.baali.web.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Balaji on 02/11/16.
 */

@Component
public class MyCustomProvider implements AuthenticationProvider
{
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        if (username.equals("user") && password.equals("user"))
        {
            return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList(new SimpleGrantedAuthority
                    ("ROLE_USER")));
        }
        else if (username.equals("admin") && password.equals("admin"))
        {
            return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList(new SimpleGrantedAuthority
                    ("ROLE_ADMIN")));
        }
        else
        {
            throw new BadCredentialsException("Invalid User!!!");
        }
    }

    public boolean supports(Class<?> authentication)
    {
        return true;
    }
}

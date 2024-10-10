package com.bz.hrm.security.jwt;

import com.bz.hrm.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String jwt = parseJwt(request);

            if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
                String username = jwtUtils.getUsernameFromJwtToken(jwt);

                // Load user details by username
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                // Create authentication token with authorities
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());

                // Set details for the current request context
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // Set the current authenticated user in SecurityContext
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else if (jwt == null) {
                logger.warn("JWT token is missing from the Authorization header");
            } else {
                logger.warn("Invalid JWT token");
            }
        } catch (Exception e) {
            logger.error("Cannot set user authentication: {}", e);
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error processing authentication");
        }

        // Continue the filter chain
        filterChain.doFilter(request, response);
    }

    /**
     * Extracts the JWT token from the Authorization header.
     */
    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (headerAuth != null && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7);  // Extract the token part after "Bearer "
        }

        return null;
    }
}

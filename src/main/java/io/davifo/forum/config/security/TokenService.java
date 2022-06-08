package io.davifo.forum.config.security;

import io.davifo.forum.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
    public String createToken(Authentication authentication){
        User Logged = (User) authentication.getPrincipal();
        return Jwts.builder()
                .setIssuer("API FORUM DAVIFO")
                .setSubject(Logged.getId()+"")
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+8600000))
                .signWith(SignatureAlgorithm.HS256, "asuhdadhopaih1293138103")
                .compact();
    }
}

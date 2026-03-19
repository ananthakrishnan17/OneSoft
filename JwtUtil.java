package in.onesoft.pos.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JwtUtil {

    private static String getSecret() {
        String envSecret = System.getenv("JWT_SECRET");
        return (envSecret != null && !envSecret.trim().isEmpty()) ? envSecret
                : "your-256-bit-super-secret-key-change-me";
    }

    private static final String SECRET = getSecret();
    private static final Algorithm ALGORITHM = Algorithm.HMAC256(SECRET);
    private static final long EXPIRATION_TIME = 86400000L; // 24 Hours

    public static String generateToken(String userId, String companyId) {
        return JWT.create()
                .withClaim("userId", userId)
                .withClaim("companyId", companyId)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(ALGORITHM);
    }

    public static DecodedJWT verifyToken(String token) {
        return JWT.require(ALGORITHM)
                .build()
                .verify(token);
    }
}
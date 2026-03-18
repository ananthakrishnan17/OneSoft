package in.onesoft.pos.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Date;

public class JwtUtil {

    private static String getSecret() {
        String envSecret = System.getenv("JWT_SECRET");
        return (envSecret != null && !envSecret.trim().isEmpty()) ? envSecret : "YOUR_SUPER_SECRET_KEY_CHANGE_IN_PROD";
    }

    private static final String SECRET = getSecret();
    private static final Algorithm ALGORITHM = Algorithm.HMAC256(SECRET);
    private static final String ISSUER = "onesoft-pos";

    public static String generateToken(Long userId, Long companyId) {
        return JWT.create()
                .withIssuer(ISSUER)
                .withClaim("userId", userId)
                .withClaim("companyId", companyId)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 86400000L)) // 1 day expiration
                .sign(ALGORITHM);
    }

    public static DecodedJWT verifyToken(String token) {
        return JWT.require(ALGORITHM)
                .withIssuer(ISSUER)
                .build()
                .verify(token);
    }
}
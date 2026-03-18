package in.onesoft.pos.filter;

import com.auth0.jwt.interfaces.DecodedJWT;
import in.onesoft.pos.util.JsonUtil;
import in.onesoft.pos.util.JwtUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/api/*")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String path = req.getRequestURI();
        
        // Exclude public paths (Health checks, Login/Auth routes)
        if (path.endsWith("/api/health") || path.contains("/api/auth/")) {
            chain.doFilter(request, response);
            return;
        }

        String header = req.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            JsonUtil.error(res, 401, "Missing or invalid Authorization header");
            return;
        }

        String token = header.substring(7);
        try {
            DecodedJWT jwt = JwtUtil.verifyToken(token);
            Long companyId = jwt.getClaim("companyId").asLong();
            Long userId = jwt.getClaim("userId").asLong();
            
            // Attach verified claims to the request so Servlets can safely use them
            req.setAttribute("companyId", companyId);
            req.setAttribute("userId", userId);

            chain.doFilter(request, response);
            
        } catch (Exception e) {
            // Token expired, mangled, or invalid signature
            JsonUtil.error(res, 401, "Invalid or expired token");
        }
    }
}
package in.onesoft.pos.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class JsonUtil {

    private static final ObjectMapper mapper = new ObjectMapper();

    // Request JSON -> Java Object
    public static <T> T parse(HttpServletRequest req, Class<T> clazz)
            throws IOException {

        return mapper.readValue(req.getInputStream(), clazz);
    }

    // Java Object -> JSON Response
    public static void send(HttpServletResponse res, int status, Object data)
            throws IOException {

        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        res.setStatus(status);

        mapper.writeValue(res.getOutputStream(), data);
    }
}
package in.onesoft.pos.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class JsonUtil {

    private static final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    private static final Validator validator;

    static {
        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            validator = factory.getValidator();
        }
    }

    // Request JSON -> Java Object
    public static <T> T parse(HttpServletRequest req, Class<T> clazz)
            throws IOException {

        T obj = mapper.readValue(req.getInputStream(), clazz);
        Set<ConstraintViolation<T>> violations = validator.validate(obj);

        if (!violations.isEmpty()) {
            String errors = violations.stream()
                    .map(v -> v.getPropertyPath() + " " + v.getMessage())
                    .collect(Collectors.joining(", "));
            throw new IllegalArgumentException(errors);
        }

        return obj;
    }

    // Object -> JSON String (For Redis)
    public static String toJson(Object obj) throws JsonProcessingException {
        return mapper.writeValueAsString(obj);
    }

    // JSON String -> Object (From Redis)
    public static <T> T fromJson(String json, Class<T> clazz) throws JsonProcessingException {
        return mapper.readValue(json, clazz);
    }

    // Java Object -> JSON Response
    public static void send(HttpServletResponse res, int status, Object data)
            throws IOException {

        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        res.setStatus(status);

        mapper.writeValue(res.getOutputStream(), data);
    }

    // Error Response
    public static void error(HttpServletResponse res, int status, String message) throws IOException {
        send(res, status, Map.of("error", message));
    }
}
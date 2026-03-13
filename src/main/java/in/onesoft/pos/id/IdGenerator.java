package in.onesoft.pos.id;

import java.security.SecureRandom;

public class IdGenerator {

    private static final SecureRandom random = new SecureRandom();

    /**
     * 19-digit ID generate பண்ணு
     * First 7 → scope ID (e.g. 0000001)
     * Last 12 → random digits
     *
     * Example: 0000001382916475820
     */
    public static String generate(String scopeId) {
        // scopeId exactly 7 digits-ஆ இருக்கணும்
        if (scopeId == null || scopeId.length() != 7) {
            throw new IllegalArgumentException("scopeId must be exactly 7 digits");
        }

        // 12 random digits generate பண்ணு
        StringBuilder random12 = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            random12.append(random.nextInt(10)); // 0-9
        }

        return scopeId + random12.toString(); // 7 + 12 = 19 digits
    }

    /**
     * ID-லிருந்து scopeId எடு
     * "0000001382916475820" → "0000001"
     */
    public static String extractScopeId(String id) {
        if (id == null || id.length() != 19) {
            throw new IllegalArgumentException("Invalid ID: must be 19 digits");
        }
        return id.substring(0, 7);
    }

    /**
     * scopeId format பண்ணு
     * 1 → "0000001"
     * 42 → "0000042"
     */
    public static String formatScopeId(int scope) {
        return String.format("%07d", scope);
    }
}
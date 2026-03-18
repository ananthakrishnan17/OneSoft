package in.onesoft.pos.servlet;

import in.onesoft.pos.model.BillHold;
import in.onesoft.pos.repository.BaseRepository;
import in.onesoft.pos.repository.BillHoldRepository;
import in.onesoft.pos.util.JsonUtil;
import in.onesoft.pos.util.RedisUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/api/bill-holds/*")
public class BillHoldServlet extends BaseServlet<BillHold> {
    private final BillHoldRepository repo = new BillHoldRepository();

    @Override
    protected BaseRepository<?, BillHold> getRepository() {
        return repo;
    }

    @Override
    protected Class<BillHold> getPojoClass() {
        return BillHold.class;
    }

    private String getRedisKey(Long companyId) {
        return "company:" + companyId + ":billholds";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Long companyId = getCompanyId(req);
        String pathInfo = req.getPathInfo();
        String key = getRedisKey(companyId);

        try (Jedis jedis = RedisUtil.getResource()) {
            if (pathInfo == null || pathInfo.equals("/")) {
                Map<String, String> holds = jedis.hgetAll(key);
                List<BillHold> list = new ArrayList<>();
                for (String json : holds.values()) {
                    list.add(JsonUtil.fromJson(json, BillHold.class));
                }
                JsonUtil.send(res, 200, list);
            } else {
                String id = pathInfo.substring(1);
                String json = jedis.hget(key, id);
                if (json == null) {
                    JsonUtil.error(res, 404, "Bill Hold not found in cache");
                } else {
                    JsonUtil.send(res, 200, JsonUtil.fromJson(json, BillHold.class));
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            BillHold hold = JsonUtil.parse(req, BillHold.class);
            Long companyId = getCompanyId(req);
            hold.companyId = companyId;

            try (Jedis jedis = RedisUtil.getResource()) {
                // Assign temporary cache ID and hold info
                if (hold.id == null) {
                    hold.id = jedis.incr("global:billholds:id");
                }
                if (hold.holdNo == null) {
                    hold.holdNo = "HOLD-" + hold.id;
                }
                if (hold.holdDate == null) {
                    hold.holdDate = OffsetDateTime.now();
                }

                jedis.hset(getRedisKey(companyId), String.valueOf(hold.id), JsonUtil.toJson(hold));
            }

            JsonUtil.send(res, 201, hold);
        } catch (IllegalArgumentException e) {
            JsonUtil.error(res, 400, e.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            String pathInfo = req.getPathInfo();
            if (pathInfo == null || pathInfo.equals("/")) {
                JsonUtil.error(res, 400, "ID required for update");
                return;
            }

            String id = pathInfo.substring(1);
            Long companyId = getCompanyId(req);
            BillHold hold = JsonUtil.parse(req, BillHold.class);
            hold.id = Long.parseLong(id);
            hold.companyId = companyId;

            try (Jedis jedis = RedisUtil.getResource()) {
                if (!jedis.hexists(getRedisKey(companyId), id)) {
                    JsonUtil.error(res, 404, "Bill Hold not found in cache");
                    return;
                }
                jedis.hset(getRedisKey(companyId), id, JsonUtil.toJson(hold));
            }
            JsonUtil.send(res, 200, hold);
        } catch (IllegalArgumentException e) {
            JsonUtil.error(res, 400, e.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            JsonUtil.error(res, 400, "ID required for deletion");
            return;
        }

        String id = pathInfo.substring(1);
        Long companyId = getCompanyId(req);

        try (Jedis jedis = RedisUtil.getResource()) {
            long deleted = jedis.hdel(getRedisKey(companyId), id);
            if (deleted > 0) {
                JsonUtil.send(res, 204, null);
            } else {
                JsonUtil.error(res, 404, "Bill Hold not found in cache");
            }
        }
    }
}
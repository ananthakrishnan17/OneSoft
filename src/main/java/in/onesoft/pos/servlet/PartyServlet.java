package in.onesoft.pos.servlet;

import in.onesoft.pos.model.Party;
import in.onesoft.pos.repository.BaseRepository;
import in.onesoft.pos.repository.PartyRepository;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/api/parties/*")
public class PartyServlet extends BaseServlet<Party> {
    private final PartyRepository repo = new PartyRepository();

    @Override
    protected BaseRepository<?, Party> getRepository() {
        return repo;
    }

    @Override
    protected Class<Party> getPojoClass() {
        return Party.class;
    }
}
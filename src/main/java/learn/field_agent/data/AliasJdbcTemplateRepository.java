package learn.field_agent.data;

import learn.field_agent.models.Alias;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AliasJdbcTemplateRepository implements  AliasRepository{

    private final JdbcTemplate jdbcTemplate;

    public AliasJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Alias> findAll() {
        final  String sql = "select alias_id, name, persona, agent_id" +
                " from alias limit 1000";
        return jdbcTemplate.query(sql, new AliasMapper());
    }

    @Override
    public Alias findById(int aliasId) {
        return null;
    }

    @Override
    public Alias add(Alias alias) {
        return null;
    }

    @Override
    public boolean update(Alias agent) {
        return false;
    }

    @Override
    public boolean deleteById(int aliasId) {
        return false;
    }
}

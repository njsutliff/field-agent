package learn.field_agent.data;

import learn.field_agent.data.mappers.AliasMapper;
import learn.field_agent.data.mappers.LocationMapper;
import learn.field_agent.models.Alias;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public class AliasJdbcTemplateRepository implements AliasRepository {

    private final JdbcTemplate jdbcTemplate;

    public AliasJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Alias findByAgentId(int agentId) {
        final String sql = "select alias_id, name, persona, agent_id "
                + "from alias "
                + "where agent_id = ?;";

        return jdbcTemplate.query(sql, new AliasMapper(), agentId).stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public Alias add(Alias alias) {
        final String sql = "insert into alias (name, persona, agent_id"
                + "values(?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, alias.getAlias());
            ps.setString(2, alias.getPersona());
            ps.setInt(3, alias.getAgentId());
            return ps;
        }, keyHolder);
        if (rowsAffected <= 0) {
            return null;
        }
        alias.setId(keyHolder.getKey().intValue());
        return alias;
    }

    @Override
    public boolean update(Alias agent) {
        final String sql = "update alias set "
                + "name = ?, "
                + "persona = ?, "
                + "agent_id = ?, " +
                "where alias_id > 0";
        return jdbcTemplate.update(sql,
                agent.getAlias(),
                agent.getPersona(),
                agent.getAgentId()) > 0;

    }

    @Override
    public boolean deleteById(int aliasId) {
        return jdbcTemplate.update("delete from alias where alias_id = ?", aliasId) > 0;
    }
}

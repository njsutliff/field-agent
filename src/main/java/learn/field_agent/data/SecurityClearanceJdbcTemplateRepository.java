package learn.field_agent.data;

import learn.field_agent.data.mappers.SecurityClearanceMapper;
import learn.field_agent.models.SecurityClearance;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class SecurityClearanceJdbcTemplateRepository implements SecurityClearanceRepository {

    private final JdbcTemplate jdbcTemplate;

    public SecurityClearanceJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<SecurityClearance> findAll() {
        final String sql = "select security_clearance_id, name security_clearance_name "
                + "from security_clearance ";
        return jdbcTemplate.query(sql, new SecurityClearanceMapper());
    }

    @Override
    public SecurityClearance findById(int securityClearanceId) {

        final String sql = "select security_clearance_id, name security_clearance_name "
                + "from security_clearance "
                + "where security_clearance_id = ?;";

        return jdbcTemplate.query(sql, new SecurityClearanceMapper(), securityClearanceId)
                .stream()
                .findFirst().orElse(null);
    }

    @Override
    public SecurityClearance add(SecurityClearance sc) {
        final String sql = "insert into security_clearance (security_clearance_id,, security_clearance_name) "
                + " values (?,?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, sc.getSecurityClearanceId());
            ps.setString(2, sc.getName());
            return ps;
        }, keyHolder);
        if (rowsAffected<=0){ return  null; }
        sc.setSecurityClearanceId(keyHolder.getKey().intValue());
        return  sc;
    }

    @Override
    public boolean update(SecurityClearance sc) {
        return false;
    }

    @Override
    public boolean deleteById(int securityClearanceId) {
        return false;
    }
}

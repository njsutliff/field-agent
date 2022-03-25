package learn.field_agent.data;

import learn.field_agent.models.SecurityClearance;
import org.springframework.transaction.annotation.Transactional;

public interface SecurityClearanceRepository {
    SecurityClearance findAll();
    SecurityClearance findById(int securityClearanceId);
    SecurityClearance add(SecurityClearance sc);
    boolean update(SecurityClearance sc);
    @Transactional
    boolean deleteById(int securityClearanceId);
}

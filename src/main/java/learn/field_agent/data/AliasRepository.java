package learn.field_agent.data;

import learn.field_agent.models.Alias;
import org.springframework.transaction.annotation.Transactional;
 public interface AliasRepository {
        Alias findByAgentId(int agentId);
        Alias add(Alias alias);
        boolean update(Alias agent);
        @Transactional
        boolean deleteById(int aliasId);

}

package learn.field_agent.data;

import learn.field_agent.models.Alias;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AliasRepository {

    Alias  findByAgentId(int agentId);

    Alias add(Alias alias);

    boolean update(Alias agent);
    @Transactional
    boolean deleteById(int aliasId);

}

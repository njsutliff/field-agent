package learn.field_agent.data;

import learn.field_agent.models.Alias;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AliasJdbcTemplateRepositoryTest {
    @Autowired
    AliasJdbcTemplateRepository repository;
    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() {
        knownGoodState.set();
    }
    @Test
    void shouldAdd() {
    }

    @Test
    void shouldFindByAgentId() {
        Alias test = new Alias(1, "test", "testPersona", 1);
         repository.findByAgentId(1);
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }
}

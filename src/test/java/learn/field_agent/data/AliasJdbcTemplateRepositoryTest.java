package learn.field_agent.data;

import learn.field_agent.models.Alias;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
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
        Alias test = new Alias(1, "test", "testPersona", 1);
        Alias actual =         repository.add(test);
        assertEquals(test, actual);
    }

    @Test
    void shouldFindByAgentId() {
         repository.findByAgentId(1);
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }
}

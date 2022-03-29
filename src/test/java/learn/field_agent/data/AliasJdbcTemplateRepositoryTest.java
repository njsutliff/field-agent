package learn.field_agent.data;

import learn.field_agent.models.Alias;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

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
        Alias test = makeAlias();
        Alias actual = repository.add(test);
        assertEquals(test, actual);
    }

    @Test
    void shouldFindByAgentId() {
         assertNotNull(repository.findByAgentId(1));
    }

    @Test
    void shouldUpdate() {
        Alias toUpdate = makeAlias();
        toUpdate.setId(1);
        toUpdate.setName("new");
        assertTrue(repository.update(toUpdate));
    }



    @Test
    void deleteById() {
    }
    private Alias makeAlias() {
        Alias alias = new Alias();
        alias.setName("test");
        alias.setAgentId(1);
        return  alias;
    }
}

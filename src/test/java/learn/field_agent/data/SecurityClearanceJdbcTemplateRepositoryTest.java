package learn.field_agent.data;

import learn.field_agent.models.SecurityClearance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class SecurityClearanceJdbcTemplateRepositoryTest {

    @Autowired
    SecurityClearanceJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() {
        knownGoodState.set();
    }
    @Test
    void shouldFindAll(){
        assertEquals(repository.findAll().size(), 2);
    }
    @Test
    void shouldNotFindNotExisting(){
        List<SecurityClearance> list = repository.findAll();
        SecurityClearance russianSpy = new SecurityClearance(3, "Russian spy");
        assertFalse(list.contains(russianSpy));
    }
    @Test
    void shouldFindById() {
        SecurityClearance secret = new SecurityClearance(1, "Secret");
        SecurityClearance topSecret = new SecurityClearance(2, "Top Secret");

        SecurityClearance actual = repository.findById(1);
        assertEquals(secret, actual);

        actual = repository.findById(2);
        assertEquals(topSecret, actual);

        actual = repository.findById(3);
        assertEquals(null, actual);
    }
    @Test void testAdd(){
        SecurityClearance aboveTopSecret = new SecurityClearance(3, "Above Top Secret");
        repository.add(aboveTopSecret);
        SecurityClearance actual = repository.findById(3);
        assertEquals(aboveTopSecret,actual);
    }
    @Test void testUpdate(){
        SecurityClearance lessSecret = makeSC();
        lessSecret.setSecurityClearanceId(3);
        assertTrue(repository.update(lessSecret));
    }
    private  SecurityClearance makeSC(){
        SecurityClearance sc = new SecurityClearance();
        sc.setName("test");
        return sc;
    }

    }
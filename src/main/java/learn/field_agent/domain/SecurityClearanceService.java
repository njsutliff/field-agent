package learn.field_agent.domain;

import learn.field_agent.data.SecurityClearanceRepository;
import learn.field_agent.models.SecurityClearance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SecurityClearanceService {
    private final SecurityClearanceRepository repository;

    public SecurityClearanceService(SecurityClearanceRepository repository) {
        this.repository = repository;
    }

    public List<SecurityClearance> findAll() {
        return repository.findAll();
    }

    public SecurityClearance findById(int securityClearanceId) {
        return repository.findById(securityClearanceId);
    }

    public Result<SecurityClearance> add(SecurityClearance sc) {
        Result<SecurityClearance> result = validate(sc);
        if (!result.isSuccess()) {
            result.addMessage("Unable to add", ResultType.INVALID);
            return result;
        }
        result.setPayload(repository.add(sc));
        return result;
    }

    public Result<SecurityClearance> update(SecurityClearance sc) {
        Result<SecurityClearance> result = validate(sc);
        return result;
    }

    boolean deleteById(int securityClearanceId) {
        return false;
    }

    private Result<SecurityClearance> validate(SecurityClearance toValidate) {
        Result<SecurityClearance> result = new Result<>();
        if(Validations.isNullOrBlank(toValidate.getName()){
            result.addMessage("Security clearance name required.", ResultType.INVALID);
        }
        findAll().stream()
                .filter(securityClearance -> securityClearance.getName()
                .equals(toValidate.getName()))
                .findAny().ifPresent(toNotFind -> result
                .addMessage("Name cannot be duplicated.", ResultType.INVALID));
        return  result;
    }
}

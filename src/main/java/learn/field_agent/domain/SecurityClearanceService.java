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

    public Result<SecurityClearance> findById(int securityClearanceId) {
        Result<SecurityClearance> result = new Result<>();
       if(repository.findById(securityClearanceId)== null){
           result.addMessage("Security Clearance not found!", ResultType.NOT_FOUND);
       }
        result.setPayload(repository.findById(securityClearanceId));
        return result;
    }

    public Result<SecurityClearance> add(SecurityClearance sc) {
        Result<SecurityClearance> result = validate(sc);
        if (!result.isSuccess()) {
            return result;
        }
        if (sc.getSecurityClearanceId() != 0) {
            result.addMessage("Cannot set security Clearance ID with `add`", ResultType.INVALID);
        }
        sc = repository.add(sc);
        result.setPayload(sc);
        return result;
    }

    public Result<SecurityClearance> update(SecurityClearance sc) {
        Result<SecurityClearance> result = validate(sc);
        if (!result.isSuccess()){
            return result;
        }
        if(!repository.update(sc)){
            result.addMessage("Security Clearance not found", ResultType.INVALID);
        }
        return result;
    }

    public Result<SecurityClearance> deleteById(int securityClearanceId) {
              // if false 404 else true TODO validation is in use
        Result<SecurityClearance> result =validateFound(securityClearanceId);
            if(!result.isSuccess()){
                return result;
            }
            return result;
    }

    private Result<SecurityClearance> validateFound(int securityClearanceId) {
        Result<SecurityClearance> result = new Result<>();
        if (!findAll().contains(findById(securityClearanceId).getPayload())){
            result.addMessage("Security Clearance not found", ResultType.NOT_FOUND);
        }
        return result;
    }

    private Result<SecurityClearance> validate(SecurityClearance toValidate) {
        Result<SecurityClearance> result = new Result<>();
        if (toValidate == null) {
            result.addMessage("Security clearance cannot be null", ResultType.INVALID);
            return result;
        }
        if (Validations.isNullOrBlank(toValidate.getName())) {
            result.addMessage("Security clearance name required.", ResultType.INVALID);
        }
        findAll().stream()
                .filter(securityClearance -> securityClearance.getName()
                        .equals(toValidate.getName()))
                .findAny().ifPresent(toNotFind -> result
                        .addMessage("Name cannot be duplicated.", ResultType.INVALID));
        return result;
    }
}

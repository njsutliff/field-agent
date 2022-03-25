package learn.field_agent.domain;

import learn.field_agent.data.SecurityClearanceRepository;
import learn.field_agent.models.Agent;
import learn.field_agent.models.SecurityClearance;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class SecurityClearanceService {
    private  final SecurityClearanceRepository repository;

    public SecurityClearanceService(SecurityClearanceRepository repository) {
        this.repository = repository;
    }

    List<SecurityClearance> findAll(){
        return  repository.findAll();
    }
    SecurityClearance findById(int securityClearanceId){
        return repository.findById(securityClearanceId);
    }
    SecurityClearance add(SecurityClearance sc){
        return sc;
    }
    Result<SecurityClearance> update(SecurityClearance sc){
        Result<SecurityClearance> result = new Result<>();
        return result;
    }
    Result<SecurityClearance> deleteById(int securityClearanceId){
        Result<SecurityClearance> result = new Result<>();
        return  result;
    }
}

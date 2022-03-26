package learn.field_agent.controllers;

import learn.field_agent.domain.SecurityClearanceService;
import learn.field_agent.models.SecurityClearance;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/security/clearance")

public class SecurityClearanceController {
    private final SecurityClearanceService service;

    public  SecurityClearanceController(SecurityClearanceService service){
        this.service = service;
    }
    @GetMapping
   public List<SecurityClearance> findAll(){
        return service.findAll();
    }
    @GetMapping("/{securityClearanceId}")
    public SecurityClearance findById(int securityClearanceId){
        return service.findById(securityClearanceId);
    }
    @PostMapping
    public SecurityClearance add(@RequestBody SecurityClearance sc){
        return sc;
    }
    @PutMapping("/{securityClearanceId}")
    public boolean update(SecurityClearance sc){
return true;
    }
    @DeleteMapping("/securityClearanceId}")
    public boolean deleteById(@PathVariable int securityClearanceId){
        return true;

    }

}

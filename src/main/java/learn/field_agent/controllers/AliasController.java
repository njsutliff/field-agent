package learn.field_agent.controllers;

import learn.field_agent.domain.AliasService;
import learn.field_agent.domain.Result;
import learn.field_agent.models.Agent;
import learn.field_agent.models.Alias;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/alias")

public class AliasController {

    private  final AliasService service;

    public AliasController(AliasService service) {
        this.service = service;
    }
    @GetMapping("/agent/{agentId}")
    public List<Alias> findByAgentId(int agentId){
    return service.findByAgentId(agentId);
    }
    @PostMapping
    public ResponseEntity<Object> add(@RequestBody  Alias alias){
    Result<Alias> result = service.add(alias);

    if(result.isSuccess()){
        return new ResponseEntity<>(result.getPayload(), HttpStatus.CREATED);
    }
        return ErrorResponse.build(result);
    }
    @PutMapping("/{aliasId}")
    public ResponseEntity<Object> update(int aliasId, Alias alias){
        return null;//TODO
    }
    @DeleteMapping("/{aliasId}")
    public ResponseEntity<Void> deleteById(int aliasId){
        return null;//TODO
    }

}

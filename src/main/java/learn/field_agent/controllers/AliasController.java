package learn.field_agent.controllers;

import learn.field_agent.domain.AliasService;
import learn.field_agent.models.Alias;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/alias")

public class AliasController {

    private  final AliasService service;

    public AliasController(AliasService service) {
        this.service = service;
    }
    @GetMapping("/{agentId}")
    public Alias findByAgentId(int agentId){
    return null;//TODO
    }
    @PostMapping
    public ResponseEntity<Object> add(@RequestBody  Alias alias){
        return null;//TODO

    }
    @PutMapping("/{agentId}")
    public ResponseEntity<Object> update(int agentId, Alias alias){
        return null;//TODO
    }
    @DeleteMapping("/{agentId}")
    public ResponseEntity<Void> deleteById(int aliasId){
        return null;//TODO
    }

}

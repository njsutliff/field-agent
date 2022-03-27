package learn.field_agent.models;

public class Alias {
    private  int aliasId;
    private String alias;
    private  String persona;
    private  int agentId;


    public int getId() {
        return aliasId;
    }

    public void setId(int id) {
        aliasId = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public int getAgentId() {
        return agentId;
    }
    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }
}

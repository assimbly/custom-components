package world.dovetail.globalvariables.mongo;

import world.dovetail.globalvariables.domain.GlobalEnvironmentVariable;

import java.util.List;

public interface MongoDao {

    GlobalEnvironmentVariable findVariableByName(String variableName, String tenant);
    List<GlobalEnvironmentVariable> findAll(String tenant);

    void updateVariable(GlobalEnvironmentVariable globalEnvironmentVariable, String tenant);
    void deleteVariable(GlobalEnvironmentVariable globalEnvironmentVariable, String tenant);
}

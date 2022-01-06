package decoratorAndProxy;

import java.util.HashMap;
import java.util.Map;

public class FuncionatioDAOProxy implements FuncionarioDAOInterface{
    private Map<String, Funcionario> funcionarios;

    public FuncionatioDAOProxy(){
        super();
        this.funcionarios = new HashMap<>();
    }

    @Override
    public void addFuncionario(Funcionario funcionario) throws FuncionarioException {
        this.funcionarios.put(funcionario.getNome(), funcionario);
    }

    @Override
    public Funcionario getFuncionario(String nome) throws FuncionarioException {
        return this.funcionarios.get(nome);
    }

    @Override
    public void altFuncionario(String nomeAlt, Funcionario funcionario) throws FuncionarioException {
        this.funcionarios.replace(nomeAlt, funcionario);
    }
}

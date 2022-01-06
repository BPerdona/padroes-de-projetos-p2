package decoratorAndProxy;

public interface FuncionarioDAOInterface {

    public void addFuncionario(Funcionario funcionario) throws FuncionarioException;
    public Funcionario getFuncionario(String nome) throws FuncionarioException;
    public void altFuncionario(String nomeAlt,Funcionario funcionario) throws  FuncionarioException;
}

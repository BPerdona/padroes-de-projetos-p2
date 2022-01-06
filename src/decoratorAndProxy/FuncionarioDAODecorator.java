package decoratorAndProxy;

public class FuncionarioDAODecorator implements FuncionarioDAOInterface{
    private static FuncionarioDAOInterface funcionarioDAO;

    private FuncionarioDAOInterface getDAO(){
        if(funcionarioDAO == null)
            funcionarioDAO = new FuncionatioDAOProxy();
        return funcionarioDAO;
    }

    @Override
    public void addFuncionario(Funcionario funcionario) throws FuncionarioException {
        //Verificando se objeto e seu conteudo é valido
        if(funcionario == null)
            throw new FuncionarioException("O Objeto Funcionario é null!");
        if(!funcIsValid(funcionario))
            throw new FuncionarioException("Preencha os campos corretamente!");
        getDAO().addFuncionario(funcionario);
    }

    @Override
    public Funcionario getFuncionario(String nome) throws FuncionarioException {
        //Verificando se nome e objeto
        if(nome.isBlank())
            throw new FuncionarioException("Informe um nome de funcionário valido!");
        Funcionario func = getDAO().getFuncionario(nome);
        if(func == null)
            throw new FuncionarioException("Informe um nome de funcionário valido!");
        return func;
    }

    @Override
    public void altFuncionario(String nomeAlt, Funcionario funcionario) throws FuncionarioException {
        //Verificando se nome, objeto e seu conteudo é valido
        if(nomeAlt.isBlank())
            throw new FuncionarioException("Informe um nome de funcionário valido!");
        if(funcionario==null)
            throw new FuncionarioException("O Objeto Funcionario é null!");
        if(!funcIsValid(funcionario))
            throw new FuncionarioException("Preencha os campos corretamente!");
        getDAO().altFuncionario(nomeAlt, funcionario);
    }

    //Função de verificação dos atributos do obj funcionario
    private boolean funcIsValid(Funcionario funcionario){
        if(funcionario.getNome().isBlank() || funcionario.getCargo().isBlank() || funcionario.getSalario() <=0)
            return false;
        return true;
    }
}

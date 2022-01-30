package staticFactorySingleton;

public class DataBaseConnection {
    private String url;
    private String user;
    private String senha;
    private static DataBaseConnection instance;

    private DataBaseConnection(String url, String user, String senha){
        this.url = url;
        this.user = user;
        this.senha = senha;
    }

    private DataBaseConnection(String user, String senha){
        this.url = "UrlPadrão";
        this.user = user;
        this.senha = senha;
    }

    private DataBaseConnection(){
        this.url = "UrlPadrão";
        this.user = "UserPadrão";
        this.senha = "SenhaPadrão";
    }

    //Por sem uma conexão seria necessario criar um metodo que retornaria uma conexão com base na instancia da classe
    //Mas por conta de ser apenas um exemplo não implementei o metodo

    public static DataBaseConnection newConnection(String url, String user, String senha){
        //validação
        if(!valida(url) || !valida(user) || !valida(senha))
            return null;

        if(instance!=null){
            instance.setUrl(url);
            instance.setUser(user);
            instance.setSenha(senha);
            return instance;
        }
        //Criando nova instancia caso ainda nao exista
        DataBaseConnection novaInstancia = new DataBaseConnection(url, user, senha);
        instance = novaInstancia;
        return instance;
    }

    public static DataBaseConnection newUserConnection(String user, String senha){
        //validação
        if(!valida(user) || !valida(senha))
            return null;

        if(instance!=null){
            instance.setUser(user);
            instance.setSenha(senha);
            return instance;
        }
        //Criando nova Instancia para o usuario caso nao exista
        DataBaseConnection novaInstancia = new DataBaseConnection(user,senha);
        instance = novaInstancia;
        return instance;
    }

    public static DataBaseConnection newUrlConnection(String url){
        //validação
        if(!valida(url))
            return null;

        if(instance!=null){
            instance.setUrl(url);
            return instance;
        }
        //Criando nova Instancia para o usuario caso nao exista
        DataBaseConnection novaInstancia = new DataBaseConnection();
        novaInstancia.setUrl(url);
        instance = novaInstancia;
        return instance;
    }

    public static DataBaseConnection newSenhaConnection(String senha){
        //validação
        if(!valida(senha))
            return null;

        if(instance!=null){
            instance.setSenha(senha);
            return instance;
        }
        //Criando nova Instancia caso nao tenha sido inicializada
        DataBaseConnection novaInstancia = new DataBaseConnection();
        novaInstancia.setSenha(senha);
        instance = novaInstancia;
        return instance;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    private static boolean valida(String content){
        return !content.contains(" ");
    }
}

package main;

import decoratorAndProxy.*;
import staticFactorySingleton.DataBaseConnection;
import fluentInterfaces.*;
import commands.*;

public class Main {

    public static void main(String[] args){

        //Utilizando o padrão Prox e Decorator para buscar, criar e alterar funcioanrios
        System.out.println("___Prox and Decorator___");

        FuncionarioDAOInterface  funcionarioDAO= new FuncionarioDAODecorator();

        Funcionario pedro = new Funcionario("Pedro", "Padeiro", 1700.0);
        Funcionario ana = new Funcionario("Ana", "Atendente", 1200.0);
        Funcionario jorge = new Funcionario("Jorge", "Estagiario", 0.0);
        Funcionario funcVazio = new Funcionario("", "", 1000.0);

        //Sempre utilizando try por estar utilizando "Banco de dados" e para ver se consegue pegar alguma exceção
        System.out.println("Adicionando Pedro:");
        try {
            //adicionando pedro
            funcionarioDAO.addFuncionario(pedro);
        }catch (FuncionarioException ex){
            System.out.println("Não consegui adicionar esse usuario.");
            System.out.println(ex.getMessage());
        }

        System.out.println("Adicionando Jorge:");
        try {
            //adicionando jorge
            funcionarioDAO.addFuncionario(jorge);
        }catch (FuncionarioException ex){
            System.out.println("Não consegui adicionar esse usuario.");
            System.out.println(ex.getMessage());
        }

        System.out.println("Adicionando ana e promovendo:");
        try {
            //adicionando ana e depois alterando seu salario
            funcionarioDAO.addFuncionario(ana);
            Funcionario anaPromovida = new Funcionario(ana.getNome(), ana.getCargo(), ana.getSalario()*1.40);
            funcionarioDAO.altFuncionario(ana.getNome(), anaPromovida);
        }catch (FuncionarioException ex){
            System.out.println("Não consegui adicionar/Promover o usuário vazio.");
            System.out.println(ex.getMessage());
        }

        System.out.println("Adicionando Funcionario Vazio:");
        try {
            //adicionando funcionario vazio
            funcionarioDAO.addFuncionario(funcVazio);
        }catch (FuncionarioException ex){
            System.out.println("Não consegui adicionar o usuário vazio.");
            System.out.println(ex.getMessage());
        }

        System.out.println("Procurando Funcionario Existente:");
        try {
            //Procurando funcionario existente
            Funcionario anaDnv = funcionarioDAO.getFuncionario("Ana");
            System.out.println(anaDnv.getNome());
        }catch (FuncionarioException ex){
            System.out.println("Não consegui adicionar esse usuario.");
            System.out.println(ex.getMessage());
        }

        System.out.println("Procurando Funcionario sem nome:");
        try {
            //Procurando funcionario sem nome
            Funcionario semNome = funcionarioDAO.getFuncionario("");
            System.out.println(semNome.getNome());
        }catch (FuncionarioException ex){
            System.out.println(ex.getMessage());
        }

        //Utilizando o padrão Static factory method e Singleton para buscar, criar e alterar funcioanrios
        System.out.println("\n\n___Static Factory method e Singleton___");

        //Ideia principal criar um classe para conexão a um banco de dados

        System.out.println("Criando instancias e dando print: ");
        DataBaseConnection joao = DataBaseConnection.newConnection("MySQL","joao","senhaErrada");
        System.out.println("URL: "+joao.getUrl()+" | Usuario: "+joao.getUser()+" | Senha: "+joao.getSenha());

        DataBaseConnection joao2 = DataBaseConnection.newSenhaConnection("senhaCerta");
        System.out.println("URL: "+joao2.getUrl()+" | Usuario: "+joao2.getUser()+" | Senha: "+joao2.getSenha());

        DataBaseConnection maria = DataBaseConnection.newUserConnection("maria", "12345678");
        System.out.println("URL: "+maria.getUrl()+" | Usuario: "+maria.getUser()+" | Senha: "+maria.getSenha());

        DataBaseConnection maria2 = DataBaseConnection.newUrlConnection("SQLite");
        System.out.println("URL: "+maria2.getUrl()+" | Usuario: "+maria2.getUser()+" | Senha: "+maria2.getSenha());

        System.out.println("\nObjetos após a ultima conexão:");
        System.out.println("URL: "+joao.getUrl()+" | Usuario: "+joao.getUser()+" | Senha: "+joao.getSenha());
        System.out.println("URL: "+joao2.getUrl()+" | Usuario: "+joao2.getUser()+" | Senha: "+joao2.getSenha());
        System.out.println("URL: "+maria.getUrl()+" | Usuario: "+maria.getUser()+" | Senha: "+maria.getSenha());
        System.out.println("URL: "+maria2.getUrl()+" | Usuario: "+maria2.getUser()+" | Senha: "+maria2.getSenha());

        //Utilizando o padrão fluent interface para criar ingredientes
        System.out.println("\n\n___Fluent Interface___");
        System.out.println("Criando novos ingredientes:");

        Ingrediente farinha = new Ingrediente().named("Farinha").described("Trigo").theAmount(2.0);
        Ingrediente acucar = new Ingrediente().named("Açucar").described("Refinado").theAmount(1.0);
        Ingrediente fermento = new Ingrediente().named("Fermento").described("Biologico").theAmount(0.1);

        System.out.println("Nome: "+farinha.getNome()+" | Descrição: "+farinha.getDescricao()+" | Quantidade: "+farinha.getQuantidade());
        System.out.println("Nome: "+acucar.getNome()+" | Descrição: "+acucar.getDescricao()+" | Quantidade: "+acucar.getQuantidade());
        System.out.println("Nome: "+fermento.getNome()+" | Descrição: "+fermento.getDescricao()+" | Quantidade: "+fermento.getQuantidade());

        //Utilizando o padrão commands para criar o carrinho de produtos comprados
        System.out.println("\n\n___Commands___");

        Carrinho c = new Carrinho();
        ExecutorComands exec = new ExecutorComands();

        ProdutoPronto pao = new ProdutoPronto("Pao", 12.20);
        ProdutoPronto paoDeQueijo = new ProdutoPronto("Pão de Queijo", 7.50);
        ProdutoPronto presunto = new ProdutoPronto("Presunto", 16.75);
        ServicoBolo bolo = new ServicoBolo("Bolo de Morango",32.40,"Recheado com chocolate.",5.0);
        ServicoBolo bolo2 = new ServicoBolo("Bolo de Fuba",7.90,"Com cobertura de chocolate.",5.0);

        c.setProdutos(exec.adicionar(new InserirProduto(c.getProdutos(), pao)));
        c.setProdutos(exec.adicionar(new InserirProduto(c.getProdutos(), paoDeQueijo)));
        c.setProdutos(exec.adicionar(new InserirProduto(c.getProdutos(), presunto)));


        //Produtos no carrinho
        printCarrinho(c);
        c.setProdutos(exec.desfazer());
        printCarrinho(c);
        c.setProdutos(exec.desfazer());
        printCarrinho(c);
        c.setProdutos(exec.refazer());
        printCarrinho(c);
        c.setProdutos(exec.adicionar(new InserirBolo(c.getProdutos(), bolo)));
        c.setProdutos(exec.adicionar(new InserirBolo(c.getProdutos(), bolo2)));
        printCarrinho(c);
        c.setDesconto(20.0);
        printCarrinho(c);
    }

    //Produtos no carrinho
    public static void printCarrinho(Carrinho c){
        for(ProdutoPronto p : c.getProdutos()){
            System.out.println("Nome: "+p.getNome()+" | Preço: "+p.getPreco());
        }
        System.out.println("Preço final: "+c.getPrecoTotal()+"\n");
    }
}

package main;

import decoratorAndProxy.*;

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
        System.out.println("\nAdicionando Pedro:");
        try {
            //adicionando pedro
            funcionarioDAO.addFuncionario(pedro);
        }catch (FuncionarioException ex){
            System.out.println("Não consegui adicionar esse usuario.");
            System.out.println(ex.getMessage());
        }

        System.out.println("\nAdicionando Jorge:");
        try {
            //adicionando jorge
            funcionarioDAO.addFuncionario(jorge);
        }catch (FuncionarioException ex){
            System.out.println("Não consegui adicionar esse usuario.");
            System.out.println(ex.getMessage());
        }

        System.out.println("\nAdicionando ana e promovendo:");
        try {
            //adicionando ana e depois alterando seu salario
            funcionarioDAO.addFuncionario(ana);
            Funcionario anaPromovida = new Funcionario(ana.getNome(), ana.getCargo(), ana.getSalario()*1.40);
            funcionarioDAO.altFuncionario(ana.getNome(), anaPromovida);
        }catch (FuncionarioException ex){
            System.out.println("Não consegui adicionar/Promover o usuário vazio.");
            System.out.println(ex.getMessage());
        }

        System.out.println("\nAdicionando Funcionario Vazio:");
        try {
            //adicionando funcionario vazio
            funcionarioDAO.addFuncionario(funcVazio);
        }catch (FuncionarioException ex){
            System.out.println("Não consegui adicionar o usuário vazio.");
            System.out.println(ex.getMessage());
        }

        System.out.println("\nProcurando Funcionario Existente:");
        try {
            //Procurando funcionario existente
            Funcionario anaDnv = funcionarioDAO.getFuncionario("Ana");
            System.out.println(anaDnv.getNome());
        }catch (FuncionarioException ex){
            System.out.println("Não consegui adicionar esse usuario.");
            System.out.println(ex.getMessage());
        }

        System.out.println("\nProcurando Funcionario sem nome:");
        try {
            //Procurando funcionario sem nome
            Funcionario semNome = funcionarioDAO.getFuncionario("");
            System.out.println(semNome.getNome());
        }catch (FuncionarioException ex){
            System.out.println(ex.getMessage());
        }
    }
}

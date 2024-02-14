package br.com.mdantas;

import br.com.mdantas.domain.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private static Scanner s = new Scanner(System.in);
    private static List<Account> bankAccounts = new ArrayList<Account>();

    public static void main(String[] args) {
    }

    public static void operations() {
        System.out.println("------------------------------------------------------");
        System.out.println("------------- Bem vindos a nossa agência -------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma operação que deseja realizar *****");
        System.out.println("|-----------------------------------------------------");
        System.out.println("|   Opção 1 - Criar Conta   |");
        System.out.println("|   Opção 2 - Depositar     |");
        System.out.println("|   Opção 3 - Sacar         |");
        System.out.println("|   Opção 4 - Transferir    |");
        System.out.println("|   Opção 5 - Listar        |");
        System.out.println("|   Opção 6 - Sair          |");
    }
}

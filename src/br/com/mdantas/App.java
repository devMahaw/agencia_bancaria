package br.com.mdantas;

import br.com.mdantas.domain.Account;
import br.com.mdantas.domain.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private static Scanner input = new Scanner(System.in);
    private static List<Account> bankAccounts = new ArrayList<Account>();

    public static void main(String[] args) {
        operations();
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

        int operation = input.nextInt();

        switch(operation) {
            case 1:
                createAccount();
                break;
            case 2:
                deposit();
                break;
            case 3:
                toWithdraw();
                break;
            case 4:
                transfer();
                break;
            case 5:
                listAccounts();
                break;
            case 6:
                System.out.println("Muito obrigado por utilizar nossa agência. Até mais!");
                System.exit(0);
            default:
                System.out.println("Opção inválida!");
                operations();
                break;
        }
    }

    public static void createAccount() {
        System.out.println("\nNome: ");
        String name = input.next();
        System.out.println("\nCPF: ");
        String cpf = input.next();
        System.out.println("\nE-mail: ");
        String email = input.next();

        Client client = new Client(name, cpf, email);
        Account account = new Account(client);

        bankAccounts.add(account);
        System.out.println("Sua conta foi criada com sucesso!");

        operations();
    }

    private static Account findAccount(Long accountNumber) {
        Account account = null;

        if (bankAccounts.size() > 0) {
            for (Account bankAccount : bankAccounts) {
                if (bankAccount.getAccountNumber() == accountNumber) {
                    account = bankAccount;
                }
            }
        }

        return account;
    }

    public static void deposit() {
        System.out.println("Numero da conta: ");
        Long accountNumber = input.nextLong();

        Account account = findAccount(accountNumber);

        if (account != null) {
            System.out.println("Qual valor deseja depositar?");
            Double depositValue = input.nextDouble();
            account.deposit(depositValue);
        } else {
            System.out.println("Conta não encontrada.");
        }

        operations();
    }

    public static void toWithdraw() {
        System.out.println("Numero da conta: ");
        Long accountNumber = input.nextLong();

        Account account = findAccount(accountNumber);

        if (account != null) {
            System.out.println("Qual valor deseja sacar?");
            Double withdrawValue = input.nextDouble();
            account.toWithdraw(withdrawValue);
        } else {
            System.out.println("Conta não encontrada.");
        }

        operations();

    }

    public static void transfer() {
        System.out.println("Número da conta do remetente: ");
        Long senderAccountNumber = input.nextLong();

        Account senderAccount = findAccount(senderAccountNumber);

        if (senderAccount != null) {
            System.out.println("Número da conta do destinatário: ");
            Long receiverAccountNumber = input.nextLong();

            Account receiverAccount = findAccount(receiverAccountNumber);

            if (receiverAccount != null) {
                System.out.println("Valor da transferência: ");
                Double transferValue = input.nextDouble();

                senderAccount.transfer(receiverAccount, transferValue);
            } else {
                System.out.println("A conta do destinatário não foi encontrada.");
            }
        } else {
            System.out.println("A conta do remetente não foi encontrada.");
        }

        operations();
    }

    public static void listAccounts() {
        if (bankAccounts.size() > 0) {
            for (Account bankAccount : bankAccounts) {
                System.out.println(bankAccount);
            }
        } else {
            System.out.print("Não há contas cadastradas.");
        }

        operations();
    }
}

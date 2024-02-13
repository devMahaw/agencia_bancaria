package br.com.mdantas.Program;

import br.com.mdantas.utils.Utils;

public class Account {

    private static Long accountCounter = 1l;

    private Long accountNumber;
    private Client client;
    private Double balance = 0.0;

    public Account(Client client) {
        this.accountNumber = accountCounter;
        this.client = client;
        accountCounter += 1;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return  "\nNúmero da conta: " + this.getAccountNumber() +
                "\nNome: " + this.client.getName() +
                "\nCPF: " + this.client.getCpf() +
                "\nE-mail: " + this.client.getEmail() +
                "\nSaldo: " + Utils.doubleToString(this.getBalance()) +
                "\n";
    }

    public void deposit(Double value) {
        if (value > 0) {
            setBalance(getBalance() + value);
            System.out.println("Seu depósito foi realizado com sucesso!");
        } else {
            System.out.println("Não foi possível realizar seu depósito.");
        }
    }

    public void toWithdraw(Double value) {
        if (value > 0 && this.getBalance() >= value) {
            setBalance(getBalance() - value);
            System.out.println("Seu saque foi realizado com sucesso!");
        } else {
            System.out.println("Não foi possível realizar seu saque.");
        }
    }

    public void transfer(Account accountToTransfer, Double value) {
        if (value > 0 && this.getBalance() >= value) {
            setBalance(getBalance() - value);
            accountToTransfer.balance = accountToTransfer.getBalance() + value;
            System.out.println("Sua transferência foi realizada com sucesso!");
        } else {
            System.out.println("Não foi possível realizar sua transferência.");
        }
    }
}

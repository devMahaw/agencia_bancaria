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
}

package br.com.mdantas.domain;

public class Client {

    private static Long clientCounter = 1l;

    private String name;
    private String cpf;
    private String email;

    public Client(String name, String cpf, String email) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        clientCounter += 1;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getCpf() {
        return cpf;
    }

    public void setCpf(java.lang.String cpf) {
        this.cpf = cpf;
    }

    public java.lang.String getEmail() {
        return email;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    public String toString() {
        return "\nNome: " + this.getName() +
               "\nCPF: " + this.getCpf() +
               "\nE-mail: " + this.getEmail();
    }
}

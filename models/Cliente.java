package models;

public class Cliente {

    private final String nome;
    private final String data;
    private final String hora;

    public Cliente(String nome, String data, String hora) {
        this.nome = nome;
        this.data = data;
        this.hora = hora;
    }

    public String getNome() {

        return nome;
    }

    public String getData() {

        return data;
    }

    public String getHora() {

        return hora;
    }


    @Override

    public String toString() {

            return "Cliente: " + getNome() + " | Data: " + getData() + " | Hora: " + getHora();
    }
}
package conversorTemperatura;

import java.util.ArrayList;

public class Historico {  //uso isso para armazenar as operações e resultados numa array pra mostrar no final
    String escolha;
    String conversao;
    double numero;
    double resultado;

    public Historico(String escolha, String conversao, double numero, double resultado) {
        this.escolha = escolha;
        this.conversao = conversao;
        this.numero = numero;
        this.resultado = resultado;
    }

    public void exibirInfo() {
        System.out.println("A conversão foi feita de " + escolha + " para " + conversao + ", sendo o valor: " + numero + " e a conversão resultando: " + resultado);
    }
}

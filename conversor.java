import java.util.Scanner;
import java.util.ArrayList;


class historico {  //uso isso para armazenar as operações e resultados numa array pra mostrar no final
    String escolha;
    String conversao;
    double numero;
    double resultado;


    public historico(String escolha, String conversao, double numero, double resultado) {
        this.escolha = escolha;
        this.conversao = conversao;
        this.numero = numero;
        this.resultado = resultado;
    }


    public void exibirInfo() {
        System.out.println("A conversão foi feita de " + escolha + " para " + conversao + ", sendo o valor: " + numero + " e a conversão resultando: " + resultado);
    }
}


public class conversor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continuar = "sim";
        double resultado = 0;
        String conversao = null;
        ArrayList<historico> historicos = new ArrayList<>();


        while(continuar.equalsIgnoreCase("sim")) {
            System.out.println("Unidades de medida: \n Celsius;\n Fahrenheit;\n Kelvin. \n Escolha uma medida: ");
            String escolha = scanner.nextLine();
            System.out.println("Digite o valor da temperatura: ");
            double numero = scanner.nextDouble();
            scanner.nextLine();
            switch (escolha.toLowerCase()){
                case "celsius":
                    scanner.nextLine();
                    System.out.println("Unidades de medida: \n -Fahrenheit;\n -Kelvin. \n Escolha qual será a conversão: ");
                    conversao = scanner.nextLine();
                    break;


                case "fahrenheit":
                    scanner.nextLine();
                    System.out.println("Unidades de medida: \n -Celsius;\n -Kelvin. \n Escolha qual será a conversão: ");
                    conversao = scanner.nextLine();
                    break;


                case "kelvin":
                    scanner.nextLine();
                    System.out.println("Unidades de medida: \n -Celsius;\n -Fahrenheit. \n Escolha qual será a conversão: ");
                    conversao = scanner.nextLine();
                    break;


                default:
                    System.out.println("Escolha de medida inválida.");
                    break;
            }


            if (escolha.equalsIgnoreCase("celsius") && conversao.equalsIgnoreCase("fahrenheit")){
                resultado= numero*1.8+32;
                System.out.println(numero+"ºC em Fahrenheit é "+Math.round(resultado)+"F.");
            }


            if (escolha.equalsIgnoreCase("celsius") && conversao.equalsIgnoreCase("kelvin")){
                resultado= numero+273;
                System.out.println(numero+"ºC em Kelvin é "+Math.round(resultado)+"K.");
            }


            if (escolha.equalsIgnoreCase("fahrenheit") && conversao.equalsIgnoreCase("celsius")){
                resultado= (5.0/9.0)*(numero-32);
                System.out.println(numero+"F em Celsius é "+Math.round(resultado)+"ºC.");
            }


            if (escolha.equalsIgnoreCase("fahrenheit") && conversao.equalsIgnoreCase("kelvin")){
                resultado=(numero-32)*(5.0/9.0)+273.15;
                System.out.println(numero+"F em Kelvin é "+Math.round(resultado)+"K.");
            }


            if (escolha.equalsIgnoreCase("kelvin") && conversao.equalsIgnoreCase("fahrenheit")){
                resultado=(numero-273.15)*(9.0/5.0)+32;
                System.out.println(numero+"K em Fahrenheit é "+Math.round(resultado)+"F.");
            }


            if (escolha.equalsIgnoreCase("kelvin") && conversao.equalsIgnoreCase("celsius")){
                resultado=numero-273.15;
                System.out.println(numero+"K em Celsius é "+Math.round(resultado)+"ºC.");
            }
            System.out.println("Você deseja continuar (sim/não)? ");
            continuar = scanner.nextLine();


            historico novonum = new historico(escolha, conversao, numero, Math.round(resultado));
            historicos.add(novonum);


            if (continuar.equalsIgnoreCase("não")){
                continuar="não";
            }
        }
        System.out.println("\nOperações realizadas:");
        for (historico p : historicos) {
            p.exibirInfo();
        }
        System.out.println("Programa de conversão encerrado.");
    }
}


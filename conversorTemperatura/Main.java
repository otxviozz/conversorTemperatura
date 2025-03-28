package conversorTemperatura;

import java.util.Scanner;
import java.util.ArrayList;

class Historico {  //uso isso para armazenar as operações e resultados numa array pra mostrar no final
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

public class Main {
	
	static String escolherconversao(String escolha, Scanner scanner) {
		String conversao = null;
		switch (escolha.toLowerCase()){
	    case "celsius":
	        System.out.println("Unidades de medida: \n -Fahrenheit;\n -Kelvin. \n Escolha qual será a conversão: ");
	        conversao = scanner.nextLine();
	        break;


	    case "fahrenheit":
	        System.out.println("Unidades de medida: \n -Celsius;\n -Kelvin. \n Escolha qual será a conversão: ");
	        conversao = scanner.nextLine();
	        break;


	    case "kelvin":
	        System.out.println("Unidades de medida: \n -Celsius;\n -Fahrenheit. \n Escolha qual será a conversão: ");
	        conversao = scanner.nextLine();
	        break;

	}
		return conversao;
}
	
	static double calcularResultado(String escolha, String conversao, double numero) {
		double resultado = 0;
		if (!escolha.equals("celsius") && !escolha.equals("fahrenheit") && !escolha.equals("kelvin")) {
	        System.out.println("Escolha de medida inválida! Use Celsius, Fahrenheit ou Kelvin.");
	        return Double.NaN;
	    }

	    if (!conversao.equals("celsius") && !conversao.equals("fahrenheit") && !conversao.equals("kelvin")) {
	        System.out.println("Conversão inválida! Use Celsius, Fahrenheit ou Kelvin.");
	        return Double.NaN;
	    }

	    // Verifica se a escolha e a conversao são diferentes
	    if (escolha.equals(conversao)) {
	        System.out.println("Conversão inválida! Escolha uma unidade diferente.");
	        return Double.NaN;  // Retorna NaN para indicar erro
	    }
		
		else if (escolha.equalsIgnoreCase("celsius") && conversao.equalsIgnoreCase("fahrenheit")){
            resultado= numero*1.8+32;
        }


		else if (escolha.equalsIgnoreCase("celsius") && conversao.equalsIgnoreCase("kelvin")){
            resultado= numero+273;
        }


		else if (escolha.equalsIgnoreCase("fahrenheit") && conversao.equalsIgnoreCase("celsius")){
            resultado= (5.0/9.0)*(numero-32);
        }


		else if (escolha.equalsIgnoreCase("fahrenheit") && conversao.equalsIgnoreCase("kelvin")){
            resultado=(numero-32)*(5.0/9.0)+273.15;
        }


		else if (escolha.equalsIgnoreCase("kelvin") && conversao.equalsIgnoreCase("fahrenheit")){
            resultado=(numero-273.15)*(9.0/5.0)+32;
        }


		else if (escolha.equalsIgnoreCase("kelvin") && conversao.equalsIgnoreCase("celsius")){
            resultado=numero-273.15;
		}
        return resultado;
	}
	
	static void executarConversoes(Scanner scanner, ArrayList<Historico> historicos) {
        String continuar = "sim";
        boolean invalido = true;

        while (continuar.equalsIgnoreCase("sim")) {
            System.out.println("Unidades de medida: \n Celsius;\n Fahrenheit;\n Kelvin. \n Escolha uma medida: ");
            String escolha = scanner.nextLine();
            System.out.println("Digite o valor da temperatura: ");
            double numero = scanner.nextDouble();
            scanner.nextLine(); // Consumir a quebra de linha

            String conversao = escolherconversao(escolha, scanner);
            double resultado = calcularResultado(escolha, conversao, numero);
            if (Double.isNaN(resultado)) {  // Se for NaN, exibe erro
                System.out.println(numero + " " + escolha + " em " + conversao + " é uma operação inválida! Portanto, não será guardada no histórico.");
            } else {  // Se for um número válido, exibe a conversão e adiciona ao histórico
                System.out.println(numero + " " + escolha + " em " + conversao + " é " + String.format("%.2f", resultado) + " " + conversao);
                historicos.add(new Historico(escolha, conversao, numero, Math.round(resultado)));
                invalido = false;
            }

            System.out.println("Você deseja continuar (sim/não)? ");
            continuar = scanner.nextLine();
            
        }
        operacoesRealizadas(historicos, invalido);
    }
	
	static void operacoesRealizadas(ArrayList<Historico> historicos, boolean invalido) {
		if (!invalido) { // Se houver pelo menos uma operação válida
            System.out.println("\nOperações realizadas:");
            for (Historico p : historicos) {
                p.exibirInfo();
            }
        } else {
            System.out.println("\nNenhuma operação válida foi realizada.");
        }
    }
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Historico> historicos = new ArrayList<>();
        executarConversoes(scanner, historicos);
        System.out.println("Programa de conversão encerrado.");
        scanner.close();
    }
}
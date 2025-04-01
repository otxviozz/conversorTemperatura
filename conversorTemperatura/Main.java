package conversorTemperatura;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Historico> historicos = new ArrayList<>();
        Conversoes.executarConversoes(scanner, historicos);
        System.out.println("Programa de conversão encerrado.");
        scanner.close();
    }
}
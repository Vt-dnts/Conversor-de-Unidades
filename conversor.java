import java.util.ArrayList;
import java.util.Scanner;

public class Conversor {

    private static Scanner ler = new Scanner(System.in); //Cria Scanner para ler o valor digitado pelo usuário quando necessário
    private static ArrayList <String> historico = new ArrayList<>(); //Array List para armazenar os resultados de converção

    //Mostra o menu de opções

    private static void Menu(){
        System.out.println("===== CONVERSOR DE UNIDADES =====");
        System.out.println("1 - Celsius para Fahrenheit");
        System.out.println("2 - Fahrenheit para Celsius");
        System.out.println("3 - Metros para Quilômetros");
        System.out.println("4 - Quilômetros para Metros");
        System.out.println("5 - Ver histórico de conversões");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    } 

    //Executa a opção escolhida pelo usuário

    private static void executarOpcao(int opcao) {
        switch (opcao) {
            case 1: converterCelsiusParaFahrenheit(); break;
            case 2: converterFahrenheitParaCelsius(); break;
            case 3: converterMetrosParaKm(); break;
            case 4: converterKmParaMetros(); break;
            case 5: mostrarHistorico(); break;
            case 0: System.out.println("Saindo... Obrigado por usar o conversor!"); break;
            default: System.out.println("Opção inválida! Tente novamente.");
        }
        System.out.println();
    }

    //Converter Celsius para Fahrenheit

    private static void converterCelsiusParaFahrenheit() {
        System.out.print("Digite a temperatura em Celsius: ");
        double celsius = ler.nextDouble();
        double fahrenheit = (celsius * 9/5) + 32;
        String res = celsius + " °C = " + fahrenheit + " °F";
        System.out.println("Resultado: " + res);
        historico.add(res);
    }

    //Converter Fahrenheit para Celsius

    private static void converterFahrenheitParaCelsius() {
        System.out.print("Digite a temperatura em Fahrenheit: ");
        double fahrenheit = ler.nextDouble();
        double celsius = (fahrenheit - 32) * 5/9;
        String res = fahrenheit + " °F = " + celsius + " °C";
        System.out.println("Resultado: " + res);
        historico.add(res);
    }

    //Converter Metros para KM

    private static void converterMetrosParaKm() {
        System.out.print("Digite o valor em metros: ");
        double metros = ler.nextDouble();
        double km = metros / 1000;
        String res = metros + " m = " + km + " km";
        System.out.println("Resultado: " + res);
        historico.add(res);
    }

    //Converter KM para Metros

    private static void converterKmParaMetros() {
        System.out.print("Digite o valor em quilômetros: ");
        double km = ler.nextDouble();
        double metros = km * 1000;
        String res = km + " km = " + metros + " m";
        System.out.println("Resultado: " + res);
        historico.add(res);
    }

    //Mostrar histórico de conversões

    private static void mostrarHistorico() {
        System.out.println("===== HISTÓRICO DE CONVERSÕES =====");
        if (historico.isEmpty()) {
            System.out.println("Nenhuma conversão realizada ainda.");
        } else {
            for (int i = 0; i < historico.size(); i++) {
                System.out.println((i+1) + ". " + historico.get(i));
            }
        }
        System.out.println(); //Quebra de linha
    }

    //main

    public static void main(String[] args) {
       int opcao;
        do {
            Menu();
            opcao = ler.nextInt();
            executarOpcao(opcao);
        } while (opcao != 0);

        ler.close();
    }
}

package org.example;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        char operator;
        double result = 0;
        String risposta = null;

        // create an object of Scanner class
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Scegli un operatore: +, -, *, /");
            operator = input.next().charAt(0);

            if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
                System.out.println("Scelta sbagliata. Riprova.");
                continue;
            }

            System.out.println("Quanti numeri vuoi inserire?");
            int numCount = input.nextInt();
            if (numCount < 2) {
                System.out.println("Devi inserire almeno due numeri.");
                continue;
            }

            double[] numbers = new double[numCount];

            for (int i = 0; i < numCount; i++) {
                System.out.print("Inserisci il numero " + (i + 1) + ": ");
                numbers[i] = input.nextDouble();
            }

            switch (operator) {
                case '+':
                    for (double num : numbers) {
                        result += num;
                    }
                    break;

                case '-':
                    result = numbers[0];
                    for (int i = 1; i < numCount; i++) {
                        result -= numbers[i];
                    }
                    break;

                case '*':
                    result = 1;
                    for (double num : numbers) {
                        result *= num;
                    }
                    break;

                case '/':
                    result = numbers[0];
                    boolean divisionByZero = false;
                    for (int i = 1; i < numCount; i++) {
                        if (numbers[i] == 0) {
                            divisionByZero = true;
                            break;
                        }
                        result /= numbers[i];
                    }

                    if (divisionByZero) {
                        System.out.println("Impossibile dividere per zero.");
                        continue;
                    }
                    break;
                default:
                    System.out.println("Scelta sbagliata");
                    break;
            }

            System.out.println("Risultato: " + result);
            System.out.println("Vuoi effettuare un'altra operazione? (s/n): ");
            risposta = input.next();
        } while (risposta.equalsIgnoreCase("s"));

        input.close();
    }
}

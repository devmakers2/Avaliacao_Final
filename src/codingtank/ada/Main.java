package codingtank.ada;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int quantityOfNumbers = 0;

        while (true) {
            quantityOfNumbers = getQuantityOfNumbers();
            boolean isQuantityIsValid = checkIfQuantityIsValid(quantityOfNumbers);

            if (!isQuantityIsValid) {
                System.out.println("a quantidade deve ser maior que zero");  // err?
            } else {
                break;
            }
        }

        double[] numbers = getNumbersFromUser(quantityOfNumbers);

        System.out.println("Qual das médias deve ser calculada?");
        System.out.println("Digite ARITMETICA para média aritmética");
        System.out.println("digite HARMONICA para média harmônica");

        Scanner scanner = new Scanner(System.in);

        String optionOfAverage = scanner.nextLine();

        double resultingAverage = 0;

        if (optionOfAverage.equals("ARITMETICA")) {
            resultingAverage = calculateArithmeticMean(numbers);
        } else if (optionOfAverage.equals("HARMONICA")) {
            resultingAverage = calculateHarmonicMean(numbers);
        } else {
            System.out.println("por favor escolha uma opção válida: ARITMETICA ou HARMONICA");
            // repete
        }

        System.out.println("os números digitados foram: ");
        for (int i = 0; i < numbers.length - 1; i++) {
            System.out.print(numbers[i] + " - ");
        }
        System.out.println(numbers[numbers.length - 1]);

        System.out.print("a média escolhida foi a média ");

        switch (optionOfAverage) {
            case "ARITMETICA":
                System.out.println("aritmética");
                break;
            case "HARMONICA":
                System.out.println("harmônica");
                break;
            default:
                System.out.println("Hum... isso não deveria acontecer. Contate o administrador do sistema.");
                return;
        }

        System.out.print("e a média resultante foi: " + resultingAverage);
    }

    private static int getQuantityOfNumbers() {
        System.out.print("por favor digite a quantidade de números: ");

        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("dado de entrada inválido, por favor tente novamente");  // err?
            return getQuantityOfNumbers();
        }
    }

    private static boolean checkIfQuantityIsValid(int quantity) {
        return quantity > 0;
    }

    private static double[] getNumbersFromUser(int quantityOfNumbers) {
        double[] numbers = new double[quantityOfNumbers];

        System.out.println("por favor digite os números:");

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextDouble();
        }

        return numbers;
    }

//    private static GET OPTION oF AVERAGE FROM USER

//    private static boolean checkIfOptionOfAverageIsValid(String optionOfAverage) {
//        return optionOfAverage.equals("")
//    }


    private static double calculateArithmeticMean(double[] numbers) {
        double sum = 0;

        for (double number : numbers) {
            sum += number;
        }

        return sum/numbers.length;
    }

    private static double calculateHarmonicMean(double[] numbers) {
        double sumOfReciprocals = 0;  // ver para ZERO

        for (double number : numbers) {
            sumOfReciprocals += 1/number;
        }

        return numbers.length/sumOfReciprocals;
    }
}

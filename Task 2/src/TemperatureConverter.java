import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the temperature conversion utility!");
        System.out.print("Enter the temperature value: ");
        double temperatureValue = scanner.nextDouble();
        System.out.print("Enter the temperature unit (C/F/K): ");
        String temperatureUnit = scanner.next();
        System.out.print("Select the output unit (C/F/K): ");
        String outputUnit = scanner.next();
        double convertedTemperature = convertTemperature(temperatureValue, temperatureUnit, outputUnit);
        System.out.println("Converted temperature: " + convertedTemperature + " " + outputUnit);
    }

    public static double convertTemperature(double temperatureValue, String temperatureUnit, String outputUnit) {
        double convertedTemperature;
        switch (temperatureUnit.toUpperCase()) {
            case "C":
                switch (outputUnit.toUpperCase()) {
                    case "F":
                        convertedTemperature = temperatureValue * 9 / 5 + 32;
                        break;
                    case "K":
                        convertedTemperature = temperatureValue + 273.15;
                        break;
                    default:
                        System.out.println("Error: Invalid output unit.");
                        System.exit(1);
                        return 0;
                }
                break;
            case "F":
                switch (outputUnit.toUpperCase()) {
                    case "C":
                        convertedTemperature = (temperatureValue - 32) * 5 / 9;
                        break;
                    case "K":
                        convertedTemperature = (temperatureValue - 32) * 5 / 9 + 273.15;
                        break;
                    default:
                        System.out.println("Error: Invalid output unit.");
                        System.exit(1);
                        return 0;
                }
                break;
            case "K":
                switch (outputUnit.toUpperCase()) {
                    case "C":
                        convertedTemperature = temperatureValue - 273.15;
                        break;
                    case "F":
                        convertedTemperature = (temperatureValue - 273.15) * 9 / 5 + 32;
                        break;
                    default:
                        System.out.println("Error: Invalid output unit.");
                        System.exit(1);
                        return 0;
                }
                break;
            default:
                System.out.println("Error: Invalid input unit.");
                System.exit(1);
                return 0;
        }
        return convertedTemperature;
    }
}
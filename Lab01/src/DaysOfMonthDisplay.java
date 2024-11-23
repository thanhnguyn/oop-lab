import java.util.Scanner;

public class DaysOfMonthDisplay {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the month (name, abbreviation, or number): ");
            String monthInput = scanner.next().toLowerCase();

            System.out.print("Enter the year: ");
            int year = scanner.nextInt();
            if (year < 0) {
                System.out.println("Invalid year. Please enter a positive number.");
                continue;
            }

            int days = getDaysInMonth(monthInput, year);
            if (days == -1) {
                System.out.println("Invalid month entered. Please try again.");
            } else {
                System.out.println("Number of days in the month: " + days);
                break;
            }
        }
        scanner.close();
    }
    public static int getDaysInMonth(String month, int year) {
        int days = -1;

        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        switch (month) {
            case "january": case "jan": case "1":
                days = 31; break;
            case "february": case "feb": case "2":
                days = isLeapYear ? 29 : 28; break;
            case "march": case "mar": case "3":
                days = 31; break;
            case "april": case "apr": case "4":
                days = 30; break;
            case "may": case "5":
                days = 31; break;
            case "june": case "jun": case "6":
                days = 30; break;
            case "july": case "jul": case "7":
                days = 31; break;
            case "august": case "aug": case "8":
                days = 31; break;
            case "september": case "sep": case "9":
                days = 30; break;
            case "october": case "oct": case "10":
                days = 31; break;
            case "november": case "nov": case "11":
                days = 30; break;
            case "december": case "dec": case "12":
                days = 31; break;
            default:
                days = -1;
        }
        return days;
    }
}

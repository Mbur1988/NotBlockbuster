package UserInterface;

import static UserInterface.MemberMenu.memberLogin;
import static UserInterface.StaffMenu.staffLogin;
import static Main.Main.input;

public class MainMenu {

    public static void mainMenu() {
        System.out.println();
        System.out.println("Welcome to the Community Library");
        System.out.println("===========Main Menu============");
        System.out.println("1. Staff Login");
        System.out.println("2. Member Login");
        System.out.println("0. Exit");
        System.out.println("================================");
        while (true) {
            System.out.print("Please make a selection (1-2, or 0 to exit): ");

            String line = input.nextLine();
            if (line.equals("0")) {
                System.exit(1);
            }
            if (line.equals("1")) {
                staffLogin();
            }
            if (line.equals("2")) {
                memberLogin();
            } else {
                System.out.println("Must me a valid integer!");
            }
        }
    }
}

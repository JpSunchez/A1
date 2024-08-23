import java.util.Scanner;
import static java.lang.System.*;
public class Main {
    // LOGIN

    //Finish Project
    private static final int LoginAttempts = 3;
    private static final String L1 = "admin";
    private static final String L2 = "chowking";
    // HOME MENU
    private static final String[] HOME_MENU_ITEMS = {
            "1. Fried Chicken",
            "2. Lauriat",
            "3. Chao Fan",
            "4. Noodles",
            "5. Halo-Halo",
            "6. Drinks",
            "7. Checkout",
            "8. Exit"
    };
    // MENU ITEMS
    private static final String[] Fried_Chicken = {
            "1PC W/RICE ",
            "1PC W/PANCIT CANTON ",
            "1PC W/WONTON ",
            "1PC W/ CHAOFAN "
    };
    private static final String[] Lauriat = {
            "CHINESE STYLE FRIED",
            "SWEET AND SOUR PORK",
            "SWEET AND SOUR CHICKEN",
            "SWEET AND SOUR FISH"
    };
    private static final String[] Chao_Fan = {
            "SIOMAI CHAO FAN",
            "LUMPIANG SHANGHAI CHAO FAN",
            "SIOMAI BEEF CHAO FAN"
    };
    private static final String[] Noodles = {
            "PANCIT CANTON",
            "WANTON MAMI",
            "BEEF MAMI",
            "BEEF WANTON MAMI"
    };
    private static final String[] Halo_Halo = {
            "SMALL",
            "MEDIUM",
            "LARGE"
    };
    private static final String[] Drink = {
            "Coke",
            "Iced Tea",
            "Chowking Pearl Milk tea"

    };
    // PRICES
    private static final int[][] MENU_PRICES = {
            {199}, {180}, {125}, {145},
            {115}, {135}, {225}, {210},
            {120}, {155}, {180},
            {110}, {85}, {90}, {120},
            {35}, {40}, {62},
            {85}, {95}, {120}
    };
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
       int logAt = 0;
        boolean LogIn = false;
        while (logAt < LoginAttempts) {
            out.print("Enter username: ");
            String username = scanner.nextLine();
            out.print("Enter password: ");
            String pass = scanner.nextLine();
            if (username.equals(L1) && pass.equals(L2)) {
                LogIn = true;
                out.println("Login successful!");
                break;
            } else {
                logAt++;
                out.println("Invalid credentials. Please try again.");
            }
        }
        if (!LogIn) {
            out.println("Too many login attempts. Exiting the program.");
            return;
        }
        // ORDER
        int[] orderNum = new int[MENU_PRICES.length];

        while (true) {
            // Output Menu
            out.println("\n---- Online Menu ----");
            for (String homeItem : HOME_MENU_ITEMS) {
                out.println(homeItem);
            }
            // Menu Choices
            out.print("\nEnter your choice: ");
            int C = scanner.nextInt();
            int o = 1, r = 0,z = 4,x = 8,c = 11,v = 12, b = 15;

            if (C == 1) {
                out.println("\n---- Fried Chicken Menu ----");
                for (String chicken : Fried_Chicken) {
                    out.print(o++ + ". ");
                    out.println(chicken + " ₱ "+(MENU_PRICES[r++][0]));
                }
                out.print("Enter your choice: ");
                int chickChoice = scanner.nextInt();
                if (chickChoice >= 1 && chickChoice <= Fried_Chicken.length) {
                    out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    if (quantity > 0) {
                        int index = chickChoice - 1;
                        orderNum[index] += quantity;
                        out.println("Added " + quantity + "x of " + Fried_Chicken[index] + " to your order.");
                    } else {
                        out.println("Invalid quantity. Please enter a positive number.");
                    }
                } else {
                    out.println("Invalid choice. Please enter a number from 1 to " + Fried_Chicken.length + ".");
                }
            } else if (C == 2) {
                out.println("\n---- Lauriat Menu ----");
                for (String lauriat : Lauriat) {
                    out.print(o++ + ". ");
                    out.println(lauriat+ " ₱ "+(MENU_PRICES[z++][0]));
                }
                out.print("Enter your choice: ");
                int lChoice = scanner.nextInt();
                if (lChoice >= 1 && lChoice <= Lauriat.length) {
                    out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    if (quantity > 0) {
                        int index = lChoice - 1;
                        orderNum[ Fried_Chicken.length + index] += quantity;
                        out.println("Added " + quantity + "x of " + Lauriat[lChoice - 1] + " to your order.");
                    } else {
                        out.println("Invalid quantity. Please enter a positive number.");
                    }
                } else {
                    out.println("Invalid choice. Please enter a number from 1 to " + Lauriat.length + ".");
                }
            } else if (C == 3) {
                out.println("\n---- Chao Fan Menu ----");
                for (String chaoFan : Chao_Fan) {
                    out.print(o++ + ". ");
                    out.println(chaoFan+ " ₱ "+(MENU_PRICES[x++][0]));
                }
                out.print("Enter your choice: ");
                int cfChoice = scanner.nextInt();
                if (cfChoice >= 1 && cfChoice <= Chao_Fan.length) {
                    out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    if (quantity > 0) {
                        int index = cfChoice - 1;
                        orderNum[Fried_Chicken.length + Lauriat.length + index] += quantity;
                        out.println("Added " + quantity + "x of " + Chao_Fan[index] + " to your order.");
                    } else {
                        out.println("Invalid quantity. Please enter a positive number.");
                    }
                } else {
                    out.println("Invalid choice. Please enter a number from 1 to " + Chao_Fan.length + ".");
                }
            } else if (C == 4) {
                out.println("\n---- Noodles Menu ----");
                for (String noodles : Noodles) {
                    out.print(o++ + ". ");
                    out.println(noodles+ " ₱ "+(MENU_PRICES[c++][0]));
                }
                out.print("Enter your choice: ");
                int nChoice = scanner.nextInt();
                if (nChoice >= 1 && nChoice <= Noodles.length) {
                    out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    if (quantity > 0) {
                        int index = nChoice - 1;
                        orderNum[Fried_Chicken.length + Lauriat.length + Chao_Fan.length + index] += quantity;
                        out.println("Added " + quantity + "x of " + Noodles[nChoice - 1] + " to your order.");
                    } else {
                        out.println("Invalid quantity. Please enter a positive number.");
                    }
                } else {
                    out.println("Invalid choice. Please enter a number from 1 to " + Noodles.length + ".");
                }
            } else if (C == 5) {
                out.println("\n---- Halo-Halo Menu ----");
                for (String haloHalo : Halo_Halo) {
                    out.print(o++ + ". ");
                    out.println(haloHalo+ " ₱ "+(MENU_PRICES[v++][0]));
                }
                out.print("Enter your choice: ");
                int HHChoice = scanner.nextInt();
                if (HHChoice >= 1 && HHChoice <= Halo_Halo.length) {
                    out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    if (quantity > 0) {
                        int index = HHChoice - 1;
                        orderNum[Fried_Chicken.length + Lauriat.length + Chao_Fan.length + Noodles.length + index] += quantity;
                        out.println("Added " + quantity + "x of " + Halo_Halo[HHChoice - 1] + " to your order.");
                    } else {
                        out.println("Invalid quantity. Please enter a positive number.");
                    }
                } else {
                    out.println("Invalid choice. Please enter a number from 1 to " + Halo_Halo.length + ".");
                }
            } else if (C == 6) {
                out.println("\n---- Drinks ----");
                for (String Dks : Drink) {
                    out.print(o++ + ". ");
                    out.println(Dks+ " ₱ "+(MENU_PRICES[b++][0]));
                }
                out.print("Enter your choice: ");
                int Drnk = scanner.nextInt();
                if (Drnk >= 1 && Drnk <= Drink.length) {
                    out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    if (quantity > 0) {
                        int index = Drnk - 1;
                        orderNum[Fried_Chicken.length + Lauriat.length + Chao_Fan.length + Noodles.length + Halo_Halo.length +index] += quantity;
                        out.println("Added " + quantity + "x of " + Drink[Drnk - 1] + " to your order.");
                    } else {
                        out.println("Invalid quantity. Please enter a positive number.");
                    }
                } else {
                    out.println("Invalid choice. Please enter a number from 1 to " + Drink.length + ".");
                }
            } else if (C == 7) {
                // Total Order
                double total = 0.00;
                out.println("\n-------------- Order Summary --------------");
                for (int i = 0; i < orderNum.length; i++) {
                    if (orderNum[i] > 0) {
                        out.println(orderNum[i] + "x " + orderName(i) + "\n₱ "+MENU_PRICES[i][0]);
                        double itemTotal = orderNum[i] * MENU_PRICES[i][0];
                        out.println("= " + itemTotal);
                        total += itemTotal;
                    }
                }
                out.println("\n-------------------------------------------");
                out.println("\nTotal : ₱ " + total);
                out.println("___________________________________________");

                out.print("\nConfirm your order (Y/N): ");
                String confirm = scanner.next();

                if (confirm.equalsIgnoreCase("Y")) {
                    out.println("Order confirmed. Thank you for your purchase!");
                    break;
                } else {
                    out.println("Returning Home menu...");
                }
            } else if (C == 8) {
                out.println("Exiting the program.");
                break;
            } else {
                out.println("Invalid choice. Please enter a number from 1 to 8.");
            }
        }
    }

    private static String orderName(int index) {
        if (index < Fried_Chicken.length) {
            return "Fried Chicken: " + Fried_Chicken[index];
        } else if (index < Fried_Chicken.length + Lauriat.length) {
            return "Lauriat: " + Lauriat[index - Fried_Chicken.length];
        } else if (index < Fried_Chicken.length + Lauriat.length + Chao_Fan.length) {
            return "Chao Fan: " + Chao_Fan[index - Fried_Chicken.length - Lauriat.length];
        } else if (index < Fried_Chicken.length + Lauriat.length + Chao_Fan.length + Noodles.length) {
            return "Noodles: " + Noodles[index - Fried_Chicken.length - Lauriat.length - Chao_Fan.length];
        } else if (index < Fried_Chicken.length + Lauriat.length + Chao_Fan.length + Noodles.length + Halo_Halo.length) {
            return "Halo-Halo: " + Halo_Halo[index - Fried_Chicken.length - Lauriat.length - Chao_Fan.length - Noodles.length];
        } else if (index < Fried_Chicken.length + Lauriat.length + Chao_Fan.length + Noodles.length + Halo_Halo.length + Drink.length) {
            return "Drinks: " + Drink[index - Fried_Chicken.length - Lauriat.length - Chao_Fan.length - Noodles.length - Halo_Halo.length];
        }
        return "";
    }
}

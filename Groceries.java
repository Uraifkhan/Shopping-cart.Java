import java.util.ArrayList; // importing ArrayList package
import java.util.InputMismatchException; 
import java.util.Scanner;

public class Groceries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        
        ArrayList<String> Groceries = new ArrayList<>();
        ArrayList<Integer> prices = new ArrayList<>();
         // display prompt from the use-side
        while(true){
        System.out.println("----------------------------");
        System.out.println("        SHOPPING CART       ");
        System.out.println("----------------------------");

        System.out.print("\nHow many items do you want to add in Cart: ");
        int numItems = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < numItems; i++) {
            try {
                System.out.print("Add item " + (i + 1) + ": ");
                String item = scanner.nextLine();
                System.out.print("Add price: ");
                int price = scanner.nextInt();
                scanner.nextLine(); 
               // adding both Item and Price to a different ArrayList using common for-loop 
                Groceries.add(item);
                prices.add(price);

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number for price.");
                scanner.nextLine(); 
                // decrementing the loop in case of inputMismatchException
                i--;
            }
        }
        
        while(run) {
        System.out.println("\nList saved successfully:");
        System.out.println("Choose an option\n1.View\n2.Remove\n3.Update\n4.Exit");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        switch (choice) {
            case 1: 
            for (int i = 0; i < Groceries.size(); i++) {
            System.out.println((i + 1) + ". " + Groceries.get(i) + " (Price: " + prices.get(i) + ")");
        }   break;

            case 2:
                System.out.print("\nRemove item by Name: ");
                String removeItem = scanner.nextLine();
                /*  here comes, the true logic when we remove an item 
                    from the ArrayList, first it checked whether the item,
                  is existed or not.If it is then, it removes the item from both ArrayLists.
                 it with diffrent one in a same index order,  
                */
                int index = Groceries.indexOf(removeItem);
                if (index != -1) {
                    /*it verifies if the index number is not equal to -1 or negative one*/
                    String removedName = Groceries.remove(index);
                    int removedPrice = prices.remove(index);
                    System.out.println(removedName +  " removed successfully!");
                } else {
                    System.out.println("Item not found in cart!");
                }

                System.out.println("\nUpdated Grocery List:");
                System.out.println("Sno   Name         Price");
                System.out.println("----------------------------");
                for (int i = 0; i < Groceries.size(); i++) {
                    System.out.printf("%-5d %-12s %d%n", (i + 1), Groceries.get(i), prices.get(i));
                }
                break;
            
            case 3:
                System.out.print("Update by name: ");
                    String updateItem = scanner.nextLine();
                    int indexUpdate = Groceries.indexOf(updateItem); // Searched for the item entered by user in the list.
                    if (indexUpdate != -1) {
                    // if item found and it's not negative index modfies it
                    System.out.print("Add new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Add new price: ");
                    int newPrice = scanner.nextInt();
                    scanner.nextLine();
                    Groceries.set(indexUpdate, newName);
                    prices.set(indexUpdate, newPrice);
                    System.out.println("Item updated successfully!");
                
                        System.out.println("Sno   Name         Price");
                        System.out.println("----------------------------");
                        for(int i = 0; i < Groceries.size(); i++) {
                            System.out.printf("%-5d %-12s %d%n", (i + 1), Groceries.get(i), prices.get(i));
                        }
                    } else {
                        System.out.println("Item not found!");
                    }
                    break;
            case 4:
                System.out.println("Exiting...");
                run = false;
                break;
            default:
                System.out.println("Invalid choice");
                
        }
    }
}
}
}
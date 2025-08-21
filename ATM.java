import java.util.*;

class Account{
    private double balance;
    private ArrayList<String> transactionHistory;
    
    public Account(double initialBalance){
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }
    
    public double getBalance(){
        return balance;
    }
    
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Enter a valid amount.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient Balance.");
            return;
        }

        balance -= amount;
        transactionHistory.add("Withdrew: ₹" + amount);
        System.out.println("Withdrawal of ₹" + amount + " successful.");
    }

    
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Enter a valid amount.");
            return;
        }

        balance += amount;
        transactionHistory.add("Deposited: ₹" + amount);
        System.out.println("Deposit of ₹" + amount + " successful.");
    }

    
    public void printTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (int i = 0; i < transactionHistory.size(); i++) {
                System.out.printf("%2d. %s\n", i + 1, transactionHistory.get(i));
            }
        }
    }

}


class User{
    private int pin;
    private String name;
    private Account account;
    
    public User(int pin, String name, double initialBalance){
        this.pin = pin;
        this.name = name;
        this.account = new Account(initialBalance);
    }
    
    public int getPin(){
        return pin;
    }
    
    public String getName(){
        return name;
    }
    
    public Account getAccount(){
        return account;
    }
}


class Card{
    private String cardNumber;
    private User linkedUser;
    
    public Card(String cardNumber, User linkedUser){
        this.cardNumber = cardNumber;
        this.linkedUser = linkedUser;
    }
    
    public String getCardNumber(){
        return cardNumber;
    }
    
    public User getUser(){
        return linkedUser;
    }
}

class ATMmachine{
    private Map<String, Card> cardDatabase;
    
    public ATMmachine(){
        cardDatabase = new HashMap<>();
    }
    
    public void registerCard(Card card){
        cardDatabase.put(card.getCardNumber(), card);
    }
    
    public Card insertCard(String cardNumber){
        return cardDatabase.get(cardNumber);
    }
    
    public boolean validatePin(User user, int enteredPin){
        return user.getPin() == enteredPin;
    }
    
    public void showMenu(User user) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.println("-----------------------------------");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.printf("Current Balance: $ %.2f\n", user.getAccount().getBalance());
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ₹");
                    double deposit = sc.nextDouble();
                    user.getAccount().deposit(deposit);
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdraw = sc.nextDouble();
                    user.getAccount().withdraw(withdraw);
                    break;

                case 4:
                    System.out.println("\n========== Transaction History ==========");
                    user.getAccount().printTransactionHistory();
                    System.out.println("=========================================");
                    break;

                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid Option. Please try again.");
            }

        } while (choice != 5);
    }
    
}

public class ATM{
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            ATMmachine atm = new ATMmachine();
            
            User aishu = new User(1981, "Aishwarya Shree", 6000);
            User swe = new User(2000, "Swetha", 10000);
            
            atm.registerCard(new Card("11223344", aishu));
            atm.registerCard(new Card("55667788", swe));
            
            System.out.println("\n============================");
            System.out.println("        ATM MACHINE");
            System.out.println("============================");
            System.out.print("Insert your card (Enter your card number): ");

            String enteredCardNumber = sc.next();
            
            Card card = atm.insertCard(enteredCardNumber);
            
            if(card == null){
                System.out.println("Card not recognised. Please try again.");
                return;
            }
            
            User user = card.getUser();
            System.out.println("Hello, "+ user.getName() + "!");
            System.out.print("Enter your Pin: ");
            int enteredPin = sc.nextInt();
            
            if(!atm.validatePin(user, enteredPin)){
                System.out.println("Incorrect Pin. Access denied");
                return;
            }

            System.out.println("\n===================================");
            System.out.println("        Welcome, " + user.getName());
            System.out.println("===================================");
            
            atm.showMenu(user);
            
        }
    }












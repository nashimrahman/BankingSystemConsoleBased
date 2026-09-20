package App;

import BankService.BankService;
import BankService.bankServiceImpl;

import java.util.Scanner;

public class main {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // to get the input
        BankService bankService = new bankServiceImpl();

        System.out.println("WELCOME TO OUR BANK");
        boolean running = true; //to get the input repeatedly

        while (running){
            System.out.println("""
                
                      1) Open Account
                      2) Deposit
                      3) Withdraw
                      4) Transfer
                      5) Account Statement
                      6) List Accounts
                      7) Search Account by Customer Name
                      0) Exit
                
                """);
            System.out.print("CHOOSE YOUR OPTION: ");
            String choice = scanner.nextLine().trim();
            System.out.printf("CHOICE: %s\n", choice);

            switch (choice) {
                case "1"-> openAccount(scanner, bankService);
                case "2"-> deposit(scanner, bankService);
                case "3"-> withdraw(scanner, bankService);
                case "4"-> transfer(scanner, bankService);
                case "5"-> accountStatement(scanner, bankService);
                case "6"-> listAccount(scanner, bankService);
                case "7"-> searchAccounts(scanner);
                case "0"-> running = false;
                default -> throw new IllegalStateException("Unexpected value: " + choice);

            }
        }
    }

    private static void openAccount(Scanner scanner, BankService bankService) {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("email: ");
        String email = scanner.nextLine();
        System.out.println("Account type (SAVINGS/ CURRENT): ");
        String type = scanner.nextLine();
        System.out.println("Initial Deposit(Blank for 0): ");
        String amountInitial = scanner.nextLine();
        Double initial = Double.valueOf(amountInitial);
        String accountNumber = bankService.openAccount(name, email, type);
        if (initial >0){
            bankService.deposit(accountNumber, initial,"Initial Deposit");
            System.out.println("Account Opened: "+ accountNumber);
        }
    }

    private static void deposit(Scanner scanner, BankService bankService) {
        System.out.print("Account Number: ");
        String accountNumber = scanner.nextLine().trim();
        System.out.print("Amount: ");
        Double amount = Double.valueOf(scanner.nextLine().trim());
        bankService.deposit(accountNumber, amount,"Deposit ");
        System.out.println("Deposited");



    }


    private static void withdraw(Scanner scanner,BankService bankService) {
    }

    private static void transfer(Scanner scanner,BankService bankService) {
    }

    private static void accountStatement(Scanner scanner,BankService bankService) {
    }

    private static void listAccount(Scanner scanner, BankService bankService) {
        bankService.listAccounts().forEach(a -> {
            System.out.println(a.getAccountNumber() + " | " + a.getAccountType() + " | " + a.getBalance());
        });
    }

    private static void searchAccounts(Scanner scanner) {
    }
}

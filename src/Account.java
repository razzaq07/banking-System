import java.util.ArrayList;
import java.util.Scanner;

public class Account extends Bank{
    private long  accountNumber;
    private String accountHolder;
    private  double balance;
    private String accountType;
    private int transactionIdTrack = 1;

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }
    public void deposit(double amount){
        if (amount > 0){
            System.out.println("Deposit successfull!");
           balance += amount;
            System.out.println("balance is : "+balance);
            System.out.println();
            Transaction t1 = new Transaction(transactionIdTrack,"DepoSit",amount,"cash Deposit");
            transactionHistory.add(t1);
            transactionIdTrack++;
        }else {
            System.out.println("invalid operation!!");
        }
    }
    public void withdraw(double amount){
        if (balance >= amount && amount > 0){
            System.out.println("Withdraw sucessfull!");
            balance -= amount;
            System.out.println("balance is : "+balance);
            System.out.println();
            Transaction t1 = new Transaction(transactionIdTrack,"Withdrawal",amount,"Cash Withdrawal");
            transactionHistory.add(t1);
            transactionIdTrack++;

        }else {
            if (balance < amount) {
                System.out.println("not enough mooney! : " + balance);
            }
            else {
                System.out.println("Please Enter > 0");
            }
        }
    }

    public Account(long accountNumber, String accountHolder, String accountType, double balance){


        this.accountNumber= accountNumber;
        this.accountHolder = accountHolder ;
        this.accountType = accountType;
        this.balance = balance ;
    }

 private ArrayList<Transaction> transactionHistory = new ArrayList<Transaction>();


   public void viewTransactionHistory(){
        if (!transactionHistory.isEmpty()){
            for (Transaction transaction : transactionHistory) {
                System.out.println("ACCOUNT NUMBER : "+getAccountNumber());
                System.out.println("Transaction id : " + transaction.getId());
                System.out.println("Transaction Type is : " + transaction.getType());
                System.out.println("Transaction Amount : "+transaction.getAmount());
                System.out.println("Description : " + transaction.getDescription());
                System.out.println("Updated Balance is : "+balance);
                System.out.println();

            }
        }
        else {
            System.out.println("Something Went Wrong...");
        }
   }
    public  void transfer(long receiverAccount, long senderAccount, double amount){
        Account sender = findAccount(senderAccount);
        Account receiver = findAccount(receiverAccount);

        if (sender != null && receiver != null) {
            if (sender.getBalance() >= amount) {
                sender.withdraw(amount);
                receiver.deposit(amount);
                System.out.println("Transfer successfull : " + amount);

            } else {
                System.out.println("sender have don't enough money : " + sender.getBalance());
            }
        }

    }

    public static void main(String[] args) {
        Account a1 = new Account(
                59173145567L,
                "Abdur  Rajjak",
                "Saving",
                500

        );

        System.out.println("Account Holder : "+a1.getAccountHolder());
        System.out.println("Account Number : "+a1.getAccountNumber());
        System.out.println("Account Type : "+a1.getAccountType());
        System.out.println("Balance : "+a1.getBalance());
       a1.deposit(1500);
       a1.withdraw(900);
       a1.deposit(9008);
       a1.withdraw(890);
        System.out.println("Press 1 For Account Statement : ");
        Scanner sc =  new Scanner(System.in);
        int getStatement = sc.nextInt();
        if (getStatement == 1){
            a1.viewTransactionHistory();
        }
        else {
            System.out.println("invalid input");
        }

    }


}


 class CurrentAccount {

}

 class SavingAccount {
}
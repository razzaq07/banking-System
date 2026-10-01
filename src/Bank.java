import java.util.ArrayList;
import java.util.Objects;

public class Bank {
    public static long genAccNo() {
        long genAccNo = 0;
        do {
           genAccNo = 0;
            int i = 0;
            while (i < 11) {
                int randomNo = (int) (Math.random() * 10);
                if (i == 0) {
                    randomNo = (int) (Math.random() * 9) + 1;
                }
                genAccNo = genAccNo * 10 + randomNo;
                i++;
            }
        }while (isAccountNumberExist(genAccNo));
        return genAccNo;
    }
    private static  ArrayList<Account> customers = new ArrayList<Account>();

 public static void printAccountDeatails(){
     for (Account account : customers){

         System.out.println(account.getAccountNumber());
         System.out.println(account.getAccountHolder());
         System.out.println(account.getAccountType());
         System.out.println(account.getBalance());
         System.out.println();
     }
 }
 public static boolean isAccountNumberExist(long AccounNumber){

     for (Account account : customers){
         if (account.getAccountNumber() == AccounNumber) {
             System.out.println("Account already exist try generate new one!");
            return true;

         }

     }
     return false;
 }

 public static Account createAccount(String accHolder, String accType, double balance){

 if (balance > 0 && (Objects.equals(accType, "Savings") || Objects.equals(accType,"Current")) && !(accHolder.isEmpty() || accHolder.isBlank())){
         long genAccountNo = genAccNo();
         Account acc = new Account(genAccountNo, accHolder, accType, balance);
         customers.add(acc);
   /*  System.out.println("Account created Successfully");
     System.out.println(acc.getAccountHolder());
     System.out.println(acc.getAccountType());
     System.out.println(acc.getAccountNumber());
     System.out.println(acc.getBalance()); */
     return acc;
 }
 else {
     System.out.println("please Enter  a valid Input");
 }
 return null;
 }
 public static Account findAccount(long accountNumber){
     for (Account account : customers){
         if ( account.getAccountNumber() == accountNumber){
             System.out.println("ACCOUNT NUMBER : "+account.getAccountNumber());
             return account;
         }

     }
     System.out.println("no result found!");
return null;
 }
 public static  void testAccount() {
     Account acc1 = new Account(59173136684L, "Abdur Rajjak", "Savings", 59999);
     customers.add(acc1);
     Account foundAccount = findAccount(acc1.getAccountNumber());
     System.out.println(foundAccount.getAccountHolder());
     System.out.println(foundAccount.getAccountNumber());
 }

 public static void depositAccount(long accountNumber, double amount){
   Account account =  findAccount(accountNumber);
   if (account != null){
       account.deposit(amount);

   }
   else {
       System.out.println("please enter valid input");
   }
 }
 public static void withdrawAccount(long accountNumber, double amount){
     Account account = findAccount(accountNumber);
     if (account != null){
         account.withdraw(amount);
     }
     else {
         System.out.println("please enter valid input");
     }

 }
    public static void main(String[] args) {
       Account accoun1 = createAccount("Abc","Savings",19);
        Account accoun2 = createAccount("xyz","Savings",1900);
      long accountNumber1 =  accoun1.getAccountNumber();
      long accountNumber2 = accoun2.getAccountNumber();
      depositAccount(accountNumber1,900);
       withdrawAccount(accountNumber1,200);
       accoun1.viewTransactionHistory();
        accoun1.transfer(accountNumber1,accountNumber2,500);


    }
  }

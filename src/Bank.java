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

 public static void createAccount(String accHolder, String accType, double balance){

 if (balance > 0 && (Objects.equals(accType, "Savings") || Objects.equals(accType,"Current")) && !(accHolder.isEmpty() || accHolder.isBlank())){
         long genAccountNo = genAccNo();
         Account acc = new Account(genAccountNo, accHolder, accType, balance);
         customers.add(acc);
     System.out.println("Account created Successfully");
     System.out.println(acc.getAccountHolder());
     System.out.println(acc.getAccountType());
     System.out.println(acc.getAccountNumber());
     System.out.println(acc.getBalance());
 }
 else {
     System.out.println("please Enter  a valid Input");
 }
 }
    public static void main(String[] args) {
     createAccount("Abc","Savings",19);

    }
  }

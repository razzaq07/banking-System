import java.util.ArrayList;

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
         System.out.println();
         System.out.println(account.getAccountNumber());
         System.out.println(account.getAccountHolder());
         System.out.println(account.getAccountType());
         System.out.println(account.getBalance());
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
 long genAccountNo = genAccNo();
 Account acc3 = new Account(genAccountNo,accHolder,accType,balance);
 customers.add(acc3);

 }
    public static void main(String[] args) {
    Account acc1 = new Account(59297344748L,"Abdur Rajjak","savings",79999);
    Account acc2 = new Account(591712749383L,"touhid kayal","current", 9999);
    customers.add(acc1);
    customers.add(acc2);
     createAccount("Abdur Rajjak","Savings",12999);
        printAccountDeatails();
    }
  }

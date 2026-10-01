public class Transaction{
   private int id;
    private String type;
    private double amount;
    private String description;

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public  Transaction(int id, String type, double amount, String description){
       this.id = id;
       this.type =  type;
       this.amount = amount;
       this.description = description;
   }
   public static void main(String[] args){
        Transaction t1 = new Transaction(
                1,
                "Deposit",
                500,
                "cash withdrawl"
                );

       System.out.println("Transaction id : "+t1.id);
       System.out.println("Transaction Type : "+t1.type);
       System.out.println("Transaction Amount : "+t1.amount);
       System.out.println("Description : "+t1.description);

   }



}

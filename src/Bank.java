import java.util.ArrayList;

public class Bank {
    public long genAccNo () {
        long genpass = 0;
        int i = 0;
        while (i < 11) {
            int randomNo = (int) (Math.random() * 10);
            if (i == 0) {
                randomNo = (int) (Math.random() * 9) + 1;
            }
            genpass = genpass * 10 + randomNo;
            i++;
        }

        System.out.println(genpass);
        return genpass;
    }
    private ArrayList<Account> customers = new ArrayList<Account>();
    public boolean isAccountNoExist () {
        if (genAccNo() == Account.get) {

        }
    }
    public static void main(String[] arge) {



    }
}

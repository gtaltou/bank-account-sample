import com.taltou.account.Account;
import com.taltou.amount.Amount;
import com.taltou.statement.Statement;


import static com.taltou.helpers.Helper.date;

public class RunBankAccountSample {

    public static void main(String[] args){
        Account account = new Account(new Statement());

        account.computeDeposit(Amount.newAmount(3000), date("01/03/2021"));
        account.computeDeposit(Amount.newAmount(4000), date("15/03/2021"));
        account.computeDeposit(Amount.newAmount(5000), date("20/03/2021"));
        account.computeDeposit(Amount.newAmount(1000), date("23/03/2021"));
        account.computeWithdrawal(Amount.newAmount(1000), date("25/03/2021"));
        account.computeWithdrawal(Amount.newAmount(2000), date("30/03/2021"));

        account.printStatement(System.out);
    }

}

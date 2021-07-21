
import java.text.DecimalFormat;
import java.util.*;

public class OptionMenu extends Account {
  Scanner menuInput = new Scanner(System.in);
  DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

  HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

  public void getSaving() {
    System.out.println("Saving Account: ");
    System.out.println(" Type 1 - View Balance");
    System.out.println(" Type 2 - Withdraw Funds");
    System.out.println(" Type 3 - Deposit Funds");
    System.out.println(" Type 4 - Exit");
    System.out.print("Choice: ");

    int selection = menuInput.nextInt();

    switch (selection) {
      case 1:
        System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
        getSaving();
        break;

      case 2:
        getsavingWithdrawInput();
        getSaving();
        break;

      case 3:
        getSavingDepositInput();
        getSaving();
        break;

      case 4:
        System.out.println("Thank You for using this ATM, bye.");
        break;

      default:
        System.out.println("\n" + "Invalid Choice." + "\n");
        getSaving();
    }
  }

}

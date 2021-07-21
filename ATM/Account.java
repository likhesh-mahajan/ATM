
import java.text.DecimalFormat;
import java.util.*;

public class Account {
  private double savingBalance = 0;
  protected static final int[] currDenom = { 20, 10, 5, 1 };
  protected static int[] currNo = { 1, 4, 2, 10 };
  protected int[] count = { 0, 0, 0, 0 };
  protected static int totalCorpus = 0;

  Scanner input = new Scanner(System.in);
  DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

  public static void calcTotalCorpus() {
    for (int i = 0; i < currDenom.length; i++) {
      totalCorpus = totalCorpus + currDenom[i] * currNo[i];
    }
  }

  public double getSavingBalance() {
    return savingBalance;
  }

  public double calcSavingWithdraw(double amount) {
    savingBalance = (savingBalance - amount);
    return savingBalance;
  }

  public double calcSavingDeposit(double amount) {
    savingBalance = (savingBalance + amount);
    return savingBalance;
  }

  public void getsavingWithdrawInput() {
    System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
    System.out.print("Amount you want to withdraw from saving Account: ");
    double amount = input.nextDouble();

    calcTotalCorpus();
    withdrawCash(amount);

    if ((savingBalance - amount) >= 0) {
      calcSavingWithdraw(amount);
      System.out.println("New saving Account Balance: " + moneyFormat.format(savingBalance));
    } else {
      System.out.println("Balance Cannot be Negative." + "\n");
    }
  }

  public void getSavingDepositInput() {
    System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
    System.out.print("Amount you want to Deposit from saving Account: ");
    double amount = input.nextDouble();

    if ((savingBalance + amount) >= 0) {
      calcSavingDeposit(amount);
      System.out.println("New saving Account Balance: " + moneyFormat.format(savingBalance));
    } else {
      System.out.println("Balance Cannot be Negative." + "\n");
    }
  }

  public double withdrawCash(double amount) {
    if (amount <= totalCorpus) {
      for (int i = 0; i < currDenom.length; i++) {
        if (currDenom[i] <= amount) {
          int noteCount = (int) (amount / currDenom[i]);

          if (currNo[i] > 0) {
            count[i] = noteCount >= currNo[i] ? currNo[i] : noteCount;
            currNo[i] = noteCount >= currNo[i] ? 0 : currNo[i] - noteCount;

            totalCorpus = totalCorpus - (count[i] * currDenom[i]);
            amount = amount - (count[i] * currDenom[i]);
          }
        }
      }
      displayNotes();
      displayLeftNotes();

    } else {
      System.out.println("Unable to dispense cash for this denomination");
    }
    return amount;
  }

  private void displayNotes() {
    for (int i = 0; i < count.length; i++) {
      if (count[i] != 0) {
        System.out.println(currDenom[i] + " * " + count[i] + " = " + (currDenom[i] * count[i]));
      }
    }
  }

  private void displayLeftNotes() {
    for (int i = 0; i < currDenom.length; i++) {
      System.out.println("Notes of " + currDenom[i] + " left are " + currNo[i]);
    }

  }

}

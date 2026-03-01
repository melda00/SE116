public class DigitalBank {
    public static void main (String[] args){
        BankBONUS.setTransferFeeRate(0.02);
        BankAccountBONUS account1= new BankAccountBONUS("melda",12345678921L);
        BankAccountBONUS account2= new BankAccountBONUS("umut",12345678922L);
        BankAccountBONUS account3= new BankAccountBONUS("doruk",12345678923L);
        account1.deposit(1000);
        account2.deposit(1000);
        account3.deposit(1000);
        account1.withdraw(500);
        account1.transferTo(account2,500);
        account1.withdraw(500);
        account1.displayAccountInfo();
        account1.displayHistory();
        account2.displayAccountInfo();
        account2.displayHistory();
        account3.displayAccountInfo();
        account3.displayHistory();


    }
}
class BankAccountBONUS {
    private String ownerName;
    private long iban;
    private int balance;
    private String[] transactionHistory;
    private int transactionCount;

    public BankAccountBONUS(String ownerName, long iban) {
        this.ownerName = ownerName;
        this.iban = iban;
        this.balance = 0;
        transactionHistory = new String[10];
        transactionCount = 0;

    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setIban(long iban) {
        this.iban = iban;
    }

    public long getIban() {
        return iban;
    }

    public int getTransactionCount() {
        return transactionCount;
    }
    public void setTransactionCount(int transactionCount) {
        this.transactionCount = transactionCount;
    }

    public void setTransactionHistory(String[] transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public String[] getTransactionHistory() {
        return transactionHistory;
    }

    private void addTransactionHistory(String record) {
        if (transactionCount<10) {
            transactionHistory[transactionCount] = record;
            transactionCount++;
        } else {
            for (int i = 0; i < transactionHistory.length-1; i++) {
                transactionHistory[i] = transactionHistory[i + 1];
            }
            transactionHistory[9] = record;
        }
    }

    public void deposit(int amount) {
        balance += amount;
        addTransactionHistory("DEPOSIT " + amount);
        System.out.println("DEPOSIT: " + amount);
    }

    public void withdraw(int amount) {
        if (balance >= amount) {
            balance = balance - amount;
            addTransactionHistory("WITHDRAW: " + amount);
            System.out.println("SUCCED_WITHDRAW: " + amount);
        } else {
            addTransactionHistory("FAILED_WITHDRAW:"+ amount);
            System.out.println("FAILEDWITHDRAW: " + amount);
            ;
        }
    }

    public void transferTo(BankAccountBONUS receiver,int amount) {
        double fee= BankBONUS.calculateTransferFee(amount);
        double totalCost=amount+fee;
        if (balance >= totalCost) {
            balance -= totalCost;
            receiver.setBalance(receiver.getBalance() + amount);
            receiver.addTransactionHistory("RECEIVED_FROM: " + ownerName + " " + amount);
            addTransactionHistory("TRANSFER_TO: " + receiver.getOwnerName() + " " + amount);
            System.out.println("SUCCEED_TRANSFER: " + amount);
        }else {
            addTransactionHistory("FAILED_TRANSFER: " + amount);
            System.out.println("FAILED_TRANSFER: " + amount);
        }

    }

    public void displayAccountInfo() {
        System.out.println("Owner: " + ownerName);
        System.out.println("Iban: " + iban);
        System.out.println("Balance: " + balance);
    }
    public void displayHistory() {
        for (int i = 0; i < transactionCount; i++) {
            System.out.println(transactionHistory[i]);
        }
    }
}
class BankBONUS{
    private static double transferFeeRate;

    public static double getTransferFeeRate() {
        return transferFeeRate;
    }
    public static void setTransferFeeRate(double rate) {
       transferFeeRate = rate;
    }

    public static double calculateTransferFee(double amount) {
        return transferFeeRate * amount;
    }

}




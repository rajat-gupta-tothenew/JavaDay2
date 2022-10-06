import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


enum AccountType {
    SAVINGS, CURRENT
}
class InsufficientAmountExceptiion extends Exception {
    public InsufficientAmountExceptiion (String str) {
        super(str);
    }
}

class Bank {
    String city;
    float rateOfInterest;

    Bank (String city, float rateOfInterest) {
        this.city = city;
        this.rateOfInterest = rateOfInterest;
    }

    public void getDetails() {
        System.out.println("City: "+city);
        System.out.println("Rate of interest: "+rateOfInterest);
    }

    public void printDetalis() {
        System.out.println("City: "+city);
        System.out.println("Rate of interest: "+rateOfInterest);
    }
}

class SBI extends Bank {
    String branchId;
    AccountType accountType;
    long balance;
    long accountNumber;

    SBI(String city, float rateOfInterest, String branchId, AccountType accountType, long balance, long accountNumber) {
        super(city, rateOfInterest);
        this.branchId = branchId;
        this.accountType = accountType;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    @Override
    public void getDetails() {
        super.getDetails();
    }

    @Override
    public void printDetalis() {
        System.out.println("\nBranch ID: " + branchId);
        super.printDetalis();
    }

    public void deposit(long amount) {
        if (amount < 0) {
            return;
        }
        balance += amount;
        System.out.println("Balance after the deposit is: " + balance);
    }

    public void withdraw(long amount) throws InsufficientAmountExceptiion {
        if (amount > balance) {
            throw new InsufficientAmountExceptiion("Required balance is less than the amount you wish to withdraw");
        } else {
            balance -= amount;
            System.out.println("Balance after the withdrawal: " + balance);
        }
    }
}

class BOI extends Bank {
    String branchId;
    AccountType accountType;
    long balance;
    long accountNumber;

    BOI (String city, float rateOfInterest, String branchId,AccountType accountType, long balance, long accountNumber) {
        super(city, rateOfInterest);
        this.branchId = branchId;
        this.accountType = accountType;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    @Override
    public void getDetails() {
        super.getDetails();
    }

    @Override
    public void printDetalis() {
        System.out.println("\nBranch ID: "+branchId);
        super.printDetalis();
    }

    public void deposit(long amount) {
        if (amount < 0) {
            return;
        }
        balance += amount;
        System.out.println("Balance after the deposit is: "+balance);
    }

    public void withdraw(long amount) throws InsufficientAmountExceptiion {
        if (amount > balance) {
            throw new InsufficientAmountExceptiion("Required balance is less than the amount you wish to withdraw");
        } else {
            balance -= amount;
            System.out.println("Balance after the withdrawal: "+balance);
        }
    }
}

class ICICI extends Bank {
    String branchId;
    AccountType accountType;
    long balance;
    long accountNumber;

    ICICI (String city, float rateOfInterest, String branchId,  AccountType accountType, long balance, long accountNumber) {
        super(city, rateOfInterest);
        this.branchId = branchId;
        this.accountType = accountType;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    @Override
    public void getDetails() {
        super.getDetails();
    }

    @Override
    public void printDetalis() {
        System.out.println("\nBranch ID: "+branchId);
        super.printDetalis();
    }

    public void deposit(long amount) {
        if (amount < 0) {
            return;
        }
        balance += amount;
        System.out.println("Balance after the deposit is: "+balance);
    }

    public void withdraw(long amount) throws InsufficientAmountExceptiion {
        if (amount > balance) {
            throw new InsufficientAmountExceptiion("Required balance is less than the amount you wish to withdraw");
        } else {
            balance -= amount;
            System.out.println("Balance after the withdrawal: "+balance);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SBI sbiAccount = new SBI("Delhi", 2.5f, "sbide02",  AccountType.valueOf("SAVINGS"), 50000, 1100510023);
        BOI boiAccount = new BOI("Mumbai", 3.0f, "boi09", AccountType.valueOf("CURRENT"), 90000, 1900781268);
        ICICI iciciAccount = new ICICI("Pune", 4.5f, "icici10",  AccountType.valueOf("SAVINGS"), 150000, 1100784512);

        sbiAccount.printDetalis();
        boiAccount.printDetalis();
        iciciAccount.printDetalis();

        System.out.println("\nSBI opened account type: "+sbiAccount.accountType);
        System.out.println("BOI opened account type: "+boiAccount.accountType);
        System.out.println("ICIC opened account type: "+iciciAccount.accountType);

        Scanner sc = new Scanner(System.in);
        int ch, acc, depositAmount, withdrawAmount;
        System.out.println("\nWhat would you like to do?");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check balance");
        System.out.println("4. Exit");
        ch = sc.nextInt();
        String timeStamp, f;
        byte[] b;
        switch (ch) {
            case 1:
                System.out.println("\nIn which account would you like to deposit: ");
                System.out.println("1. SBI");
                System.out.println("2. BOI");
                System.out.println("3. ICIC");
                acc = sc.nextInt();
                switch (acc) {
                    case 1:
                        System.out.println("Current Balance: "+sbiAccount.balance);
                        System.out.println("How much amount would you like to deposit: ");
                        depositAmount = sc.nextInt();
                        sbiAccount.deposit(depositAmount);
                        timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                        f = "\nTime of transaction: "+timeStamp+"\tAccount number: "+sbiAccount.accountNumber+"\tAmount deposited: "+depositAmount+"\tAmount before deposit: "+(sbiAccount.balance-depositAmount)+"\tCurrent Balance: "+sbiAccount.balance+"\tTrx status: Success"+"\tFailure reason: --";
                        b = f.getBytes();
                        try {
                            FileOutputStream fout = new FileOutputStream("/home/rajat/IdeaProjects/Java_2/sbiLogs.txt");
                            fout.write(b);
                            fout.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case 2:
                        System.out.println("Current Balance: "+boiAccount.balance);
                        System.out.println("How much amount would you like to deposit: ");
                        depositAmount = sc.nextInt();
                        boiAccount.deposit(depositAmount);
                        timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                        f = "\nTime of transaction: "+timeStamp+"\tAccount number: "+boiAccount.accountNumber+"\tAmount deposited: "+depositAmount+"\tAmount before deposit: "+(boiAccount.balance-depositAmount)+"\tCurrent Balance: "+boiAccount.balance+"\tTrx status: Success"+"\tFailure reason: --";
                        b = f.getBytes();
                        try {
                            FileOutputStream fout = new FileOutputStream("/home/rajat/IdeaProjects/Java_2/boiLogs.txt");
                            fout.write(b);
                            fout.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case 3:
                        System.out.println("Current Balance: "+iciciAccount.balance);
                        System.out.println("How much amount would you like to deposit: ");
                        depositAmount = sc.nextInt();
                        iciciAccount.deposit(depositAmount);
                        timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                        f = "\nTime of transaction: "+timeStamp+"\tAccount number: "+iciciAccount.accountNumber+"\tAmount deposited: "+depositAmount+"\tAmount before deposit: "+(iciciAccount.balance-depositAmount)+"\tCurrent Balance: "+iciciAccount.balance+"\tTrx status: Success"+"\tFailure reason: --";
                        b = f.getBytes();
                        try {
                            FileOutputStream fout = new FileOutputStream("/home/rajat/IdeaProjects/Java_2/iciciLogs.txt");
                            fout.write(b);
                            fout.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    default:
                        System.out.println("Incorrect option, Exiting from the menu!!");
                        break;
                }
                break;

            case 2:
                System.out.println("\nFrom which account would you like to withdraw: ");
                System.out.println("1. SBI");
                System.out.println("2. BOI");
                System.out.println("3. ICICI");
                acc = sc.nextInt();
                switch (acc) {
                    case 1:
                        System.out.println("Current Balance: "+sbiAccount.balance);
                        System.out.println("How much would you like to withdraw: ");
                        withdrawAmount = sc.nextInt();
                        try {
                            sbiAccount.withdraw(withdrawAmount);
                            timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                            f = "\nTime of transaction: "+timeStamp+"\tAccount number: "+sbiAccount.accountNumber+"\tAmount withdrawn: "+withdrawAmount+"\tAmount before withdrawal: "+(sbiAccount.balance+withdrawAmount)+"\tCurrent Balance: "+sbiAccount.balance+"\tTrx status: Success"+"\tFailure reason: --";
                            b = f.getBytes();
                            try {
                                FileOutputStream fout = new FileOutputStream("/home/rajat/IdeaProjects/Java_2/sbiLogs.txt");
                                fout.write(b);
                                fout.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } catch (InsufficientAmountExceptiion e) {
                            timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                            f = "\nTime of transaction: "+timeStamp+"\tAccount number: "+sbiAccount.accountNumber+"\tAmount withdrawn: "+0+"\tAmount before withdrawal: "+iciciAccount.balance+"\tCurrent Balance: "+iciciAccount.balance+"\tTrx status: Failure"+"\tFailure reason: Less balance than amount to be withdrawn";
                            b = f.getBytes();
                            try {
                                FileOutputStream fout = new FileOutputStream("/home/rajat/IdeaProjects/Java_2/sbiLogs.txt");
                                fout.write(b);
                                fout.close();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                        break;

                    case 2:
                        System.out.println("Current Balance: "+boiAccount.balance);
                        System.out.println("How much would you like to withdraw: ");
                        withdrawAmount = sc.nextInt();
                        try {
                            boiAccount.withdraw(withdrawAmount);
                            timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                            f = "\nTime of transaction: "+timeStamp+"\tAccount number: "+boiAccount.accountNumber+"\tAmount withdrawn: "+withdrawAmount+"\tAmount before withdrawal: "+(boiAccount.balance+withdrawAmount)+"\tCurrent Balance: "+boiAccount.balance+"\tTrx status: Success"+"\tFailure reason: --";
                            b = f.getBytes();
                            try {
                                FileOutputStream fout = new FileOutputStream("/home/rajat/IdeaProjects/Java_2/boiLogs.txt");
                                fout.write(b);
                                fout.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } catch (InsufficientAmountExceptiion e) {
                            timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                            f = "\nTime of transaction: "+timeStamp+"\tAccount number: "+boiAccount.accountNumber+"\tAmount withdrawn: "+0+"\tAmount before withdrawal: "+boiAccount.balance+"\tCurrent Balance: "+boiAccount.balance+"\tTrx status: Failure"+"\tFailure reason: Less balance than amount to be withdrawn";
                            b = f.getBytes();
                            try {
                                FileOutputStream fout = new FileOutputStream("/home/rajat/IdeaProjects/Java_2/boiLogs.txt");
                                fout.write(b);
                                fout.close();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                        break;

                    case 3:
                        System.out.println("Current Balance: "+iciciAccount.balance);
                        System.out.println("How much would you like to withdraw: ");
                        withdrawAmount = sc.nextInt();
                        try {
                            iciciAccount.withdraw(withdrawAmount);
                            timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                            f = "\nTime of transaction: "+timeStamp+"\tAccount number: "+iciciAccount.accountNumber+"\tAmount withdrawn: "+withdrawAmount+"\tAmount before withdrawal: "+(iciciAccount.balance+withdrawAmount)+"\tCurrent Balance: "+iciciAccount.balance+"\tTrx status: Success"+"\tFailure reason: --";
                            b = f.getBytes();
                            try {
                                FileOutputStream fout = new FileOutputStream("/home/sharda/Documents/Introjava2/iciciLogs.txt");
                                fout.write(b);
                                fout.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } catch (InsufficientAmountExceptiion e) {
                            timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                            f = "\nTime of transaction: "+timeStamp+"\tAccount number: "+iciciAccount.accountNumber+"\tAmount withdrawn: "+0+"\tAmount before withdrawal: "+iciciAccount.balance+"\tCurrent Balance: "+iciciAccount.balance+"\tTrx status: Failure"+"\tFailure reason: Less balance than amount to be withdrawn";
                            b = f.getBytes();
                            try {
                                FileOutputStream fout = new FileOutputStream("/home/sharda/Documents/Introjava2/iciciLogs.txt");
                                fout.write(b);
                                fout.close();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                        break;

                    default:
                        System.out.println("Incorrect option, Exiting from the menu!!");
                        break;
                }
                break;

            case 3:
                System.out.println("\nWhich account's balance would you like to know: ");
                System.out.println("1. SBI");
                System.out.println("2. BOI");
                System.out.println("3. ICICI");
                acc = sc.nextInt();
                switch (acc) {
                    case 1:
                        System.out.println("Your SBI account currently have a balance of: "+sbiAccount.balance);
                        break;

                    case 2:
                        System.out.println("Your BOI account currently have a balance of: "+boiAccount.balance);
                        break;

                    case 3:
                        System.out.println("Your ICICI account currently have a balance of: "+iciciAccount.balance);
                        break;

                    default:
                        System.out.println("Incorrect option, Exiting from the menu!!");
                        break;
                }
                break;

            case 4: break;
        }
        sc.close();
    }
}


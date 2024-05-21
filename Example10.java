public class Example10 {
    private static class BankAccount {
        private int balance;
        private int accountId;

        public BankAccount(int accountId, int balance) {
            this.accountId = accountId;
            this.balance = balance;
        }

        public void deposit(int amount) {
            balance += amount;
        }

        public void withdraw(int amount) {
            balance -= amount;
        }

        public int getBalance() {
            return balance;
        }

        public int getAccountId() {
            return accountId;
        }

        public void transferTo(BankAccount other, int amount) throws InterruptedException {
            if (this.balance >= amount) {
                Thread.sleep(1);
                this.withdraw(amount);
                other.deposit(amount);

                System.out.println("Transferred " + amount + " from account " + this.getAccountId() + " to account " + other.getAccountId());
            } else {
                System.out.println("Insufficient funds in account " + this.getAccountId() + " for transfer");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BankAccount account1 = new BankAccount(1, 1000);
        BankAccount account2 = new BankAccount(2, 1500);

        Thread client1 = new Thread(() -> {
            try {
                account1.transferTo(account2, 500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread client2 = new Thread(() -> {
            try {
                account1.transferTo(account2, 700);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        client1.start();
        client2.start();

        client1.join();
        client2.join();

        System.out.println("account1.getBalance() = " + account1.getBalance());
        System.out.println("account2.getBalance() = " + account2.getBalance());
    }
}

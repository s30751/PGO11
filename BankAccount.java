import java.util.ArrayList;
import java.util.List;

    public class BankAccount implements AccountOperations {
        private double balance;
        private List<Transaction> transactions;

        public BankAccount() {
            this.balance = 0;
            this.transactions = new ArrayList<>();
        }

        @Override
        public double checkBalance() {
            return balance;
        }

        @Override
        public void transfer(BankAccount toAccount, double amount) throws AccountOperationException {
            if (amount <= 0 || amount > this.balance) {
                throw new AccountOperationException("Invalid transfer amount.");
            }
            this.balance -= amount;
            toAccount.deposit(amount);
            transactions.add(new Transaction(amount, this, toAccount));
        }

        @Override
        public void deposit(double amount) {
            if (amount > 0) {
                this.balance += amount;
                transactions.add(new Transaction(amount, null, this));
            }
        }

        public List<Transaction> getTransactions() {
            return transactions;
        }
    }


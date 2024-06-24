public class Main {
    public static void main(String[] args) {
        // Create an admin
        Admin admin = new Admin("AdminFirstName", "AdminLastName");

        // Create two employees
        Employee emp1 = new Employee("Employee1FirstName", "Employee1LastName");
        Employee emp2 = new Employee("Employee2FirstName", "Employee2LastName");

        // Add employees to admin
        admin.addEmployee(emp1);
        admin.addEmployee(emp2);

        // Create four clients
        Client client1 = emp1.addClient("Client1FirstName", "Client1LastName");
        Client client2 = emp1.addClient("Client2FirstName", "Client2LastName");
        Client client3 = emp2.addClient("Client3FirstName", "Client3LastName");
        Client client4 = emp2.addClient("Client4FirstName", "Client4LastName");

        // Each client creates an account
        client1.createAccount();
        client2.createAccount();
        client3.createAccount();
        client4.createAccount();

        // Deposit money into each account
        client1.getAccount().deposit(1000);
        client2.getAccount().deposit(1500);
        client3.getAccount().deposit(2000);
        client4.getAccount().deposit(2500);

        try {
            // Perform 10 transactions
            client1.getAccount().transfer(client2.getAccount(), 100);
            client2.getAccount().transfer(client3.getAccount(), 200);
            client3.getAccount().transfer(client4.getAccount(), 300);
            client4.getAccount().transfer(client1.getAccount(), 400);
            client1.getAccount().transfer(client3.getAccount(), 50);
            client2.getAccount().transfer(client4.getAccount(), 100);
            client3.getAccount().transfer(client1.getAccount(), 200);
            client4.getAccount().transfer(client2.getAccount(), 300);
            client1.getAccount().transfer(client4.getAccount(), 400);
            client2.getAccount().transfer(client3.getAccount(), 500);
        } catch (AccountOperationException e) {
            System.out.println(e.getMessage());
        }

        // Check transactions for each account
        System.out.println("Client1 Transactions: " + client1.getAccount().getTransactions().size());
        System.out.println("Client2 Transactions: " + client2.getAccount().getTransactions().size());
        System.out.println("Client3 Transactions: " + client3.getAccount().getTransactions().size());
        System.out.println("Client4 Transactions: " + client4.getAccount().getTransactions().size());
    }
}

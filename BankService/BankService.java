package BankService;
import domain.Account;
import java.util.List;

// account open karneka implementation
public interface BankService {

    String openAccount(String name, String email, String accountType);

    List<Account> listAccounts();

    void deposit(String accountNumber, Double amount, String deposit);

}
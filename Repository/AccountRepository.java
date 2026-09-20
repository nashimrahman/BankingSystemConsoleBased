package Repository;
import domain.Account;
import java.util.*;

public class AccountRepository {

    //storing all accounts by key value pair
    private final Map<String, Account> accountsByNumber = new HashMap<>();

    public void save(Account account) {
        accountsByNumber.put(account.getAccountNumber(), account);
    }

    public List<Account> findAll() {
        return new ArrayList<>(accountsByNumber.values());
    }

    public Optional<Account> findByNumer(String accountNumber) {
        return Optional.ofNullable(accountsByNumber.get(accountNumber));
    }
}
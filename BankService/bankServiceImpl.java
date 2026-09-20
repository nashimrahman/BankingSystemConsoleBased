package BankService;

import Repository.AccountRepository;
import Repository.transactionRepository;
import domain.Account;
import domain.Transaction;
import domain.Type;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class bankServiceImpl implements BankService {

    //creating object
    private final AccountRepository accountRepository= new AccountRepository();
    private final transactionRepository transactionRepository = new transactionRepository();

    @Override
    public String openAccount(String name, String email, String accountType) {

        String customerId = UUID.randomUUID().toString();
       // String accountNumber = UUID.randomUUID().toString();
        String accountNumber = getAccountNumber();
        Account account = new Account(accountNumber, accountType, (double)0 ,customerId);
        accountRepository.save(account);
        return accountNumber;
    }
    

    private String getAccountNumber() {
        int size = accountRepository.findAll().size()+1;
        return String.format("AC%06d", size);
    }


    @Override
    public List<Account> listAccounts() {
        return accountRepository.findAll().stream()
                .sorted(Comparator.comparing(Account::getAccountNumber))
                .collect(Collectors.toList());
    }


    @Override
    public void deposit(String accountNumber, Double amount, String note) {

        Account account = accountRepository.findByNumer(accountNumber)
                .orElseThrow(()-> new RuntimeException("Account not found "+accountNumber));
        account.setBalance(account.getBalance()+ amount);

        Transaction transaction = new Transaction(account.getAccountNumber(),
                amount, UUID.randomUUID().toString(), note, LocalDateTime.now(), Type.DEPOSIT);
        transactionRepository.add(transaction);



    }


}

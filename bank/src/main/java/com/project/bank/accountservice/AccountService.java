package com.project.bank.accountservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bank.accountDao.AccountRepo;
import com.project.bank.accountentity.Account;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepo repo;
	
	
	public Account postData(Account a) {
		return repo.save(a);
	}
	

	public Optional<Account> fetchById(long id) {
		return repo.findById(id);
	}

    public Account deposit(Long id, double amount) {
        Account account = fetchById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        account.setBalance(account.getbalance() + amount);
        return repo.save(account);
    }
    
    public Account withdraw(Long id, double amount) {
        Account account = fetchById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        if (account.getbalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }
        account.setBalance(account.getbalance() - amount);
        return repo.save(account);
    }


	public List<Account> getData() {
		return repo.findAll();
	}
	
	public void delete(Account account) {
		repo.delete(account);
	}
	
}

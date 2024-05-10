package com.project.bank.accountcontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bank.accountentity.Account;
import com.project.bank.accountservice.AccountService;
import com.project.bank.exception.AccountNotFoundException;


@RestController
@RequestMapping("/bank")

public class AccountController {
	
	@Autowired
	private AccountService as;
	
	
	//For creating account
	@PostMapping("/post")
	public ResponseEntity <Account> createAccount(@RequestBody Account a){
		return new ResponseEntity<>(as.postData(a),HttpStatus.ACCEPTED);
	}
	
//	@GetMapping("/get")
//	public ResponseEntity<List<Account>> getBankDetails(){
//		return new ResponseEntity<>(as.getData(),HttpStatus.OK);
//	}
//	
	//Getting Account
	@GetMapping("/getById/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable long id) throws AccountNotFoundException{
      Account account = as.fetchById(id).orElseThrow(()-> new AccountNotFoundException(id+" Account is not found .."));
			return new ResponseEntity<>(account,HttpStatus.OK);	
	}
	
	
	//For deposit
	
	   @PostMapping("/{id}/deposit")
	    public Account deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
	        Double amount = request.get("amount");
	        return as.deposit(id, amount);
	    }
	   
	   
		//For Withdraw

	   @PostMapping("/{id}/withdraw")
	    public Account withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
	        Double amount = request.get("amount");
	        return as.withdraw(id, amount);
	    }
		
}
	
	
	
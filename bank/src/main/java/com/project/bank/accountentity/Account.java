package com.project.bank.accountentity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="BankAccounts")
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="AccountHolder",nullable=false)
	private String accountHolder;
	
	@Column(name="Balance",nullable=false)
	private double balance;
	
	public Account() {}
	
	public Account(int id,String accountHolder,double balance) {
		this.id=id;
		this.accountHolder=accountHolder;
		this.balance=balance;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public int getId() {
		return id;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	
	public void setBalance(double balance) {
		this.balance=balance;
	}
	
	public double getbalance() {
		return balance;
	}
	
	public String toString() {
		return id+" "+accountHolder+" "+balance;
	}
	
}

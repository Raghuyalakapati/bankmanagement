package com.project.bank.accountDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.bank.accountentity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account,Long>{
	
     //	  This is the dao layer for the Account

}

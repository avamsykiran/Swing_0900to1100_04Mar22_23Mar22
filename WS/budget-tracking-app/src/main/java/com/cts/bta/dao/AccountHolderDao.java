package com.cts.bta.dao;

import java.util.List;

import com.cts.bta.entities.AccountHolder;
import com.cts.bta.exceptions.BTAException;

public interface AccountHolderDao {
	List<AccountHolder> getAll() throws BTAException;
	AccountHolder getById(Long id) throws BTAException;
	AccountHolder add(AccountHolder entity) throws BTAException;
	AccountHolder modify(AccountHolder entity) throws BTAException;
	void deleteById(Long id) throws BTAException;
}

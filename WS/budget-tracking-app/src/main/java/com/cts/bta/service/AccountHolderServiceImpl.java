package com.cts.bta.service;

import java.util.List;

import com.cts.bta.dao.AccountHolderDao;
import com.cts.bta.dao.AccountHolderDaoImpl;
import com.cts.bta.entities.AccountHolder;
import com.cts.bta.exceptions.BTAException;

public class AccountHolderServiceImpl implements AccountHolderService{

	private AccountHolderDao ahDao;
	
	public AccountHolderServiceImpl() {
		this.ahDao=new AccountHolderDaoImpl();
	}
	
	@Override
	public List<AccountHolder> getAll() throws BTAException {
		return ahDao.getAll();
	}

	@Override
	public AccountHolder getById(Long id) throws BTAException {
		return ahDao.getById(id);
	}

	@Override
	public AccountHolder add(AccountHolder entity) throws BTAException {
		return ahDao.add(entity);
	}

	@Override
	public AccountHolder modify(AccountHolder entity) throws BTAException {
		return ahDao.modify(entity);
	}

	@Override
	public void deleteById(Long id) throws BTAException {
		ahDao.deleteById(id);
	}

}

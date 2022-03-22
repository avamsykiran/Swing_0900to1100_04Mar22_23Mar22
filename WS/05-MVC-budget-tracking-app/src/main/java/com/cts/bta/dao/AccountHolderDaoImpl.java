package com.cts.bta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cts.bta.entities.AccountHolder;
import com.cts.bta.exceptions.BTAException;

public class AccountHolderDaoImpl implements AccountHolderDao {

	static final String GET_ALL = "SELECT id,name,mobile,mail_id,balance FROM accountholders";
	static final String GET_BY_ID = "SELECT id,name,mobile,mail_id,balance FROM accountholders WHERE id=?";
	static final String INS = "INSERT INTO accountholders(id,name,mobile,mail_id,balance) values(?,?,?,?,0)";
	static final String UPD = "UPDATE accountholders set name=?,mobile=?,mail_id=?,balance=? WHERE id=?";
	static final String DEL_BY_ID = "DELETE FROM accountholders WHERE id=?";
	static final String MAX_ID = "SELECT MAX(id) FROM accountholders";

	private AccountHolder mapRow(ResultSet rs) throws SQLException {
		return new AccountHolder(rs.getLong("id"), rs.getString("name"), rs.getString("mobile"),
				rs.getString("mail_id"), rs.getDouble("balance"));
	}

	@Override
	public List<AccountHolder> getAll() throws BTAException {
		List<AccountHolder> accountHoldersList = new ArrayList<AccountHolder>();

		try (Connection con = Connector.getConnection(); PreparedStatement pst = con.prepareStatement(GET_ALL)) {
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				accountHoldersList.add(mapRow(rs));
			}
		} catch (SQLException exp) {
			// log the exp
			exp.printStackTrace();
			throw new BTAException("Unable to retrive details");
		}

		return accountHoldersList;
	}

	@Override
	public AccountHolder getById(Long id) throws BTAException {
		AccountHolder accountHolder = null;
		try (Connection con = Connector.getConnection(); PreparedStatement pst = con.prepareStatement(GET_BY_ID)) {

			pst.setLong(1, id);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				accountHolder = mapRow(rs);
			}
		} catch (SQLException exp) {
			// log the exp
			exp.printStackTrace();
			throw new BTAException("Unable to retrive details");
		}

		return accountHolder;
	}

	@Override
	public AccountHolder add(AccountHolder entity) throws BTAException {
		try (Connection con = Connector.getConnection(); PreparedStatement pst = con.prepareStatement(INS)) {

			pst.setLong(1, entity.getId());
			pst.setString(2, entity.getName());
			pst.setString(3, entity.getMobile());
			pst.setString(4, entity.getMailId());
			pst.setDouble(5, entity.getBalance());
			pst.executeUpdate();

		} catch (SQLException exp) {
			// log the exp
			exp.printStackTrace();
			throw new BTAException("Unable to save details");
		}
		return entity;
	}

	@Override
	public AccountHolder modify(AccountHolder entity) throws BTAException {
		try (Connection con = Connector.getConnection(); PreparedStatement pst = con.prepareStatement(UPD)) {

			pst.setString(1, entity.getName());
			pst.setString(2, entity.getMobile());
			pst.setString(3, entity.getMailId());
			pst.setDouble(4, entity.getBalance());
			pst.setLong(5, entity.getId());
			pst.executeUpdate();

		} catch (SQLException exp) {
			// log the exp
			exp.printStackTrace();
			throw new BTAException("Unable to save details");
		}
		return entity;
	}

	@Override
	public void deleteById(Long id) throws BTAException {
		try (Connection con = Connector.getConnection(); PreparedStatement pst = con.prepareStatement(DEL_BY_ID)) {

			pst.setLong(1, id);
			pst.executeUpdate();

		} catch (SQLException exp) {
			// log the exp
			exp.printStackTrace();
			throw new BTAException("Unable to remove details");
		}
	}

	@Override
	public Long maxAccountHolderId() throws BTAException {
		Long id = null;
		try (Connection con = Connector.getConnection(); PreparedStatement pst = con.prepareStatement(MAX_ID)) {
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				id = rs.getLong(1);
			}
		} catch (SQLException exp) {
			// log the exp
			exp.printStackTrace();
			throw new BTAException("Unable to retrive latest id");
		}
		return id;
	}

}

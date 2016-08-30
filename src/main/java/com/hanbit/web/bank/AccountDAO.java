package com.hanbit.web.bank;

import java.util.List;
import java.util.Map;

public interface AccountDAO {
	public int insertAccount(AccountVO acc);
	public int selectMoney(int accNo);
	public void deposit(AccountVO acc);
	public void withdraw(AccountVO acc);
	public int delete(String delete);
	public List<?> selectAll();
	public int count();
	public Map<?, ?> selectMap();
}

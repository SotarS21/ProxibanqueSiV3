package service;

import java.util.List;

import metier.BankAccount;

public interface IServiceAccount {

	public void addAccountToClient(long idClient, BankAccount.etype type, long startSold);
	public  void removeAccountToClient(long idClient, BankAccount.etype type);
	public  void updateOverdrawToClient(long idClient, long newOverdraft);
	public  void transferAccoutToAccount(BankAccount host, BankAccount dest, double sold);
	public  boolean checkOverdraft(BankAccount myAccount);
	public  boolean checkRich(BankAccount myAccount);
	public  List<BankAccount> getAllAccount();
	public  BankAccount getAccountById(long id);
	
}

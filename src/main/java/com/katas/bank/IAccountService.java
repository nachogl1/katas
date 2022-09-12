package com.katas.bank;

public interface IAccountService {
    void deposit(int amount);
    void withdraw(int amount);
    void printStatement();
}

package com.atm.transaction;

import com.atm.model.Account;
import java.util.Scanner;

public class Withdrawal extends Transaction {

    public Withdrawal(Account account) {
        super(account);
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah penarikan: ");
        double amount = scanner.nextDouble();

        double currentBalance = account.getBalance();
        double newBalance = currentBalance - amount;

        // Cek apakah saldo setelah penarikan akan melebihi saldo minimal
        if (newBalance >= Account.MINIMUM_BALANCE) {
            account.debit(amount);
            System.out.println("Penarikan berhasil. Saldo Anda sekarang: Rp" + account.getBalance());
        } else {
            System.out.println("Penarikan gagal. Saldo tidak boleh kurang dari Rp" + Account.MINIMUM_BALANCE);
        }
    }
}
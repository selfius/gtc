package local.self.gtc.service;

import local.self.gtc.model.Balance;
import local.self.gtc.repository.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TheService {

    @Autowired
    private BalanceRepository balanceRepository;

    public static final int DEFAULT_BALANCE = 2;

    public Balance findOrCreateBalance(String username) {
        Optional<Balance> usersBalance = balanceRepository.findById(username);
        return usersBalance.orElseGet(() -> balanceRepository.save(new Balance(username, DEFAULT_BALANCE)));
    }
}

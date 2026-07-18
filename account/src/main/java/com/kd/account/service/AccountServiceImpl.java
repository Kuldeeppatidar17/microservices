package com.kd.account.service;

import com.kd.account.constant.MessageConstants;
import com.kd.account.dtos.AccountResponse;
import com.kd.account.dtos.CreateAccountRequest;
import com.kd.account.dtos.UpdateAccountRequest;

import com.kd.account.entity.Account;
import com.kd.account.exceptions.ResourceNotFoundException;
import com.kd.account.mapper.AccountMapper;
import com.kd.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    @Override
    public AccountResponse create(CreateAccountRequest request) {

        Account account=accountMapper.toEntity(request);

        Account savedAccount=accountRepository.save(account);

        return accountMapper.toResponse(savedAccount);
    }

    @Override
    @Transactional(readOnly = true)
    public AccountResponse getById(Long id) {
        Account account=accountRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(MessageConstants.ACCOUNT_NOT_FOUND + id));
        return accountMapper.toResponse(account);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AccountResponse> getAll() {
        return accountRepository.findAll()
                .stream()
                .map(accountMapper::toResponse)
                .toList();
    }

    @Override
    public AccountResponse update(Long id, UpdateAccountRequest request) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(MessageConstants.ACCOUNT_NOT_FOUND + id));

        account.setAccountHolderName(request.accountHolderName());
        account.setAccountType(request.accountType());
        account.setBalance(request.balance());

        Account updatedAccount = accountRepository.save(account);

        return accountMapper.toResponse(updatedAccount);
    }

    @Override
    public void delete(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(MessageConstants.ACCOUNT_NOT_FOUND + id));

        accountRepository.delete(account);
    }
}

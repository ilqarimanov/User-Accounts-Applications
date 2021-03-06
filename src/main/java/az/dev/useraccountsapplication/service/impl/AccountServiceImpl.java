package az.dev.useraccountsapplication.service.impl;

import az.dev.useraccountsapplication.dto.response.CommonResponse;
import az.dev.useraccountsapplication.dto.response.ErrorResponse;
import az.dev.useraccountsapplication.entity.AccountEntity;
import az.dev.useraccountsapplication.entity.UserEntity;
import az.dev.useraccountsapplication.enums.ErrorCodeEnum;
import az.dev.useraccountsapplication.exception.CustomNotFoundException;
import az.dev.useraccountsapplication.repository.AccountRepository;
import az.dev.useraccountsapplication.repository.UserRepository;
import az.dev.useraccountsapplication.dto.request.AccountRequest;
import az.dev.useraccountsapplication.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountServiceImpl(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @Override
    public CommonResponse createAccount(AccountRequest accountRequest) throws RuntimeException {
        UserEntity user = userRepository.findUserEntityById(accountRequest.getUserId())
                .orElseThrow(() -> new CustomNotFoundException(ErrorCodeEnum.IS_EMPTY));
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setUserId(user);
        accountEntity.setAccountNumber(accountRequest.getAccountNumber());
        accountEntity.setBalance(accountRequest.getBalance());
        accountRepository.save(accountEntity);

        return new CommonResponse(ErrorResponse.getSuccessMessage());
    }

    @Override
    public CommonResponse accountList() {
        List<UserEntity> userEntities = userRepository.findAll();
        if (userEntities.size() == 0 || userEntities == null) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("User List is Empty");
            errorResponse.setCode(151);
            return new CommonResponse(errorResponse);
        }
        return new CommonResponse(ErrorResponse.getSuccessMessage(), userEntities);

    }


    @Override
    public List<AccountEntity> searchAccount(Long userId) {
        UserEntity user = userRepository.findUserEntityById(userId)
                .orElseThrow(() -> new CustomNotFoundException(ErrorCodeEnum.USER_NOT_FOUND));
        return accountRepository.findAllByUserId(user)
                .orElseThrow(() -> new CustomNotFoundException(ErrorCodeEnum.ACCOUNT_NOT_FOUND));
    }
}






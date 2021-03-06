package az.dev.useraccountsapplication.controller;

import az.dev.useraccountsapplication.dto.request.AccountRequest;
import az.dev.useraccountsapplication.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountsController {


    private final AccountService accountService;


    public AccountsController(AccountService accountService) {
        this.accountService = accountService;

    }

    @GetMapping("/accountlist")
    public ResponseEntity<?> accountList() {
        return ResponseEntity.ok(accountService.accountList());
    }


    @PostMapping("/create-account")
    public ResponseEntity<?> createAccount(@RequestBody @Validated AccountRequest accountRequest) {
        return ResponseEntity.ok(accountService.createAccount(accountRequest));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> searchAccount(@PathVariable("userId") Long userId) {
            return ResponseEntity.ok(accountService.searchAccount(userId));
    }
}

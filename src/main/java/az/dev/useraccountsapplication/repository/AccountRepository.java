package az.dev.useraccountsapplication.repository;

import az.dev.useraccountsapplication.entity.AccountEntity;
import az.dev.useraccountsapplication.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    List<AccountEntity> findAllByUserId(UserEntity userId);
}

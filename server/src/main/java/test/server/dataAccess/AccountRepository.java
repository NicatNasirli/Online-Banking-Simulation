package test.server.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.server.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}

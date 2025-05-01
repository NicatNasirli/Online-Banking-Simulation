package test.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import test.server.utilities.mapper.AccountMapper;
import test.server.utilities.mapper.TransactionMapper;
import test.server.utilities.mapper.UserMapper;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    public AccountMapper getAccountMapper(){
        return new AccountMapper();
    }
    @Bean
    public UserMapper getUserMapper(){
        return new UserMapper();
    }
    @Bean
    public TransactionMapper getTransactionMapper(){
        return new TransactionMapper();
    }
}

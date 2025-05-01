package test.server.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String accountNumber;

    private Double balance;

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "receiverAccount",cascade = CascadeType.ALL)
    private List<Transaction> receivedTransactions;

    @OneToMany(mappedBy = "senderAccount",cascade = CascadeType.ALL)
    private List<Transaction> sentTransactions;

}

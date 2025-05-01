package test.server.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double amount;

    private LocalDateTime date;

    private String description;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Account receiverAccount;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Account senderAccount;
}

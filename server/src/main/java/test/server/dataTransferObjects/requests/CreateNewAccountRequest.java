package test.server.dataTransferObjects.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateNewAccountRequest {
    private Double balance;
}

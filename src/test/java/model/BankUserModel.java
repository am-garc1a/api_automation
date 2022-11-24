package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Base class for bank user model.
 *
 * @author am.garcia
 */
@Data
@NoArgsConstructor
@JsonPropertyOrder({"name", "lastName", "accountNumber", "amount",
        "transactionType", "email", "active", "country", "telephone", "id"})
public class BankUserModel {
    private String name;
    private String lastName;
    private String accountNumber;
    private String amount;
    private String transactionType;
    private String email;
    private String active;
    private String country;
    private String telephone;
    private String id;
}

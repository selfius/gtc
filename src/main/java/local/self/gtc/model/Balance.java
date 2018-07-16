package local.self.gtc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import local.self.gtc.util.PrettyPrinter;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Data
public class Balance {

    public Balance() {
    }

    public Balance(String login, Integer balance) {
        this.login = login;
        this.balance = balance;
    }

    @Id
    @JsonProperty
    private String login;

    @JsonProperty
    private Integer balance;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balance balance1 = (Balance) o;
        return Objects.equals(login, balance1.login) &&
                Objects.equals(balance, balance1.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, balance);
    }

    @Override
    public String toString() {
        return PrettyPrinter.toPrettyString(this);
    }
}

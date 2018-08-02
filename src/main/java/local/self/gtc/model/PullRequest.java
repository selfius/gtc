package local.self.gtc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import local.self.gtc.util.PrettyPrinter;
import lombok.Data;

@Data
public class PullRequest {

    public PullRequest() {
    }

    public PullRequest(Integer number) {
        this.number = number;
    }

    @JsonProperty
    private Integer number;

    @Override
    public String toString() {
        return PrettyPrinter.toPrettyString(this);
    }
}

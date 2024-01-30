package project.server.base.data;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;

public class ClientInfoData implements Serializable {

    @Column(name = "balance")
    private BigDecimal balance;
    @Column(name = "position")
    private Integer position;

    public ClientInfoData() {
    }

    public ClientInfoData(BigDecimal balance, Integer position) {
        this.balance = balance;
        this.position = position;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}

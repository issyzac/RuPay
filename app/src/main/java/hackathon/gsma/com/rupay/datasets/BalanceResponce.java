package hackathon.gsma.com.rupay.datasets;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by issy on 7/8/17.
 */

public class BalanceResponce implements Serializable{

    @SerializedName("availableBalance")
    private String amount;

    @SerializedName("currency")
    private String currency;

    @SerializedName("status")
    private String status;

    public BalanceResponce(){}

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

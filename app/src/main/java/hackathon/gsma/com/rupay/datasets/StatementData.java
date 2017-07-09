package hackathon.gsma.com.rupay.datasets;

/**
 * Created by fred on 08/07/2017.
 */

public class StatementData {
    String amount;
    String transactionStatus;
    String transactionReference;
    String transaction_to;


    public StatementData(String amount, String refID, String to){
        this.amount = amount;
        this.transactionReference = refID;
        this.transaction_to = to;

    }
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }

    public String getTransaction_to() {
        return transaction_to;
    }

    public void setTransaction_to(String transaction_to) {
        this.transaction_to = transaction_to;
    }
}

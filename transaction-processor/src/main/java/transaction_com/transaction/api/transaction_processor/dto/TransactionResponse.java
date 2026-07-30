package transaction_com.transaction.api.transaction_processor.dto;

public class TransactionResponse {

    private String id;
    private String estatus;
    private String referencia;
    private String operacion;

    public TransactionResponse(String id, String estatus, String referencia, String operacion) {
        this.id = id;
        this.estatus = estatus;
        this.referencia = referencia;
        this.operacion = operacion;
    }

    public String getId() {
        return id;
    }

    public String getEstatus() {
        return estatus;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getOperacion() {
        return operacion;
    }
}
package transaction_com.transaction.api.transaction_processor.dto;

import java.math.BigDecimal;

public class TransactionRequest {

    private String operacion;
    private BigDecimal importe;
    private String cliente;
    private String secreto;

    // GETTERS
    public String getOperacion() {
        return operacion;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public String getCliente() {
        return cliente;
    }

    public String getSecreto() {
        return secreto;
    }

    // SETTERS
    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setSecreto(String secreto) {
        this.secreto = secreto;
    }
}
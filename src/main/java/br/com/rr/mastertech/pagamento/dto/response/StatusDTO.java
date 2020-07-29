package br.com.rr.mastertech.pagamento.dto.response;

public class StatusDTO {

    public StatusDTO(String status) {
        this.status = status;
    }

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

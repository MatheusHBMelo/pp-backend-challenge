package tech.mhbm.pp_backend.domain.models;

import jakarta.persistence.*;
import tech.mhbm.pp_backend.domain.controllers.dtos.TransferResponse;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_Transfer")
public class Transfer implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "payer_id")
    private Wallet payer;

    @ManyToOne
    @JoinColumn(name = "payee_id")
    private Wallet payee;

    private BigDecimal value;

    public Transfer() {
    }

    public Transfer(Wallet payer, Wallet payee, BigDecimal value) {
        this.payer = payer;
        this.payee = payee;
        this.value = value;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Wallet getPayer() {
        return payer;
    }

    public void setPayer(Wallet payer) {
        this.payer = payer;
    }

    public Wallet getPayee() {
        return payee;
    }

    public void setPayee(Wallet payee) {
        this.payee = payee;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public TransferResponse TransferResponse() {
        return new TransferResponse(id, payer, payee, value);
    }
}

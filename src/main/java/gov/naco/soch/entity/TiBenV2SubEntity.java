package gov.naco.soch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.io.Serializable;


@Entity(
        name = "TiBenV2SubEntity"
)
@Table(
        name = "ti_beneficiary"
)
public class TiBenV2SubEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;

    @Column(
            name = "ti_code"
    )
    private String tiCode;

    @ManyToOne
    @JoinColumn(
            name = "status_id"
    )
    private MasterTiClientStatus status;

    @ManyToOne
    @JoinColumn(
            name = "master_hrg_primary_id"
    )
    private TypologyMaster hrgPrimary;

    @ManyToOne
    private MasterBenSubEntity beneficiary;

    @Column(name="is_active")
    private Boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTiCode() {
        return tiCode;
    }

    public void setTiCode(String tiCode) {
        this.tiCode = tiCode;
    }

    public MasterTiClientStatus getStatus() {
        return status;
    }

    public void setStatus(MasterTiClientStatus status) {
        this.status = status;
    }

    public TypologyMaster getHrgPrimary() {
        return hrgPrimary;
    }

    public void setHrgPrimary(TypologyMaster hrgPrimary) {
        this.hrgPrimary = hrgPrimary;
    }

    public MasterBenSubEntity getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(MasterBenSubEntity beneficiary) {
        this.beneficiary = beneficiary;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}

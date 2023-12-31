package gov.naco.soch.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the master_hiv2_lab_result_status database table.
 *
 */
@GenericGenerator(name = "master_hiv2_lab_result_status", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name = "sequence_name", value = "master_hiv2_lab_result_status_id_seq"),
                @Parameter(name = "increment_size", value = "1"),
                @Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "master_hiv2_lab_result_status")
@NamedQuery(name = "MasterHiv2LabResultStatus.findAll", query = "SELECT m FROM MasterHiv2LabResultStatus m")
public class MasterHiv2LabResultStatus extends Auditable<Long> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "master_hiv2_lab_result_status")
    private Long id;
    private String code;
    private String name;
    private String description;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_delete")
    private Boolean isDelete;

    public MasterHiv2LabResultStatus() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsDelete() {
        return this.isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
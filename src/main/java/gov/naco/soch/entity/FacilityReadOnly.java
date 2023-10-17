package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the facility database table.
 * 
 */
@GenericGenerator(name = "facility", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
	@Parameter(name = "sequence_name", value = "facility_id_seq"), @Parameter(name = "increment_size", value = "1"),
	@Parameter(name = "optimizer", value = "hilo") })
@Entity(name = "facilityReadOnly")
@Table(name = "facility")
@Immutable
public class FacilityReadOnly extends Auditable<Long> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "facility")
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(length = 99)
    private String code;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_delete")
    private Boolean isDelete;

    @Column(length = 99)
    private String name;

    @Column(name = "is_external")
    private Boolean isExternal;

    @Column(name = "facility_type_id")
    private Long facilityTypeId;
    
    @ManyToOne
    private AddressReadOnly address;

    public FacilityReadOnly() {

    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    public Boolean getIsActive() {
	return isActive;
    }

    public void setIsActive(Boolean isActive) {
	this.isActive = isActive;
    }

    public Boolean getIsDelete() {
	return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
	this.isDelete = isDelete;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Boolean getIsExternal() {
	return isExternal;
    }
    

    public AddressReadOnly getAddress() {
        return address;
    }

    public void setAddress(AddressReadOnly address) {
        this.address = address;
    }

    public void setIsExternal(Boolean isExternal) {
	this.isExternal = isExternal;
    }

    public Long getFacilityTypeId() {
	return facilityTypeId;
    }

    public void setFacilityTypeId(Long facilityTypeId) {
	this.facilityTypeId = facilityTypeId;
    }
}
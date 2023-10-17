package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;


@GenericGenerator(name = "master_beneficiary_time_availability", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "master_beneficiary_time_availability_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "master_beneficiary_time_availability")
public class MasterBenificiaryTimeAvailability implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "master_beneficiary_time_availability")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_delete")
    private Boolean isDelete;

    @CreatedBy
    @Column(name = "created_by")
    protected Long createdBy;

    @CreatedDate
    @Column(name = "created_time")
    protected LocalDateTime createdTime;

    @LastModifiedBy
    @Column(name = "modified_by")
    protected Long modifiedBy;

    @LastModifiedDate
    @Column(name = "modified_time")
    private LocalDateTime modifiedTime;

    public MasterBenificiaryTimeAvailability() {

    }

    public MasterBenificiaryTimeAvailability(Long masterTimeId, String masterTimeName) {
	this.id = masterTimeId;
	this.name = masterTimeName;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
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

    public Long getCreatedBy() {
	return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
	this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedTime() {
	return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
	this.createdTime = createdTime;
    }

    public Long getModifiedBy() {
	return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
	this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getModifiedTime() {
	return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
	this.modifiedTime = modifiedTime;
    }

}

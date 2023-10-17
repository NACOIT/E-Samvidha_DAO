package gov.naco.soch.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class ReportAuditable {
	@CreatedDate
	@Column(name = "created_time", nullable = false, updatable = false)
	private Date createdDate;
	@ManyToOne
	@JoinColumn(name = "created_by", nullable = false, updatable = false)
	private UserMaster createdUser;
	@LastModifiedDate
	@Column(name = "modified_time")
	private Date modifiedDate;
	@ManyToOne
	@JoinColumn(name = "modified_by")
	private UserMaster modifiedUser;

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public UserMaster getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(UserMaster createdUser) {
		this.createdUser = createdUser;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public UserMaster getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(UserMaster modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

}

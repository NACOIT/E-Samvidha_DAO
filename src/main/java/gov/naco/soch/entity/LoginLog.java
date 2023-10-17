package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the soch_system_config database table.
 * 
 */
@GenericGenerator(name = "login_log", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "login_log_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "login_log")
@NamedQuery(name = "LoginLog.findAll", query = "SELECT l FROM LoginLog l")
public class LoginLog implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "login_log")
	private Long id;
	
	@Column(name = "date_time")
	private LocalDateTime dateTime;
	
	@Column(name = "login_status")
	private Long loginStatus;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserMaster userMaster;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Long getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(Long loginStatus) {
		this.loginStatus = loginStatus;
	}

	public UserMaster getUserMaster() {
		return userMaster;
	}

	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}
	
	
}

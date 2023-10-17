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

@GenericGenerator(name = "typology_master_vc", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "typology_master_typology_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Entity(name = "TypologyMasterVCReadOnly")
@Table(name = "typology_master")
@NamedQuery(name = "TypologyMasterVCReadOnly.findAll", query = "SELECT t FROM TypologyMasterVCReadOnly t")
public class TypologyMasterVCReadOnly implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "typology_master_vc")
	@Column(name = "typology_id", unique = true, nullable = false)
	private Long typologyId;

	@Column(name = "typology_name")
	private String typologyName;

	public Long getTypologyId() {
		return typologyId;
	}

	public void setTypologyId(Long typologyId) {
		this.typologyId = typologyId;
	}

	public String getTypologyName() {
		return typologyName;
	}

	public void setTypologyName(String typologyName) {
		this.typologyName = typologyName;
	}

}

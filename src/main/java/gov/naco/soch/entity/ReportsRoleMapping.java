package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "global_report_role_mapping")
public class ReportsRoleMapping extends ReportAuditable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mapping_id")
	private Long mappingId;
	@ManyToOne
	@JoinColumn(name = "report_id")
	private MasterReport masterReport;
	@ManyToOne
	@JoinColumn(name = "submodule_id")
	private ReportsSubModule subModule;
	@ManyToOne
	@JoinColumn(name = "module_id")
	private ReportsModule reportsModule;
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	public Long getMappingId() {
		return mappingId;
	}

	public void setMappingId(Long mappingId) {
		this.mappingId = mappingId;
	}

	public MasterReport getMasterReport() {
		return masterReport;
	}

	public void setMasterReport(MasterReport masterReport) {
		this.masterReport = masterReport;
	}

	public ReportsSubModule getSubModule() {
		return subModule;
	}

	public void setSubModule(ReportsSubModule subModule) {
		this.subModule = subModule;
	}

	public ReportsModule getReportsModule() {
		return reportsModule;
	}

	public void setReportsModule(ReportsModule reportsModule) {
		this.reportsModule = reportsModule;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}

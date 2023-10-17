package gov.naco.soch.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "global_master_reports")
public class MasterReport extends ReportAuditable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "report_id")
	private Long reportId;
	@Column(name = "report_name")
	private String reportname;
	@Column(name = "display_order")
	private int displayOrder;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "submodule_id")
	private ReportsSubModule subModule;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "module_id")
	private ReportsModule reportsModule;
	private String url;
	@Column(name = "is_superset_report")
	private Boolean superSetReportExists;
	@OneToMany
	@JoinColumn(name = "report_id")
	private Set<GlobalReportsDivisionMapping> globalReportsDivisionMappings;

	public Long getReportId() {
		return reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

	public String getReportname() {
		return reportname;
	}

	public void setReportname(String reportname) {
		this.reportname = reportname;
	}

	public int getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean isSuperSetReportExists() {
		return superSetReportExists;
	}

	public void setSuperSetReportExists(Boolean superSetReportExists) {
		this.superSetReportExists = superSetReportExists;
	}

	public Set<GlobalReportsDivisionMapping> getGlobalReportsDivisionMappings() {
		return globalReportsDivisionMappings;
	}

	public void setGlobalReportsDivisionMappings(Set<GlobalReportsDivisionMapping> globalReportsDivisionMappings) {
		this.globalReportsDivisionMappings = globalReportsDivisionMappings;
	}
	

}

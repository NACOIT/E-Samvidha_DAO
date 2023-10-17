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
@Table(name = "global_reports_submodule")
public class ReportsSubModule extends ReportAuditable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "submodule_id")
	private Long subModuleId;

	@Column(name = "submodule_name")
	private String subModuleName;
	@Column(name = "display_order")
	private int displayOrder;
	@ManyToOne
	@JoinColumn(name = "module_id")
	private ReportsModule reportsModule;

	public Long getSubModuleId() {
		return subModuleId;
	}

	public void setSubModuleId(Long subModuleId) {
		this.subModuleId = subModuleId;
	}

	public String getSubModuleName() {
		return subModuleName;
	}

	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}

	public int getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	public ReportsModule getReportsModule() {
		return reportsModule;
	}

	public void setReportsModule(ReportsModule reportsModule) {
		this.reportsModule = reportsModule;
	}

}

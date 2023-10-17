package gov.naco.soch.constructordto;

public class GlobalReportsDto {

	private Long reportid;
	private int moduleOrder;
	private String moduleName;
	private int subModuleOrder;
	private String subModuleName;
	private int reportOrder;
	private String reportName;
	private String url;
	private boolean superSetReportExists;
	private Long roleId;

	public Long getReportid() {
		return reportid;
	}

	public void setReportid(Long reportid) {
		this.reportid = reportid;
	}

	public int getModuleOrder() {
		return moduleOrder;
	}

	public void setModuleOrder(int moduleOrder) {
		this.moduleOrder = moduleOrder;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public int getSubModuleOrder() {
		return subModuleOrder;
	}

	public void setSubModuleOrder(int subModuleOrder) {
		this.subModuleOrder = subModuleOrder;
	}

	public String getSubModuleName() {
		return subModuleName;
	}

	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}

	public int getReportOrder() {
		return reportOrder;
	}

	public void setReportOrder(int i) {
		this.reportOrder = i;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public boolean isSuperSetReportExists() {
		return superSetReportExists;
	}

	public void setSuperSetReportExists(boolean superSetReportExists) {
		this.superSetReportExists = superSetReportExists;
	}

}

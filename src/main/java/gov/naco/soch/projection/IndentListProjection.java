package gov.naco.soch.projection;

import java.time.LocalDate;

public interface IndentListProjection {

	Long getIndentId();

	String getIndentNumber();

	LocalDate getIndentDate();

	Long getIndentStatusId();

	String getIndentStatus();

	Long getProcurementAgentId();

	String getProcurementAgentName();

	String getProductName();

	void setIndentId(Long indentId);

	void setIndentNumber(String indentNumber);

	void setIndentDate(LocalDate indentDate);

	void setIndentStatusId(Long indentStatusId);

	void setIndentStatus(String indentStatus);

	void setProcurementAgentId(Long procurementAgentId);

	void setProcurementAgentName(String procurementAgentName);

}

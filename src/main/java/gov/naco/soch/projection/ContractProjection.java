package gov.naco.soch.projection;

import java.time.LocalDateTime;

public interface ContractProjection {

	Long getId();

	String getIndentNumber();

	String getNoaNumber();

	LocalDateTime getAllotmentDate();

	Long getSupplierId();

	String getSupplierName();

	String getContractStatus();

}

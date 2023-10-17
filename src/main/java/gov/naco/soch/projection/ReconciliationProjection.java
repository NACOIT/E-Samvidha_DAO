package gov.naco.soch.projection;

import java.math.BigInteger;

public interface ReconciliationProjection {
	
	BigInteger getPendingReconcileCount();
	
	BigInteger getAvgReconcileDays();

}

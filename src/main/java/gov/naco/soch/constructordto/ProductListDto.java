package gov.naco.soch.constructordto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class ProductListDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private String stiRtiDiasnosysTypeId;
	    
	    private String stiRtiDiasnosysType;
	    
	    private Long productId;
	    
	    private String productName;
	    
	    private List<BatchDetailsDto> activeBatchDetails;
	   
	    private Long facilityId;

		public String getStiRtiDiasnosysTypeId() {
			return stiRtiDiasnosysTypeId;
		}

		public void setStiRtiDiasnosysTypeId(String stiRtiDiasnosysTypeId) {
			this.stiRtiDiasnosysTypeId = stiRtiDiasnosysTypeId;
		}

		public String getStiRtiDiasnosysType() {
			return stiRtiDiasnosysType;
		}

		public void setStiRtiDiasnosysType(String stiRtiDiasnosysType) {
			this.stiRtiDiasnosysType = stiRtiDiasnosysType;
		}

		public Long getProductId() {
			return productId;
		}

		public void setProductId(Long productId) {
			this.productId = productId;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public Long getFacilityId() {
			return facilityId;
		}

		public void setFacilityId(Long facilityId) {
			this.facilityId = facilityId;
		}

		public List<BatchDetailsDto> getActiveBatchDetails() {
			return activeBatchDetails;
		}

		public void setActiveBatchDetails(List<BatchDetailsDto> activeBatchDetails) {
			this.activeBatchDetails = activeBatchDetails;
		}
}

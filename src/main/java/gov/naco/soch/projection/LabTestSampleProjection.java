/**
 * 
 */
package gov.naco.soch.projection;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Pranav MS (144958)
 * @email pranav.sasi@ust-global.com
 * @date 2020-Aug-25 6:23:27 pm 
 * 
 */
public interface LabTestSampleProjection {
	//bdn_serial_number
	public String  getBdn();
	public String setBdn(String bdn);
	
	//artCode
	public String getArtCode();
	public String setArtCode(String artCode);
	
	//facilityName
	public String getFacilityName();
	public String setFacilityName(String facilityName);
	
	//firstName
	public String getFirstName();
	public String setFirstName(String firstName);	
	
	//middleName
	public String getMiddleName();
	public String setMiddleName(String middleName);	
	
	//lastName
	public String getLastName();
	public String setLastName(String lastName);	
	
	//artNumber
	public String getArtNumber();
	public String setArtNumber(String artNumber);
	
	//preArtNumber
	public String getPreArtNumber();
	public String setPreArtNumber(String preArtNumber);
	
	//sampleCollectedDate
	public LocalDateTime getSampleCollectedDate();
	public LocalDateTime setSampleCollectedDate(LocalDateTime sampleCollectedDate);
	
	//sampleReceivedDate
	public LocalDateTime getSampleReceivedDate();
	public LocalDateTime setSampleReceivedDate(LocalDateTime sampleReceivedDate);

	//testTypeId
	public Long getTestTypeId();
	public Long setTestTypeId(Long testTypeId);
	
	//testType
	public String getTestType();
	public String setTestType(String testType);
	
	//batchId
	public Long getBatchId();
	public Long setBatchId(Long batchId);
	
	
	//sampleId
	public Long getSampleId();
	public Long setSampleId(Long sampleId);
	
}


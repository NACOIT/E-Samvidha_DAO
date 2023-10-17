/**
 * 
 */
package gov.naco.soch.projection;

import java.time.LocalDateTime;

/**
 * @author Jiji_145999
 *
 * @date 01-Jan-2021 3:39:54 pm
 */
public interface ArtLabVLPreviousDispatchProjection {
	
	String getMasterBatchStatus();
	Long getBatchId();
	LocalDateTime getDispatchDate();
	String getBdnSerialNumber();
	Long getNumOfSamples();
	LocalDateTime getReceivedDate();
	Long getAcceptedSamples();
	Long getRejectedSamples();
	Long getFacilityId();
	String getFacilityName();
	String getFacilityCode();
	String getFacilityArtCode();
	Long getLabId();
	String getLabName();
	String getLabCode();
	Long getLabFacilityTypeId();
	Long getArtcLabTechUserId();
	String getArtcLabTechUserFirstName();
	String getArtcLabTechUserLastName();
	String getArtcLabTechUserMobile();
	String getLabAddressLineOne();
	String getLabAddressLineTwo();
	Long getVlTechUserId();
	String getVlTechUserFirstName();
	String getVlTechUserLastName();
	String getVlTechUserMobile();
	LocalDateTime getResultReceivedDate();

}

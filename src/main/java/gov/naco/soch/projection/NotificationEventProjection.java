package gov.naco.soch.projection;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import gov.naco.soch.constructordto.MasterDto;
import gov.naco.soch.entity.MasterNotificationEventType;
import gov.naco.soch.entity.NotificationEventRole;

public interface NotificationEventProjection {
	
	Long getEventId();

	@JsonIgnore
	Set<NotificationEventRole> getNotificationEventRoles();

	@JsonIgnore
	MasterNotificationEventType getMasterNotificationEventType();
	
	String getModule();

	String getDescription();

	String getName();

	String getEmailSubject();

	String getEmailTemplate();

	Boolean getIsEnabled();

	String getSmsTemplate();

	String getWhatsappTemplate();
	
	String getWebTemplate();
	
	String getActionUrl();
	
	Boolean getIsWebEnabled();
	
	Boolean getIsSpecific();
	
	Boolean getIsEmailEnabled();
	
	Boolean getIsWhatsappEnabled();
	
	Boolean getIsSmsEnabled();
	
	String getIcon();

	default List<MasterDto> getNotificationEventRole() {
		List<MasterDto> responseList = new ArrayList<>();
		if (!getNotificationEventRoles().isEmpty()) {
			getNotificationEventRoles().forEach(x -> {
				MasterDto masterDto = new MasterDto();
				masterDto.setName(x.getRole().getName());
				masterDto.setId(x.getRole().getId());
				responseList.add(masterDto);
			});

			return responseList;
		}
		return null;
	}
	default MasterDto getMasterNotificationEventTypes() {
		MasterDto masterNotificationEventType = new MasterDto();
		if(getMasterNotificationEventType()!=null) {
			masterNotificationEventType.setId(getMasterNotificationEventType().getId());
			masterNotificationEventType.setName(getMasterNotificationEventType().getName());
		}
		return masterNotificationEventType;
		
	}
}
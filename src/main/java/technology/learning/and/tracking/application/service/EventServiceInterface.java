package technology.learning.and.tracking.application.service;

import java.util.List;

import technology.learning.and.tracking.application.model.CourseEntity;
import technology.learning.and.tracking.application.model.EventEntity;

public interface EventServiceInterface {

	public abstract EventEntity EventRegisterService(EventEntity ev);

	public abstract EventEntity findEventByEid(int eid);

	public abstract EventEntity eventUpdateService(EventEntity ev);

	public abstract int deleteEvent(int eid);

	public abstract List<EventEntity> getAllEvents();


}

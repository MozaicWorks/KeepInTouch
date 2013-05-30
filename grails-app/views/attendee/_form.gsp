<%@ page import="keepintouch.Attendee" %>



<div class="fieldcontain ${hasErrors(bean: attendeeInstance, field: 'location', 'error')} ">
	<label for="location">
		<g:message code="attendee.location.label" default="Location" />
		
	</label>
	<g:textField name="location" value="${attendeeInstance?.location}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: attendeeInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="attendee.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${attendeeInstance?.name}"/>
</div>


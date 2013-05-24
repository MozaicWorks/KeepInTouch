<%@ page import="keepintouch.Attendee" %>



<div class="fieldcontain ${hasErrors(bean: attendeeInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="attendee.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${attendeeInstance?.name}"/>
</div>


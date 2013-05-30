<%@ page import="keepintouch.Attendee" %>

<div class="fieldcontain ${hasErrors(bean: attendeeInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="attendee.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${attendeeInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: attendeeInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="attendee.email.label" default="Email" />
		
	</label>
	<g:textField name="email" value="${attendeeInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: attendeeInstance, field: 'location', 'error')} ">
	<label for="location">
		<g:message code="attendee.location.label" default="Location" />
		
	</label>
	<g:textField name="location" value="${attendeeInstance?.location}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: attendeeInstance, field: 'age', 'error')} ">
	<label for="age">
		<g:message code="attendee.age.label" default="Age" />
		
	</label>
	<g:textField name="age" value="${attendeeInstance?.age}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: attendeeInstance, field: 'twitter', 'error')} ">
	<label for="twitter">
		<g:message code="attendee.twitter.label" default="Twitter" />
		
	</label>
	<g:textField name="twitter" value="${attendeeInstance?.twitter}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: attendeeInstance, field: 'blog', 'error')} ">
	<label for="blog">
		<g:message code="attendee.blog.label" default="Blog" />
		
	</label>
	<g:textField name="blog" value="${attendeeInstance?.blog}"/>
</div>



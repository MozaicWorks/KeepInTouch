
<%@ page import="keepintouch.Attendee" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'attendee.label', default: 'Attendee')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-attendee" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-attendee" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list attendee">
			
				<g:if test="${attendeeInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="attendee.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${attendeeInstance}" field="name"/></span>

				</li>
				</g:if>

                <g:if test="${attendeeInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="attendee.email.label" default="Email" /></span>

						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${attendeeInstance}" field="email"/></span>

				</li>
				</g:if>
				
				<g:if test="${attendeeInstance?.location}">
				<li class="fieldcontain">
					<span id="location-label" class="property-label"><g:message code="attendee.location.label" default="Location" /></span>
					
						<span class="property-value" aria-labelledby="location-label"><g:fieldValue bean="${attendeeInstance}" field="location"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${attendeeInstance?.age}">
				<li class="fieldcontain">
					<span id="age-label" class="property-label"><g:message code="attendee.age.label" default="Age" /></span>
					
						<span class="property-value" aria-labelledby="age-label"><g:fieldValue bean="${attendeeInstance}" field="age"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${attendeeInstance?.twitter}">
				<li class="fieldcontain">
					<span id="twitter-label" class="property-label"><g:message code="attendee.twitter.label" default="Twitter" /></span>
					
						<span class="property-value" aria-labelledby="twitter-label"><g:fieldValue bean="${attendeeInstance}" field="twitter"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${attendeeInstance?.blog}">
				<li class="fieldcontain">
					<span id="blog-label" class="property-label"><g:message code="attendee.blog.label" default="Blog" /></span>
					
						<span class="property-value" aria-labelledby="blog-label"><g:fieldValue bean="${attendeeInstance}" field="blog"/></span>
					
				</li>
				</g:if>
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${attendeeInstance?.id}" />
					<g:link class="edit" action="edit" id="${attendeeInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>

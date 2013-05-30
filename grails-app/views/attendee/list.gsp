
<%@ page import="keepintouch.Attendee" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'attendee.label', default: 'Attendee')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-attendee" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-attendee" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>

      <div id="profiles-carousel" class="carousel slide">
        <ol class="carousel-indicators">
          <li data-target="#profiles-carousel" data-slide-to="0" class="active"></li>
          <li data-target="#profiles-carousel" data-slide-to="1"></li>
          <li data-target="#profiles-carousel" data-slide-to="2"></li>
        </ol>
        <!-- Carousel items -->
        <div class="carousel-inner">
			<g:each in="${attendeeInstanceList}" status="i" var="attendeeInstance">
				<div class="item">
	            	<img src="https://secure.gravatar.com/avatar/dc44752c6b185f3fb904ad639b7d59d1?s=500&d=https%3A%2F%2Fsecure.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D51&r=G" alt="avatar" />
	            	<div class="carousel-caption">
	              		<h4>${fieldValue(bean: attendeeInstance, field: "name")}</h4>
	              		<p>Location: <strong>${fieldValue(bean: attendeeInstance, field: "location")}</strong></p>
	              		<p>Email: <strong>${fieldValue(bean: attendeeInstance, field: "email")}</strong></p>
	            	</div>
          		</div>
				
			</g:each>
	    </div>
        <!-- Carousel nav -->
        <a class="carousel-control left" href="#profiles-carousel" data-slide="prev">&lsaquo;</a>
        <a class="carousel-control right" href="#profiles-carousel" data-slide="next">&rsaquo;</a>
      </div>

			<table>
				<thead>
					<tr>
						<g:sortableColumn property="name" title="${message(code: 'attendee.name.label', default: 'Name')}" />
						
						<g:sortableColumn property="location" title="${message(code: 'attendee.location.label', default: 'Location')}" />
					
						<g:sortableColumn property="email" title="${message(code: 'attendee.email.label', default: 'Email')}" />
						
						<g:sortableColumn property="age" title="${message(code: 'attendee.age.label', default: 'Age')}" />
						
						<g:sortableColumn property="twitter" title="${message(code: 'attendee.twitter.label', default: 'Twitter')}" />
						
						<g:sortableColumn property="blog" title="${message(code: 'attendee.blog.label', default: 'Blog')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${attendeeInstanceList}" status="i" var="attendeeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
                        <td>
                            <g:link action="show" id="${attendeeInstance.id}">${fieldValue(bean: attendeeInstance, field: "name")}</g:link>
                        </td>
						<td>
                            ${fieldValue(bean: attendeeInstance, field: "location")}
                        </td>
                        <td>
                            <avatar:gravatar email="${attendeeInstance.email}"/>
                            ${fieldValue(bean: attendeeInstance, field: "email")}
                        </td>
						<td>
                            ${fieldValue(bean: attendeeInstance, field: "age")}
                        </td>
                        <td>
                            ${fieldValue(bean: attendeeInstance, field: "twitter")}
                        </td>
                        <td>
                            ${fieldValue(bean: attendeeInstance, field: "blog")}
                        </td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${attendeeInstanceTotal}" />
			</div>
		</div>
	</body>
</html>

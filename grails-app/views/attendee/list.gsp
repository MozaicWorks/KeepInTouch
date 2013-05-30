
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

          <div class="active item">
            <img src="https://secure.gravatar.com/avatar/dc44752c6b185f3fb904ad639b7d59d1?s=500&d=https%3A%2F%2Fsecure.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D51&r=G" alt="avatar" />
            <div class="carousel-caption">
              <h4>Robert Calin</h4>
              <p>Now that we know who you are, I know who I am. I'm not a mistake! It all makes sense! In a comic, you know how you can tell who the arch-villain's going to be? He's the exact opposite of the hero. And most times they're friends, like you and me! I should've known way back when... You know why, David? Because of the kids. They called me Mr Glass.</p>
            </div>
          </div>

          <div class="item">
            <img src="https://secure.gravatar.com/avatar/eb2e398ce847e2ca474a74d42d47ff52?s=500&d=https%3A%2F%2Fsecure.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D51&r=G" alt="avatar" />
            <div class="carousel-caption">
              <h4>aimee rivers</h4>
              <p>Now that we know who you are, I know who I am. I'm not a mistake! It all makes sense! In a comic, you know how you can tell who the arch-villain's going to be? He's the exact opposite of the hero. And most times they're friends, like you and me! I should've known way back when... You know why, David? Because of the kids. They called me Mr Glass.</p>
            </div>
          </div>

          <div class="item">
            <img src="https://secure.gravatar.com/avatar/195766b982bba78f88db36b25fab225d?s=500&d=https%3A%2F%2Fsecure.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D51&r=G" alt="avatar" />
            <div class="carousel-caption">
              <h4>Alexandru Bolboaca</h4>
              <p>Now that we know who you are, I know who I am. I'm not a mistake! It all makes sense! In a comic, you know how you can tell who the arch-villain's going to be? He's the exact opposite of the hero. And most times they're friends, like you and me! I should've known way back when... You know why, David? Because of the kids. They called me Mr Glass.</p>
            </div>
          </div>
        </div>
        <!-- Carousel nav -->
        <a class="carousel-control left" href="#profiles-carousel" data-slide="prev">&lsaquo;</a>
        <a class="carousel-control right" href="#profiles-carousel" data-slide="next">&rsaquo;</a>
      </div>

			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="location" title="${message(code: 'attendee.location.label', default: 'Location')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'attendee.name.label', default: 'Name')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${attendeeInstanceList}" status="i" var="attendeeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${attendeeInstance.id}">${fieldValue(bean: attendeeInstance, field: "location")}</g:link></td>
					
						<td>${fieldValue(bean: attendeeInstance, field: "name")}</td>
					
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

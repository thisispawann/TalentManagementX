%{--Include Main Layout--}%
<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <h3><g:message code="member.details" args="['Details']"/></h3>
    </div>
    <div class="card-body">
        <g:if test="${member}">
            <caption>${member.fullName} Details:</caption>
            <table class="table">
                <tr>
                    <th class="text-right"><g:message code="full.name"/> : </th><td class="text-left">${member.fullName}</td>
                </tr>
                <tr>
                    <th class="text-right"><g:message code="email"/> : </th><td class="text-left">${member.email}</td>
                </tr>
                <tr>
                    <th class="text-right"><g:message code="user.type"/> : </th><td class="text-left">${member.memberType}</td>
                </tr>
            </table>
        </g:if>
        <div class="form-action-panel">
            <g:link controller="member" action="index" class="btn btn-danger"><g:message code="cancel"/></g:link>
        </div>
    </div>
</div>
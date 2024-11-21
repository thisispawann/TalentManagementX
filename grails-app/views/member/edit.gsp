%{--Include Main Layout--}%
<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <g:message code="member" args="['Update']"/>
    </div>
    <div class="card-body">
        <g:form controller="member" action="update">
            <g:hiddenField name="id" value="${member.id}"/>
            <g:render template="form" model="[edit:'yes']"/>
            <div class="form-action-panel">
                <g:submitButton class="btn btn-outline-secondary" name="update" value="${g.message(code: "update")}"/>
                <g:link controller="member" action="index" class="btn btn-danger"><g:message code="cancel"/></g:link>
            </div>
        </g:form>
    </div>
</div>
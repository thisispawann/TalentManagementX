%{--Include Main Layout--}%
<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header fs-4">
        <g:message code="member" args="['Create']"/>
    </div>
    <div class="card-body">
        <g:form controller="member" action="save">
%{--    if the form is submitted, then the save action will be called of member controller        --}%

        %{--Partial Templating--}%
            <g:render template="form"/>
            <div class="form-action-panel mt-5">
                <g:submitButton class="btn btn-outline-secondary" name="save" value="${g.message(code: "CreateEmployee")}"/>
                <g:link controller="member" action="index" class="btn btn-danger"><g:message code="cancel"/></g:link>
            </div>
        </g:form>
    </div>
</div>
%{--Include Main Layout--}%
<meta name="layout" content="main"/>

<div class="card" style="margin: 0rem -8rem;">
    <div class="card-header fs-4">
        <g:message code="member" args="['Lists']"/>
        <span class="add-member">
            <div class="form-group">
                <g:if test="${session.USER_ROLE == 'MANAGER'}">
                    <g:link controller="member" action="create" class="btn btn-outline-danger"><i
                            class="fas fa-add"></i> Add Employee</g:link>
                </g:if>
                <g:link controller="member" action="index" class="btn btn-outline-secondary"><i
                        class="fas fa-refresh"></i> Refresh</g:link>
            </div>
        </span>

    </div>

    %{-- Actions --}%
    <span class="d-flex flex-row-reverse my-2 p-2 search-action">
        <div class="btn-group">
            <g:form controller="member" action="index" method="GET" class="form-inline my-lg-0">
                <g:select name="colName" class="form-control select" from="[fullName: 'Full Name', email: 'Email']"
                          value="${params?.colName}" optionKey="key" optionValue="value"/>
                <g:textField name="colValue" class="form-control input" value="${params?.colValue}"/>
                <button class="btn btn-outline-success my-1 my-0 search" type="submit"><i
                        class="fas fa-magnifying-glass"></i> Search</button>
            </g:form>
        </div>
    </span>

    %{-- Table --}%
    <div class="card-body">
        <g:if test="${memberList.isEmpty()}">
            <p style="text-align: center; margin-top: 2rem; font-size: 1.3rem; color: #BA3925">No employees has been added yet!&nbsp;Add new one.</p>
        </g:if>
        <g:else>
            <table class="table table-bordered">
                <thead class="thead-dark">
                <tr style="color:#BA3925; text-decoration: none">
                    <g:sortableColumn property="fullName" title="${g.message(code: "full.name")}"/>
                    <g:sortableColumn property="email" title="${g.message(code: "email")}"/>
                    <th class="action-row"><g:message style="color: #BA3925" code="action"/></th>
                </tr>
                </thead>
                <tbody>
                %{--            in: object to iterate over  var: name of the info --}%
                <g:each in="${memberList}" var="info">
                    <tr>
                        <td>${info?.fullName}</td>
                        <td>${info?.email}</td>
                        <td>
                            <div class="btn-group">
%{--                                <g:if test="${session.USER_ROLE == 'MANAGER' || session.userEmail == info.email}">--}%

                                    <g:link controller="member" action="details" class="btn btn-default"
                                            style="background: #ffd94b80 !important;"
                                            id="${info.id}"><i
                                            class="fas fa-eye"></i> View</g:link>

                                <g:if test="${session.USER_ROLE == 'MANAGER' || session.userEmail == info.email}">
                                    <g:link controller="member" action="edit" class="btn btn-default"
                                            id="${info.id}"
                                            style="margin-left: 3px;"><i
                                            class="fas fa-edit"></i> Update</g:link>
                                </g:if>

                                <g:if test="${session.USER_ROLE == 'MANAGER'}">
                                    <g:if test="${info.email != 'thisispawann@gmail.com'}">
                                        <g:link controller="member" action="deleteConfirmation" id="${info.id}"
                                                class="btn btn-outline-danger" style="margin-left: 3px;"><i
                                                class="fas fa-trash"></i> Delete</g:link>
                                    </g:if>
                                </g:if>
                            </div>
                        </td>
                    </tr>
                </g:each>
                </tbody>
            </table>
        %{-- Pagination --}%
            <div class="paginate">
                <g:paginate total="${total ?: 0}"/>
            </div>
        </g:else>
    </div>
</div>

<div class="alert alert-light text-success" role="alert" id="flashMessage">
    ${flash.message}
</div>
<script>
    var flashMessage = document.getElementById('flashMessage');

    // checking if the flash message element exists and if it has content
    if (flashMessage && flashMessage.innerHTML.trim() !== '') {
        // set a timeout to hide the message after 2 seconds
        setTimeout(function () {
            flashMessage.style.display = 'none'; // hiding the message
        }, 2000);
    }
</script>


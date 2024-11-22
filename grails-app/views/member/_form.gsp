<g:if test="${!login}">
    <div class="form-group">
        <label><g:message code="full.name"/> <strong style="color: red">*</strong></label></label>
    <g:textField name="fullName" class="form-control" value="${member?.fullName}" placeholder="Please Enter Full Name"/>
%{--    if member is available then fullName will be called--}%
    <UIHelper:renderErrorMessage fieldName="fullName" model="${member}" errorMessage="please.enter.full.name"/>
    </div>

</g:if>
<div class="form-group">
    <label><g:message code="email.address"/> <strong style="color: red">*</strong></label></label>
<g:field type="email" id="email" name="email" class="form-control" value="${member?.email}" placeholder="Please Enter Email" required=""/>
<UIHelper:renderErrorMessage fieldName="email" model="${member}" errorMessage="please.enter.email"/>
</div>

<g:if test="${!edit}">
    <div class="form-group">
        <label><g:message code="password"/> <strong style="color: red">*</strong></label>
        <g:passwordField name="password" id="password" class="form-control" value="${member?.password}" placeholder="hidden" required=""/>
        <UIHelper:renderErrorMessage fieldName="password" model="${member}" errorMessage="please.enter.password"/>

        <span id="passwordError" class="text-danger"></span>
    </div>
</g:if>

<script>
    document.addEventListener("DOMContentLoaded", function() {
        // Check if this is the registration form
        var isRegistrationForm = window.location.pathname.includes("/registration");

        if (isRegistrationForm) {
            // Password validation code
            var passwordField = document.getElementById("password");
            var passwordError = document.getElementById("passwordError");
            var passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$/;

            passwordField.addEventListener("input", validatePassword);

            function validatePassword() {
                var password = passwordField.value;

                if (!passwordRegex.test(password)) {
                    passwordError.innerText = " Must be at least 8 characters! \n Must Contains Uppercase letter (A-Z)! \n Must Contains Lowercase letter (a-z)! \n Must Contains at least 1 Special Character (e.g: !@#$%^&*)!";
                } else {
                    passwordError.innerText = "";
                }
            }
        }
    });
</script>

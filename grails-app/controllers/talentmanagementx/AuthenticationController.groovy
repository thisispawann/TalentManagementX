package talentmanagementx

class AuthenticationController {

    AuthenticationService authenticationService
    MemberService memberService

    def login() { // if authenticated then redirect to index
        if (authenticationService.isAuthenticated()) {
            flash.message = "login successful!"
            redirect(controller: 'dashboard', action: 'index')
        }
    }


    def doLogin() { // if email and password is correct then go to index otherwise stay in login
        if (authenticationService.doLogin(params.email, params.password)) {
            //flash.message = "Login Successful..."
            Member member = memberService.getSingleMember(params.email)
            session.setAttribute("USER_ROLE", member.memberType)
            session.setAttribute("userEmail", member.email)
            redirect(controller: "dashboard", action: "index")
        } else {
            //flash.message = AppUtil.infoMessage("Email and Password are not matched!")
            //flash.message = "Registration successful! You can now log in."
            redirect(controller: "authentication", action: "login")
        }
    }

    def logout() {
        render(view: "logoutConfirmation")
    }

    def doLogout() {
        session.invalidate()
        redirect(controller: "authentication", action: "login")
    }

    // registration

    def registration() {
        [member: flash.redirectParams]
    }


    def doRegistration() {
        def response = memberService.save(params)
        if (response.isSuccess) {
            authenticationService.setMemberAuthorization(response.model)
            //flash.message = "Registration successful! You can now log in."
            redirect(controller: "authentication", action: "login")
        } else {
            flash.redirectParams = response.model
            redirect(controller: "authentication", action: "registration")
        }
    }

    // for registration
    def create() {
        [authentication: flash.redirectParams]
        // if someone not filled form and clicked on create button then validation applied
    }

    def save() {
        def response = memberService.save(params)
        if (!response.isSuccess) {
            flash.redirectParams = response.model
            // flash.message
            redirect(controller: "authentication", action: "registration")
        } else {
            //flash.message = AppUtil.infoMessage(g.message(code: "saved"))
            redirect(controller: "authentication", action: "doLogin")
        }
    }
}

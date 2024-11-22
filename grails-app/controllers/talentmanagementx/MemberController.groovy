package talentmanagementx


class MemberController {
    AuthenticationService authenticationService
    MemberService memberService

    def index() { // default method where we can call lists function to view all the members
        def response = memberService.list(params)
        [memberList: response.list, total: response.count] // map the saved data to the gsp page
    }

    def details(Integer id) {
        def response = memberService.getById(id)
        if (!response) {
            redirect(controller: "member", action: "index")
        } else {
            [member: response] // if there is the data, it will render the details page
        }
    }

    def create() {
        [member: flash.redirectParams]// if someone not filled form and clicked on create button then validation applied
    }

    def save() {
        def response = memberService.save(params)
        if (!response.isSuccess) {
            flash.redirectParams = response.model
            redirect(controller: "member", action: "create")
        } else {
            //flash.message = AppUtil.infoMessage(g.message(code: "saved"))
            flash.message = "Data saved successfully!"
            redirect(controller: "member", action: "index")
        }
    }

    def edit(Long id) {
        def loggedInMember = authenticationService.getMember()
        def memberToEdit = Member.get(id)

        if (!memberToEdit) {
            // if the member doesn't exist
            flash.message = "Member not found."
            redirect(controller: "member", action: "index")
            return
        }

//        if (loggedInMember == GlobalConfig.USER_ROLE.MANAGER || loggedInMember.id == memberToEdit.id) {
//        if (loggedInMember == GlobalConfig.USER_ROLE.MANAGER || memberToEdit.id == loggedInMember.id) {
        if (loggedInMember == GlobalConfig.USER_ROLE.MANAGER || loggedInMember.memberType == GlobalConfig.USER_ROLE.MANAGER || loggedInMember.id == memberToEdit.id) {
            if (flash.redirectParams) {
                [member: flash.redirectParams]
            } else {
                [member: memberToEdit]
            }
        } else {
            // displaying an error message if neither manager nor the member themselves
            flash.message = "You are not AUTHORIZED to update this member."
            redirect(controller: "dashboard", action: "index")
        }
    }

    def update() {
        def response = memberService.getById(params.id)
        if (!response) {
            redirect(controller: "member", action: "index")
        } else {
            response = memberService.update(response, params)
            if (!response.isSuccess) {
                flash.redirectParams = response.model
                redirect(controller: "member", action: "edit") // if not update success, redirect to edit page
            } else {
                redirect(controller: "member", action: "index")
            }
        }
    }

    def delete(Integer id) {
        def response = memberService.getById(id) // select data by getById() and implement delete() in service layer
        if (!response) {
            redirect(controller: "member", action: "index")
        } else {
            response = memberService.delete(response)
            redirect(controller: "member", action: "index")
        }
    }

    def deleteConfirmation(Integer id) {
        def controller = "member" // controller for Member
        def action = "delete" // action for Member
//        [controller: controller, action: action, id: id] // for single instance
        render(view: '/shared/deleteConfirmation', model: [controller: controller, action: action, id: id])

    }

}

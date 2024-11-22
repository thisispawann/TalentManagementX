package talentmanagementx

class UIHelperTagLib {
    static namespace = "UIHelper"

    AuthenticationService authenticationService

    def renderErrorMessage = { attrs, body ->
        def model = attrs.model
        String fieldName = attrs.fieldName
        String errorMessage = attrs.errorMessage? g.message(code: attrs.errorMessage): g.message(code: "invalid.input")
        if (model && model.errors && model.errors.getFieldError(fieldName)){
            out << "<small class='form-text text-danger''><strong>${errorMessage}</strong></small>"
        }
    }

    def memberActionMenu = { attrs, body ->
        out << '<li class=" dropdown">'
        out << g.link(class:"name-link"){
            authenticationService.getMemberName()
        }
//        out << '<div class="dropdown-menu show">'
//        out << g.link(controller: "authentication", action: "logout", class: "dropdown-item"){g.message(code:"logout")}
//        out << "</div></li>"
    }

    def rightNavigation = { attrs, body ->
        List navigations = [
                [controller: "dashboard", action: "index", name: "dashboard"],
                [controller: "leave", action: "index", name: "leave"],
                [controller: "member", action: "index", name: "employee"],

        ]

        if(authenticationService.isAdministratorMember()){
            navigations.add([controller: "salary", action: "index", name: "salary"])
//            navigations.add([controller: "member", action: "index", name: "employee"])
        }

        navigations.each { menu ->
            out << '<li class="list-group-item">'
            out << g.link(controller: menu.controller, action: menu.action) { g.message(code: menu.name, args: ['']) }
            out << '</li>'
        }
    }

}

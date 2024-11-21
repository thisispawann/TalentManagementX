package talentmanagementX

class UIHelperTagLib {

    static namespace = "UIHelper"

    def rightNavigation = { attrs, body ->
        List navigations = [
                [controller: "dashboard", action: "index", name: "dashboard"],
                [controller: "leave", action: "index", name: "leave"],
                [controller: "member", action: "index", name: "employee"],

        ]

    }
}
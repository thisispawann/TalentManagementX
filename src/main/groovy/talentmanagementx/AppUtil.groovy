package talentmanagementx

import org.grails.web.util.WebUtils

// this class is responsible for some utility function like response, session
class AppUtil {
    // will be used in controller
    static saveResponse(Boolean isSuccess, def model) {
        return [isSuccess: isSuccess, model: model]
    }

    // session
    static getAppSession() {
        return WebUtils.retrieveGrailsWebRequest().session
    }

    // throw some message one controller to another
    static infoMessage(String message, boolean status = true) {
        return [info: message, success: status]
    }
}

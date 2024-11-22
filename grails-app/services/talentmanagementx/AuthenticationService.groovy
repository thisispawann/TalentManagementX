package talentmanagementx
//import org.mindrot.jbcrypt.BCrypt


class AuthenticationService {
    private static final String AUTHORIZED = "AUTHORIZED"

    def setMemberAuthorization(Member member) {
        def authorization = [isLoggedIn: true, member: member]
        AppUtil.getAppSession()[AUTHORIZED] = authorization
    }

    def doLogin(String email, String password, boolean isEmployee = false) {
        // Encode the password using MD5 for both roles
        password = password.encodeAsMD5()

        Member member
        if (isEmployee) {
            // For employee role, find by email only and compare encoded password
            member = Member.findByEmail(email)
            if (member && member.password == password) {
                setMemberAuthorization(member)
                return true
            }
        } else {
            // For regular member, find by email and password
            member = Member.findByEmailAndPassword(email, password)
            if (member != null) {
                setMemberAuthorization(member)
                return true
            }
        }
        return false
    }

    boolean isAuthenticated() {
        def authorization = AppUtil.getAppSession()[AUTHORIZED]
        if (authorization && authorization.isLoggedIn) {
            return true
        }
        return false
    }

    def getMember() {
        def authorization = AppUtil.getAppSession()[AUTHORIZED]
        return authorization?.member
    }

    def getMemberName() {
        def member = getMember()
        return "Logged in as : ${member.fullName}"
    }

    def isAdministratorMember(){
        def member = getMember()
        if (member && member.memberType == GlobalConfig.USER_ROLE.MANAGER){
            return true
        }
        return false
    }

    def isEmployeeMember() {
        def member = getMember()
        if (member && member.memberType == GlobalConfig.USER_ROLE.EMPLOYEE){
            return true
        }
    }


}

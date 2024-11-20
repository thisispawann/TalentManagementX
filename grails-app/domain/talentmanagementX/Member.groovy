package talentmanagementX

class Member {
    Integer id
    String fullName
    String email
    String password
    String memberType = GlobalConfig.USER_ROLE.EMPLOYEE
    Date dateCreated

    static constraints = {
        fullName(blank: false)
        email(email: true, nullable: false, blank: false, unique: true)

    }

    // has password with MD5()
    def beforeInsert() {
        this.password = this.password.encodeAsMD5()

    }

    def beforeUpdate() {
        this.password = this.password.encodeAsMD5()

    }
}


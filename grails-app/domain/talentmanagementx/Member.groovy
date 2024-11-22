package talentmanagementx

class Member {
    Integer id
    String fullName
    String email
    String password
    String memberType = GlobalConfig.USER_ROLE.EMPLOYEE
    Date dateCreated

    static hasMany = [leave: Leave]

    static constraints = {
        fullName(blank: false)
        email(email:true, nullable: false, blank: false, unique: true)
    }

    def beforeInsert() {
        this.password = this.password.encodeAsMD5()
    }

    def beforeUpdate() {
        this.password = this.password.encodeAsMD5()
    }
}

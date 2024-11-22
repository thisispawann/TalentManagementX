package talentmanagementx


class Leave {
    Integer id
    String leave_type
    Date start_date
    Date end_date
    String leave_reason
    String status

    Member member

    // Reference To Employee and Manager
    static belongsTo = [member : Member]

    static constraints = {
        leave_type(blank:false, maxSize: 255)
        start_date(blank: false)
        end_date(blank: false)
        leave_reason(blank: false, maxSize: 255)
        member(nullable: false)
        status(nullable: false)
    }

}


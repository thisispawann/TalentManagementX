package talentmanagementx

class GlobalConfig {
    public static final def USER_ROLE = [
            MANAGER: "MANAGER",
            EMPLOYEE: "EMPLOYEE",
    ]

    public static Integer itemsPerPage() {
        return 7
    }
}

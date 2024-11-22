package talentmanagementx

import grails.web.servlet.mvc.GrailsParameterMap

import javax.transaction.Transactional

@Transactional
class MemberService {

    // when controller parameter is set with same name as a request parameter, the controller parameter is retrieved
    def save(GrailsParameterMap params) {
        Member member = new Member(params)
        def response = AppUtil.saveResponse(false, member)
        if (member.validate()) {
            member.save(flush: true)
            if (!member.hasErrors()){
                response.isSuccess = true
            }
        }
        return response
    }

    def update(Member member, GrailsParameterMap params) {
        member.properties = params
        def response = AppUtil.saveResponse(false, member)
        if (member.validate()) {
            member.save(flush:true)
            if (!member.hasErrors()){
                response.isSuccess = true
            }
        }
        return response
    }

    def getById(Serializable id) {
        return Member.get(id)
    }

    // for case-insensitive for email: ram@gmail.com or Ram@gmail.com to find ram@gmail.com
    def list(GrailsParameterMap params) {
        params.max = params.max ?: GlobalConfig.itemsPerPage()
        List<Member> memberList = Member.createCriteria().list(params) {
            if (params?.colName && params?.colValue) {
                if (params.colName == "email") {
                    // Case-insensitive search for email addresses
                    ilike("email", params.colValue.toLowerCase() + "%") // ilike can be used instead of like to make the match case insensitive
                } else {
                    // For other columns, perform a case-insensitive search
                    ilike(params.colName, "%" + params.colValue + "%")
                }
            }
            if (!params.sort) {
                order("id", "desc")
            }
        }
        return [list: memberList, count: Member.count()]
    }

    def delete(Member member) {
        try {
            member.delete(flush: true)
        } catch (Exception e) {
            println(e.getMessage())
            return false
        }
        return true
    }

    def totalEmployeeCount() {
        Member.count();
    }


    def getSingleMember(String email) {
        try{
            Member member = Member.findByEmail(email)
            return member
        }catch (Exception e) {
            println(e.getMessage())
            return false
        }
    }
}

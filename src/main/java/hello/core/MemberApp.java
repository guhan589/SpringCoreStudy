package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    
    //psvm 단축키
    public static void main(String[] args) {
        /*AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();*/



        //★★★★★★
        //  Spring은 ApplicationContext에서 시작을 하고 이것을 SpringContainer라고 생각해야함
        ApplicationContext applicanetionContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //  -> AppConfig Class에 있는 Bean어노테이션이 붙어있는 메서드를 Spring에 등록

        MemberService memberService = applicanetionContext.getBean("memberService", MemberService.class);
        //memberSerivce는 AppConfig Class에 메서드 이름을 적는다

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());

    }
}

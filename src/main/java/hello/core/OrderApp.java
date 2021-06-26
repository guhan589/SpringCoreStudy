package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderSerivce;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

       /* AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        OrderSerivce orderSerivce = appConfig.orderSerivce();*/

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderSerivce orderSerivce = ac.getBean("orderSerivce", OrderSerivce.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order itemA = orderSerivce.createOrder(memberId, "itemA", 10000);
        System.out.println("itemA = " + itemA);

    }
}

package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OrderSerivce;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    
    /**
     * MemberRepository 와 DiscountPolicy 를 return 하는 메서드를 만들경우 가독성이 향상과 
     * 코드의 관리가 쉬워짐
     * */
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderSerivce orderSerivce() {
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}

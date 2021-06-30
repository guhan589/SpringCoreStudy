package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OrderSerivce;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration  //애플리케이션의 구성정보를 담당하는 configuration 에노테이션
                // Configuration을 적지 않으면 AppConfig 클래스는 싱글톤(Singletone)으로 생성 되지 않는다.\
// 즉 MemberRepository 는 총 3번 (cintainer에 등록과 각 memberService/ orderService 메서드 호출 시 생성)
public class AppConfig{
    /**
     * 제어의 역전: IOC(Inversion of Control)
     * 프로그램의 제어 흐름을 직접 제어하는 것이 아니라 외부에서 관리하는 것을 제어의 역전 이라고 한다.
     * */


    /**
     * MemberRepository 와 DiscountPolicy 를 return 하는 메서드를 만들경우 가독성이 향상과 
     * 코드의 관리가 쉬워짐
     * */

    @Bean //Bean은 SpringContainer에 bean을 등록
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }


    //★★★★ Bean등록은 메서드 이름을 그대로 bean등록 / 이름변경이 가능하다.
    // @Bean(name = "orderService1")
    @Bean
    public OrderSerivce orderService() {
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    @Bean
    //MemberRespository 구현체 생성
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    //DiscountPolicy 구현체 생성
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}

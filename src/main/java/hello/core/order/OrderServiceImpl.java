package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderSerivce{
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //DIP 위반 ★★★★★
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();


    /**
     * DI(Dependency Injection)규칙과 OCP 규칙 지킴
     * OCP(개방 폐쇄 원칙) - 확장에 대해서는 열려있고 수정에 대해서는 닫혀있다.
     *
    * */

    /**
     * 의존관계는 정적인 클래스 의존 관게와
     * 실행 시점에 결정되는 동적인 객체인스턴스) 의존관계 둘을 분리해서 생각해야 함.
     *
     * import를 보고 의존관계 분석이 가능하다.
     * */
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;


    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

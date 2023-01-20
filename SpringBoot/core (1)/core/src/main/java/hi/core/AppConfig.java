package hi.core;

import hi.core.discount.DiscountPolicy;
import hi.core.discount.FixDiscountPolicy;
import hi.core.discount.RateDiscountPolicy;
import hi.core.member.MemberRepository;
import hi.core.member.MemberService;
import hi.core.member.MemberServiceImpl;
import hi.core.member.MemoryMemberRepository;
import hi.core.order.OrderService;
import hi.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}

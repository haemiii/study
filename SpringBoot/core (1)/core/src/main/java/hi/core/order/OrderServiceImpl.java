package hi.core.order;

import hi.core.discount.DiscountPolicy;
import hi.core.discount.FixDiscountPolicy;
import hi.core.discount.RateDiscountPolicy;
import hi.core.member.Member;
import hi.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    // DiscountPolicy discountPolicy = new FixDiscountPolicy();


    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository,
                            @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    // 1.생성자 방식의 의존관계 주입
//    @Autowired
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    // 2.setter 방식의 의존관계 주입 : 자바빈 프로퍼티 규약
//    @Autowired(required = false)  //required = false : 주입할 대상이 없어도 동작
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }

    // 3.필드 주입 방식
//    @Autowired
//    private MemberRepository memberRepository;
//    @Autowired
//    private DiscountPolicy discountPolicy;

    // 4.메서드 주입 방식
    /*@Autowired
    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }*/

    // 호출 안됨!
//    @Autowired(required = false)
//    public void setNoBean1(Member member) {
//        System.out.println("setNoBean1 = " + member);
//    }
//    //null 호출
//    @Autowired
//    public void setNoBean2(@Nullable Member member) {
//        System.out.println("setNoBean2 = " + member);
//    }
//    //Optional.empty 호출
//    @Autowired(required = false)
//    public void setNoBean3(Optional<Member> member) {
//        System.out.println("setNoBean3 = " + member);
//    }
//
//    public MemberRepository getMemberRepository() {
//        return memberRepository;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice,discountPrice);
    }

}

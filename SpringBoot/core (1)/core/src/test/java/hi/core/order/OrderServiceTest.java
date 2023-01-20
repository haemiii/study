package hi.core.order;

import hi.core.member.Grade;
import hi.core.member.Member;
import hi.core.member.MemberService;
import hi.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void vip_o() {
        Member member = new Member(2L, "memberVIP", Grade.VIP);
        memberService.join(member);

        Order chair = orderService.createOrder(member.getId(), "chair", 10000);
        Assertions.assertThat(chair.getDiscountPrice()).isEqualTo(1000);
    }
}

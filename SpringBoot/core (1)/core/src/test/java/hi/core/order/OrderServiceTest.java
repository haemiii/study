package hi.core.order;

import hi.core.AppConfig;
import hi.core.member.Grade;
import hi.core.member.Member;
import hi.core.member.MemberService;
import hi.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void vip_o() {
        Member member = new Member(2L, "memberVIP", Grade.VIP);
        memberService.join(member);

        Order chair = orderService.createOrder(member.getId(), "chair", 10000);
        Assertions.assertThat(chair.getDiscountPrice()).isEqualTo(1000);
    }
}

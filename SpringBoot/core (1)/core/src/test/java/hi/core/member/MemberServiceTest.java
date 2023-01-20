package hi.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        Member member = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member);

        Member member1 = memberService.findMember(1L);

        Assertions.assertThat(member).isEqualTo(member1);

    }
}

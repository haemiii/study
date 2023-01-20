package hi.core.discount;

import hi.core.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}

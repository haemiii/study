package hi.core.discount;

import hi.core.member.Grade;
import hi.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return 1000;
        }else {
            return 0;
        }
    }
}

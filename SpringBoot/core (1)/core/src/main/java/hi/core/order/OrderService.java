package hi.core.order;

import hi.core.member.Member;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}

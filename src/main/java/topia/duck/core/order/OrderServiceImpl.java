package topia.duck.core.order;

import topia.duck.core.discount.DiscountPolicy;
import topia.duck.core.discount.FixDiscountPolicy;
import topia.duck.core.member.Member;
import topia.duck.core.member.MemberRepository;
import topia.duck.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements  OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

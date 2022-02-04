package topia.duck.core;

import topia.duck.core.discount.DiscountPolicy;
import topia.duck.core.discount.FixDiscountPolicy;
import topia.duck.core.member.MemberRepository;
import topia.duck.core.member.MemberService;
import topia.duck.core.member.MemberServiceImpl;
import topia.duck.core.member.MemoryMemberRepository;
import topia.duck.core.order.OrderService;
import topia.duck.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }


}

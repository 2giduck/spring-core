package topia.duck.core;

import topia.duck.core.discount.FixDiscountPolicy;
import topia.duck.core.member.MemberService;
import topia.duck.core.member.MemberServiceImpl;
import topia.duck.core.member.MemoryMemberRepository;
import topia.duck.core.order.OrderService;
import topia.duck.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }


}

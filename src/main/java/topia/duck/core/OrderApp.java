package topia.duck.core;

import topia.duck.core.member.Grade;
import topia.duck.core.member.Member;
import topia.duck.core.member.MemberService;
import topia.duck.core.member.MemberServiceImpl;
import topia.duck.core.order.Order;
import topia.duck.core.order.OrderService;
import topia.duck.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}

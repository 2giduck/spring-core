package topia.duck.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import topia.duck.core.discount.DiscountPolicy;
import topia.duck.core.discount.RateDiscountPolicy;
import topia.duck.core.member.MemberRepository;
import topia.duck.core.member.MemberService;
import topia.duck.core.member.MemberServiceImpl;
import topia.duck.core.member.MemoryMemberRepository;
import topia.duck.core.order.OrderService;
import topia.duck.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }


}

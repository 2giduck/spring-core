package topia.duck.core.order;

import org.junit.jupiter.api.Test;
import topia.duck.core.discount.FixDiscountPolicy;
import topia.duck.core.member.Grade;
import topia.duck.core.member.Member;
import topia.duck.core.member.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceImplTest {

    @Test
    void createOrder(){
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}

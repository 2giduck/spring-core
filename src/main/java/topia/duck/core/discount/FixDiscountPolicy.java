package topia.duck.core.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import topia.duck.core.annotation.MainDiscountPolicy;
import topia.duck.core.member.Grade;
import topia.duck.core.member.Member;

@Component
@MainDiscountPolicy
public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000;


    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}

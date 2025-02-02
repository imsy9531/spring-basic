package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 10% 할인이 적용되어야 한다ㅏ.")
    void vip_o() {
        // given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        // when
        int discount = rateDiscountPolicy.discount(member, 10000);
        // then
        assertEquals(1000, discount);
    }

    @Test
    @DisplayName("VIP 아니면 할인 적용 안돼야 한다.")
    void vip_x() {
        // given
        Member member = new Member(1L, "memberVIP", Grade.BASIC);
        // when
        int discount = rateDiscountPolicy.discount(member, 10000);
        // then
        assertEquals(discount, 0);
    }
}
package com.study.core.discount;

import com.study.core.member.Grade;
import com.study.core.member.Member;

public class FixDicountPolicy implements DiscountPolicy{

    private int discountFixAmount=1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}

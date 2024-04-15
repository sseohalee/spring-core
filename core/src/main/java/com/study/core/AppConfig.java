package com.study.core;

import com.study.core.discount.DiscountPolicy;
import com.study.core.discount.FixDicountPolicy;
import com.study.core.member.MemberRepository;
import com.study.core.member.MemberService;
import com.study.core.member.MemberServiceImpl;
import com.study.core.member.MemoryMemberRepository;
import com.study.core.order.OrderService;
import com.study.core.order.OrderServiceImpl;

// 애플리케이션의 실제 동작에 필요한 "구현 객체"를 생성한다.
public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDicountPolicy();
    }
}

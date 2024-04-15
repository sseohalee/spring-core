package com.study.core.order;

import com.study.core.discount.DiscountPolicy;
import com.study.core.discount.FixDicountPolicy;
import com.study.core.member.Member;
import com.study.core.member.MemberRepository;
import com.study.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    // 회원과 할인 관련
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDicountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member=memberRepository.findById(memberId);

        // 등급만 넘겨도 되지만, 미래 확장성을 고려해 member를 통째로 넘김
        // 등급 or member는 개발 시 프로젝트 상황에 맞춰 유동적으로 변경(선택) 가능
        int discountPrice = discountPolicy.discount(member,itemPrice);

        // discountPrice 계산해서 정보 추가해서 넘겨주기
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

package com.study.core.member;

public interface MemberService {
    void join(Member member);

    Member findMEmber(Long memberId);
}

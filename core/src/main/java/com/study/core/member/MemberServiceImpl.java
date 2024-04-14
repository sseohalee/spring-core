package com.study.core.member;

public class MemberServiceImpl implements  MemberService{
    // 멤버 리파지토리 = new 메모리멤버리파지토리 -> 멤버 인터페이스 = new 멤버 구현객체 -> 갈아 끼우기 쉽게
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMEmber(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

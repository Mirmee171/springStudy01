package hello.core.member;

public class MemberServiceImpl implements MemberService {

    //인터페이스만 가지고 있으면 nullPointerException 이 터지기 때문에 구현객체를 선택해줌
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

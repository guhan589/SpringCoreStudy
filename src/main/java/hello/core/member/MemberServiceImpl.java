package hello.core.member;

public class MemberServiceImpl implements MemberService {
// impl은 인터페이스 구현체가 하나일 경우 class이름에 impl사용
//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;

    }

    @Override

    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long numberId) {
        return memberRepository.findById(numberId);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

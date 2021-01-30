package poolc.poolc.Repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import poolc.poolc.Repository.MemberRepository;
import poolc.poolc.Service.MemberService;
import poolc.poolc.domain.Member;
import poolc.poolc.domain.ProjectMember;

import javax.persistence.EntityManager;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EntityManager em;

    @Test
    public void 회원가입() throws Exception{
        List<ProjectMember> projectMembers = new ArrayList<>();
        String a = "ddd";
        Member member = new Member("1", "anfro2520", "jasotn12@naver.com", "010-4595-9147", "hyungchulpak",
                "ComputerScience", "2015147514", false, false, LocalDateTime.now(), LocalDateTime.now(), "pass",
                LocalDateTime.now(),"aaa","나는 박형철이다", false, a.getBytes(), a.getBytes(), projectMembers );

        memberRepository.save(member);
    }


    @Test
    public void 모든회원조회() throws Exception{
        List<ProjectMember> projectMembers = new ArrayList<>();
        String a = "ddd";
        Member member1 = new Member("1", "anfro2520", "jasotn12@naver.com", "010-4595-9147", "hyungchulpak",
                "ComputerScience", "2015147514", false, false, LocalDateTime.now(), LocalDateTime.now(), "pass",
                LocalDateTime.now(),"aaa","나는 박형철이다", false, a.getBytes(), a.getBytes(), projectMembers );
        Member member2 = new Member("2", "ppp", "anfr2520@gmail.com", "010-1111-2222", "ppp",
                "ComputerScience", "2016147514", false, false, LocalDateTime.now(), LocalDateTime.now(), "pass",
                LocalDateTime.now(),"aaa","나는 ppp이다", false, a.getBytes(), a.getBytes(), projectMembers );
        memberRepository.save(member1);
        memberRepository.save(member2);
        List<Member> members = memberRepository.findAll();
        for (Member member : members) {
            System.out.println("member = " + member);
        }
    }

    @Test
    public void UUID회원찾기() throws Exception{
        List<ProjectMember> projectMembers = new ArrayList<>();
        String a = "ddd";
        Member member = new Member("1", "anfro2520", "jasotn12@naver.com", "00-4595-9147", "hyungchulpak",
                "ComputerScience", "2015147514", false, false, LocalDateTime.now(), LocalDateTime.now(), "pass",
                LocalDateTime.now(),"aaa","나는 박형철이다", false, a.getBytes(), a.getBytes(), projectMembers );

        memberRepository.save(member);
        em.flush();
        em.clear();
        System.out.println(member);
        Member findMember = memberRepository.findOne("1");
        member.equals(findMember);
    }


    @Test
    public void 이메일로회원찾기() throws Exception{
        List<ProjectMember> projectMembers = new ArrayList<>();
        String a = "ddd";
        Member member = new Member("1", "anfro2520", "jasotn12@naver.com", "010-4595-9147", "hyungchulpak",
                "ComputerScience", "2015147514", false, false, LocalDateTime.now(), LocalDateTime.now(), "pass",
                LocalDateTime.now(),"aaa","나는 박형철이다", false, a.getBytes(), a.getBytes(), projectMembers );

        memberRepository.save(member);
        em.flush();
        em.clear();
        System.out.println(member);
        Member findMember = memberRepository.findByEmail("jasotn12@naver.com");
        member.equals(findMember);
    }

    @Test
    public void 회원가입_후_탈퇴() throws Exception{
        List<ProjectMember> projectMembers = new ArrayList<>();
        String a = "ddd";
        Member member = new Member("1", "anfro2520", "jasotn12@naver.com", "010-4595-9147", "hyungchulpak",
                "ComputerScience", "2015147514", false, false, LocalDateTime.now(), LocalDateTime.now(), "pass",
                LocalDateTime.now(),"aaa","나는 박형철이다", false, a.getBytes(), a.getBytes(), projectMembers );
        memberRepository.save(member);
        memberRepository.delete(member);

        Member findMember = memberRepository.findOne("1");
        assertNotEquals(findMember,member);
    }

}
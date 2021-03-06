package org.poolc.api.board;

import lombok.RequiredArgsConstructor;
import org.poolc.api.board.domain.Board;
import org.poolc.api.board.repository.BoardRepository;
import org.poolc.api.member.domain.MemberRole;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("boardTest")
@RequiredArgsConstructor
public class BoardDataLoader implements CommandLineRunner {
    private final BoardRepository boardRepository;

    @Override
    public void run(String... args) {
        boardRepository.save(
                new Board("공지사항", "notice", 0L, MemberRole.PUBLIC, MemberRole.ADMIN)
        );
        boardRepository.save(
                new Board("자유게시판", "free", 0L, MemberRole.MEMBER, MemberRole.MEMBER)
        );
        boardRepository.save(
                new Board("구인홍보게시판", "recruit", 0L, MemberRole.MEMBER, MemberRole.MEMBER)
        );
        boardRepository.save(
                new Board("학술게시판", "study_priv", 0L, MemberRole.MEMBER, MemberRole.MEMBER)
        );
        boardRepository.save(
                new Board("게임제작부", "gamedev", 0L, MemberRole.MEMBER, MemberRole.MEMBER)
        );
        boardRepository.save(
                new Board("임원진", "meeting", 0L, MemberRole.ADMIN, MemberRole.ADMIN)
        );
        boardRepository.save(
                new Board("삭제할게시판", "willbedeleted", 0L, MemberRole.PUBLIC, MemberRole.MEMBER)
        );
        boardRepository.save(
                new Board("수정할게시판", "updateBoard", 0L, MemberRole.PUBLIC, MemberRole.MEMBER)
        );
        boardRepository.save(
                new Board("페이지네이션확인게시판", "pagination", 0L, MemberRole.PUBLIC, MemberRole.PUBLIC)
        );
    }
}

package a_assignment.day_03;

import java.util.List;

public class Day02Mission03 {
    public static void main(String[] args) {
        //게시글 용 VO
        //게시글용 DAO
        //Main - 모든 함수 사용 및 출력

        BoardDao boardService = new BoardDao();

        //입력
        boardService.insertBoard("첫번째 게시글", "안녕하세요", "황한슬");
        boardService.insertBoard("두번째 게시글", "반가워요", "삼성");
        boardService.insertBoard("세번째 게시글", "하이", "Kim");
        boardService.insertBoard("네번째 게시글", "HI!", "James");

        // 하나 검색
        BoardVo boardVo = boardService.selectById(1);
        System.out.println("1번 게시글 = " + boardVo);

        //전체 검색
        List<BoardVo> allPosts = boardService.selectAll();
        allPosts.forEach(e -> System.out.println("게시글 조회 : " + e));

        //검색어 검색
        List<BoardVo> selectByCond = boardService.selectByCondition("첫번째");
        selectByCond.forEach(e -> System.out.println("검색어 조회(첫번째) : " + e));

        //삭제
        boolean isDeleted = boardService.deleteById(1);
        if (isDeleted) {
            System.out.println("삭제됨. 남은 게시글 : " + boardService.countAll());
        } else {
            System.out.println("존재하지 않는 key");
        }

        //수정
        boolean isUpdated = boardService.updateBoard(2, "삼성", "첫번째 게시글", "하이요");
        if (isUpdated) {
            System.out.println("수정 성공");
            BoardVo updatePost = boardService.selectById(2);
            System.out.println("수정 후 데이터 : " + updatePost);
        }

    }
}

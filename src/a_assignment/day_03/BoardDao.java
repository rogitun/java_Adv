package a_assignment.day_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BoardDao {
    private static final HashMap<Integer, BoardVo> database;
    private static int IDX;

    static {
        database = new HashMap<>();
        IDX = 0;
    }

    public void insertBoard(String title, String content, String writer) {
        BoardVo boardVo = new BoardVo(++IDX, title, content, writer);
        database.put(IDX, boardVo);
    }

    public BoardVo selectById(int boardId) {
        Optional<BoardVo> boardOpt = Optional.ofNullable(database.get(boardId));
        return boardOpt.orElseThrow();
    }

    public List<BoardVo> selectAll() {
        return new ArrayList<>(database.values());
    }

    public boolean updateBoard(int boardId, String writer, String title, String content) {
        Optional<BoardVo> boardOpt = Optional.ofNullable(database.get(boardId));
        if (boardOpt.isEmpty()) {
            return false;
        }
        BoardVo boardVo = boardOpt.get();
        if (!boardVo.getWriter().equals(writer)) {
            return false;
        }

        boardVo.setTitle(title);
        boardVo.setContent(content);
        return true;
    }

    public boolean deleteById(int boardIdx) {
        boolean isPresent = database.containsKey(boardIdx);
        if (isPresent) {
            database.remove(boardIdx);
            return true;
        } else {
            return false;
        }
    }

    public List<BoardVo> selectByCondition(String condition) {
        return database.values()
                .stream()
                .filter(e -> e.getTitle().contains(condition) || e.getContent().contains(condition))
                .collect(Collectors.toList());
    }


    public int countAll() {
        return database.size();
    }
}

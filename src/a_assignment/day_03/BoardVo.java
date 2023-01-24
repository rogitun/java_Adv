package a_assignment.day_03;

public class BoardVo {
    private int boardIdx;
    private String title;
    private String content;
    private String writer;

    @Override
    public String toString() {
        return "BoardVo{" +
                "boardIdx=" + boardIdx +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }

    public BoardVo(int boardIdx, String title, String content, String writer) {
        this.boardIdx = boardIdx;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public int getBoardIdx() {
        return boardIdx;
    }

    public void setBoardIdx(int boardIdx) {
        this.boardIdx = boardIdx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}

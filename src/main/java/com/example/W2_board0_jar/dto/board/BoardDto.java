package com.example.W2_board0_jar.dto.board;

public class BoardDto {

    // 게시글 유형
    private String boardType;
    
    // 게시글 번호
    private int boardNum;
    
    // 게시글 제목
    private String boardTitle;
    
    // 게시글 내용
    private String boardComment;

    // 작성자
    private String creater;

    // 작성시간
    private String createTime;

    // 수정자
    private String modifier;

    // 수정시간
    private String modifiedTime;

    // 파일경로
    private String fileRoot;

    public BoardDto(String boardType, int boardNum, String boardTitle, String boardComment, String creater, String createTime, String modifier, String modifiedTime, String fileRoot) {
        this.boardType = boardType;
        this.boardNum = boardNum;
        this.boardTitle = boardTitle;
        this.boardComment = boardComment;
        this.creater = creater;
        this.createTime = createTime;
        this.modifier = modifier;
        this.modifiedTime = modifiedTime;
        this.fileRoot = fileRoot;
    }

    public String getBoardType() {
        return boardType;
    }

    public void setBoardType(String boardType) {
        this.boardType = boardType;
    }

    public int getBoardNum() {
        return boardNum;
    }

    public void setBoardNum(int boardNum) {
        this.boardNum = boardNum;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardComment() {
        return boardComment;
    }

    public void setBoardComment(String boardComment) {
        this.boardComment = boardComment;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getFileRoot() {
        return fileRoot;
    }

    public void setFileRoot(String fileRoot) {
        this.fileRoot = fileRoot;
    }

}

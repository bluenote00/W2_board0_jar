package com.example.W2_board0_jar.dto.board;

public class BoardDto {

    // 게시글 유형
    private String boardType;

    // 게시글 유형
    private String boardTypeName;
    
    // 게시글 번호
    private int boardNum;
    
    // 게시글 제목
    private String boardTitle;
    
    // 게시글 내용
    private String boardComment;

    // 작성자
    private String creator;

    // 작성시간
    private String createTime;

    // 수정자
    private String modifier;

    // 수정시간
    private String modifiedTime;

    // 파일명
    private String fileName;
    
    // 파일경로
    private String fileRoot;

    public BoardDto() {}

    public String getBoardType() {
        return boardType;
    }

    public void setBoardType(String boardType) {
        this.boardType = boardType;
    }

    public String getBoardTypeName() {
        return boardTypeName;
    }

    public void setBoardTypeName(String boardTypeName) {
        this.boardTypeName = boardTypeName;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileRoot) {
        this.fileName = fileName;
    }

    public String getFileRoot() {
        return fileRoot;
    }

    public void setFileRoot(String fileRoot) {
        this.fileRoot = fileRoot;
    }

}

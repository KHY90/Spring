package com.ohgiraffers.chap06fileupload;

public class FileDTO {

    private String originFileName; // 파일의 이름

    private String saveName; // 확장자 이름

    private String fileFath;

    private String fileDescription;

    public FileDTO() {
    }

    public FileDTO(String originFileName, String saveName, String fileFath, String fileDescription) {
        this.originFileName = originFileName;
        this.saveName = saveName;
        this.fileFath = fileFath;
        this.fileDescription = fileDescription;
    }

    public String getOriginFileName() {
        return originFileName;
    }

    public void setOriginFileName(String originFileName) {
        this.originFileName = originFileName;
    }

    public String getSaveName() {
        return saveName;
    }

    public void setSaveName(String saveName) {
        this.saveName = saveName;
    }

    public String getFileFath() {
        return fileFath;
    }

    public void setFileFath(String fileFath) {
        this.fileFath = fileFath;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    @Override
    public String toString() {
        return "FileDTO{" +
                "originFileName='" + originFileName + '\'' +
                ", saveName='" + saveName + '\'' +
                ", fileFath='" + fileFath + '\'' +
                ", fileDescription='" + fileDescription + '\'' +
                '}';
    }
}

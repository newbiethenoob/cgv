package com.spring.dto;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class BoardDto {
	
	int rno, bhit;
	String bid, btitle, bcontent, bdate, bfile, bsfile, bfile2, bsfile2;
	CommonsMultipartFile file1, file2;
	CommonsMultipartFile[] fileList = new CommonsMultipartFile[2]; 
	//파일 업로드-다운로드
//	폼에서 넘어오는 파일 데이터 매핑 필드 --> CommonsMultipartFile file1;	
//	board 테이블에 저장할 데이터 저장 필드 --> String bfile, bsfile;	
	
	public int getRno() {
		return rno;
	}
	public CommonsMultipartFile[] getFileList() {
		return fileList;
	}
//	public void setFileList(CommonsMultipartFile[] fileList) {
//		this.fileList = fileList;
//	}
	public String getBfile2() {
		return bfile2;
	}
	public void setBfile2(String bfile2) {
		this.bfile2 = bfile2;
	}
	public String getBsfile2() {
		return bsfile2;
	}
	public void setBsfile2(String bsfile2) {
		this.bsfile2 = bsfile2;
	}
	public String getBfile() {
		return bfile;
	}
	public void setBfile(String bfile) {
		this.bfile = bfile;
	}
	public String getBsfile() {
		return bsfile;
	}
	public void setBsfile(String bsfile) {
		this.bsfile = bsfile;
	}
	public CommonsMultipartFile getFile1() {
		return file1;
	}
	public void setFile1(CommonsMultipartFile file1) {
		this.file1 = file1;
		fileList[0] = file1;
	}
	public CommonsMultipartFile getFile2() {
		return file2;
	}
	public void setFile2(CommonsMultipartFile file2) {
		this.file2 = file2;
		fileList[1] = file2;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getBhit() {
		return bhit;
	}
	public void setBhit(int bhit) {
		this.bhit = bhit;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	
	

}

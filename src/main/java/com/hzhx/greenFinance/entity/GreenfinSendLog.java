package com.hzhx.greenFinance.entity;

public class GreenfinSendLog {

	private String requestDate;
	private String requestId;
	private String requestUrl;
	private String reportBank;
	private String timestamp;
	private String requestType;
	private String fileNameIndex;
	private String fileName;
	private String resultCode;
	private String resultMessage;
	private String resultData;

	public GreenfinSendLog(String requestId) {
		super();
		this.requestId = requestId;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public String getReportBank() {
		return reportBank;
	}

	public void setReportBank(String reportBank) {
		this.reportBank = reportBank;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public String getResultData() {
		return resultData;
	}

	public void setResultData(String resultData) {
		this.resultData = resultData;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getFileNameIndex() {
		return fileNameIndex;
	}

	public void setFileNameIndex(String fileNameIndex) {
		this.fileNameIndex = fileNameIndex;
	}

}

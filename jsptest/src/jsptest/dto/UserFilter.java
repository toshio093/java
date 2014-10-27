package jsptest.dto;


import java.util.List;


public class UserFilter {
	List<String> pstnCodes;
	String layerCode;

	public List<String> getPstnCodes() {
		return pstnCodes;
	}
	public void setPstnCodes(List<String> pstnCodes) {
		this.pstnCodes = pstnCodes;
	}
	public String getLayerCode() {
		return layerCode;
	}
	public void setLayerCode(String layerCode) {
		this.layerCode = layerCode;
	}
	public UserFilter() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public UserFilter(List<String> pstnCodes, String layerCode) {
		super();
		this.pstnCodes = pstnCodes;
		this.layerCode = layerCode;
	}


}
package model.AdministrativeArea;

import javax.xml.bind.annotation.XmlTransient;

public class Properties {
	
	private int ID_0;
	private int ID_1;
	private int ID_2;
	private int ID_3;
	private String NAME_0;
	private String NAME_1;
	private String NAME_2;
	private String NAME_3;
	private String ISO;
	private String TYPE_3;
	private String ENGTYPE_3;
	private double Shape_Lenght;
	private double Shape_Area;
	private Object CCN_3;
	private Object CCA_3;
	private Object NL_NAME_3;
	private Object VARNAME_3;
	
	public int getID_0() {
		return ID_0;
	}
	
	public void setID_0(int iD_0) {
		ID_0 = iD_0;
	}
	
	public int getID_1() {
		return ID_1;
	}
	
	public void setID_1(int iD_1) {
		ID_1 = iD_1;
	}
	
	public int getID_2() {
		return ID_2;
	}
	
	public void setID_2(int iD_2) {
		ID_2 = iD_2;
	}
	
	public int getID_3() {
		return ID_3;
	}
	
	public void setID_3(int iD_3) {
		ID_3 = iD_3;
	}
	
	public String getNAME_0() {
		return NAME_0;
	}
	
	public void setNAME_0(String nAME_0) {
		NAME_0 = nAME_0;
	}
	
	public String getNAME_1() {
		return NAME_1;
	}
	
	public void setNAME_1(String nAME_1) {
		NAME_1 = nAME_1;
	}
	
	public String getNAME_2() {
		return NAME_2;
	}
	
	public void setNAME_2(String nAME_2) {
		NAME_2 = nAME_2;
	}
	
	public String getNAME_3() {
		return NAME_3;
	}
	
	public void setNAME_3(String nAME_3) {
		NAME_3 = nAME_3;
	}
	
	public String getISO() {
		return ISO;
	}
	
	public void setISO(String iSO) {
		ISO = iSO;
	}
	
	@XmlTransient
	public String getTYPE_3() {
		return TYPE_3;
	}
	
	@XmlTransient
	public void setTYPE_3(String tYPE_3) {
		TYPE_3 = tYPE_3;
	}
	
	@XmlTransient
	public String getENGTYPE_3() {
		return ENGTYPE_3;
	}
	
	@XmlTransient
	public void setENGTYPE_3(String eNGTYPE_3) {
		ENGTYPE_3 = eNGTYPE_3;
	}
	
	@XmlTransient
	public double getShape_Lenght() {
		return Shape_Lenght;
	}
	
	@XmlTransient
	public void setShape_Lenght(double shape_Lenght) {
		Shape_Lenght = shape_Lenght;
	}
	
	@XmlTransient
	public double getShape_Area() {
		return Shape_Area;
	}
	
	@XmlTransient
	public void setShape_Area(double shape_Area) {
		Shape_Area = shape_Area;
	}
	
	@XmlTransient
	public Object getCCN_3() {
		return CCN_3;
	}
	
	@XmlTransient
	public void setCCN_3(Object cCN_3) {
		CCN_3 = cCN_3;
	}
	
	@XmlTransient
	public Object getCCA_3() {
		return CCA_3;
	}
	
	@XmlTransient
	public void setCCA_3(Object cCA_3) {
		CCA_3 = cCA_3;
	}
	
	@XmlTransient
	public Object getNL_NAME_3() {
		return NL_NAME_3;
	}
	
	@XmlTransient
	public void setNL_NAME_3(Object nL_NAME_3) {
		NL_NAME_3 = nL_NAME_3;
	}
	
	@XmlTransient
	public Object getVARNAME_3() {
		return VARNAME_3;
	}
	
	@XmlTransient
	public void setVARNAME_3(Object vARNAME_3) {
		VARNAME_3 = vARNAME_3;
	}

	@Override
	public String toString() {
		return "Properties [ID_0=" + ID_0 + ", ID_1=" + ID_1 + ", ID_2=" + ID_2 + ", ID_3=" + ID_3 + ", NAME_0="
				+ NAME_0 + ", NAME_1=" + NAME_1 + ", NAME_2=" + NAME_2 + ", NAME_3=" + NAME_3 + ", ISO=" + ISO + "]";
	}

}

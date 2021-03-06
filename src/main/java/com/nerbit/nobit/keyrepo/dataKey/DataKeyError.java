package com.nerbit.nobit.keyrepo.dataKey;

public class DataKeyError {
	
	public static final String ERR_CODE_NO_SUCH_DATAKEY = "301";
	public static final String ERR_DISP_NO_SUCH_DATEKEY="no such data-key";
	
	String error_code;
	String error_disp;
	/**
	 * @return the error_code
	 */
	public String getError_code() {
		return error_code;
	}
	/**
	 * @param error_code the error_code to set
	 */
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	/**
	 * @return the error
	 */
	public String getError() {
		return error_disp;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error_disp = error;
	}
	public DataKeyError(String errcode, String errordisp) {
		super();
		this.error_code = errcode;
		this.error_disp = errordisp;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserError [error_code=" + error_code + ", error=" + error_disp + "]";
	}
	
}

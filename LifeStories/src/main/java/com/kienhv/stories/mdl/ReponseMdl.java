package com.kienhv.stories.mdl;

public class ReponseMdl {
	private static int SUCCESS = 0;
	private static String MSG_SUCCESS = "thành công";
	private static int ERR_DEFAULT = 0;
	private static String MSG_ERR_DEFAULT = "Đã có lỗi xảy ra";

	private String message;
	private int errorCode;
	private Object data;
	
	private static ReponseMdl instance;
	private static ReponseMdl instanceErrorDefault;
	public static ReponseMdl getInsSuccess() {
		if(instance == null) {
			instance = new ReponseMdl(MSG_SUCCESS, SUCCESS);
		}
		return instance;
	}
	
	public static ReponseMdl getInsErrorDefault() {
		if(instanceErrorDefault == null) {
			instanceErrorDefault = new ReponseMdl(MSG_ERR_DEFAULT, ERR_DEFAULT);
		}
		return instanceErrorDefault;
	}

	public ReponseMdl() {
		super();
	}

	public ReponseMdl(String message, int errorCode) {
		super();
		this.message = message;
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}

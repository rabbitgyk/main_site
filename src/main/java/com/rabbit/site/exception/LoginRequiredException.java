package com.rabbit.site.exception;

/**
 * 必须登录时的异常
 * @author rabbit
 * @date 2015年8月12日 下午10:02:02
 */
public class LoginRequiredException extends RuntimeException {

	private static final long serialVersionUID = 6518158660456589758L;
	private boolean isAjax;

	public LoginRequiredException(boolean isAjax,String message) {
		super(message);
		this.setAjax(isAjax);
	}

	public LoginRequiredException(Throwable cause) {
		super(cause);
	}

	public LoginRequiredException(String message, Throwable cause) {
		super(message, cause);
	}

	public boolean isAjax() {
		return isAjax;
	}

	public void setAjax(boolean isAjax) {
		this.isAjax = isAjax;
	}
}

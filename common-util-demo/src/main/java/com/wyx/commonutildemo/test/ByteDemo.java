package com.wyx.commonutildemo.test;

/**
 * @author : Just wyx
 * @Date : 2020/11/21
 */
public class ByteDemo {
	private static final byte EU_NOTIFY_FLAG = 1 << 0;
	private static final byte CLOUD_NOTIFY_FLAG = 1 << 1;

	private Integer notifyFlag = 0;

	public Integer getNotifyFlag() {
		return notifyFlag;
	}


	public static void main(String[] args) {
		ByteDemo byteDemo = new ByteDemo();
		byteDemo.addNotifyEu();
		System.out.println(byteDemo.isEuNotify());
	}

	public boolean isEuNotify(){
		return (notifyFlag & EU_NOTIFY_FLAG) == EU_NOTIFY_FLAG;
	}

	public void addNotifyEu() {
		this.notifyFlag = notifyFlag | EU_NOTIFY_FLAG;
	}
}

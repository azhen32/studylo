package com.azhen.constants;

/**使用枚举表述数据字典
 * Created by azhen on 16-12-9.
 */
public enum StatEnum {
    SUCCESS(1,"秒杀成功"),
    END(0,"秒杀结束"),
    REPEAT_KILL(-1,"重复秒杀"),
    INNER_ERROR(-2,"系统异常"),
    DATA_REWRITE(-3,"数据篡改");

    private int state;
    private String stateInfo;

    StatEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }


    public String getStateInfo() {
        return stateInfo;
    }

    public static StatEnum stateOf(int index) {
        for(StatEnum state : values()) {
            if(state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}

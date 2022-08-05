package com.hust.hospital.entity;

/**
 * @author EdwardXu
 * @description 病人的状态
 */

public enum Status {
    /**
     * 执行中
     */
    OPERATING(1, "执行中"),
    /**
     * 变异
     */
    MUTATED(2, "变异"),
    /**
     * 正常结束
     */
    ENDED(3, "正常结束"),
    /**
     * 未加入
     */
    UNINVOLVED(4, "未加入");
    private int id;
    private String description;

    Status(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static int getIdByDescription(String description) {
        if (UNINVOLVED.description.equals(description)) {
            return UNINVOLVED.id;
        } else if (ENDED.description.equals(description)) {
            return ENDED.id;
        } else if (MUTATED.description.equals(description)) {
            return MUTATED.id;
        } else if (OPERATING.description.equals(description)) {
            return OPERATING.id;
        } else {
            return 0;
        }
    }

    public static String getDescriptionById(int id) {
        if (UNINVOLVED.id == id) {
            return UNINVOLVED.description;
        } else if (ENDED.id == id) {
            return ENDED.description;
        } else if (MUTATED.id == id) {
            return MUTATED.description;
        } else if (OPERATING.id == id) {
            return OPERATING.description;
        } else {
            return null;
        }
    }
}

package com.hust.hospital.entity;

public enum StageStatus {
    /**
     * 0表示准备进行 1表示已完成 2表示正在进行
     */
    DONE("已完成", 1), DOING("正在进行", 2), TODO("准备进行", 0);
    /**
     * 状态描述
     */
    private String description;
    private int id;

    StageStatus(String description, int id) {
        this.description = description;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static int getIdByDescription(String description) {
        if (DONE.description.equals(description)) {
            return DONE.id;
        } else if (DOING.description.equals(description)) {
            return DOING.id;
        } else if (TODO.description.equals(description)) {
            return TODO.id;
        } else {
            return -1;
        }
    }

    public static String getDescriptionById(int id) {
        if (DONE.id == id) {
            return DONE.description;
        } else if (DOING.id == id) {
            return DOING.description;
        } else if (TODO.id == id) {
            return TODO.description;
        } else {
            return null;
        }
    }
}

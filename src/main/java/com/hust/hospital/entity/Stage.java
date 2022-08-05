package com.hust.hospital.entity;


/**
 * @description 路径处于的阶段
 * @author EdwardXu
 */

public enum Stage {
    /**
     * 具体阶段
     */
    ONE(0,"阶段1"),TWO(1,"阶段2"),THREE(2,"阶段3"),FOUR(3,"阶段4");
    /**
     * stage的id
     */
    private int id;
    /**
     * stage的描述
     */
    private String description;

    Stage(int id,String description){
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
        if (ONE.description.equals(description)) {
            return ONE.id;
        } else if (TWO.description.equals(description)) {
            return TWO.id;
        } else if (THREE.description.equals(description)) {
            return THREE.id;
        } else if (FOUR.description.equals(description)) {
            return FOUR.id;
        } else {
            return -1;
        }
    }
    public static String getDescriptionById(int id) {
        if (ONE.id == id) {
            return ONE.description;
        } else if (TWO.id == id) {
            return TWO.description;
        } else if (THREE.id == id) {
            return THREE.description;
        } else if (FOUR.id == id) {
            return FOUR.description;
        } else {
            return null;
        }
    }

}

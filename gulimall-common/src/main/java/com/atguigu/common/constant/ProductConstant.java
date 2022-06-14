package com.atguigu.common.constant;

public class ProductConstant {

    public enum attrEnum{
        ATTR_ENUM_BASE(1,"基本属性"),
        ATTR_ENUM_SALE(0,"销售属性");

        private int code;
        private String msg;

        attrEnum(int code ,String msg){
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
    public enum StatussEnum{
        NEW_SPU(0,"新建"),
        SPU_UP(1,"上架"),
        SPU_DOWN(2,"下架");

        private int code;
        private String msg;

        StatussEnum(int code ,String msg){
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}

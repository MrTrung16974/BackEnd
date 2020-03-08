package com.vnp.template.common;

public enum Function {
    admin("Quản trị hệ thống"),
    viewUser("Xem tài khoản"),
    addUser("Thêm tài khoản"),
    ;
    private final String displayName;

    Function(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName() {
        return displayName;
    }
}

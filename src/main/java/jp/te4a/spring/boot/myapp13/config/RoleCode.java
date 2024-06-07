package jp.te4a.spring.boot.myapp13.config;

public enum RoleCode {
    ROLE_ADMIN((byte)1,"権限","ADMIN"),
    ROLE_USER((byte)2,"一般ユーザー","USER"),
    ROLE_OTHER((byte)3,"管理者","OTHER");

    private final Byte id;
    private final String name;
    private final String code;

    private RoleCode(final Byte id, final String name, final String code){
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public Byte getId(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }

    public String getCode(){
        return this.code;
    }

    public static String getCode(Byte roleId){
        String rolename = null;

        if(roleId == ROLE_ADMIN.getId()){
            rolename = "ROLE_" + ROLE_ADMIN.getCode();
        }else if(roleId == ROLE_USER.getId()){
            rolename = "ROLE_" + ROLE_USER.getCode();
        }else if(roleId == ROLE_OTHER.getId()){
            rolename = "ROLE_" + ROLE_OTHER.getCode();
        }
        return rolename;
    }
}

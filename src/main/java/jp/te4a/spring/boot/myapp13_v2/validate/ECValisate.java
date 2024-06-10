package jp.te4a.spring.boot.myapp13_v2.validate;
import jakarta.validation.*;
import jp.te4a.spring.boot.myapp13_v2.validate.ECValid.TestValid;

public class ECValisate implements ConstraintValidator<TestValid,String>{
    String param;
    @Override
    public void initialize(ECValid.TestValid nv){
        param = nv.param();
    }
    @Override
    public boolean isValid(String in,ConstraintValidatorContext cxt){
        if(in == null){
            return false;
        }
        System.out.println(in.equals(param));
        return !in.equals(param);
    }
}

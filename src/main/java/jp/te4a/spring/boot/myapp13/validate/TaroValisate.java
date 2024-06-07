package jp.te4a.spring.boot.myapp13.validate;
import jakarta.validation.*;
import jp.te4a.spring.boot.myapp13.validate.TaroValid.Writter;

public class TaroValisate implements ConstraintValidator<Writter,String>{
    String ok;
    @Override
    public void initialize(Writter wr){
        ok = wr.ok();
    }
    @Override
    public boolean isValid(String in,ConstraintValidatorContext cxt){
        if(in == null){
            return false;
        }
        System.out.println(in.equals(ok));
        return in.equals(ok);
    }
}

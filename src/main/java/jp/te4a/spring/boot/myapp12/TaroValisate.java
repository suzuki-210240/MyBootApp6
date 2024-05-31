package jp.te4a.spring.boot.myapp12;
import jakarta.validation.*;
import jp.te4a.spring.boot.myapp12.TaroValid.Writter;

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

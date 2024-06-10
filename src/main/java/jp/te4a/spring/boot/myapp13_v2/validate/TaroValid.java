package jp.te4a.spring.boot.myapp13_v2.validate;
import java.lang.annotation.*;
import jakarta.validation.*;

public class TaroValid {
    @Documented
    @Constraint(validatedBy = TaroValisate.class)
    @Target({ElementType.METHOD,ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
        
    public @interface Writter{
        
        String ok();
        String message() default "{ok} を入力してください.";
        //Classオブジェクトを得る（戻り値とする）　メソッドgroups()
        //デフォルト値は空のクラス
        Class<?>[] groups() default{};
        //Payloadクラスを継承したClassオブジェクトを得る
        //（戻り値とする）メソッドpayload(),デフォルト値は空のクラス
        Class<? extends Payload>[] payload() default{};
    }
}

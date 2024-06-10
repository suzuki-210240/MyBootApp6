package jp.te4a.spring.boot.myapp13_v2.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jp.te4a.spring.boot.myapp13_v2.bean.BookBean;

public interface BookRepository extends JpaRepository<BookBean,Integer>{

    @Query("SELECT X FROM BookBean X ORDER BY X.title")
    List<BookBean> findAllOrderByTitle();
}




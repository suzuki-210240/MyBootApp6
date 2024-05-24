package jp.te4a.spring.boot.myapp8;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.springframework.stereotype.Repository;
import org.springframework.beans.BeanUtils;

@Repository
public class BookRepository {
    private final ConcurrentMap<Integer,BookBean>bookMap = new ConcurrentHashMap<>();
    
    private int BOOK_ID = 0;
    public int getBookId(){
        return BOOK_ID++;
    }

    public BookBean create(BookBean bookBean){
        return bookMap.put(bookBean.getId(),bookBean);
    }

    public BookBean update(BookBean updatBookBean){
        BookBean bookBean = bookMap.get(updatBookBean.getId());
        BeanUtils.copyProperties(updatBookBean, bookBean);
        return bookBean;
    }

    public void delete(Integer bookId){
        bookMap.remove(bookId);
    }

    public List<BookBean> findAll(){
        return new ArrayList<>(bookMap.values());
    }

    public BookBean findOne(Integer id){
        return bookMap.get(id);
    }
}



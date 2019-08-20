package com.peony.ibatis;


import com.peony.ibatis.entity.BookDO;
import com.peony.ibatis.repository.BookDAO;
import com.peony.ibatis.repository.BookDaoImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

/**
 * MyBatis 首先会查询二级缓存。若二级缓存未命中，再去查询一级缓存
 */
import java.util.List;

@Slf4j
public class IbatisTest {

    private static BookDAO bookDao;


    static {
        bookDao = new BookDaoImpl();
    }

    @Test
    public void ibatisJtest(){
        SqlSessionFactory sqlSessionFactory = BookDaoImpl.getSqlSessionFactory();
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();

        log.info("==========bookMapper1 select");
        BookDAO bookMapper1 = sqlSession1.getMapper(BookDAO.class);
        List<BookDO> bookDOS1 = bookMapper1.selectList(BookDO.builder().name("english1").build());
        System.out.println(bookDOS1);

        log.info("==========bookMapper2 insert");
        BookDAO bookMapper2 = sqlSession2.getMapper(BookDAO.class);
        bookMapper2.insert(BookDO.builder().name("english1").build());
        sqlSession2.commit();

        log.info("==========bookMapper1 select");
        List<BookDO> bookDOS2 = bookMapper1.selectList(BookDO.builder().name("english1").build());
        System.out.println(bookDOS2);
    }
}

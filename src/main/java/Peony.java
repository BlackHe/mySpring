import com.peony.ibatis.entity.BookDO;
import com.peony.ibatis.repository.BookDAO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

public class Peony {
    public static void main(String[] args) throws IOException {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        BookDAO mapper = sqlSession.getMapper(BookDAO.class);
//        BookDO param = new BookDO();
//        List<BookDO> books = mapper.selectList(param);
//        System.out.println(books);
////        mapper.insert(new BookDO("springcloud"));
////        SqlSession sqlSession2 = sqlSessionFactory.openSession();
//        BookDAO mapper2 = sqlSession.getMapper(BookDAO.class);
//        List<BookDO> books2 = mapper2.selectList(param);
//        System.out.println(books2);
        BigDecimal d1 = new BigDecimal(100.19999);
        BigDecimal d2 = new BigDecimal(100.000000009);
        System.out.println(d1.add(d2).toString());
        System.out.println(d1.add(d2).setScale(0,BigDecimal.ROUND_DOWN));
        System.out.println(new BigDecimal(1));

    }

    interface baseOrder{
        void query();
    }
}

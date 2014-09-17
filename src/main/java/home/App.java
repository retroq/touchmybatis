package home;

import home.data.User;
import home.mappers.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.InputStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception{
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUser(1l);
        System.out.println(user.getName() + " " + user.getPhone());
        System.out.println(mapper.selectUserByName("Anton").getAddress().getCity());
        User user1 = new User();
        user1.setName("Boris");
        user1.setPhone("+7899564");
        user1.setAddress(user.getAddress());
        mapper.insertUser(user1);
        sqlSession.commit();
        sqlSession.close();
        }
}

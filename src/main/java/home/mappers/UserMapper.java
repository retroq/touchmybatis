package home.mappers;

import home.data.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by антон on 12.09.2014.
 */

public interface UserMapper {
    @Select("SELECT * FROM user WHERE id = #{id}")
    public User getUser(Long id);

    public User selectUserByName(@Param("name") String name);

    public void insertUser(User user);
}

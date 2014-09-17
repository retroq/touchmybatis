package home.mappers;

import home.data.Address;
import org.apache.ibatis.annotations.Select;

/**
 * Created by антон on 13.09.2014.
 */
public interface AddressMapper {
    @Select("SELECT * FROM ADDRESS WHERE id = #{id}")
    public Address getById(Long id);
}

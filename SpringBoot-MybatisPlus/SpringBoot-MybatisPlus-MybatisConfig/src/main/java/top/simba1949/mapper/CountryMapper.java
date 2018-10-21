package top.simba1949.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.simba1949.common.Country;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author simba@onlying.cn
 * @since 2018-10-20
 */
@Repository
public interface CountryMapper extends BaseMapper<Country> {

}

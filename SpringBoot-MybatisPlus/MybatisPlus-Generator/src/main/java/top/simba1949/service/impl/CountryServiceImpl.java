package top.simba1949.service.impl;

import top.simba1949.common.Country;
import top.simba1949.mapper.CountryMapper;
import top.simba1949.service.ICountryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author simba@onlying.cn
 * @since 2018-10-20
 */
@Service
public class CountryServiceImpl extends ServiceImpl<CountryMapper, Country> implements ICountryService {

}

package top.simba1949.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.simba1949.common.CountryCommon;
import top.simba1949.mapper.CountryMapper;
import top.simba1949.service.ICountryService;

import java.util.List;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/20 8:06
 */
@Service
public class CountryServiceImpl implements ICountryService {

    @Autowired
    private CountryMapper countryMapper;

    @Override
    public void insert(CountryCommon countryCommon) {
        countryMapper.insert(countryCommon);
    }

    @Override
    public void delete(Integer id) {
        countryMapper.delete(id);
    }

    @Override
    public void update(CountryCommon countryCommon) {
        countryMapper.update(countryCommon);
    }

    @Override
    public List<CountryCommon> getList(CountryCommon commonStart, CountryCommon commonEnd) {
        return countryMapper.getList(commonStart, commonEnd);
    }
}

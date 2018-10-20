package top.simba1949.service;

import top.simba1949.common.CountryCommon;

import java.util.List;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/20 8:06
 */
public interface ICountryService {

    void insert(CountryCommon countryCommon);

    void delete(Integer id);

    void update(CountryCommon countryCommon);

    List<CountryCommon> getList(CountryCommon commonStart, CountryCommon commonEnd);
}

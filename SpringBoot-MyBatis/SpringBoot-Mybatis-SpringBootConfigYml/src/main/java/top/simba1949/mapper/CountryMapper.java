package top.simba1949.mapper;

import org.apache.ibatis.annotations.Param;
import top.simba1949.common.CountryCommon;

import java.util.List;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/20 8:17
 */
public interface CountryMapper {
    /**
     * 增
     * @param countryCommon
     */
    void insert(@Param("countryCommon") CountryCommon countryCommon);

    /**
     * 删
     * @param id
     */
    void delete(@Param("id") Integer id);

    /**
     * 改
     * @param countryCommon
     */
    void update(@Param("countryCommon") CountryCommon countryCommon);

    /**
     * 查
     * @param commonStart
     * @param commonEnd
     * @return
     */
    List<CountryCommon> getList(@Param("commonStart") CountryCommon commonStart, @Param("commonEnd") CountryCommon commonEnd);
}

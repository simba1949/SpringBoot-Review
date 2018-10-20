package top.simba1949.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.simba1949.common.CountryCommon;
import top.simba1949.service.ICountryService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/20 8:05
 */
@Log
@RestController
public class CountryController {

    @Autowired
    private ICountryService iCountryService;

    /**
     *
     * @param countryCommon
     * @return
     */
    @PostMapping("insert")
    public String insert(CountryCommon countryCommon){
        try {
            iCountryService.insert(countryCommon);
        } catch (Exception e) {
            return e.getMessage();
        }

        return "添加成功";
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("delete")
    public String delete(Integer id){
        try {
            iCountryService.delete(id);
        } catch (Exception e) {
            return e.getMessage();
        }

        return "删除成功";
    }

    /**
     *
     * @param countryCommon
     * @return
     */
    @PostMapping("/update")
    public String update(CountryCommon countryCommon){
        try {
            iCountryService.update(countryCommon);
        } catch (Exception e) {
            return e.getMessage();
        }

        return "更新成功";
    }

    /**
     *
     * @param commonStart
     * @param commonEnd
     * @return
     */
    @GetMapping("/get.list")
    public List<CountryCommon> getList(CountryCommon commonStart, CountryCommon commonEnd){
        List<CountryCommon> list = new ArrayList<>();
        try {
            list = iCountryService.getList(commonStart, commonEnd);
        } catch (Exception e) {
           log.info(e.getMessage());
        }

        return list;
    }

}

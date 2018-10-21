package top.simba1949.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import top.simba1949.common.Country;
import top.simba1949.mapper.CountryMapper;
import top.simba1949.service.ICountryService;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author simba@onlying.cn
 * @since 2018-10-20
 */
@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private ICountryService iCountryService;

    @GetMapping("/get.list")
    public List<Country> getList(){

        return iCountryService.list(null);
    }
}


package ita.newbee.mall.newbeemall.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
@RestController
public class JdbcController {
//    自动配置，因此可以直接通过 @Autowired 注入进来
    @Autowired
    JdbcTemplate jdbcTemplate;
    @ResponseBody
    // 查询所有记录
    @GetMapping("/queryAll")
    public List<Map<String, Object>> queryAll() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from jdbc_test");
        return list;
    }

    // 新增一条记录
    @GetMapping("/insert")
    public Object insert(String type, String name) {
        if (StringUtils.isEmpty(type) || StringUtils.isEmpty(name)) {
            return false;
        }
        jdbcTemplate.execute("insert into jdbc_test(`type`,`name`) value (\"" + type + "\",\"" + name + "\")");
        return true;
    }
}

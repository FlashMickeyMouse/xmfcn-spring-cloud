package com.cn.xmf.job.sys;

import com.alibaba.fastjson.JSONObject;
import com.cn.xmf.base.model.RetData;
import com.cn.xmf.model.es.EsModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * ElasticsearchService(ES服务)
 *
 * @author rufei.cn
 * @version 2019-05-19
 */
@FeignClient(value = "${base-service:elasticsearch-service}")// 配置远程服务名以及自定义权限验证配置
@RequestMapping("/server/es/")// 配置远程服务路径
@SuppressWarnings("all")
public interface ElasticsearchService {

    /**
     * 保存单条数据到ES
     *
     * @param message
     * @return
     */
    @RequestMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RetData save(@RequestBody EsModel es);

    /**
     * 保存集合数据到ES
     *
     * @param message
     * @return
     */
    @RequestMapping(value = "saveBatch", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RetData saveBatch(@RequestBody EsModel es);


    /**
     * search根据 关键词查询ES信息
     *
     * @param EsModel es
     * keywords 查询关键词
     * highlights 高亮词
     * @return
     */
    @RequestMapping(value = "search", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<JSONObject> search(@RequestBody EsModel es);
}

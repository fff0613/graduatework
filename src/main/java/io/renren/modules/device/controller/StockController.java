package io.renren.modules.device.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.common.utils.Result;
import io.renren.modules.device.entity.CompanyEntity;
import io.renren.modules.device.entity.DeviceEntity;
import io.renren.modules.device.entity.OptionEntity;
import io.renren.modules.device.service.DeviceService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.device.entity.StockEntity;
import io.renren.modules.device.service.StockService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-08 13:57:16
 */
@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockService stockService;
    @Autowired
    private DeviceService deviceService;

    @GetMapping("/stocklist")
    public Result queryList(){
        Result<List<OptionEntity>> result = new Result<>();
        List<OptionEntity> list = stockService.queryList();
        return result.ok(list);
    }
    @GetMapping("/ifo")
    public Result queryAll(){
        Result<List<StockEntity>> result = new Result<>();
        List<StockEntity> list = stockService.queryAll();
        return result.ok(list);
    }
    @RequestMapping("/search/{stockName}")
    public Result queryByName(@PathVariable("stockName") String stockName){
        Result<List<StockEntity>> result = new Result<>();
        List<StockEntity> list = stockService.queryByName(stockName);
        return result.ok(list);
    }
    @PostMapping("/add")
    public Result add(@RequestBody StockEntity stockEntity){
        System.out.println("stock/add");
        String s = stockService.insertStock(stockEntity);
        System.out.println(stockEntity.toString());
        System.out.println(s);
        Result<String> result = new Result<>();
        return result.ok(s);
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:stock:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = stockService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{stockname}")
    @RequiresPermissions("generator:stock:info")
    public R info(@PathVariable("stockname") String stockname){
		StockEntity stock = stockService.getById(stockname);

        return R.ok().put("stock", stock);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:stock:save")
    public R save(@RequestBody StockEntity stock){
		stockService.save(stock);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("generator:stock:update")
    public R update(@RequestBody StockEntity stock){
		stockService.updateStock(stock);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("generator:stock:delete")
    public R delete(@RequestBody String[] stocknames){
        for(String stockname:stocknames){
            List<DeviceEntity> deviceEntities = deviceService.queryByStock(stockname);
            if(deviceEntities != null &&deviceEntities.size() != 0){
                return R.error("库房不为空");
            }
        }
		stockService.deleteStock(stocknames);

        return R.ok();
    }

}

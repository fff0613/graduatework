package io.renren.modules.device.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import io.renren.common.utils.Result;
import io.renren.modules.device.entity.*;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import io.swagger.models.auth.In;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.device.service.LiferecordService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-09 12:43:22
 */
@RestController
@RequestMapping("/liferecord")
public class LiferecordController {
    @Autowired
    private LiferecordService liferecordService;
    @Autowired
    private SysUserService sysUserService;
    @PostMapping("/inventory/execute")
    public R inventoryExe(@RequestBody InventoryEntity[] inventoryEntities){
        System.out.println(Arrays.toString(inventoryEntities));
        liferecordService.executeInventory(inventoryEntities);
        return R.ok();
    }
    @GetMapping("/inventory/devicelist/{recordid}")
    public Result getDeviceList(@PathVariable("recordid")Long recordid){
        Result<List<DeviceEntity>> result = new Result<>();
        List<DeviceEntity> inventoryDeviceList = liferecordService.getInventoryDeviceList(recordid);
        return result.ok(inventoryDeviceList);
    }
//    @GetMapping("/inventory/ifo/devicelist/{recordid}")
//    public Result getInventoryIfo(@PathVariable("recordid")Long recordid){
//        Result<List<InventoryIfo>> result = new Result<>();
//        List<InventoryIfo> inventoryDeviceList = liferecordService.getInventoryDeviceList(recordid);
//        return result.ok(inventoryDeviceList);
//    }

    @GetMapping("/user/{userid}")
    public Result getUser(@PathVariable("userid")Long userid){
        Result<String> result = new Result<>();
        String s = sysUserService.queryByUserId(userid);
        return result.ok(s);
    }
    @GetMapping("/ifo/{exeid}/{content}")
    public Result queryByContent(@PathVariable("exeid")Long exeid,@PathVariable("content")String content){
        Result<List<LiferecordEntity>> result = new Result<>();
        List<LiferecordEntity> queryall = liferecordService.queryByContent(exeid,content);
        return result.ok(queryall);
    }
    @GetMapping("/ifo/{exeid}")
    public Result queryByExeId(@PathVariable("exeid")Long exeid){
        Result<List<LiferecordEntity>> result = new Result<>();
        List<LiferecordEntity> queryall = liferecordService.queryByExeId(exeid);
        return result.ok(queryall);
    }
    @GetMapping("/ifo")
    public Result queryAll(){
        Result<List<LiferecordEntity>> result = new Result<>();
        List<LiferecordEntity> deliverylist = liferecordService.queryAll();
        System.out.println(deliverylist.toString());
        return result.ok(deliverylist);
    }
    @GetMapping("fellowlist")
    public Result queryList(){
        Result<List<SysUserEntity>> result = new Result<>();
        List<SysUserEntity> list = liferecordService.queryFellowList();
        return result.ok(list);
    }
    @PostMapping("/storage/search")
    public Result storageSearch(@RequestBody LifeCon item){
        Result<List<LiferecordEntity>> result = new Result<>();
        List<LiferecordEntity> storageEntities = liferecordService.storageByCondition(item);
        return result.ok(storageEntities);
    }
    @PostMapping("/transfer/search")
    public Result transferSearch(@RequestBody LifeCon item){
        Result<List<LiferecordEntity>> result = new Result<>();
        List<LiferecordEntity> storageEntities = liferecordService.transferByCondition(item);
        return result.ok(storageEntities);
    }
    @PostMapping("/delivery/search")
    public Result deliverySearch(@RequestBody LifeCon item){
        Result<List<LiferecordEntity>> result = new Result<>();
        List<LiferecordEntity> deliveryEntities = liferecordService.deliveryByCondition(item);
        return result.ok(deliveryEntities);
    }
    @PostMapping("/allocation/search")
    public Result allocationSearch(@RequestBody LifeCon item){
        Result<List<LiferecordEntity>> result = new Result<>();
        List<LiferecordEntity> deliveryEntities = liferecordService.allocationByCondition(item);
        return result.ok(deliveryEntities);
    }
    @PostMapping("/scrap/search")
    public Result scrapSearch(@RequestBody LifeCon item){
        Result<List<LiferecordEntity>> result = new Result<>();
        List<LiferecordEntity> deliveryEntities = liferecordService.scrapByCondition(item);
        return result.ok(deliveryEntities);
    }
    @PostMapping("/inventory/search")
    public Result inventorySearch(@RequestBody LifeCon item){
        Result<List<LiferecordEntity>> result = new Result<>();
        List<LiferecordEntity> deliveryEntities = liferecordService.inventoryByCondition(item);
        return result.ok(deliveryEntities);
    }

    //设备日志
    @GetMapping("/inventory")
    public Result inventorylist(){
        Result<List<LiferecordEntity>> result = new Result<>();
        List<LiferecordEntity> deliverylist = liferecordService.inventorylist();
        System.out.println(deliverylist.toString());
        return result.ok(deliverylist);
    }
    @GetMapping("/scrap")
    public Result scraplist(){
        Result<List<LiferecordEntity>> result = new Result<>();
        List<LiferecordEntity> deliverylist = liferecordService.scraplist();
        System.out.println(deliverylist.toString());
        return result.ok(deliverylist);
    }
    @GetMapping("/giveback")
    public Result gblist(){
        Result<List<LiferecordEntity>> result = new Result<>();
        List<LiferecordEntity> deliverylist = liferecordService.givebacklist();
        System.out.println(deliverylist.toString());
        return result.ok(deliverylist);
    }
    @GetMapping("/lent")
    public Result lentlist(){
        Result<List<LiferecordEntity>> result = new Result<>();
        List<LiferecordEntity> deliverylist = liferecordService.lentlist();
        System.out.println(deliverylist.toString());
        return result.ok(deliverylist);
    }
    @GetMapping("/allocation")
    public Result allocationlist(){
        Result<List<LiferecordEntity>> result = new Result<>();
        List<LiferecordEntity> deliverylist = liferecordService.allocationlist();
        System.out.println(deliverylist.toString());
        return result.ok(deliverylist);
    }
    @GetMapping("/return")
    public Result returnlist(){
        Result<List<LiferecordEntity>> result = new Result<>();
        List<LiferecordEntity> deliverylist = liferecordService.returnlist();
        System.out.println(deliverylist.toString());
        return result.ok(deliverylist);
    }
    @GetMapping("/storage")
    public Result storagelist(){
        Result<List<LiferecordEntity>> result = new Result<>();
        List<LiferecordEntity> storagelist = liferecordService.storagelist();
        return result.ok(storagelist);
    }
    @GetMapping("/delivery")
    public Result deliverylist(){
        Result<List<LiferecordEntity>> result = new Result<>();
        List<LiferecordEntity> deliverylist = liferecordService.deliverylist();
        System.out.println(deliverylist.toString());
        return result.ok(deliverylist);
    }
    @GetMapping("/transfer")
    public Result transferlist(){
        Result<List<LiferecordEntity>> result = new Result<>();
        List<LiferecordEntity> transferlist = liferecordService.transferlist();
        System.out.println(transferlist.toString());
        return result.ok(transferlist);
    }
    @GetMapping("/stockreturn")
    public Result stockreturn(){
        Result<List<LiferecordEntity>> result = new Result<>();
        List<LiferecordEntity> stockreturnlist = liferecordService.stockreturnlist();
        System.out.println(stockreturnlist.toString());
        return  result.ok(stockreturnlist);
    }

    @RequestMapping("/{deviceid}")
//    @RequiresPermissions("liferecord:info")
    public Result queryDeviceAllLog(@PathVariable("deviceid") Integer deviceid){
        List<DeviceLogEntity> list = liferecordService.queryAllLog(deviceid);
        Result<List<DeviceLogEntity>> result = new Result<>();
        return result.ok(list);
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:liferecord:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = liferecordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{recordid}")
//    @RequiresPermissions("generator:liferecord:info")
    public R info(@PathVariable("recordid") Long recordid){
		LiferecordEntity liferecord = liferecordService.getById(recordid);

        return R.ok().put("liferecord", liferecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:liferecord:save")
    public R save(@RequestBody LiferecordEntity liferecord){
		liferecordService.save(liferecord);

        return R.ok();
    }

    /**
     * 修改
     */
//    @PostMapping("/add")
//    public R add(@RequestParam Map<String,Object> params) throws ParseException {
////        System.out.println(liferecord.toString());
//        RecordEntity liferecord = new RecordEntity();
//        liferecord.setDevicename((String)params.get("devicename"));
//        System.out.println(params.get("deviceid").toString());
//        String temp = (String)params.get("deviceid");
//        if(temp != null && !temp.equals(""))
//            liferecord.setDeviceid(Integer.parseInt((String)params.get("deviceid")));
//
//        liferecord.setDevicemodel((String)params.get("devicemodel"));
//        liferecord.setDevicetype((String) params.get("devicetype"));
//        liferecord.setOriginstock((String)params.get("originstock"));
//        liferecord.setAmount(Integer.parseInt((String)params.get("amount")));
//        liferecord.setDescr((String)params.get("descr"));
//        liferecord.setManufacture((String)params.get("manufacture"));
//        System.out.println(params.get("reporterid").toString());
//        temp = (String)params.get("reporterid");
//        if(temp != null && !temp.equals(""))
//            liferecord.setReporterid(Long.parseLong((String)params.get("reporterid")));
////        System.out.println(params.get("stockbatch").toString());
//        temp = (String)params.get("stockbatch");
//        if(temp != null && !temp.equals(""))
//            liferecord.setStockbatch(Integer.parseInt((String)params.get("stockbatch")));
//        liferecord.setStockname((String)params.get("stockname"));
////        System.out.println((Timestamp)params.get("storagetime"));
////        Date date = new Date();
////        date =Timestamp.valueOf((String)params.get("storagetime"));
//        System.out.println((String)params.get("storagetime"));
////        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////        Timestamp ts = new Timestamp((String)params.get("storagetime"));
////        liferecord.setStoragetime(sdf.parse((String)params.get("storagetime")));
////        System.out.println(liferecord.toString());
////		liferecordService.addRecord(liferecord);
//
//        return R.ok();
//    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public R add(@RequestBody RecordEntity item) {
        System.out.println(item.toString());
        liferecordService.addRecord(item);
        return R.ok();
    }
    @RequestMapping(value = "/adddelivery",method = RequestMethod.POST)
    public R addDelivery(@RequestBody RecordEntity item) {
        System.out.println(item.toString());
        liferecordService.addDelivery(item);
        return R.ok();
    }
    @RequestMapping(value = "/addAllocation",method = RequestMethod.POST)
    public R addAllocation(@RequestBody RecordEntity item) {
        System.out.println(item.toString());
        liferecordService.addDelivery(item);
        return R.ok();
    }
    @RequestMapping(value = "/addscrap",method = RequestMethod.POST)
    public R addScrap(@RequestBody RecordEntity item) {
        System.out.println(item.toString());
        liferecordService.addScrap(item);
        return R.ok();
    }
    @RequestMapping(value = "/addinventory",method = RequestMethod.POST)
    public R addInventory(@RequestBody InventoryRecordEntity item) {
        System.out.println(item.toString());
        liferecordService.addInventory(item);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:liferecord:delete")
    public R delete(@RequestBody Long[] recordids){
		liferecordService.removeByIds(Arrays.asList(recordids));

        return R.ok();
    }

}

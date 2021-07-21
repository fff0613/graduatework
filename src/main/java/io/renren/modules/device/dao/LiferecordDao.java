package io.renren.modules.device.dao;

import io.renren.modules.device.entity.InventoryComplete;
import io.renren.modules.device.entity.InventoryEntity;
import io.renren.modules.device.entity.LiferecordEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.device.entity.MaintainEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-09 12:43:22
 */
@Mapper
public interface LiferecordDao extends BaseMapper<LiferecordEntity> {
	//inventory
	List<InventoryComplete> getInventoryComplete(Long orderid);
	void executeInventory(InventoryEntity item);
	List<Integer> getDeviceList(Long id);
	void updateExecutorid(InventoryEntity item);
	void insertInventoryDevice(Long orderid,int deviceid);
	//
	List<LiferecordEntity> queryByExeId(Long id);
	List<LiferecordEntity> queryByContent(Long id, String content);
	List<LiferecordEntity> transferByStock(String stock);
	List<LiferecordEntity> transferByState(String state);
	List<LiferecordEntity> transferByExecutor(String executor);
	List<LiferecordEntity> transferByStockAndExecutor(String stock,String executor);
	List<LiferecordEntity> transferByStateAndExecutor(String state,String executor);
	List<LiferecordEntity> transferByStockAndState(String stock,String state);
	List<LiferecordEntity> transferByStockAndStateAndExecutor(String stock,String state,String executor);
	List<LiferecordEntity> storageByStock(String stock);
	List<LiferecordEntity> storageByState(String state);
	List<LiferecordEntity> storageByExecutor(String executor);
	List<LiferecordEntity> storageByStockAndExecutor(String stock,String executor);
	List<LiferecordEntity> storageByStateAndExecutor(String state,String executor);
	List<LiferecordEntity> storageByStockAndState(String stock,String state);
	List<LiferecordEntity> storageByStockAndStateAndExecutor(String stock,String state,String executor);
	List<LiferecordEntity> deliveryByStock(String stock);
	List<LiferecordEntity> deliveryByState(String state);
	List<LiferecordEntity> deliveryByExecutor(String executor);
	List<LiferecordEntity> deliveryByStockAndExecutor(String stock,String executor);
	List<LiferecordEntity> deliveryByStateAndExecutor(String state,String executor);
	List<LiferecordEntity> deliveryByStockAndState(String stock,String state);
	List<LiferecordEntity> deliveryByStockAndStateAndExecutor(String stock,String state,String executor);
	List<LiferecordEntity> allocationByStock(String stock);
	List<LiferecordEntity> allocationByState(String state);
	List<LiferecordEntity> allocationByExecutor(String executor);
	List<LiferecordEntity> allocationByStockAndExecutor(String stock,String executor);
	List<LiferecordEntity> allocationByStateAndExecutor(String state,String executor);
	List<LiferecordEntity> allocationByStockAndState(String stock,String state);
	List<LiferecordEntity> allocationByStockAndStateAndExecutor(String stock,String state,String executor);
	List<LiferecordEntity> scrapByStock(String stock);
	List<LiferecordEntity> scrapByState(String state);
	List<LiferecordEntity> scrapByExecutor(String executor);
	List<LiferecordEntity> scrapByStockAndExecutor(String stock,String executor);
	List<LiferecordEntity> scrapByStateAndExecutor(String state,String executor);
	List<LiferecordEntity> scrapByStockAndState(String stock,String state);
	List<LiferecordEntity> scrapByStockAndStateAndExecutor(String stock,String state,String executor);
	List<LiferecordEntity> inventoryByStock(String stock);
	List<LiferecordEntity> inventoryByState(String state);
	List<LiferecordEntity> inventoryByExecutor(String executor);
	List<LiferecordEntity> inventoryByStockAndExecutor(String stock,String executor);
	List<LiferecordEntity> inventoryByStateAndExecutor(String state,String executor);
	List<LiferecordEntity> inventoryByStockAndState(String stock,String state);
	List<LiferecordEntity> inventoryByStockAndStateAndExecutor(String stock,String state,String executor);
	void insertStorage(LiferecordEntity item);
	void insertTransfer(LiferecordEntity item);
	void inserStockReturn(LiferecordEntity item);
	void insertGiveBack(LiferecordEntity item);
	void insertDelivery(LiferecordEntity item);
	void insertAllocation(LiferecordEntity item);
	void insertScrap(LiferecordEntity item);
	Long insertInventory(LiferecordEntity item);
	List<LiferecordEntity> queryById(Integer deviceId);
	List<LiferecordEntity> storagelist();
	List<LiferecordEntity> deliverylist();
	List<LiferecordEntity> transferlist();
	List<LiferecordEntity> stockreturnlist();
	List<LiferecordEntity> returnlist();
	List<LiferecordEntity> lentlist();
	List<LiferecordEntity> givebacklist();
	List<LiferecordEntity> inventorylist();
	List<LiferecordEntity> scraplist();
	List<LiferecordEntity> allocationlist();
	List<LiferecordEntity> queryAll();
}

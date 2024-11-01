package top.resty.store.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.resty.store.dto.PageDTO;
import top.resty.store.entities.Goods;
import top.resty.store.entities.Search;
import top.resty.store.service.IGoodsService;
import top.resty.store.utils.InsertUtil;
import top.resty.store.vo.ResultVO;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author resty
 * @since 2024-10-26
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

  @Autowired
  private IGoodsService goodsService;

  @RequestMapping("/search")
  public ResultVO search(@RequestBody PageDTO pageDTO) {
    return ResultVO.success(goodsService.search(pageDTO));
  }

  @RequestMapping("/list")
  public ResultVO list() {
    return ResultVO.success(goodsService.list());
  }

  @RequestMapping("/page")
  public ResultVO page (@RequestBody Page page) {
    // System.out.println("page = " + page);
    Page<Goods> goodsPage = goodsService.selectPage(page);
    List<Goods> records = goodsPage.getRecords();
    records.forEach(record -> {
      loadMoney(record);
    });
    return ResultVO.success(goodsPage);
  }

  @RequestMapping("/remove")
  public ResultVO remove(@RequestBody Goods goods) {
    return ResultVO.success(goodsService.removeById(goods.getId()));
  }

  @RequestMapping("/update")
  public ResultVO update (@RequestBody Goods goods) {
    saveMoney(goods);
    return ResultVO.success(goodsService.updateById(goods));
  }

  @RequestMapping("/save")
  public ResultVO save (@RequestBody Goods goods) {
    goods.setId(InsertUtil.id());
    saveMoney(goods);
    return ResultVO.success(goodsService.save(goods));
  }

  public void saveMoney (Goods goods) {
    goods.setPrice(InsertUtil.saveMoney(goods.getPrice()));
    goods.setMoney(InsertUtil.saveMoney(goods.getMoney()));
  }

  public void loadMoney (Goods goods) {
    goods.setPrice(InsertUtil.loadMoney(goods.getPrice()));
    goods.setMoney(InsertUtil.loadMoney(goods.getMoney()));
  }
}

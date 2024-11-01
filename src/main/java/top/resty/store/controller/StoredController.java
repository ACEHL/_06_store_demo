package top.resty.store.controller;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.resty.store.entities.Search;
import top.resty.store.entities.Stored;
import top.resty.store.service.IStoredService;
import top.resty.store.utils.InsertUtil;
import top.resty.store.vo.ResultVO;

import java.sql.Wrapper;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author resty
 * @since 2024-10-26
 */
@RestController
@RequestMapping("/stored")
public class StoredController {

  @Autowired
  private IStoredService iStoredService;

  @RequestMapping("/list")
  public ResultVO list() {
    return ResultVO.success(iStoredService.list());
  }

  @PostMapping("/update")
  public ResultVO update(@RequestBody Stored stored) {
    return ResultVO.success(
        iStoredService.update(stored,
            new LambdaUpdateWrapper<Stored>().eq(Stored::getId, stored.getId())));
  }

  @RequestMapping("/search")
  public ResultVO search(@RequestBody Search search) {
    System.out.println("search --------" + search);
    return ResultVO.success(iStoredService.search(search.getKeyword()));
  }

  @PostMapping("/save")
  public ResultVO save (@RequestBody Stored stored) {
    stored.setId(InsertUtil.id());
    return ResultVO.success(iStoredService.save(stored));
  }

  @PostMapping("/delete")
  public ResultVO delete (@RequestBody Stored stored) {
    return ResultVO.success(iStoredService.removeById(stored.getId()));
  }


}

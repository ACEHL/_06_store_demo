package top.resty.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.resty.store.entities.Search;
import top.resty.store.entities.Type;
import top.resty.store.service.ITypeService;
import top.resty.store.utils.InsertUtil;
import top.resty.store.vo.ResultVO;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author resty
 * @since 2024-10-26
 */
@RestController
@RequestMapping("/type")
public class TypeController {

  @Autowired
  private ITypeService typeService;


  @PostMapping("/update")
  public ResultVO update(@RequestBody Type type) {
    return ResultVO.success(typeService.updateById(type));
  }

  @RequestMapping("/list")
  public ResultVO list (){
    return ResultVO.success(typeService.list());
  }

  @RequestMapping("/search")
  public ResultVO search(@RequestBody Search search) {
    return ResultVO.success(typeService.search(search.getKeyword()));
  }

  @PostMapping("/remove")
  public ResultVO remove (@RequestBody Type type) {
    return ResultVO.success(typeService.removeById(type.getId()));
  }

  @PostMapping("/save")
  public ResultVO save (@RequestBody Type type) {
    type.setId(InsertUtil.id());
    return ResultVO.success(typeService.save(type));
  }
}

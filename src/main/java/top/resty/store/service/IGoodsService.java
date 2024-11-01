package top.resty.store.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.resty.store.dto.PageDTO;
import top.resty.store.entities.Goods;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author resty
 * @since 2024-10-26
 */
public interface IGoodsService extends IService<Goods> {

  Page<Goods> selectPage(Page page);

  Page<Goods> search(PageDTO pageDTO);
}

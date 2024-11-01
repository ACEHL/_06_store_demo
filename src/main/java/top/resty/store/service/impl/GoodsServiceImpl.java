package top.resty.store.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import top.resty.store.dto.PageDTO;
import top.resty.store.entities.Goods;
import top.resty.store.mapper.GoodsMapper;
import top.resty.store.service.IGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author resty
 * @since 2024-10-26
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

  @Autowired
  private GoodsMapper goodsMapper;
  @Override
  public Page<Goods> selectPage(Page page) {
    Long l = goodsMapper.selectCount(new QueryWrapper<Goods>());
    page.setTotal(l);
    return goodsMapper.selectPage(page,new QueryWrapper<Goods>().last("limit "+((page.getCurrent()-1) * page.getSize())+","+ page.getSize()));
  }

  @Override
  public Page<Goods> search(PageDTO pageDTO) {
    Long l = 0L;
    if (pageDTO.getKeyword() == null || pageDTO.getKeyword().equals("")){
      l = goodsMapper.selectCount(new QueryWrapper<Goods>());
    }else{
      l = goodsMapper.selectCount(new LambdaQueryWrapper<Goods>().like(Goods::getName,pageDTO.getKeyword()));
      System.out.println("查询出的数量为"+l);
    }
    pageDTO.getPage().setTotal(l);
    return goodsMapper.selectPage(pageDTO.getPage(), new LambdaQueryWrapper<Goods>().like(Goods::getName,pageDTO.getKeyword())
        .last("limit "+((pageDTO.getPage().getCurrent()-1) * pageDTO.getPage().getSize())+","+ pageDTO.getPage().getSize())
    );
  }
}

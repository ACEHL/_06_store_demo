package top.resty.store.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import top.resty.store.entities.Stored;
import top.resty.store.entities.Type;
import top.resty.store.mapper.TypeMapper;
import top.resty.store.service.ITypeService;
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
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements ITypeService {

  @Autowired
  private TypeMapper typeMapper;

  @Override
  public List<Type> search(String keyword) {
    if (ObjectUtils.isEmpty(keyword)) {
      return null;
    }
    Type stored = new Type();
    stored.setName(keyword);
    int i = 0 ;
    try {
      i = Integer.valueOf(keyword);
    } catch (NumberFormatException e) {
      // 不是数字，不进行转换
      return typeMapper.selectList(new QueryWrapper<Type>().lambda()
          .like( Type::getName, stored.getName())
      );
    }
    stored.setType(i);
    return typeMapper.selectList(new QueryWrapper<Type>().lambda()
        .like( Type::getName, stored.getName()).or()
        .like( Type::getType, stored.getType())
    );
  }
}

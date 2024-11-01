package top.resty.store.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import top.resty.store.entities.Stored;
import top.resty.store.mapper.StoredMapper;
import top.resty.store.service.IStoredService;
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
public class StoredServiceImpl extends ServiceImpl<StoredMapper, Stored> implements IStoredService {

  @Autowired
  private StoredMapper storedMapper;
  @Override
  public List<Stored> search(String keyword) {
    if (ObjectUtils.isEmpty(keyword)) {
      return null;
    }
    Stored stored = new Stored();
    stored.setName(keyword);
    stored.setAddress(keyword);
    stored.setManager(keyword);
    return storedMapper.selectList(new QueryWrapper<Stored>().lambda()
        .like( Stored::getName, stored.getName()).or()
        .like( Stored::getAddress, stored.getAddress()).or()
        .like( Stored::getManager, stored.getManager())
    );
  }
}

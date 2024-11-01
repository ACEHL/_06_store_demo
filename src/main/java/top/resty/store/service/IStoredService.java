package top.resty.store.service;

import top.resty.store.entities.Stored;
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
public interface IStoredService extends IService<Stored> {

  List<Stored> search(String keyword);
}

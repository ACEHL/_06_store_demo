package top.resty.store.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author : resty
 * @since : 2024年10月29 - 08:44
 */
@Data
public class PageDTO<T> {
  private Page<T> page ;
  private String keyword;
}

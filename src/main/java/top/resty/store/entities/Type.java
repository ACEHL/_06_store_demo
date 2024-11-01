package top.resty.store.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author resty
 * @since 2024-10-26
 */
@Getter
@Setter
@TableName("tb_type")
public class Type {

    /**
     * 分类表ID
     */
    @TableId("id")
    private String id;

    /**
     * 0,食品 1, 电器 2, 厨具 3, 白酒 4, 茶
     */
    @TableField("type")
    private Integer type;

    /**
     * 仓库类型名称
     */
    @TableField("name")
    private String name;
}

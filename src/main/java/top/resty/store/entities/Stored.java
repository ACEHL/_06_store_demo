package top.resty.store.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
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
@TableName("tb_stored")
public class Stored {

    /**
     * 仓库表ID
     */
    @TableId("id")
    private String id;

    /**
     * 仓库名称
     */
    @TableField("name")
    private String name;

    /**
     * 仓库地址
     */
    @TableField("address")
    private String address;

    /**
     * 管理员
     */
    @TableField("manager")
    private String manager;
}

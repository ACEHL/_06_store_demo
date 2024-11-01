package top.resty.store.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
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
@TableName("tb_goods")
public class Goods {

    /**
     * 商品表ID
     */
    @TableId("id")
    private String id;

    /**
     * 仓库表ID
     */
    @TableField("stored_id")
    private String storedId;

    /**
     * 商品分类表ID
     */
    @TableField("type_id")
    private String typeId;

    /**
     * 商品名称
     */
    @TableField("name")
    private String name;

    /**
     * 上架时间
     */
    @TableField("listing_time")
    private LocalDateTime listingTime;

    /**
     * 保质期
     */
    @TableField("best_before_time")
    private LocalDateTime bestBeforeTime;

    /**
     * 商品数量
     */
    @TableField("count")
    private Integer count;

    /**
     * 商品单价
     */
    @TableField("price")
    private String price;

    /**
     * 商品总价
     */
    @TableField("money")
    private String money;
}

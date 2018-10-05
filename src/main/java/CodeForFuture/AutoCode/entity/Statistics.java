package CodeForFuture.AutoCode.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author AutoCode
 * @since 2018-10-05
 */
public class Statistics implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 是哪个功能的统计
     */
    private String function;

    /**
     * DAO层数量统计
     */
    private Long statistics;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Long getStatistics() {
        return statistics;
    }

    public void setStatistics(Long statistics) {
        this.statistics = statistics;
    }

    @Override
    public String toString() {
        return "Statistics{" +
        "id=" + id +
        ", function=" + function +
        ", statistics=" + statistics +
        "}";
    }
}

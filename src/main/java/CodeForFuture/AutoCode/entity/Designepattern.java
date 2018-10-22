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
 * @since 2018-10-20
 */
public class Designepattern implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 设计模式名称
     */
    private String designpattern;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesignpattern() {
        return designpattern;
    }

    public void setDesignpattern(String designpattern) {
        this.designpattern = designpattern;
    }

    @Override
    public String toString() {
        return "Designepattern{" +
        "id=" + id +
        ", designpattern=" + designpattern +
        "}";
    }
}

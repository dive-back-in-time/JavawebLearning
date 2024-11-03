package schedule.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*
使用lombok也可以
lombok jar包
 */
@AllArgsConstructor //定义了所有全参构造器
@NoArgsConstructor //定义所有无参构造
@Data
public class SysUser implements Serializable {
    private Integer uid;
    private String username;
    private String userpwd;
}

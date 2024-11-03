package schedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
/*
使用lombok也可以
lombok jar包
 */
@AllArgsConstructor //定义了所有全参构造器
@NoArgsConstructor //定义所有无参构造
@Data
public class SysUser {
    private Integer uid;
    private String username;
    private String userPed;
}

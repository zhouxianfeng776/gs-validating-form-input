package hello.valid;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: GroupOrder
 * Author:   Administrator
 * Date:     2018/11/25 18:04
 * Description: 组合分组
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@GroupSequence({UpdateGroup.class,SaveGroup.class,  Default.class})
public interface GroupOrder {

}
package cn.iocoder.basic.module.member.dal.mysql.config;

import cn.iocoder.basic.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.basic.module.member.dal.dataobject.config.MemberConfigDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 积分设置 Mapper
 *
 * @author QingX
 */
@Mapper
public interface MemberConfigMapper extends BaseMapperX<MemberConfigDO> {
}

package cn.iocoder.basic.module.report.dal.mysql.goview;

import cn.iocoder.basic.framework.common.pojo.PageParam;
import cn.iocoder.basic.framework.common.pojo.PageResult;
import cn.iocoder.basic.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.basic.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.basic.module.report.dal.dataobject.goview.GoViewProjectDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoViewProjectMapper extends BaseMapperX<GoViewProjectDO> {

    default PageResult<GoViewProjectDO> selectPage(PageParam reqVO, Long userId) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GoViewProjectDO>()
                .eq(GoViewProjectDO::getCreator, userId)
                .orderByDesc(GoViewProjectDO::getId));
    }

}

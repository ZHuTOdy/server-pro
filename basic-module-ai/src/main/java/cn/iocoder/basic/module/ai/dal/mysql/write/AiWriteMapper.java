package cn.iocoder.basic.module.ai.dal.mysql.write;

import cn.iocoder.basic.framework.common.pojo.PageResult;
import cn.iocoder.basic.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.basic.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.basic.module.ai.controller.admin.write.vo.AiWritePageReqVO;
import cn.iocoder.basic.module.ai.dal.dataobject.write.AiWriteDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * AI 写作 Mapper
 *
 * @author xiaoxin
 */
@Mapper
public interface AiWriteMapper extends BaseMapperX<AiWriteDO> {

    default PageResult<AiWriteDO> selectPage(AiWritePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<AiWriteDO>()
                .eqIfPresent(AiWriteDO::getUserId, reqVO.getUserId())
                .eqIfPresent(AiWriteDO::getType, reqVO.getType())
                .eqIfPresent(AiWriteDO::getPlatform, reqVO.getPlatform())
                .betweenIfPresent(AiWriteDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(AiWriteDO::getId));
    }

}

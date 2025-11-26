package cn.iocoder.basic.module.iot.dal.mysql.ota;

import cn.iocoder.basic.framework.common.pojo.PageResult;
import cn.iocoder.basic.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.basic.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.basic.module.iot.controller.admin.ota.vo.firmware.IotOtaFirmwarePageReqVO;
import cn.iocoder.basic.module.iot.dal.dataobject.ota.IotOtaFirmwareDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IotOtaFirmwareMapper extends BaseMapperX<IotOtaFirmwareDO> {

    default IotOtaFirmwareDO selectByProductIdAndVersion(Long productId, String version) {
        return selectOne(IotOtaFirmwareDO::getProductId, productId,
                IotOtaFirmwareDO::getVersion, version);
    }

    default PageResult<IotOtaFirmwareDO> selectPage(IotOtaFirmwarePageReqVO pageReqVO) {
        return selectPage(pageReqVO, new LambdaQueryWrapperX<IotOtaFirmwareDO>()
                .likeIfPresent(IotOtaFirmwareDO::getName, pageReqVO.getName())
                .eqIfPresent(IotOtaFirmwareDO::getProductId, pageReqVO.getProductId())
                .betweenIfPresent(IotOtaFirmwareDO::getCreateTime, pageReqVO.getCreateTime())
                .orderByDesc(IotOtaFirmwareDO::getCreateTime));
    }

}

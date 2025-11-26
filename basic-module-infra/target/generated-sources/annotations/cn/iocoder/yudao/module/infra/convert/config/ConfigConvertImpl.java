package cn.iocoder.yudao.module.infra.convert.config;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.infra.controller.admin.config.vo.ConfigRespVO;
import cn.iocoder.yudao.module.infra.controller.admin.config.vo.ConfigSaveReqVO;
import cn.iocoder.yudao.module.infra.dal.dataobject.config.ConfigDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-26T14:13:45+0800",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.44.0.v20251118-1623, environment: Java 21.0.9 (Eclipse Adoptium)"
)
public class ConfigConvertImpl implements ConfigConvert {

    @Override
    public PageResult<ConfigRespVO> convertPage(PageResult<ConfigDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<ConfigRespVO> pageResult = new PageResult<ConfigRespVO>();

        pageResult.setTotal( page.getTotal() );
        pageResult.setList( convertList( page.getList() ) );

        return pageResult;
    }

    @Override
    public List<ConfigRespVO> convertList(List<ConfigDO> list) {
        if ( list == null ) {
            return null;
        }

        List<ConfigRespVO> list1 = new ArrayList<ConfigRespVO>( list.size() );
        for ( ConfigDO configDO : list ) {
            list1.add( convert( configDO ) );
        }

        return list1;
    }

    @Override
    public ConfigRespVO convert(ConfigDO bean) {
        if ( bean == null ) {
            return null;
        }

        ConfigRespVO configRespVO = new ConfigRespVO();

        configRespVO.setKey( bean.getConfigKey() );
        configRespVO.setCategory( bean.getCategory() );
        configRespVO.setCreateTime( bean.getCreateTime() );
        configRespVO.setId( bean.getId() );
        configRespVO.setName( bean.getName() );
        configRespVO.setRemark( bean.getRemark() );
        configRespVO.setType( bean.getType() );
        configRespVO.setValue( bean.getValue() );
        configRespVO.setVisible( bean.getVisible() );

        return configRespVO;
    }

    @Override
    public ConfigDO convert(ConfigSaveReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        ConfigDO configDO = new ConfigDO();

        configDO.setConfigKey( bean.getKey() );
        configDO.setCategory( bean.getCategory() );
        configDO.setId( bean.getId() );
        configDO.setName( bean.getName() );
        configDO.setRemark( bean.getRemark() );
        configDO.setValue( bean.getValue() );
        configDO.setVisible( bean.getVisible() );

        return configDO;
    }
}

package cn.iocoder.yudao.module.system.convert.auth;

import cn.iocoder.yudao.module.system.api.sms.dto.code.SmsCodeSendReqDTO;
import cn.iocoder.yudao.module.system.api.sms.dto.code.SmsCodeUseReqDTO;
import cn.iocoder.yudao.module.system.api.social.dto.SocialUserBindReqDTO;
import cn.iocoder.yudao.module.system.controller.admin.auth.vo.AuthLoginRespVO;
import cn.iocoder.yudao.module.system.controller.admin.auth.vo.AuthPermissionInfoRespVO;
import cn.iocoder.yudao.module.system.controller.admin.auth.vo.AuthSmsLoginReqVO;
import cn.iocoder.yudao.module.system.controller.admin.auth.vo.AuthSmsSendReqVO;
import cn.iocoder.yudao.module.system.controller.admin.auth.vo.AuthSocialLoginReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.oauth2.OAuth2AccessTokenDO;
import cn.iocoder.yudao.module.system.dal.dataobject.permission.MenuDO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-26T14:13:48+0800",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.44.0.v20251118-1623, environment: Java 21.0.9 (Eclipse Adoptium)"
)
public class AuthConvertImpl implements AuthConvert {

    @Override
    public AuthLoginRespVO convert(OAuth2AccessTokenDO bean) {
        if ( bean == null ) {
            return null;
        }

        AuthLoginRespVO.AuthLoginRespVOBuilder authLoginRespVO = AuthLoginRespVO.builder();

        authLoginRespVO.accessToken( bean.getAccessToken() );
        authLoginRespVO.expiresTime( bean.getExpiresTime() );
        authLoginRespVO.refreshToken( bean.getRefreshToken() );
        authLoginRespVO.userId( bean.getUserId() );

        return authLoginRespVO.build();
    }

    @Override
    public AuthPermissionInfoRespVO.MenuVO convertTreeNode(MenuDO menu) {
        if ( menu == null ) {
            return null;
        }

        AuthPermissionInfoRespVO.MenuVO.MenuVOBuilder menuVO = AuthPermissionInfoRespVO.MenuVO.builder();

        menuVO.alwaysShow( menu.getAlwaysShow() );
        menuVO.component( menu.getComponent() );
        menuVO.componentName( menu.getComponentName() );
        menuVO.icon( menu.getIcon() );
        menuVO.id( menu.getId() );
        menuVO.keepAlive( menu.getKeepAlive() );
        menuVO.name( menu.getName() );
        menuVO.parentId( menu.getParentId() );
        menuVO.path( menu.getPath() );
        menuVO.visible( menu.getVisible() );

        return menuVO.build();
    }

    @Override
    public SocialUserBindReqDTO convert(Long userId, Integer userType, AuthSocialLoginReqVO reqVO) {
        if ( userId == null && userType == null && reqVO == null ) {
            return null;
        }

        SocialUserBindReqDTO socialUserBindReqDTO = new SocialUserBindReqDTO();

        if ( reqVO != null ) {
            socialUserBindReqDTO.setCode( reqVO.getCode() );
            socialUserBindReqDTO.setState( reqVO.getState() );
        }
        socialUserBindReqDTO.setUserId( userId );
        socialUserBindReqDTO.setUserType( userType );

        return socialUserBindReqDTO;
    }

    @Override
    public SmsCodeSendReqDTO convert(AuthSmsSendReqVO reqVO) {
        if ( reqVO == null ) {
            return null;
        }

        SmsCodeSendReqDTO smsCodeSendReqDTO = new SmsCodeSendReqDTO();

        smsCodeSendReqDTO.setMobile( reqVO.getMobile() );
        smsCodeSendReqDTO.setScene( reqVO.getScene() );

        return smsCodeSendReqDTO;
    }

    @Override
    public SmsCodeUseReqDTO convert(AuthSmsLoginReqVO reqVO, Integer scene, String usedIp) {
        if ( reqVO == null && scene == null && usedIp == null ) {
            return null;
        }

        SmsCodeUseReqDTO smsCodeUseReqDTO = new SmsCodeUseReqDTO();

        if ( reqVO != null ) {
            smsCodeUseReqDTO.setCode( reqVO.getCode() );
            smsCodeUseReqDTO.setMobile( reqVO.getMobile() );
        }
        smsCodeUseReqDTO.setScene( scene );
        smsCodeUseReqDTO.setUsedIp( usedIp );

        return smsCodeUseReqDTO;
    }
}

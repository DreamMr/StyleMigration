package com.stylemigration.stylemigration.service.migration;

import org.springframework.stereotype.Component;

/**
 * @author wwb
 * 图像风格迁移的接口
 */
@Component
public interface Migration {
    /**
     * 将直接从前端获得的base64编码作为参数传递
     * @param base64Code 图片的base64编码
     * @return  迁移完成后的base64编码
     */
    String transForm(String base64Code);
}

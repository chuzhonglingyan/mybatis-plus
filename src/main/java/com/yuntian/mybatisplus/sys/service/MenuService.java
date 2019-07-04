package com.yuntian.mybatisplus.sys.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuntian.mybatisplus.sys.model.dto.MenuDTO;
import com.yuntian.mybatisplus.sys.model.entity.Menu;
import com.yuntian.mybatisplus.common.IBaseService;
import java.util.Collection;

/**
 * <p>
 * 后台系统-菜单表 服务类
 * </p>
 *
 * @author yuntian
 * @since 2019-07-02
 */
public interface MenuService extends IBaseService<Menu> {

   IPage<Menu> queryListByPage(MenuDTO dto);


   void updateByDTO(Menu dto);


   void deleteByDTO(Menu dto);


   void deleteBatchByDTO(Collection<Menu> entityList);

}

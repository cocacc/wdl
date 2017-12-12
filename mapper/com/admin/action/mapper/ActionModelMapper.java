package com.admin.action.mapper;

import java.util.List;

import com.admin.action.model.ActionModel;

public interface ActionModelMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(ActionModel record);

    int insertSelective(ActionModel record);

    ActionModel selectByPrimaryKey(Integer aid);
    
    List<ActionModel> selectAll();
    
    List<ActionModel> selectByUserKey(String aid);

    int updateByPrimaryKeySelective(ActionModel record);

    int updateByPrimaryKey(ActionModel record);
}
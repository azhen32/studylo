package com.azhen.mapper;

import com.azhen.domain.Videos;
import com.azhen.domain.VideosExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideosMapper {
    int countByExample(VideosExample example);

    int deleteByExample(VideosExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Videos record);

    int insertSelective(Videos record);

    List<Videos> selectByExample(VideosExample example);

    Videos selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Videos record, @Param("example") VideosExample example);

    int updateByExample(@Param("record") Videos record, @Param("example") VideosExample example);

    int updateByPrimaryKeySelective(Videos record);

    int updateByPrimaryKey(Videos record);
}
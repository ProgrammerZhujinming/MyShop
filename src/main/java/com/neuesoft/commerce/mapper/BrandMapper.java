package com.neuesoft.commerce.mapper;

import com.neuesoft.commerce.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BrandMapper {

    @Insert("insert into brand(bname,cid,blogo) values(#{bname},#{cid},#{blogo})")
    public void insertBrand(Brand brand);
}

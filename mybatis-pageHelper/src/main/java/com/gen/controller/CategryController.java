package com.gen.controller;

import com.gen.dao.CategoryMapper;
import com.gen.model.Category;
import com.gen.model.CategoryExample;
import com.gen.model.CategoryPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 龙浩 on 2018/7/11.
 */
@RestController
public class CategryController {

    @Autowired
    private CategoryMapper categoryMapper;

    @RequestMapping("/getCategory")
    public List<CategoryPo> getCategory() {
        CategoryExample example = new CategoryExample();
        // 查询出全部数据
        List<Category> categories = categoryMapper.selectByExample(example);
        List<CategoryPo> rootList = new ArrayList<>();
        // 将查询出来的数据填充进Po类
        for (Category category : categories) {
            CategoryPo categoryPo = new CategoryPo();
            categoryPo.setId(category.getId());
            categoryPo.setName(category.getName());
            categoryPo.setParentId(category.getParentId());
            rootList.add(categoryPo);
        }

        List<CategoryPo> result = new ArrayList<>();

        // 找到所有的一级分类
        for (CategoryPo categoryPo : rootList) {
            if (categoryPo.getParentId() == null) {
                result.add(categoryPo);
            }
        }

        // 查询出所有的父分类
        for (CategoryPo categoryPo : result) {
                categoryPo.setCategoryPoList(getChildList(categoryPo.getId(),rootList));
        }

        return result;
    }

    public List<CategoryPo> getChildList(int id, List<CategoryPo> rootList) {
        List<CategoryPo> childList = new ArrayList<>();
        // 遍历所有的数据,把父分类的子分类填充进去
        for (CategoryPo categoryPo : rootList) {
            if (categoryPo.getParentId() != null) {

                if (id == categoryPo.getParentId()) {
                    // 如果该元素的父分类id和传入的一致
                    childList.add(categoryPo);
                }
            }
        }

        // 把子元素的元素再循环一遍
        for (CategoryPo categoryPo : childList) {
            List<CategoryPo> childList1 = getChildList(categoryPo.getId(), rootList);
            categoryPo.setCategoryPoList(childList1);
        }

        // 跳出递归的条件
        if (childList.size() == 0) {
            return null;
        }

        return childList;
    }
}

package com.lh.controller;

        import io.swagger.annotations.ApiModel;
        import io.swagger.annotations.ApiModelProperty;

        import java.util.List;

/**
 * Created by 龙浩 on 2018/7/19.
 */
@ApiModel(value="User")
public class User {

    @ApiModelProperty(value = "用户id",example = "123" ,dataType = "String",required = true)
    private String id;
    @ApiModelProperty(value = "用户名称",example = "张三",dataType = "String")
    private String name;
    @ApiModelProperty(value = "用户年龄", dataType = "Int")
    private int age;
    @ApiModelProperty(value = "id的数组")
    private String[] ids;
    @ApiModelProperty(value = "名称集合")
    private List<String> names;

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

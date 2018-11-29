package com.mrl.spring.annotation.contition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector
{

    
    //返回值就是导入到容器中的组件全类名
    //AnnotationMetadata:当前标注Import注解的类的所有信息
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        //不能返回null值

        return new String[] {"com.mrl.spring.annotation.bean.Blue","com.mrl.spring.annotation.bean.Yellow"};
    }

}

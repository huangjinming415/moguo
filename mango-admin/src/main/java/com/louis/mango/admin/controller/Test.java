package com.louis.mango.admin.controller;

import com.sun.xml.internal.txw2.Document;
import org.apache.xmlbeans.impl.common.DocumentHelper;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

/**
 * @Description: ${DESCRIPTION}
 * @ClassName: ${CLASSNAME}
 * @Author: huangjinming
 * @Date: 2021/10/18 19:02
 */
public class Test {
    //解析xml格式字符串和TReportMonth实体类对应
    public static Bean parseXmlStr(String xml) throws Exception {

        // 将字符串转化为XML文档对象
        Document document = DocumentHelper.parseText(xml);
        // 获得文档的根节点
        Element root = document.getRootElement();
        // 遍历根节点下所有子节点
        Iterator<?> iter = root.elementIterator();

        //新建实体类
        Bean bean = new Bean();
        Class<?> c = Class.forName("包名.Bean");
        bean = (Bean) c.newInstance();// 创建这个实体的对象
        while (iter.hasNext()) {
            Element ele = (Element) iter.next();
            // 获取set方法中的参数字段（实体类的属性）
            Field field = c.getDeclaredField(ele.getName());
            // 获取set方法，field.getType())获取它的参数数据类型
            Method declaredMethod = c.getDeclaredMethod("set" + ele.getName(), field.getType());
            // 调用set方法
            // 如果标签内有值再进行转换
            if(ele.getText()!=null && !"".equals(ele.getText())){
                //字符串，日期，其他引用类型分别处理
                if (field.getType() == String.class){
                    declaredMethod.invoke(bean, ele.getText());
                }else if(!"Date".equals(field.getType().getSimpleName())){
                    // java.lang下面类型通用转换函数
                    Class<?> class1 = Class.forName(field.getType().getName());
                    Method method = class1.getMethod("parse" + field.getType().getSimpleName(),String.class);
                    if (method != null) {
                        Object ret = method.invoke(null, ele.getText().toString());
                        if (ret != null);
                        declaredMethod.invoke(bean, ret);
                    }
                    //日期格式单独处理
                }else{
                    String strDate = ele.getText();
                    Date date = null;
                    try {
                        date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(strDate);
                    } catch (ParseException e) {

                    }
                    declaredMethod.invoke(bean, date);
                }
            }

        }
        return Bean;
    }
}

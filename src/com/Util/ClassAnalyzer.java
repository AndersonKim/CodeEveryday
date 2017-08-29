package com.Util;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * class analyzer in beta
 * get class info as following
 * -class name      add Test+A
 * -class methods   add test+A
 * -TODO add more info to constract one class in building time
 * -support class type include []
 */
public class ClassAnalyzer {
    private Class _class = null;
    private String _longName = null;
    private String _shortName = null;
    private Method[] _methods = null;

    public ClassAnalyzer(Class aClass) {
        _class = aClass;
        set_longName();
        set_shortName();
        set_methods();
    }

    public void set_methods() {
        this._methods = _class.getMethods();
    }

    public void set_longName() {
        this._longName = _class.getName();
    }

    public void set_shortName() {
        this._shortName = StringUtils.strAfterLastDot(_class.getName());
    }

    public String get_longName() {
        return _longName;
    }

    public String get_shortName() {
        return _shortName;
    }

    public Method[] get_methods() {
        return _methods;
    }

    public String genTestClassName() {
        return "Test" + StringUtils.upperFirstLetter(_shortName);
    }

    /**
     * generate test method including type and return type
     * using void modifier
     * TODO using more not-saying rules
     *
     * @return
     */
    public List genTestClassMethod() {
        ArrayList<String> methodStrLine = new ArrayList<String>();
        for (Method method : _methods) {
            //make every method like following
           /*
           * public void testXXXX(){}
           * */
            String prefix = "@Test\npublic void test";
            String posfix = "(";
            //find parameter and type
            Type[] para = method.getParameterTypes();
            for (int i = 0; i < method.getGenericParameterTypes().length; i++) {
                String parType = StringUtils.strAfterLastDot(para[i].toString());
                String parName = StringUtils.lowerFirstLetter(parType);
                posfix = posfix.concat(parType + " " + parName);
                if (i == method.getGenericParameterTypes().length - 1) {
                    break;
                }
                posfix = posfix.concat(",");
            }
            posfix = posfix.concat("){}");
            methodStrLine.add(prefix + StringUtils.upperFirstLetter(method.getName()) + posfix);
        }
        return methodStrLine;
    }

}

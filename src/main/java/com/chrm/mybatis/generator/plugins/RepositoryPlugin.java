package com.chrm.mybatis.generator.plugins;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.IntrospectedTable.TargetRuntime;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;

public class RepositoryPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean clientGenerated(Interface interfaze, IntrospectedTable introspectedTable) {

        if (introspectedTable.getTargetRuntime() == TargetRuntime.MYBATIS3) {
            // don't need to do this for MYBATIS3_DSQL as that runtime already adds this annotation 
            interfaze.addImportedType(
                    new FullyQualifiedJavaType("org.springframework.stereotype.Repository")); //$NON-NLS-1$
            interfaze.addAnnotation("@Repository"); //$NON-NLS-1$
        }
        return true;
    }
}
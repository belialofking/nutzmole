package org.nutz.mole.impl;

import java.util.HashMap;
import java.util.Map;
import org.nutz.lang.Strings;

import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mole.Creator;
import org.nutz.mole.MoleContext;
import org.nutz.mole.meta.ZTable;

public class PojoCreater implements Creator {

	private static final Log log = Logs.get();
	
	public void create(MoleContext context) {
        String beanName = context.getConfig().getProject().get("bean_name");
        String moduleName = context.getConfig().getProject().get("module_name");
        
		String pathRoot = context.getConfig().getProject().get("srcFileRoot") + beanName + "/";
		Map<String, Object> datas = new HashMap<String, Object>();
		datas.put("packageName", context.getConfig().getProject().get("packageName") );
        datas.put("beanName", beanName );
        datas.put("moduleName", moduleName);
		for (ZTable zTable : context.getTables()) {
			datas.put("zTable", zTable);
			log.debugf("POJO{ClassName:%s,TableName:%s}", zTable.getClassName(),zTable.getTableName());
			FreemarkerHelp.make(pathRoot + zTable.getClassName() + ".java", "POJO.ftl", datas);
		}
		
		
	}
}

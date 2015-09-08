package org.nutz.mole;

import org.nutz.mole.impl.GenerallyDatabaseAdaptor;
import org.nutz.mole.impl.HelpFileCreater;
import org.nutz.mole.impl.Init;
import org.nutz.mole.impl.ModuleCreater;
import org.nutz.mole.impl.PojoCreater;

public class ZMole {

	public static void main(String[] args) throws Throwable {
		// 加载配置,检验配置
		MoleContext context = new MoleContext();
		// 初始化项目结构
		new Init().init(context.getConfig());
		// 获取数据库表结构,构建DTable
		DatabaseAdaptor adaptor = new GenerallyDatabaseAdaptor();
		context = adaptor.fromDb(context);
		if(context!=null)
		{
		//System.out.println(Json.toJson(context));
			generator(context);
		}else
		{
			System.out.println("请检查数据库连接或者数据库是否有表");
		}
	}
    
    private static void generator(MoleContext context){
        new PojoCreater().create(context);
        new ModuleCreater().create(context);
		new HelpFileCreater().create(context);
    }

}
